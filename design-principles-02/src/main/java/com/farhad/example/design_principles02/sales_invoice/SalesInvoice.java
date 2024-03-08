package com.farhad.example.design_principles02.sales_invoice;

// import javax.swing.GroupLayout;
// import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class SalesInvoice extends Frame {

	private Date invoiceDate;;
	private Customer soldTo;
	private Customer shipTo;
	private SalesPerson soldBy;
	private LineItems items;

	private CustomerUI soldToUi;
	private CustomerUI shipToUi;
	
	public SalesInvoice(Customer soldTo) {
		this.soldTo = soldTo;
	}

	public SalesInvoice() {
		this(CustomerDB.getCustomer(0), CustomerDB.getCustomer(0), new SalesPerson(), null);
	}

	public SalesInvoice(int customerNumber) {
		this(CustomerDB.getCustomer(customerNumber), CustomerDB.getCustomer(customerNumber), new SalesPerson(), null);
	}
	
	

	public SalesInvoice(Customer soldTo, Customer recipient, SalesPerson soldBy, LineItems items) {
		this.soldTo = soldTo;
		this.shipTo = recipient;
		this.soldBy = soldBy;
		this.items = items == null ? this.items = new LineItems(5, this) : items;
		this.soldToUi = new CustomerUI(soldTo, " Sold To");
		this.shipToUi = new CustomerUI(shipTo, " Ship To");
	}

	private double tax() {
		return 0;
	}

	public double totalDue() {
		return 0;
	}
	
	public void buildUI() {
		Panel top = new Panel();
		top.setLayout(new GridLayout(1, 2));
		add(top, "North");
		top.add(soldToUi);
		top.add(shipToUi);
		soldToUi.setVisible(true);
		shipToUi.setVisible(true);
		setSize(800, 	800);
		setTitle("Sales invoice");
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});		

	}

	public static void main(String[] args) {
		SalesInvoice salesInvoice = new SalesInvoice();
		salesInvoice.buildUI();
	}

	public void updateTotals() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateTotals'");
	}

}
