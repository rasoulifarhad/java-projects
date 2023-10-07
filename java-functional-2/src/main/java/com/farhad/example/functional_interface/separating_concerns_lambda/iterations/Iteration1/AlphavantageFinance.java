package com.farhad.example.functional_interface.separating_concerns_lambda.iterations.Iteration1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

public class AlphavantageFinance {

    public static BigDecimal getPrice(final String ticker) {
        try {
            String strUrl = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=C1869ZFS2Y0RJ7KQ&datatype=csv", ticker).toString();
            final URL url = new URL(strUrl);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[4]);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
