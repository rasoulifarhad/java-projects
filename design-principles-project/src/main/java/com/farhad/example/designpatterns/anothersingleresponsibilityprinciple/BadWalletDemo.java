package com.farhad.example.designpatterns.anothersingleresponsibilityprinciple;

import java.math.BigDecimal;
import lombok.Data;

// Concerns:
// 1. The storing of the money and brand
// 2. The representation of the money
public class BadWalletDemo {
    interface Wallet {
        void setBrand(String brand);
        String getBrand();
        void setMoney(BigDecimal money);
        BigDecimal getMoney();
        String printMoney();
    }

    @Data
    static class MyWallet implements Wallet {
        private String brand;
        private BigDecimal money;

        @Override
        public String printMoney() {
            return money.toString();
        }
    }
}
