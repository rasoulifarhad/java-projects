package com.farhad.example.design_principles02.sales_invoice;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LineItems {

	private int maxLineItems;
	private SalesInvoice salesInvoice;

	public LineItems(int maxLineItems, SalesInvoice salesInvoice) {
		this.maxLineItems = maxLineItems;
		this.salesInvoice = salesInvoice;
		this.ltems = new ArrayList<>();
	}

	private List<LineItem> ltems;
}
