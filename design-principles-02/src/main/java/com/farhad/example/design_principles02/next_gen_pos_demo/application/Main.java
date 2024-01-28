package com.farhad.example.design_principles02.next_gen_pos_demo.application;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Address;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.ProductCatalog;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Register;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Store;
import com.farhad.example.design_principles02.next_gen_pos_demo.ui.ProcessSaleJFrame;

public class Main {

	public static void main(String[] args) {
		
		Address address = new Address("foo street","Melbourne","VIC","3000");
		ProductCatalog productCatalog = new ProductCatalog();
		Store store = new Store(address, "Food Store", productCatalog);
		Register register = store.getRegister();

		ProcessSaleJFrame processSaleJFrame = new ProcessSaleJFrame(register, productCatalog);
		processSaleJFrame.setVisible(true);
	}
}
