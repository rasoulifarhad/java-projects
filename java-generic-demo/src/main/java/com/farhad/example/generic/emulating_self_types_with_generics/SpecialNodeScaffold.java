package com.farhad.example.generic.emulating_self_types_with_generics;

public abstract class SpecialNodeScaffold<THIS extends SpecialNodeScaffold<THIS>> extends NodeScaffold<THIS> {

}
