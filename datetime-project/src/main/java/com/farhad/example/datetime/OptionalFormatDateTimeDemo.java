package com.farhad.example.datetime;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalFormatDateTimeDemo {
    
    public static void main(String[] args) throws ParseException {
        String dateFormatPattern = "yyyy['-']['/']['.']MM['-']['/']['.']dd H['H']:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatPattern);

        String strDate = "2023-02-03 05:22:33";
        LocalDateTime localDateTime =  LocalDateTime.from(dateTimeFormatter.parse(strDate));
        log.info("{}",localDateTime);

        strDate = "2023/02/03 05:22:33";
        localDateTime =  LocalDateTime.from(dateTimeFormatter.parse(strDate));
        log.info("{}",localDateTime);

        strDate = "2023.02.03 05:22:33";
        localDateTime =  LocalDateTime.from(dateTimeFormatter.parse(strDate));
        log.info("{}",localDateTime);

        strDate = "2023.02.03 5:22:33";
        localDateTime =  LocalDateTime.from(dateTimeFormatter.parse(strDate));
        log.info("{}",localDateTime);
    }

}
