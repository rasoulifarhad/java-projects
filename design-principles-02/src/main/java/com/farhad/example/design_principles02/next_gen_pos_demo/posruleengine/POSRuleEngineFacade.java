package com.farhad.example.design_principles02.next_gen_pos_demo.posruleengine;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Payment;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Sale;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.SalesLineItem;

public class POSRuleEngineFacade {

	private static POSRuleEngineFacade instance;

	private List<Rule> rules;

	
	private POSRuleEngineFacade() {
		rules = new ArrayList<>();
	}

	public synchronized static POSRuleEngineFacade getInstance() {
		if (instance == null) {
			instance = new POSRuleEngineFacade();
		}
		return instance;
	}
	
	public boolean isInvalid(SalesLineItem item, Sale sale) {
		return false;
	}

	public boolean isInvalid(Payment payment, Sale sale) {
		return false;
	}

}
