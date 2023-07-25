package com.farhad.example.stream.basic;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.farhad.example.stream.basic.ItemServiceDemo.Item;
import com.farhad.example.stream.basic.ItemServiceDemo.ItemService;
public class OrderServiceDemo {
    
    public final static class Order {
        private final Long itemId;
        private final Long userId;

        public Order(final Long itemId, final Long userId) {
            this.itemId = notNull(itemId);
            this.userId = notNull(userId);
        }
        public Long itemId() {
            return itemId;
        }

        public Long userId() {
            return userId;
        }
    }

    public static class OrderService {

        private final AtomicLong sendOrders = new AtomicLong();

        public void sendOrder(final Order order) {
            notNull(order);
            //Send to order Managemment system....
            sendOrders.incrementAndGet();
        }

        public long sendOrders() {
            return sendOrders.get();
        }
    }

    final static class User {
        private final Long id;

        public User(final Long id) {
            this.id = notNull(id);
        }

        public Long id() {
            return id;
        }
    }

    public static class UserService {
        private final ThreadLocal<User> currentUser = new ThreadLocal<>();

        public User currentUser() {
            return currentUser.get();
        }

        public void setCurrentUser(final User user) {
            currentUser.set(user);
        }

        public void clearCurrentUser() {
            currentUser.remove();
        }
    }

    public static class Support {
        public static void givenALoggedInUser(UserService userService) {
            userService.setCurrentUser(new User(123L));
        }

        public static List<Item> itemsToBuy() {
            return new ItemService().allItems();
        }
    }
}
