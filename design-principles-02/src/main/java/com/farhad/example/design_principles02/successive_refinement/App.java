package com.farhad.example.design_principles02.successive_refinement;

public class App {

	public static void main(String[] args) {
		
		try {
			Args arg = new Args("l,p#,d*", args);
			boolean logging = arg.getBoolean('l');
			int port = arg.getInt('p');
			String directory = arg.getString('d');
			executeApplication(logging, port, directory);
		} catch (ArgException e) {
			System.out.printf("Argument error: %s\n", e.errorMessage());
		}
	}

	private static void executeApplication(boolean logging, int port, String directory) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'executeApplication'");
	}
}
