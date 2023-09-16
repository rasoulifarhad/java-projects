package com.farhad.example.ddd_tips.tomato_architecture.Demo5;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.transaction.Transactional;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Propagation;

// Instead of leveraging the power and flexibility offered by the selected framework, creating an indirection or abstraction on 
// top of the selected framework with the hope that someday you might switch the framework to a different one is usually a very 
// bad idea.
// Introducing our own similar annotations and re-implementing the same features support by delegating the actual handling to the framework 
// is unnecessary. Instead, it’s better to either directly use the framework’s annotations or compose the annotation with additional semantics 
// if needed.
public class Demo5 {
	
	static class DoThis {

		@Target(ElementType.TYPE)
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		@Transactional
		public @interface UseCase {
			@AliasFor (
				annotation = Transactional.class
			)
			Propagation propagation() default Propagation.REQUIRED;
		}
	}
}
