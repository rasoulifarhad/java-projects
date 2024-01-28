package com.farhad.example.design_principles02.next_gen_pos_demo.datatype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemId {

	private String id;

	public static ItemId of(String id) {
		return new ItemId(id);
	}

	public static ItemId of(int id) {
		return new ItemId(Integer.toString(id));
	}


}
