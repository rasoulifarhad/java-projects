package com.farhad.example.design_principles02.video_store_demo.demo2.statement;

import com.farhad.example.design_principles02.video_store_demo.demo2.Customer;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class Statement {

	final Customer customer;

	public abstract String generate();
}
