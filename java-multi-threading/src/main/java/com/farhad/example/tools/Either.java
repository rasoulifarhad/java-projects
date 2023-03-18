package com.farhad.example.tools;

import java.util.Optional;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

/**
 * When working with streams, we probably don't want to stop processing the stream if an exception occurs. 
 * 
 * Why not consider "the exceptional situation" just as much as a possible result as we would for a "successful" result. Let's 
 * consider it both as data, continuing to process the stream, and decide afterward what to do with it.
 * 
 * An Either is a generic wrapper with two possibilities. It can either be a Left or a Right but never both. Both left and right 
 * can be of any types. ( Either<String,Integer> )
 * 
 * If we use this principle for exception handling, we can say that our Either type holds either an Exception or a value ( left 
 * is the Exception and the right is the successful value ).
 */
@Slf4j
public class Either<L,R> {

    private final L left;
    private final R right ;

    private Either(L left, R right) {
        this.left = left ;
        this.right = right;
    }

    public static <L,R> Either<L,R> Left( L value ) {
        return new Either<L,R>(value, null);
    }

    public static <L,R> Either<L,R> Right( R right ) {
        return new Either<L,R>(null, right);
    }

    public Optional<L> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<R> getRight() {
        return Optional.ofNullable(right);
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }

    public <T> Optional<T> mapLeft( Function<? super L, T> mapper) {
        if( isLeft() ) {
            return Optional.of(mapper.apply(left));
        }
        return Optional.empty();
    }

    public <T> Optional<T> mapRight( Function<? super R, T> mapper) {
        if ( isRight() ) {
            return Optional.of(mapper.apply(right));
        } 
        return Optional.empty();
    }

    /**
     * 
     * By adding this static lift method to the Either, we can now simply "lift" a function that throws a checked exception and let 
     * it return an Either. 
     * 
     */
    public static <T,R> Function<T,Either<Exception,R>> lift(CheckedFunction<T,R> function) {

        return t -> {
            try {
                return Either.Right(function.apply(t));
            } catch (Exception e) {
                return Either.Left(e);
            }
        };
    }

    /**
     * 
     * liftWithValue function within the Pair type is used to pair both the exception and the original value into the left of an Either.
     * Now, we have all the information we possibly need if something goes wrong, instead of only having the Exception. 
     */
    public static <T,R> Function<T,Either<Pair<Exception,T>,R>> liftWithValue(CheckedFunction<T,R> function) {
        return t -> {
            try {
                return Right(function.apply(t)) ;
            } catch (Exception e) {
                return Left(Pair.of(e, t));
            }
        };
    }
    public String toString() {
        if ( isLeft() ) {
            return String.format("Left(%s)", left);
        } else {
            return String.format("Right(%s)", right);
        }
    }
    
}
