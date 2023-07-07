package com.farhad.example.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import javax.money.CurrencyContext;
import javax.money.CurrencyContextBuilder;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.RoundingQuery;
import javax.money.RoundingQueryBuilder;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class RoundingDemoTest {
    
    private static final String s1 = "200.12345678";
    private static final String s2 = "100.1234567";
    private static CurrencyContext CTX = CurrencyContextBuilder.of("RoundingDemoTest").build(); 
    private MonetaryAmount [] moneys = new MonetaryAmount[] {Money.of(new BigDecimal(s1), "CHF"),
                                                            Money.of(new BigDecimal(s2),"JPY") };
    
    @Test
    public void demonstrateRoundingWithDefaultRounding() {
        System.out.println(s1);
        System.out.println(s2);
        for (MonetaryAmount m : moneys) {
            System.out.println( m + ", " +  m.with(Monetary.getDefaultRounding()));
        }
    }

    @Test
    public void demonstrateRoundingForCash() {
        System.out.println(s1);
        System.out.println(s2);
        for(MonetaryAmount m : moneys) {
            RoundingQuery rq = RoundingQueryBuilder.of().setCurrency(m.getCurrency()).set("cashRounding", true).build();
            System.out.println( m + ", " +  m.with(Monetary.getRounding(rq)));
        }
    }

    @Test
    public void demonstrateRoundingMath() {
        System.out.println(s1);
        System.out.println(s2);
        RoundingQuery rq = null;
        for(MonetaryAmount m : moneys) {
            rq = RoundingQueryBuilder.of().setCurrency(m.getCurrency()).set(RoundingMode.UP).build();
            System.out.println( m + ", "  + m.with(Monetary.getRounding(rq)));
        }
    }

    @Test
    public void demonstrateKnownRoundingNames() {
        System.out.println(s1);
        System.out.println(s2);
        Set<String> rn =  Monetary.getRoundingNames();
        rn.forEach(roundingName -> System.out.println(roundingName) );
    }
}
