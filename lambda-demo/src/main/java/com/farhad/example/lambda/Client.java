package com.farhad.example.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Client {
    

    public C2 findFirstC2WithoutLambda(A a) {

        for (B b : a.getListOfBs()) {
            for (C c : b.getListOfCs()) {
                if ( c instanceof C2 ) {
                    return ( C2 ) c ;
                }
            }
        }
        return null;
    }

    public <T> T findFirstWithoutLambda( A a, Class<T> clazz  ) {

        for (B b : a.getListOfBs()) {
            for (C c : b.getListOfCs()) {
                if ( clazz.isAssignableFrom(c.getClass()) ) {
                    return clazz.cast(c) ;
                }
            }
        }
        return null;
    }


    public C2 findFirstC2WithoutLambdaComplete(A a) {

        if ( a == null || a.getListOfBs() == null ) {
            return null;
        }

        for (B b : a.getListOfBs()) {
            List<C> cs = b.getListOfCs() ;
            if ( cs == null ) {
                continue;
            }

            for (C c : cs) {
                if ( c instanceof C2 ) {
                    return ( C2 ) c ;
                }
            }
        }
        return null;
    }

    public Optional<C2> findFirstC2(A a) {

        return a.getListOfBs().stream()
                                .flatMap( b -> b.getListOfCs().stream()) 
                                .filter( C2.class::isInstance )
                                .map( C2.class::cast )
                                .findFirst();
    }

    public  <T extends C> Optional<T> findFirst( A a, Class<T> clazz ) {

        return a.getListOfBs().stream()
                                .flatMap( b -> b.getListOfCs().stream()) 
                                .filter( clazz::isInstance )
                                .map( clazz::cast )
                                .findFirst();
    }

    public Optional<C2> findFirstC2Complete(A a) {

        return  Optional.ofNullable( a )
                                .map( A::getListOfBs )
                                .orElseGet( Collections::emptyList )
                                .stream()
                                .flatMap( this::toStreamOfC )
                                .filter(C2.class::isInstance)
                                .map( C2.class::cast)
                                .findFirst();
    }

    private Stream<C> toStreamOfC( B b ) {

        return Optional.ofNullable( b.getListOfCs() )
                            .orElseGet( Collections::emptyList )
                            .stream();
    }

}
