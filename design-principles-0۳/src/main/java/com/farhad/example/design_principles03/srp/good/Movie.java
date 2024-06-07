package com.farhad.example.design_principles03.srp.good;

import com.farhad.example.design_principles03.srp.raw.User.SubscriptionType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Movie {

    private final SubscriptionType subscriptionType;
}
