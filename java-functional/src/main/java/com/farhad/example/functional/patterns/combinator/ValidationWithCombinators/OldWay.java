package com.farhad.example.functional.patterns.combinator.ValidationWithCombinators;

import java.util.Objects;

public class OldWay {
	
	static class User {

		public final String name;
		public final int age;
		public final String email;

		
		public User(String name, int age, String email) {
			Objects.requireNonNull(name);
			Objects.requireNonNull(email);
			this.name = name;
			this.age = age;
			this.email = email;
		}

		public boolean isValid() {
			return nameIsNotEmpty() && emailContainsAtsign();
		}

		private boolean emailContainsAtsign() {
			return email.contains("@");
		}

		private boolean nameIsNotEmpty() {
			return !name.trim().isEmpty();
		}
	}

	public static void main(String[] args) {
		System.out.println(new User("user", 45, "user@example.com").isValid());
	}

}
