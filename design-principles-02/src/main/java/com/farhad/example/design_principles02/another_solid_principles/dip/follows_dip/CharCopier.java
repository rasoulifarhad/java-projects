package com.farhad.example.design_principles02.another_solid_principles.dip.follows_dip;

public class CharCopier {
	
	public void copy(Reader reader, Writer writer) {
		int c;
		while ( (c = reader.getChar()) != -1 ) {
			writer.putChar((char)c);
		}
	}

}
