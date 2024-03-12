package com.farhad.example.design_principles02.duplication_detector;

import lombok.RequiredArgsConstructor;

// Whenever we sit down to write a class we make a series of choices. We may choose to use one library over another or we 
// may use one algorithm or another but the fact is, many of these choices are significant and the best thing that we can 
// do is be conscious of the fact that we are making them. When we are, we often find places where objects help.
//
// With that code in place, I ran my duplication detector on an old code base and found some duplication, but then I had some 
// other questions. For instance: how much duplication could I find if I made the detector replace every identifier and 
// keyword with the character 'x'? If I did that, I’d have a detector that ignored symbol information and looked directly at 
// patterns in the source. What other algorithm could I use? I could just transform the identifiers to ‘x’s and leave the 
// keywords alone. That would eliminate some ‘false positives’, patterns of duplication that we can’t really extract.
//
// Clearly,the number of ways that we can transform the source when detecting duplication is endless:we can transform the 
// source in any number of ways depending upon the type of duplication we’d like to highlight.
//
// Whenever I'mthis situation,I feel like I'moverwhelmed by choice.I feel like I’m making a choice,but I know that it can 
// change,and more often than not that means I need another object.
//
// In this case, a DuplicationDetector could use a LineTransformer class to do its work. Maybe we can have several 
// different kinds of LineTransformers. We could have an ExactMatchTransformer that accepts a line and returns it 
// with all of of its runs of whitespace converted to single spaces. And, we could have an IdentifierInvariantTransformer 
// which takes a line and returns a copy of it that has all of its identifiers converted into 'x's.
//
// If we are aware of the choices that we make as we make them, we can decide whether they are choices that can change 
// or not. If they are, it’s worth thinking about creating objects that embody them.
// 
@RequiredArgsConstructor
public class DuplicationDetector {

	private final LineTransformer lineTransformer;

	static String transformLine(String line) {
		return line.replaceAll("\\s+", " ");
	}

	protected String transformLine(Line source) {
		return lineTransformer.transform(source);
	}

}
