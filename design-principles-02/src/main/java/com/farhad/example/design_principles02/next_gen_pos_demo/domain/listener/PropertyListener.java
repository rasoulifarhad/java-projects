package com.farhad.example.design_principles02.next_gen_pos_demo.domain.listener;

import com.farhad.example.design_principles02.next_gen_pos_demo.domain.event.PropertyEvent;

public interface PropertyListener {

	void onPropertyEvent(PropertyEvent propertyEvent );
}
