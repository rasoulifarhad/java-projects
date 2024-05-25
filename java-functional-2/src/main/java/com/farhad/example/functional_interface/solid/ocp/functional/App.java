package com.farhad.example.functional_interface.solid.ocp.functional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

    public static void main(String[] args) {
        
        ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(SimpleDateFormat::new);

        DateFormat dateFormat = localFormatter.get();


        AtomicInteger threadId = new AtomicInteger();
        ThreadLocal<Integer> localId = ThreadLocal.withInitial(() -> threadId.incrementAndGet());
        int idForThisThread = localId.get();
    }
}
