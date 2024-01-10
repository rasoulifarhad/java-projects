package com.farhad.example.generic.correlating_subtype_polymorphism_with_generic_polymorphism.better;

public abstract class Number<N extends Number<N>> implements Comparable<N>{

}
