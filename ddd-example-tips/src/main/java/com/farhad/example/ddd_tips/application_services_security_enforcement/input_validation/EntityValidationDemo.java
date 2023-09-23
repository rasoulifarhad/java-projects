package com.farhad.example.ddd_tips.application_services_security_enforcement.input_validation;

import java.util.Objects;

public class EntityValidationDemo {
    public static class CustomerNo {

    }

    public static class PostalAddress {

    }

    public static class Customer {

        private String name;
        private CustomerNo customerNo;
        private PostalAddress address;

        public Customer(CustomerNo customerNo, String name, PostalAddress address) {
            setCustomerNo(customerNo); // <1>
            setName(name);
            setPostalAddress(address);
        }

        public void setCustomerNo(CustomerNo customerNo) {
            this.customerNo = Objects.requireNonNull(customerNo, "customerNo must not be null");
        }

        public void setName(String name) {
            Objects.requireNonNull(name, "name must not be null");
            if (name.length() < 1 || name.length() > 50) { // <2>
                throw new IllegalArgumentException("Name must be between 1 and 50 characters");
            }
            this.name = name;
        }

        public void setPostalAddress(PostalAddress address) {
            this.address = Objects.requireNonNull(address, "address must not be null");
        }        
    }
}
