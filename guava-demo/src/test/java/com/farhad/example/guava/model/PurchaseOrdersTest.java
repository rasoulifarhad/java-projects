package com.farhad.example.guava.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Predicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PurchaseOrdersTest {

    private PurchaseOrders purchaseOrders;

    @BeforeEach
    public void setUp() {
        purchaseOrders = new PurchaseOrders();
        PurchaseOrder order ;
        order = new PurchaseOrder(
                    new Customer("Farhad"),
                    LocalDate.of(2023, Month.JANUARY, 10),
                    OrderStatus.PENDING);
        purchaseOrders.addOrder(order);

        order = new PurchaseOrder(
                    new Customer("Ali"), 
                    LocalDate.of(2023, Month.APRIL, 12),
                    OrderStatus.PENDING);
        purchaseOrders.addOrder(order);

        order = new PurchaseOrder(
                    new Customer("Ali"), 
                    LocalDate.of(2023, Month.JULY, 5),
                    OrderStatus.SHIPPED);
        purchaseOrders.addOrder(order);
        
        order = new PurchaseOrder(
                    new Customer("Farhad"),
                    LocalDate.of(2023, Month.JUNE, 17),
                    OrderStatus.DELIVERED);
        purchaseOrders.addOrder(order);
    }

    @AfterEach
    public void tearDown() {
        purchaseOrders.clean();
        purchaseOrders = null;
    }

    @Test
    void testListOrders() {
        final Customer customer = new Customer("Farhad");
        Predicate<PurchaseOrder> condition = customerPredocate(customer);
        List<PurchaseOrder> selected = purchaseOrders.listOrders(condition); 
        log.info("{}", selected);
        assertThat(selected).hasSize(2);
    }

    @Test
    void testListOrdersByCustomer() {
        final Customer customer = new Customer("Ali");
        List<PurchaseOrder> selected = purchaseOrders.listOrdersByCustomer(customer);
        log.info("{}", selected);
        assertThat(selected).hasSize(2);
    }

    @Test
    void testListRecentOrders() {
        List<PurchaseOrder> selected = purchaseOrders.listRecentOrders(
                                                        LocalDate.of(2023, Month.JULY, 2));
        log.info("{}", selected);
        assertThat(selected).hasSize(1);

        selected = purchaseOrders.listRecentOrders(
                                                        LocalDate.of(2023, Month.JANUARY, 2));
        log.info("{}", selected);
        assertThat(selected).hasSize(4);

    }

    @Test
    void testSelectOrders() {
        Customer customer = new Customer("Farhad");
        Predicate<PurchaseOrder> condition = customerPredocate(customer);
        Collection<PurchaseOrder> selected = purchaseOrders.selectOrders(condition);
        log.info("{}", selected);
        assertThat(selected).hasSize(2);
    }

    @Test
    void testOrders() {
        Customer customer = new Customer("Ali");
        Predicate<PurchaseOrder> condition = customerPredocate(customer);
        for (PurchaseOrder order : purchaseOrders.orders(condition)) {
            log.info("{}", order);
        }
        assertThat(purchaseOrders.orders(condition)).hasSize(2);
    }

    private Predicate<PurchaseOrder> customerPredocate(final Customer customer) {
        return new Predicate<PurchaseOrder>() {

                @Override
                public boolean apply(PurchaseOrder order) {
                    return order.getCustomer().equals(customer);
                }
            };
    }
}
