package com.farhad.example.design_principles02.sales_invoice;

import lombok.Getter;

// ANALYZING THE SALES INVOICE
//
// The Customer is the person you send the bill to. You might ship your product to the same person.A Customer 
// object should have name and address information,so your invoice gets sent to the right address.You’ll also 
// want some credit-worthiness information and maybe some links to the Customer’s buying history.
//
// The Recipient is the person you send your product to. Because the Recipient isn’t necessarily paying the 
// bill,you don’t need the same kind of credit information you would for a Customer.If your business is the 
// sort where the Customers and the Recipients are normally different—a florist,for instance—you may want to 
// maintain the distinction between a Customer and a Recipient.In many retail or mail-order(Web-order?) 
// applications,however,the Customer and Recipient are almost always the same.In this kind of situation,it 
// makes sense to use a single class for both Customer and Recipient.That’s what we’ll do here.
//
// The SalesPerson is the person who took the order. You need to know who that is because you need to pay 
// sales commissions based on the number of units they sold.
//
// Finally, the LineItem objects store the actual items sold, with the quantities of each item. The LineItem 
// class is perhaps the most important part of the application—the key abstraction, if you will. If you get 
// the LineItem class wrong, you’re liable to lose track of how much you sold and how much each item cost.
//
// Which objects collaborate with which other objects?
// How many objects participate in each collaboration?
// Is the collaboration mandatory or optional?
//
// ANALYZING SalesInvoice COLLABORATIONS
//
// Every SalesInvoice object collaborates with only one Customer object.\
// Also, every SalesInvoice object must have a Customer - you can’t send out a bill without one.
// 
//   SalesInvoice (0..N) --------------- (1) Customer  
//   SalesInvoice (1..N) --------------- (0..1) Recipient  
//   SalesInvoice (0..N) --------------- (1) SalesPerson  
//   SalesInvoice (1) --------------- (1..N) LineItem
//
// ASSOCIATIONS AND MESSAGES
//
// classifying each relationship by using the categories given previously:
//   - Uses relationship,in which objects communicate via messages
//   - Composition relationship,in which an object is composed of other objects
//   - Simple association,in which objects depend on one another but do not directly interact
//
// Whenever one object sends a message to another object, a uses relationship is established...
//
// the SalesInvoice-Customer association is a single-direction, mandatory association that implements a uses relationship.
// 
// six different techniques for implementing a uses relationship: 
//
// - Customers as Arguments
// - Creating Your Own Customers
//   For some business transactions (buying a house or car, for instance), it might be entirely appropriate to fill out a credit application before the sale. 
// - Third-Party Customers
//   satisfies the need for Customers that can exist independently 
//    
// - Combining Constructors and Mutators
// - PASSING AN ARGUMENT
//   his is appropriate when:
//     - The object you’re going to use will be used only in a single method, and the state of that object 
//       doesn’t need to be(or positively shouldn’t be)retained between calls.
//     - The object you have to use carries with it some immediate state information that must be renewed 
//       each time the method is called.
//     - The object you’re using is easily constructed outside your class environment. If, however,it’s 
//       easier for you(in the using class)to construct the object you want to use from scratch(because 
//       of some special knowledge),use the next technique(creating objects on-the-fly).
//     - If an identical object is constructed over and over, or if it’s very time-consuming to construct 
//       an object and you need to use it more than once,you should use a referential attribute to hold a 
//       reference to the object you’ll use,rather than pass it as an argument or create it on-the-fly.
// - CREATING OBJECTS ON-THE-FLY
//   A second way to get an object that will be used in only a single method is to create it inside the 
//   method itself.
//
// Rules for Using Objects
//
// You should use a referential attribute when:
// - The object needs to be directed from several different methods, or the object stores 
//   persistent state information between method calls.
// - The object you are going to use is used repeatedly.
// - The object you are going to use is very expensive or time consuming to construct, and 
//   you will use the object more than once.
// You should pass the object you’ll use as an argument when
// - The object you want to use will be used only in a single method.
// - It’s easier to construct the object you want to use outside your class. This is the 
//   case when the object you’re going to use brings in some information supplied by the 
//   caller.
// You should construct the object you want to use on-the-fly—that is, inside the method where it’s used—when
// - The object will be used in only that method.
// - The invoking object has information needed to construct the object that will be used, information 
//   that would be more difficult or impossible for an outside caller to supply.

public class App {


	public static void main(String[] args) {
		Used usedObject = new Used();
		usedObject.methodOne();
		usedObject.methodTwo(usedObject.getPrivateText());
	}
	static class Used {
		@Getter
		private String privateText = "his is some private text";

		public void init() {

		}
		public Label methodOne() {
			return new Label(privateText);
		}
		
		public Label methodTwo(String text) {
			return new Label(text);
		}

	
	}

	static class Label {
		private String text;

		public Label(String label) {
			this.text = label;
		}
	}
}
