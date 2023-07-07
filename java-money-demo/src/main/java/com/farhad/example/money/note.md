## What is JSR 354?

See https://github.com/JavaMoney/jsr354-ri/blob/master/moneta-core/src/main/asciidoc/userguide.adoc

See https://github.com/JavaMoney/javamoney-lib

See https://www.baeldung.com/java-money-and-currency

See https://github.com/JavaMoney/javamoneyjmh

See https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-lang-math-3/src/test/java/com/baeldung/money/JavaMoneyUnitManualTest.java

JSR 354 provides a portable and extendible framework for handling of Money & Currency. The API models monetary amounts and currencies in a platform independent and portable way, including well defined extension points. It's API defines a simple yet flexible contract that enables users to choose the implementation matching their target requirements best and having full control about the numeric state at all stages during monetary processing. 


> The API basically consists of four packages:

- `javax.money` contains the main artifacts of the API, e.g. the interfaces for MonetaryAmount, CurrencyUnit, MonetaryOperator, MonetaryQuery, and the accessor singletons for amounts, currencies and roundings.
- `javax.money.convert` contains currency conversion logic.
- `javax.money.format` contains the formatting logic, which has some similarities with java.text but relies more on immutable artifacts and builders.
- `javax.money.spi` contains the service provider interfaces and the bootstrap logic, which allows to configure the API also within EE contexts (e.g. running it within a CDI container).


> The Money class is internally based on java.math.BigDecimal. Therefore the arithmetic precision and rounding capabilities of BigDecimal are also usable with Money.  

<br/>

> By default, instances of Money internally are initialized with MathContext.DECIMAL64.  

<br/>

> The class FastMoney internally uses a single long value to model a monetary amount. it uses a fixed scale of 5 digits. 

<br/>

> by default FastMoney rounds input values (of type MonetaryAmount, or numbers) to its internal 5 digits scale. 

<br/>

> By default, additional implementation classes are added, by registering an instance of MonetaryAmountFactoryProviderSpi as JDK services loaded by java.util.ServiceLoader. 

<br/>

> For this you have to add the following contents to META-INF/services/javax.money.spi.MonetaryAmountFactoryProviderSpi:

```
my.fully.qualified.MonetaryAmountFactoryProviderImplClass
```

> For further ease of use, your implementations may furthermore provide static factory methods, e.g.

<br/>

```java
public static MyMoney of(String currencyCode, double number);
public static MyMoney of(String currencyCode, long number);
public static MyMoney of(String currencyCode, Number number);
```

> utility functions

>> MonetaryUtil.reciprocal() provides an operator for calculating the reciprocal value of an amount (1/amount).

<br/>

>> MonetaryUtil.permil(BigDecimal decimal), MonetaryUtil.permil(Number number), MonetaryUtil.permil(Number number, MathContext mathContext) provides an operator for calculating permils.

<br/>

>> MonetaryUtil.percent(BigDecimal decimal), MonetaryUtil.percent(Number number) provides an operator for calculating percentages.

<br/>

>> MonetaryUtil.minorPart() provides an operator for extracting only the minor part of an amount.

<br/>

>> MonetaryUtil.majorPart() provides an operator for extracting only the major part of an amount.

<br/>

>> MonetaryUtil.minorUnits() provides a query for extracting only the minor units of an amount.

<br/>

>> MonetaryUtil.majorUnits() provides a query for extracting only the major units of an amount.

<br/>

> Additionally several aggregate functions are provided on MonetaryFunctions, they are specially useful when combined with the new Java 8 Lambda/Streaming features:

>> public static Collector<MonetaryAmount, ?, Map<CurrencyUnit, List<MonetaryAmount>>> groupByCurrencyUnit() provides a Collector to group by CurrencyUnit.

<br/>

>> public static Collector<MonetaryAmount, MonetarySummaryStatistics, MonetarySummaryStatistics> summarizingMonetary() create the summary of the MonetaryAmount.

<br/>

>> public static Collector<MonetaryAmount, GroupMonetarySummaryStatistics, GroupMonetarySummaryStatistics> groupBySummarizingMonetary() create MonetaryAmount group by MonetarySummary.

<br/>

>> public static Comparator<MonetaryAmount> sortCurrencyUnit() get a comparator for sorting currency units ascending.

<br/>

>> public static Comparator<MonetaryAmount> sortCurrencyUnitDesc() get a comparator for sorting currency units descending.

<br/>

>> public static Comparator<MonetaryAmount> sortNumber() + access a comparator for sorting amount by number value ascending.

<br/>

>> public static Comparator<MonetaryAmount> sortNumberDesc() access a comparator for sorting amount by number value descending.

<br/>

>> public static Predicate<MonetaryAmount> isCurrency(CurrencyUnit currencyUnit) creates a predicate that filters by CurrencyUnit.

<br/>

>> public static Predicate<MonetaryAmount> isNotCurrency(CurrencyUnit currencyUnit) creates a predicate that filters by +CurrencyUnit.

<br/>

>> public static Predicate<MonetaryAmount> containsCurrencies(CurrencyUnit requiredUnit, CurrencyUnit... otherUnits) creates a filtering predicate based on the given currencies.

<br/>

>> public static Predicate<MonetaryAmount> isGreaterThan(MonetaryAmount amount) creates a filter using MonetaryAmount.isGreaterThan.

<br/>

>> public static Predicate<MonetaryAmount> isGreaterThanOrEqualTo( MonetaryAmount amount) creates a filter using MonetaryAmount.isGreaterThanOrEqualTo.

<br/>

>> public static Predicate<MonetaryAmount> isLessThan(MonetaryAmount amount) creates a filter using MonetaryAmount.isLess.

<br/>

>> public static Predicate<MonetaryAmount> isLessThanOrEqualTo( MonetaryAmount amount) creates a filter using MonetaryAmount.isLessThanOrEqualTo.

<br/>

>> public static Predicate<MonetaryAmount> isBetween(MonetaryAmount min, MonetaryAmount max) creates a filter using the isBetween predicate.

<br/>

>> public static MonetaryAmount sum(MonetaryAmount a, MonetaryAmount b) adds two monetary together.

<br/>

>> public static MonetaryAmount min(MonetaryAmount a, MonetaryAmount b) returns the smaller of two MonetaryAmount values. If the arguments have the same value, the result is that same value.

<br/>

>> public static MonetaryAmount max(MonetaryAmount a, MonetaryAmount b) returns the greater of two MonetaryAmount values. If the arguments have the same value, the result is that same value.

<br/>

>> public static BinaryOperator<MonetaryAmount> sum() Creates a BinaryOperator to sum.

<br/>

>> public static BinaryOperator<MonetaryAmount> min() creates a BinaryOperator to calculate the minimum amount

<br/>

>> public static BinaryOperator<MonetaryAmount> max() creates a BinaryOperator to calculate the maximum amount.

<br/>


> Moneta provides different roundings, all accessible from the `MonetaryRoundings` singleton.

<br/>

> You can acquire instances of arithmetic roundings by passing the target scale and RoundingMode to be used within the `RoundingQuery` passed:

<br/>



> You can add additional roundings by registering instances of RoundingProviderSpi. Be default this has to be done based on the mechanism as defined by the Java ServiceLoader.

<br/>

Implement a RoundingProviderSpi providing a currency rounding for "BTC" (Bitcoin):

```java
public final class TestRoundingProvider implements RoundingProviderSpi {

    private static final MonetaryRounding ROUNDING = new MyCurrencyRounding();

    private final Set<String> roundingNames;

    public TestRoundingProvider() {
        Set<String> names = new HashSet<>();
        names.add("custom1");
        this.roundingNames = Collections.unmodifiableSet(names);
    }

    @Override
    public MonetaryRounding getRounding(RoundingQuery roundingQuery) {
        CurrencyUnit cu = roundingQuery.getCurrency();
        if (cu != null && "BTC".equals(cu.getCurrencyCode())) {
            return ROUNDING;
        }
        return null;
    }

    @Override
    public Set<String> getRoundingNames() {
        return Collections.emptySet();
    }

}
```



> For adding additional CurrencyUnit instances to the MonetaryCurrencies singleton, you must implement an instance of CurrencyProviderSpi. Following a minimal example, hereby also using the BuildableCurrencyUnit class, that also provides currencies for Bitcoin:

<br/>

Implementing a Bitcoin currency provider:

```java
public final class BitCoinProvider implements CurrencyProviderSpi {

    private Set<CurrencyUnit> bitcoinSet = new HashSet<>();

    public BitCoinProvider() {
       bitcoinSet.add(CurrencyUnitBuilder.of("BTC", "MyCurrencyBuilder").build());
       bitcoinSet = Collections.unmodifiableSet(bitcoinSet);
    }

    /**
     * Return a {@link CurrencyUnit} instances matching the given
     * {@link javax.money.CurrencyQuery}.
     *
     * @param query the {@link javax.money.CurrencyQuery} containing the parameters determining the query. not null.
     * @return the corresponding {@link CurrencyUnit}s matching, never null.
     */
    @Override
    public Set<CurrencyUnit> getCurrencies(CurrencyQuery query) {
       // only ensure BTC is the code, or it is a default query.
       if (query.isEmpty()
           || query.getCurrencyCodes().contains("BTC")
           || query.getCurrencyCodes().isEmpty()) {
           return bitcoinSet;
       }
       return Collections.emptySet();
    }

}
```


> By default, the BitCoinProvider class must be configured as service to be loadable by java.util.ServiceLoader. This can be achieved by adding a file META-INF/services/javax.money.spi.CurrencyProviderSpi with the following content to your classpath:

<br/>

Contents of META-INF/services/javax.money.spi.CurrencyProviderSpi

```
# assuming the class BitCoinProvider is in the package my.fully.qualified
my.fully.qualified.BitCoinProvider
```

> Building Custom Currency Units

You can use the MonetaryCurrencies static methods to register currencies as follows.

Example of registering CurrencyUnit instances programmatically.

```java
CurrencyUnit unit = CurrencyUnitBuilder.of("FLS22", "MyCurrencyProvider")
    .setDefaultFractionDigits(3)
    .build();

// registering it
Monetary.registerCurrency(unit);
Monetary.registerCurrency(unit, Locale.MyCOUNTRY);
```

Fortunately CurrencyUnitBuilder is also capable of registering a currency on creation, by just passing a register flag to the call: So the same can be rewritten as follows:

Example of registering CurrencyUnit instances programmatically, using CurrencyUnitBuilder.

```java
CurrencyUnitBuilder.of("FLS22", "MyCurrencyProvider")
    .setDefaultFractionDigits(3)
    .build(true /* register */);
```