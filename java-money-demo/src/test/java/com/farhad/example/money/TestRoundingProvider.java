package com.farhad.example.money;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;
import javax.money.RoundingContext;
import javax.money.RoundingContextBuilder;
import javax.money.RoundingQuery;
import javax.money.spi.RoundingProviderSpi;

public final class TestRoundingProvider implements RoundingProviderSpi{

    private static final MonetaryRounding ROUNDING = new MyCurrencyRounding();
    private final Set<String> roundingNames;
    
    public TestRoundingProvider() {
        Set<String> names = new HashSet<>();
        names.add("custom1");
        this.roundingNames = Collections.unmodifiableSet(names);
    }
    @Override
    public MonetaryRounding getRounding(RoundingQuery query) {
        CurrencyUnit cu = query.getCurrency();
        if (cu != null && "BTC".equals(cu.getCurrencyCode())) {
            return ROUNDING;
        }
        return null;
    }

    @Override
    public Set<String> getRoundingNames() {
        return Collections.emptySet();
    }

    private static final RoundingContext ROUNDING_CONTEXT = RoundingContextBuilder.of("farhad", "farhadd").build(); 
    static class  MyCurrencyRounding implements MonetaryRounding, Serializable {

        @Override
        public MonetaryAmount apply(MonetaryAmount amount) {
            MonetaryRounding r = Monetary.getRounding(amount.getCurrency());
            return r.apply(amount);
        }

        @Override
        public RoundingContext getRoundingContext() {
            return ROUNDING_CONTEXT;
        }

    }
    
}
