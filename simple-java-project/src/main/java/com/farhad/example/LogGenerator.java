package com.farhad.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogGenerator {
    
    private void generateRandomLogData2(int num) {
        // Get current time
        // long currentTime = System.currentTimeMillis();
        // Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));

        // Create random error code (between 1 and 5)
        int randomNumCode = (int)Math.floor(Math.random() * 5 + 1);
        String errCode = String.format("err_%s", randomNumCode) ;

        // Create random status result
        int randomNumStatus = (int)Math.floor(Math.random() * 100 + 1);
        String status = randomNumStatus < 70 ? "OK" : ( randomNumStatus < 95 ? "WARN" : "FAIL")  ;

        // TimeZone timeZone = TimeZone.getTimeZone("UTC");
        // DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        // df.setTimeZone(timeZone);
        // df.format(date);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        Log logObgect =  Log.builder()
                                .timestamp(zonedDateTime.format(formatter))
                                .level("info")
                                .error_code(errCode)
                                .status(status)
                                .server_protocol("HTTP/1.1")
                                .request_method("GET")
                                .request_uri("/api/logger")
                                .message(String.format("This is a sample log message no. %s", num))
                            .build();
        JSONObject jo = new JSONObject(logObgect);
        // jo.put("timestamp", df.format(date));
        log.info("{}", jo.toString());
        // System.out.println(jo);
    }

    private void generateRandomLogData(int num) {
        // Get current time
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        // Create random error code (between 1 and 5)
        int randomNumCode = (int)Math.floor(Math.random() * 5 + 1);
        String errCode = String.format("err_%s", randomNumCode) ;
        // Create random status result
        int randomNumStatus = (int)Math.floor(Math.random() * 100 + 1);
        String status = randomNumStatus < 70 ? "OK" : ( randomNumStatus < 95 ? "WARN" : "FAIL")  ;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        JSONObject jo = new JSONObject();
        jo.put("timestamp", zonedDateTime.format(formatter));
        jo.put("level", "info");
        jo.put("error_code", errCode);
        jo.put("status", status);
        jo.put("server_protocol", "HTTP/1.1");
        jo.put("request_method", "GET");
        jo.put("request_uri", "/api/logger");
        jo.put("message", String.format("This is a sample log message no. %s", num));
        // log.info("{}", jo.toString());
        System.out.println(jo);
    }

    // duration in minutes
    public void  generateData(int numLogs, int duration) {
        int totalSeconds = duration * numLogs * 60;
        int freq = 1000 / numLogs ;
        Timer timer = new Timer() ;
        for (int i = 0; i < totalSeconds; i++) {
            int num = i ;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    generateRandomLogData( num + 1  );
                }
            }, freq * i);
        }
    }

    @Builder
    @Getter
    @Setter
    static class Log {
        private String timestamp;
        private String level;
        private String error_code;
        private String status;
        private String server_protocol;
        private String request_method;
        private String request_uri;
        private String message;

    }

    public static void main(String[] args) {
        LogGenerator logGenerator = new LogGenerator();
        logGenerator.generateData(1, 1);
    }
}
