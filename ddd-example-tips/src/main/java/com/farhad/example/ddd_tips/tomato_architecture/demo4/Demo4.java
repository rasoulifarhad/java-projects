package com.farhad.example.ddd_tips.tomato_architecture.demo4;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

public class Demo4 {
	
	static class DontDoThis {

		static class LineItem {

		}
		static class Cart {
			List<LineItem> lineItems;
		}

		static class CartDto {

		}

		interface CartRepository {

			Cart getCart(UUID cartId);

		}
		@Service
		@Transactional
		@RequiredArgsConstructor
		static class CartService {
			private final CartRepository cartRepository;
			CartDto getCart(UUID cartId) {
				Cart cart = cartRepository.getCart(cartId);
				BigDecimal cartTotal = calculateCartTotal(cart);
				// ....
				return null;
			}
			private BigDecimal calculateCartTotal(Cart cart) {
				return null;
			}
		}
	}

	// If you have domain object state change methods that affect only that object or a method to calculate something from 
	// the state of the object, then those methods belong to that domain object.
	static class DoThis {
		static class LineItem {

		}
		static class Cart {
			List<LineItem> lineItems;

			public BigDecimal getTotal() {
				return null;
			}
		}

		static class CartDto {

		}

		interface CartRepository {

			Cart getCart(UUID cartId);

		}
		@Service
		@Transactional
		@RequiredArgsConstructor
		static class CartService {
			private final CartRepository cartRepository;
			CartDto getCart(UUID cartId) {
				Cart cart = cartRepository.getCart(cartId);
				BigDecimal cartTotal = cart.getTotal();
				// ....
				return null;
			}
		}

	}
}
