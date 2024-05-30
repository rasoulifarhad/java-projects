package com.farhad.example.synchronization.raceconditions_locks_conditions.with_lock;

public class UnsynchBankTest {

    private static final int NACCOUNT = 100;
    private static final double INITIAL_BALANCE = 1000;
    private static final int DELY = 10;
    private static final double MAX_AMOUNT = 0;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNT; i++) {
            
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };

            Thread t = new Thread(r);
            t.start();;
        }
    }
}
