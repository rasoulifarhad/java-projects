package com.farhad.example.collections;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

// Use this to capture  all the artifacts/logs from the target JVM & host for analysis.
//
// ./yc -j {JAVA_HOME} -onlyCapture -p {PID} -hd
//
// ./yc -j /usr/java/jdk1.8.0_141 -onlyCapture -p 15326 -hd
//
// ps -ef | grep java
//
// java ... &
// javaPID=$!
// echo PID is $javaPID
//
@Slf4j
public class CollectionsClearDemo {
    
    static final int ARRAY_SIZE = 2_000_000;
    static final long SLEEP_TIME_MILLI = 100_000;
    static class NormalDemo {   
        private static ArrayList<Long> longList = new ArrayList<>();
        public static void main(String[] args) throws Exception {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                longList.add(Long.valueOf(i));
            }
            log.info("Array filled!!!");
            Thread.sleep(SLEEP_TIME_MILLI);
        }
    }

    static class ClearDemo {   
        private static ArrayList<Long> longList = new ArrayList<>();
        public static void main(String[] args) throws Exception {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                longList.add(Long.valueOf(i));
            }
            log.info("Array filled!!!");
            longList.clear();
            Thread.sleep(SLEEP_TIME_MILLI);
        }
    }

    static class NullDemo {   
        private static ArrayList<Long> longList = new ArrayList<>();
        public static void main(String[] args) throws Exception {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                longList.add(Long.valueOf(i));
            }
            log.info("Array filled!!!");
            longList = null;
            Thread.sleep(SLEEP_TIME_MILLI);
        }
    }

}
