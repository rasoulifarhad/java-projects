package com.farhad.example.designpatterns.anothersingleresponsibilityprinciple;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GoodWalletDemo {
    
    interface Wallet {
        String getBrand();
        void setBrand(String brand);
        BigDecimal getMoney();
        void setMoney(BigDecimal money);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class MyWallet implements Wallet {
        private String brand;
        private BigDecimal money;
    }

    interface MoneyPrinter {
        void printMoney(BigDecimal money);

        static MoneyPrinter instance() {
            return new ToStringPrinter();
        }
    }

    static class ToStringPrinter implements MoneyPrinter {

        @Override
        public void printMoney(BigDecimal money) {
            System.out.println(money.toString());
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new MyWallet("My Brand", new BigDecimal("500.0"));
        MoneyPrinter printer = MoneyPrinter.instance();
        printer.printMoney(wallet.getMoney());
    }
}
