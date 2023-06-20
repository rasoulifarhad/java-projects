package com.farhad.example.stream;

import static com.farhad.example.stream.collectors.model.foobar.Foo.foosWithBars;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import com.farhad.example.stream.collectors.model.foobar.Bar;
import com.farhad.example.stream.collectors.model.foobar.Foo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * map operation,transform the objects of a stream into another type of objects.
 * 
 * FlatMap transforms each element of the stream into a stream of other objects. So each object 
 * will be transformed into zero, one or multiple other objects backed by streams.
 * 
 * The contents of those streams will then be placed into the returned stream of the flatMap 
 * operation.
 */
@Slf4j
public class FlatMapDemo {
    
    public void demonstrateResolveBarObjectsOfEachFoo() {

        List<Foo> foos = foosWithBars();
        log.info("");
        foos.stream()
                .flatMap(f -> f.getBars().stream())
                .forEach(b -> log.info("{}", b.getName()));

    }

    public void demonstrateTransferFoosToBars() {

        log.info("");
        IntStream.range(1, 4)
                    .mapToObj(i -> new Foo("Foo" + i ) )
                    // Returns a stream consisting of the elements of this stream, additionally performing the provided action 
                    // on each element as elements are consumed from the resulting stream.
                    .peek(f -> IntStream
                                    .range(1, 4)
                                    .mapToObj( i -> 
                                            new Bar("Bar" + i + " <- " + f.getName() ) )
                                    .forEach(f.getBars()::add))
                    .flatMap(f -> f.getBars().stream())
                    .forEach(b -> log.info("{}", b.getName()));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Outer {
        Nested nested;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Nested {
        Inner inner;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Inner {
        String foo;
    }

    public void demonstrateNullCheckWithoutStream() {
        Outer outer = new Outer();
        if( outer != null && outer.nested != null && outer.nested.inner != null ) {
            log.info("Foo: {}", outer.nested.inner.foo);
        }

        outer = new Outer();
        try {
            Objects.requireNonNull(outer);
            Objects.requireNonNull(outer.nested);
            Objects.requireNonNull(outer.nested.inner);
            log.info("Foo: {}", outer.nested.inner.foo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        outer =  new Outer( new Nested( new Inner( "bar" ) ) );
        if( outer != null && outer.nested != null && outer.nested.inner != null ) {
            log.info("Foo: {}", outer.nested.inner.foo);
        }

        outer =  new Outer( new Nested( new Inner( "another bar" ) ) );
        try {
            Objects.requireNonNull(outer);
            Objects.requireNonNull(outer.nested);
            Objects.requireNonNull(outer.nested.inner);
            log.info("Foo: {}", outer.nested.inner.foo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demonstrateNullCheckWithOptionalAndFlatMap() {
        // Each call to flatMap returns an Optional wrapping the desired object if present or null if absent.
        Optional.of( new Outer())
            .flatMap(o -> Optional.ofNullable(o.nested))
            .flatMap(n -> Optional.ofNullable(n.inner))
            .flatMap(i -> Optional.ofNullable(i.foo))
            .ifPresent(f -> log.info("Foo: {}", f));

        Optional.of( new Outer( new Nested( new Inner( "bar" ) ) ))
            .flatMap(o -> Optional.ofNullable(o.nested))
            .flatMap(n -> Optional.ofNullable(n.inner))
            .flatMap(i -> Optional.ofNullable(i.foo))
            .ifPresent(f -> log.info("Foo: {}", f));
    }

    public static void main(String[] args) {
        FlatMapDemo demo = new FlatMapDemo();

        demo.demonstrateResolveBarObjectsOfEachFoo();
        demo.demonstrateTransferFoosToBars();
        demo.demonstrateNullCheckWithoutStream();
        demo.demonstrateNullCheckWithOptionalAndFlatMap();
    }



}
