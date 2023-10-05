package com.farhad.example.ddd_tips.application_service.application.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.farhad.example.ddd_tips.application_service.application.client.ClientProvider;
import com.farhad.example.ddd_tips.application_service.domain.model.client.Client;
import com.farhad.example.ddd_tips.application_service.domain.model.order.Order;
import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderAccessPolicy;
import com.farhad.example.ddd_tips.application_service.domain.model.order.OrderRepository;
import com.farhad.example.ddd_tips.application_service.domain.model.product.Product;

import io.vavr.control.Either;

// See https://betterprogramming.pub/the-benefits-of-overlapping-sociable-tests-in-domain-testing-63bb9b6a0a6d
@ExtendWith(MockitoExtension.class)
public class SolitaryOrderServiceTest {

    @Mock
    private ClientProvider clientProvider; 

    @Mock
    private OrderAccessPolicy orderAccessPolicy;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldPlaceValidOrder() {

        UUID id = UUID.randomUUID();
        try (MockedStatic<UUID> mockedUUID = Mockito.mockStatic(UUID.class)) {
            
            //given
            mockedUUID.when(UUID::randomUUID).thenReturn(id);
            String productId = "prodict1";
            int amount = 2;
            String clientId = "client1";
            Order intermediateOrder = Order.init(clientId);
            List<Product> products = Arrays.asList(new Product(productId, amount));
            intermediateOrder.add(products);

            Order finalOrder = Order.init(clientId);
            finalOrder.add(products);
            ReflectionTestUtils.setField(finalOrder, "status", Order.Status.PLACED);

            Client client = new Client(clientId, false);

            // when
            when(clientProvider.fetchClient(clientId)).thenReturn(Optional.of(client));
            when(orderAccessPolicy.check(intermediateOrder, client)).thenReturn(Either.right(true));
            when(orderRepository.save(finalOrder)).thenReturn(finalOrder);
            Order result = orderService.placeOrder(products, clientId);

            // then
            assertThat(result).isNotNull();
            assertThat(result.getId()).isNotBlank();
            assertThat(result.getId()).isEqualTo(id.toString());
            verify(clientProvider).fetchClient(clientId);
            verify(orderAccessPolicy).check(finalOrder, client);
            verify(orderRepository).save(finalOrder);


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
