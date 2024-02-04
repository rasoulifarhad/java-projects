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
public class App {

}
