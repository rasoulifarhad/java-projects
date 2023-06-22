package com.farhad.example.guava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

public class PurchaseOrders {
    
    private final List<PurchaseOrder> orders = new ArrayList<>();

    public boolean addOrder(PurchaseOrder order) {
        Objects.requireNonNull(order);
        return orders.add(order);
    }
    
    public void clean() {
        orders.clear();
    }

    @Deprecated
    public List<PurchaseOrder> listOrdersByCustomer(Customer customer) {
        Objects.requireNonNull(customer);
        final List<PurchaseOrder> selected = new ArrayList<>();
        for (PurchaseOrder order : orders) {
            if (customer.equals(order.getCustomer())) {
                selected.add(order);
            }
        }
        return selected;
    }

    @Deprecated
    public List<PurchaseOrder> listRecentOrders(LocalDate from) {
        Objects.requireNonNull(from);
        final List<PurchaseOrder> selected = new ArrayList<>();
        for (PurchaseOrder order : orders) {
            if(order.getOrderData().isAfter(from)) {
                selected.add(order);
            }
        }
        return selected ;
    }

    public List<PurchaseOrder> listOrders(Predicate<PurchaseOrder> condition) {
        Objects.requireNonNull(condition);
        final List<PurchaseOrder> selected = new ArrayList<>();
        for (PurchaseOrder order : orders) {
            if(condition.apply(order)) {
                selected.add(order);
            }
        }
        return selected;
    }

    // The returned collection is a live view of unfiltered (the input collection); changes to one affect the other.
    public Collection<PurchaseOrder> selectOrders(Predicate<PurchaseOrder> condition) {
        return Collections2.filter(orders, condition);
    }

    public Iterable<PurchaseOrder> orders(Predicate<PurchaseOrder> condition) {
        return Iterables.filter(orders, condition);
    }

    public Iterable<PurchaseOrder> orders2(Predicate<? super PurchaseOrder> condition) {
        return Iterables.filter(orders, condition);
    }

    public static void main(String[] args) {
        final Customer customer = new Customer("Farhad");
        final Predicate<PurchaseOrder> condition = new Predicate<PurchaseOrder>() {

            @Override
            public boolean apply(PurchaseOrder order) {
                if (order.getCustomer().equals(customer)) {
                    return true;
                }
                return false;
                // return order.getCustomer().equals(customer);
            }
        }; 

        final PurchaseOrders purchaseOrders = new PurchaseOrders();
        List<PurchaseOrder> selected = purchaseOrders.listOrders(condition);
    }
}
