package com.farhad.example.ddd_tips.application_service.domain.model.order.access;

public class OrderAccessException extends RuntimeException {
    
    public OrderAccessException(){
        super();
    }

    public OrderAccessException(String message){
        super(message);
    }

    public OrderAccessException(Throwable cause){
        super(cause);
    }

    public OrderAccessException(String message, Throwable cause){
        super(message, cause);
    }

}
