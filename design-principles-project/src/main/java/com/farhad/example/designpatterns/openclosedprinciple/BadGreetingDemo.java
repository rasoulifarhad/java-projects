package com.farhad.example.designpatterns.openclosedprinciple;

public class BadGreetingDemo {
	

	public static class Greeter {
		
		private String formality;

		public void setFormality(String formality) {
			this.formality = formality;
		}

		public String greet() {
			if ("formal".equals(formality)) {
				return "Good evening, sir.";
			} else if ("casual".equals(formality)) {
				return "Sup bro?";
			} else if ("intimate".equals(formality)) {
				return "Hello Darling!";
			} else {
				return "Hello.";
			}
		}
	}
}
