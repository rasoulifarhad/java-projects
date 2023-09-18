package com.farhad.example.functional.try_success_failure;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public abstract class Try<T> {
	
	private Try(){

	}

	public abstract boolean isSuccess();

	public abstract boolean isFailure();

	public abstract T get() throws GetOfFailureException;

	public abstract T checkedGet() throws Exception;

	public abstract void forEach(Consumer<? super T> action);

	public abstract <U> Try<U> map(Function<? super T, ? extends U> mapper);

	public abstract <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> mapper);

	public abstract Try<T> filter(Predicate<? super T> predicate);

	public abstract <U> Try<U> recover(Function<? super Exception, ? extends U> recoverFun);

	public abstract <U> Try<U> recoverWith(Function<? super Exception, ? extends Try<U>> recoverFun);

	public abstract Try<Exception> failed();

	public abstract Optional<T> toOptional();

	public abstract T getOrElse(T defaultValue);

	public abstract Try<T> orElse(Try<T> defaultValue);

	public abstract <U> Try<U> transform(Function<? super T, ? extends Try<U>> successFunc,
										Function<Exception, ? extends Try<U>> failureFunc);

	public static <T> Try<T> apply(FailableSupplier<T> supplier) {
		try {
			return new Success<>(supplier.get()) ;
		} catch (Exception e) {
			return new Failure<>(e) ;
		}
	}

	@RequiredArgsConstructor
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@ToString(onlyExplicitlyIncluded = true)
	public static final class Success<T> extends Try<T> {

		@EqualsAndHashCode.Include
		@ToString.Include
		private final T value;

		@Override
		public boolean isSuccess() {
			return true;
		}

		@Override
		public boolean isFailure() {
			return false;
		}

		@Override
		public T get() throws GetOfFailureException {
			return value;
		}

		@Override
		public T checkedGet() throws Exception {
			return get();
		}

		@Override
		public void forEach(Consumer<? super T> action) {
			action.accept(value);
		}

		@Override
		public <U> Try<U> map(Function<? super T, ? extends U> mapper) {
			return Try.apply(() -> mapper.apply(value));
		}

		@Override
		public <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> mapper) {
			try {
				return mapper.apply(value);
			} catch (Exception e) {
				return new Failure<>(e);
			}
		}

		@Override
		public Try<T> filter(Predicate<? super T> predicate) {
			try {
				if(predicate.test(value)) {
					return this;
				} else {
					return new Failure<>(new NoSuchElementException("Predicate does not hold for " + value));
				}
			} catch (Exception e) {
				return new Failure<>(e);
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public <U> Try<U> recover(Function<? super Exception, ? extends U> recoverFun) {
			return (Try<U>) this;
		}

		@SuppressWarnings("unchecked")
		@Override
		public <U> Try<U> recoverWith(Function<? super Exception, ? extends Try<U>> recoverFun) {
			return (Try<U>) this;
		}

		@Override
		public Try<Exception> failed() {
			return new Failure<>(new UnsupportedOperationException("Success.failed"));
		}

		@Override
		public Optional<T> toOptional() {
			return Optional.of(value);
		}

		@Override
		public T getOrElse(T defaultValue) {
			return value;
		}

		@Override
		public Try<T> orElse(Try<T> defaultValue) {
			return this;
		}

		@Override
		public <U> Try<U> transform(Function<? super T, ? extends Try<U>> successFunc,
				Function<Exception, ? extends Try<U>> failureFunc) {
			return successFunc.apply(value);
		}
	}

	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@ToString(onlyExplicitlyIncluded = true)
	public static final class Failure<T> extends Try<T> {
		@EqualsAndHashCode.Include
		@ToString.Include
		private final Exception exception;
		private final GetOfFailureException uncheckedException;

		
		public Failure(Exception exception) {
			this.exception = exception;
			this.uncheckedException = new GetOfFailureException(exception);
		}

		@Override
		public boolean isSuccess() {
			return false;
		}

		@Override
		public boolean isFailure() {
			return true;
		}

		@Override
		public T get() throws GetOfFailureException {
			throw uncheckedException;
		}

		@Override
		public T checkedGet() throws Exception {
			throw exception;
		}

		@Override
		public void forEach(Consumer<? super T> action) {
		}

        @SuppressWarnings("unchecked")
		@Override
		public <U> Try<U> map(Function<? super T, ? extends U> mapper) {
			return (Try<U>) this;
		}
        @SuppressWarnings("unchecked")
		@Override
		public <U> Try<U> flatMap(Function<? super T, ? extends Try<U>> mapper) {
			return (Try<U>) this;
		}

		@Override
		public Try<T> filter(Predicate<? super T> predicate) {
			return this;
		}

		@Override
		public <U> Try<U> recover(Function<? super Exception, ? extends U> recoverFun) {
			try {
				return Try.apply(() ->  recoverFun.apply(exception));
			} catch (Exception e) {
				return new Failure<>(e);
			}
		}

		@Override
		public <U> Try<U> recoverWith(Function<? super Exception, ? extends Try<U>> recoverFun) {
			try {
				return recoverFun.apply(exception);
			} catch (Exception e) {
				return new Failure<>(e);
			}
		}

		@Override
		public Try<Exception> failed() {
			return new Success<Exception>(exception);
		}

		@Override
		public Optional<T> toOptional() {
			return Optional.empty();
		}

		@Override
		public T getOrElse(T defaultValue) {
			return defaultValue;
		}

		@Override
		public Try<T> orElse(Try<T> defaultValue) {
			return defaultValue;
		}

		@Override
		public <U> Try<U> transform(Function<? super T, ? extends Try<U>> successFunc,
				Function<Exception, ? extends Try<U>> failureFunc) {
			return failureFunc.apply(exception);
		}
	}

}
