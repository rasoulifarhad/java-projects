package com.farhad.example.designpatterns.adapter;

import lombok.RequiredArgsConstructor;

// See https://medium.datadriveninvestor.com/practical-use-of-design-patterns-in-java-1c73f7cbd6ca
public class SocketDemo {
    
    public static void main(String[] args) {
        Socket socket = new ChargingCable();
        socket.connect();
        Earplug earplug = new Earplug();
        Socket earplugAdapter = new EarplugAdapter(earplug);
        earplugAdapter.connect();
    }

    interface Socket {
        void connect();
    }

    static class ChargingCable implements Socket {

        @Override
        public void connect() {
            System.out.println("Charging device......");
        }
    }

    static class Earplug implements EarplugSocket {

        @Override
        public void connectEarplugSocket() {
            System.out.println("Earplug connectected Socket with adapter. ");
        }
    }

    interface EarplugSocket {
        void connectEarplugSocket();
    }

    @RequiredArgsConstructor
    static class EarplugAdapter implements Socket {

        private final Earplug earplug;
        @Override
        public void connect() {
            this.earplug.connectEarplugSocket();
        }

    }
}
