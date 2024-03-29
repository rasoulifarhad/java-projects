package com.farhad.example.design_principles02.ecommerce_system;

// There is a TaskController object that handles sales requests over the internet
//
// When the sales order is requested, the controller delegates to a SalesOrder object
//
// Changing requirements:
//
// - start charging taxeson order from customers
// - need to add rules for taxation, but how?
//   - modify existing SalesOrder to handle U.S. taxes
//   - extend the existing SalesOrder object and modify the tax rules so it applies to the new country  
//   - consider what is variable in the design / encapsulate the concept the varies
//
// In England, old-age pensioners are not required to pay taxes on sales items
//
// How can this be handled?
//
// 1. Pass age of the Customer to TaxCalculator object
// 2. Be more general and pass a Customer object
// 3. Be even more general and pass a reference to the SalesOrder object (this) to the 
//    TaxCalculator and let that EnglishStrategy object ask SalesOrder for customer age 
//    (post some html to the client)
//
// Don’t need more than one instance of each TaxCalculator class
//
// Solution:
//
// - Let Strategy objects handle the instantiation
// - Let there be only one instance
// - Don’t concern clients (SalesOrder) over this detail
// - In other words, use the Singleton design pattern
//
// In the Ecommerce system, we will now 
// 
// - “Decorate” a SalesTicket and 
// - “Observe” a Customer
//
// Decorate SalesTicketPrinter
//
// - Assume the SalesTicketPrinter currently creates an html sales receipt   Airline Ticket
// - New Requirement: Add header with company name, add footer that is an advertisement, during 
//   the holidays add holiday relevant header(s) and footer(s), we’re not sure how many
//
// One solution
//
// - Place control in SalesTicketPrinter, Then you need flags to control what header(s) get printed
// - If there are many types of headers and footers, with only one being printed each time, use Strategy
// - If there are more than one header and footer, and the ordering changes, and the number of combinations grows,
//   - use the Decorator design pattern to chain together the desired 
//     functionality in the correct order needed
//   - Start chain with decorators, end with original object
//
// Observe Customer
//
// - New Requirements: Send an email to a new customer and verify the customer's address with the post office
//
// - If this was it, hard code Customer behavior when being added to data base
// 
// Or use Observer
// 
// - With additional behaviors (such as send advertisements via snail mail), there may be a 
//   changing list of objects that need notification that a new customer is being added
//
// - These objects will have different interfaces 
// 
//   - SendEmail, SendCouponsViaSnailMail, SellPrivateInformationToTelemarketers, ....
//
// Next up: change two objects into "Observers"
//
// Observer
//
// - Have Customer extend Observable
// - Have all of the objects that need notification  implement Observer (all have the update method
// - Have some configurer add the correct observers to the Customer object with addObservers
// - Have the addCustomer method send the message notifyObservers
// 
public class App {

}
