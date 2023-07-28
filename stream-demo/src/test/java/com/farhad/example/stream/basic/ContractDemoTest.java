package com.farhad.example.stream.basic;

import static com.farhad.example.stream.basic.ContractDemo.Contract.ensureThat;
import static com.farhad.example.stream.basic.ContractDemo.Contract.requireThat;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.farhad.example.stream.basic.ContractDemo.CustomizedMatcher;
import com.farhad.example.stream.basic.ContractDemo.NeverGetHere;
import com.farhad.example.stream.basic.ContractDemo.SomeCustomizedClass;

public class ContractDemoTest {

	@Test
	public void testNeverGeteHere() {
		assertThrows(
			AssertionError.class, 
			() -> NeverGetHere.neverGetHere());
	}

	@Test
	public void testNeverGetHereWithMessage() {
		assertThrows(
			AssertionError.class, 
			() -> NeverGetHere.neverGetHere("noooooooooo!!!"));
	}

	@Test
	public void should_satisfy_allof_test() {
		requireThat(anyValidString()).satisfies(notNullValue(String.class), not(isEmptyString()));
		ensureThat(EMPTY_LIST).satisfies(notNullValue(Collection.class), empty());
	}

	@Test
	public void should_satisfy_anyof_test() {
		requireThat(anyNonEmptyList()).satisfiesAnyOf(instanceOf(Double.class), not(empty()), not(instanceOf(Integer.class))); 
		ensureThat(anyNonEmptyList()).satisfiesAnyOf(instanceOf(Double.class), not(empty()));
	}

	@Test
	public void should_not_satisfy_anyof_test() {
		requireThat(Double.valueOf("1.3")).satisfiesNonOf(isEmptyOrNullString(), isIn(asList(1.0, 1.2, 1.4))); 
	}

	@Test
	public void should_support_customizedMatcher_test() {
		requireThat(new SomeCustomizedClass("42")).satisfies(customizedMatcher("42"));
		final SomeCustomizedClass someCustomizedClass = 
				requireThat(new SomeCustomizedClass("x")).satisfies(new CustomizedMatcher("x"));
		assertEquals("x", someCustomizedClass.value);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "ab", "qbc", "abcd"})
	public void should_support_customizedMatcher_parametrized_test(String value) {
		final SomeCustomizedClass actual = requireThat(new SomeCustomizedClass(value)).satisfies(new CustomizedMatcher(value));
		assertEquals(value, actual.value);
	}

	private String anyValidString() {
		return "Any valid string";
	}

	private List<String> anyNonEmptyList() {
		return asList("a", "b");
	}
	private Matcher<SomeCustomizedClass> customizedMatcher(final String expectedValue) {
		return new CustomizedMatcher(expectedValue);
	}


}
