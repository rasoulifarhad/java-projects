package com.farhad.example.design_principles02.next_gen_pos_demo.ui;

import javax.swing.JFrame;

import com.farhad.example.design_principles02.next_gen_pos_demo.domain.ProductCatalog;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Register;

public class ProcessSaleJFrame extends JFrame{

	private Register register;
	private ProductCatalog productCatalog;

	public ProcessSaleJFrame(Register register, ProductCatalog productCatalog) {
		this.register = register;
		this.productCatalog = productCatalog;
	}

}
