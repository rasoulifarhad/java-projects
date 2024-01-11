package com.farhad.example.generic.emulating_self_types_with_generics;

public abstract class VerySpecialNodeScaffold<THIS extends VerySpecialNodeScaffold<THIS>> extends SpecialNodeScaffold<THIS> {

}
