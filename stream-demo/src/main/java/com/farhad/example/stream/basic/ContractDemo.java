package com.farhad.example.stream.basic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.validator.routines.EmailValidator;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ContractDemo {
	
	public static final class Contract<T> {

		private final T value;
		private Contract(T value) {
			this.value = value;
		}

		public static <T> Contract<T> requireThat(final T value) {
			return new Contract<T>(value);
		}

		public static <T> Contract<T> ensureThat(final T value) {
			return new Contract<T>(value);
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		public T satisfies(final Matcher... matchers) {
			assertThat(value, allOf(matchers));
			return value;
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		public T satisfiesAnyOf(final Matcher... matchers) {
			assertThat(value, anyOf(matchers));
			return value;
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		public T satisfiesNonOf(final Matcher... matchers) {
			assertThat(value, not(anyOf(matchers)));
			return value;
		}
	}

	public static class NeverGetHere {
		public static void neverGetHere() {
			neverGetHere(""); 
		}

		public static void neverGetHere(final String message) {
			assert false : "Unexpected execution branch. ".concat(message);
		}
	}

	public static class ValidEmailAddress {
		public static Matcher<String> isValidEmailAddress() {
			return new TypeSafeMatcher<String>() {

				@Override
				public void describeTo(Description description) {
					description.appendText("email address");
				}

				@Override
				protected boolean matchesSafely(String item) {
					return EmailValidator.getInstance().isValid(item);
				}
				
			};
		}
	}


	static final class CustomizedMatcher extends TypeSafeMatcher<SomeCustomizedClass> {

		private final String expectedValue;

		public CustomizedMatcher(final String  expectedValue) {
			this.expectedValue = expectedValue;
		}
		@Override
		public void describeTo(Description description) {
			description.appendText("CustomizedMatcher");
		}

		@Override
		protected boolean matchesSafely(SomeCustomizedClass item) {
			return expectedValue.equals(item.value);
		}

	} 
	static class SomeCustomizedClass {
		public final String value;

		public SomeCustomizedClass(final String value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		final String value = Contract.requireThat("Hi").satisfies(not(nullValue()), not(isEmptyString()));
		System.out.println(value);

		Collection<String> collection = Contract.requireThat(Arrays.asList("1", "2", "3"))
												.satisfies(
													not(nullValue()),
													not(empty()),
													not(hasItem(nullValue()))
												);
		System.out.println(collection);
	}
}
