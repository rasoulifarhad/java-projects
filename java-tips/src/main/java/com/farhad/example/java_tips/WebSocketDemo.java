package com.farhad.example.java_tips;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocketHandshakeException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class WebSocketDemo {

    public static void main(String[] args) {
        
        new WebSocketDemo().demo();
    }

    private void demo() {

        try {
            WebSocket server = new WebSocketConfig().getWebSocket();
            server.sendText("Hello", true);

            server.sendClose(1001, "Bye!");
        } catch (Exception e) {
            if(e.getMessage().contains("WebSocketHandshakeException")) {
                var hex = ((WebSocketHandshakeException)  e.getCause()).getResponse();
                System.err.println("Body:\t" + hex.body());
                System.err.println("HTTP Request:  " + hex.request());
                System.err.println("HTTP Version:  " + hex.version());
                System.err.println("Headers:");
                hex.headers().map().forEach((h, v) -> System.err.println("   " + h + ":   " + v));
                System.err.println("Previous response:  " + hex.previousResponse());
            } else {
                e.printStackTrace();
            }
        }
    }

    static class WebSocketConfig {
    
        private final String ENDPOINT = "ws://localhost:8080";
        private final WebSocket server;

        public WebSocketConfig() throws InterruptedException, ExecutionException {
            WebSocket.Listener listener = new WebSocketListener();
            CompletableFuture<WebSocket> futureWebSocket;
            futureWebSocket = HttpClient
                .newHttpClient()
                .newWebSocketBuilder()
                .buildAsync(URI.create(ENDPOINT), listener);
            server = futureWebSocket.get();
        }

        WebSocket getWebSocket() {
            return server;
        }
    }

    static class WebSocketListener implements WebSocket.Listener {

        @Override
        public void onOpen(WebSocket webSocket) {
            webSocket.request(1);
            System.out.println("websocket listener opened.");
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println(data);
            webSocket.request(1);
            return new CompletableFuture<String>()
                .completeAsync(() -> "onText completed").thenAccept(System.out::println);
        }

        @Override
        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
            System.out.println("websocket listener closed. statuseCode: " + statusCode);
            System.out.println("Cause: " + reason);
            webSocket.sendClose(statusCode, reason);
            return new CompletableFuture<Void>();
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Error: " + error.getCause());
            System.out.println("Message: " + error.getLocalizedMessage());
            webSocket.abort();
        }
    
        
        
    }
}
