package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.next_gen_pos_demo.datatype.Money;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.event.PropertyEvent;
import com.farhad.example.design_principles02.next_gen_pos_demo.domain.listener.PropertyListener;
import com.farhad.example.design_principles02.next_gen_pos_demo.posruleengine.POSRuleEngineFacade;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Sale {

	@Setter
	private SalePricingStrategy pricingStrategy;
	private boolean isComplete;
	private List<SalesLineItem> lineItems;
	private Instant time;
	private Payment payment;
	private List<TaxLineItem> taxLineItems;
	private Customer customer;

	private List<PropertyListener> propertyListeners;
	private Money total;

	public Sale() throws Exception {
		lineItems = new ArrayList<>();
		taxLineItems = new ArrayList<>();
		isComplete = false;
		time = Instant.now();
		pricingStrategy = PricingStrategyFactory.getInstance().getSalePricingStrategy();
		propertyListeners = new ArrayList<>();
	}

	public void makeLineItem(ProductDescription productDescription, int quantity) {
		SalesLineItem item = SalesLineItem.of(productDescription, quantity);
		if (POSRuleEngineFacade.getInstance().isInvalid(item, this)) {
			lineItems.add(item);
		}
	}

	public void complete() {
		this.isComplete = true;
	}

	public Money getTotal() {
		return lineItems.stream()
				.map(SalesLineItem::getSubtotal)
				.reduce(Money.of("0.0"), (m1, m2) -> m1.add(m2));

	}

	public Payment makePayment(Money cashTendered) {
		this.payment = Payment.create(cashTendered);
		return this.payment;
	}

	public Money getBalance() {
		return payment.getAmount().minus(getTotal());
	}

	// remove that
	public String printReceipt() {
		StringBuilder receipt = new StringBuilder();
		for (SalesLineItem item : lineItems) {
			receipt.append(item.toString());
			receipt.append("\n");
		}
		receipt.append("Total:       " + getTotal() + "\n");
		receipt.append("Paid amount: " + payment.getAmount() + "\n");
		receipt.append("Balance:     " + getBalance());
		return receipt.toString();
	}

	public Money getTenderedAmountOfPayment() {
		return payment.getAmount();
	}

	public AccountHolder getAccountHolderOfPayment() {
		return payment.getAccount().getAccountHolder();
	}

	public Money getPreDiscountTotal() {
		return getTotal();
	}

	public void enterCustomerForDiscount(Customer customer) {
		this.customer = customer;
		PricingStrategyFactory.getInstance().addCustomerPricingStrategy(this);
	}

	public void addPropertyListener(PropertyListener propertyListener) {
		propertyListeners.add(propertyListener);
	}

	private void publishPropertyEvent(String name, Object oldvalue, Object value) {
		PropertyEvent propertyEvent = new PropertyEvent(this, name, oldvalue, value);
		propertyListeners.forEach(pl -> pl.onPropertyEvent(propertyEvent));
	}

	public void setTotal(Money newTotal) {
		Money oldTotal = this.total;
		this.total = newTotal;
		publishPropertyEvent("sale.total", oldTotal, total);
	}
}