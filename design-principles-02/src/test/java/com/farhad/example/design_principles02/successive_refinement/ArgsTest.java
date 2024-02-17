package com.farhad.example.design_principles02.successive_refinement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArgsTest {

	@Test
	public void testSingleBooleanPresent() {
		Args args = new Args("x", new String[] { "-x" });

		System.out.println(args.getBoolean('x'));
		assertEquals(true, args.getBoolean('x'));
	}

	@Test
	public void testSingleBooleanNotPresent() {
		Args args = new Args("x", new String[] {});

		System.out.println(args.getBoolean('x'));
		assertEquals(false, args.getBoolean('x'));
	}
	
	@Test
	public void testSimpleStringPresent() {
		Args args = new Args("x*", new String[] { "-x", "param" });

		assertTrue(args.has('x'));
		assertEquals("param", args.getString('x'));
		System.out.println(args.getBoolean('x'));
	}


	@Test
	public void testMissingStringArgument() {
		

		assertThrows(ArgException.class, () ->  {
			Args args = new Args("x*", new String[] { "-x" });
		});
	}
}
