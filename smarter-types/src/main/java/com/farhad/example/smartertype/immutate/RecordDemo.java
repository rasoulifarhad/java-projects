package com.farhad.example.smartertype.immutate;

import static com.farhad.example.smartertype.util.Check.valid;
import static com.farhad.example.smartertype.util.Show.show;


public class RecordDemo {
	
	record Stars(int n) {

		Stars {
			
			show("In compact constructor:"); 
			show("n: " + n + ", n(): " + n());
			// compile error: The blank final field n may not have been initialized
			// show("this.n: " + this.n);

			x();
		}
		public void x() {
			show("n: " + n + ", n(): " + n());
			show("this.n: " + this.n);
		}
		public static void main(String[] args) {
			Stars s = new Stars(10);
			show("After construction:");
			s.x();
		}
	}


	record FullName(String name) {

		FullName {
			show("Checking Fullname " + name);
			valid(name.split(" ").length > 1, name + " needs  first and last names");
		}
	}

	record BirthDate(String dob) {

		BirthDate {
			show("TODO: Check BirthDate " +  dob);
		}
	}

	record EmailAddress(String address) {

		EmailAddress {
			show("TODO: Checking EmailAddress " + address);
		}
	}

	record Person(FullName name , BirthDate dateOfBirth, EmailAddress email) {
		Person {
			show("TOTO: Check Person");
		}
	}

	public static class People {
		public static void main(String[] args) {
			
			Person person = new Person(
				new FullName("Far Fas"), 
				new BirthDate("xx/xx/xxxx"), 
				new EmailAddress("xxxxx@gmail.com"));
			show(person);
		}
	}
}
