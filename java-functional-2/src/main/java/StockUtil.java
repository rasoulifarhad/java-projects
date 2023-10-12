import java.math.BigDecimal;
import java.util.function.Predicate;

import com.farhad.example.functional_interface.AlphavantageFinance;
import com.farhad.example.functional_interface.StockInfo;

public class StockUtil {
    
    public static StockInfo getPrice(final String ticker) {
        return new StockInfo(ticker, AlphavantageFinance.getPrice(ticker));
    }

    public static Predicate<StockInfo> isPriceLessThan(final int price) {
        return stockInfo -> stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }

    public static StockInfo pickHigh(final StockInfo s1, final StockInfo s2) {
        return s1.price.compareTo(s2.price) > 0 ? s1  : s2;
    }
}
