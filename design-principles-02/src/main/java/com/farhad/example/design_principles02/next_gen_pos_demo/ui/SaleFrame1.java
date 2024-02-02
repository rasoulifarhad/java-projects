package com.farhad.example.design_principles02.next_gen_pos_demo.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.farhad.example.design_principles02.next_gen_pos_demo.domain.Sale;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.event.PropertyEvent;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.listener.PropertyListener;

public class SaleFrame1 extends JFrame implements PropertyListener {

	private static final long serialVersionUID = 1L;

	private JButton btnOk = new JButton("Ok");

	private JTextField saleTextField = new JTextField("");
	private JLabel saleLabel = new JLabel("Sale Total", SwingConstants.CENTER);

	public void initialize(Sale sale) {
		sale.addPropertyListener(this);
	}

	@Override
	public void onPropertyEvent(PropertyEvent propertyEvent) {

		if (propertyEvent.getPropertyName().equals("sale.total")) {
			saleTextField.setText(propertyEvent.getNewValue().toString());
		}
	}

}
