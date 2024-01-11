package com.farhad.example.generic;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Demo_06 {

	interface Employee {
		double getSalary();
	}

	interface Manager extends Employee {
	}

	interface Accountant extends Employee {
	}

	interface SoftwareEngineer extends Employee {
	}

	interface Stream<T> extends BaseStream<T, Stream<T>> {
		<R> Stream<R> map(Function<? super T, ? extends R> mapper);

		<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

		IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
		T reduce(T identity, BinaryOperator<T> accumulator);
	}

	interface Stream01<T> extends BaseStream01<T> {
		<R> Stream01<R> map(Function<? super T, ? extends R> mapper);

		<R> Stream01<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

		IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);

		T reduce(T identity, BinaryOperator<T> accumulator);
	}

	interface BaseStream01<T> extends AutoCloseable {

		BaseStream01<T> sequential();

		BaseStream01<T> parallel();

		BaseStream01<T> unordered();

		BaseStream01<T> onClose(Runnable closeHandler);

		Iterator<T> iterator();

		Spliterator<T> spliterator();

		boolean isParallel();

		void close();		
	}


	// BaseStream is a typical example of the fluent API but instead of returning
	// the type itself methods return S extends BaseStream<T, S>.
	interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable {
		S sequential();

		S parallel();

		S unordered();

		S onClose(Runnable closeHandler);

		Iterator<T> iterator();

		Spliterator<T> spliterator();

		boolean isParallel();

		void close();
	}
	
	public static void main(String[] args) {
		
		Stream<Employee> employees = null;;

		employees
			.map(Employee::getSalary)
			.parallel()
			.reduce(0.0, (acc, next) -> acc + next); // // compile error


		Stream01<Employee> employees01 = null;;

		// employees01
		// 	.map(Employee::getSalary)
		// 	.parallel()
		// 	.reduce(0.0, (acc, next) -> acc + next); // // compile error
	}

}
