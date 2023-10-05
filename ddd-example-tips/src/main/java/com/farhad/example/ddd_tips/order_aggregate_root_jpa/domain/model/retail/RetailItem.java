package com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.retail;

import java.net.URI;

import com.farhad.example.ddd_tips.order_aggregate_root_jpa.domain.model.base.Amount;

import lombok.Data;

@Data
public class RetailItem {
    
    private URI itemUri;
    private String title;
    private String desription;
    private Amount currentPrice; 
}
