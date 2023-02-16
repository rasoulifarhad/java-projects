package com.farhad.example.dispatch.doubledispatch.v1;

import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;;

@Slf4j
public class DiscountTest {
   
    @Test
    public void double_dispatch_test() {

        // Given
        HtmlOrderViewCreator htmlOrderViewCreator = new HtmlOrderViewCreator();

        Order orderWith501Dollars = Order.orderOfOneProduct501();
        GoldishOrder goldishOrderWith501Dollars = GoldishOrder.orderOfOneProduct501();

        // When
        orderWith501Dollars.accept(htmlOrderViewCreator);
        String orderHtml = htmlOrderViewCreator.getHtml();

        goldishOrderWith501Dollars.accept(htmlOrderViewCreator);
        String goldishOrderHtml = htmlOrderViewCreator.getHtml() ;
      
        // Then
        log.info("orderHtml: {}", orderHtml);
        log.info("goldishOrderHtml: {}", goldishOrderHtml);
        assertThat(orderHtml).containsPattern("<p>Regular order total cost: .*</p>");
        assertThat(goldishOrderHtml).containsPattern("<h1>Goldish user order</h1><p> total cost: .*</p>");
    }



}
