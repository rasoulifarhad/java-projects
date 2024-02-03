package com.farhad.example.command_processor;

// The 'delete' command takes the object representing the text a s its first parameter.The 
// range of characters to delete is specified by two additional parameters.
public class DeleteCmd extends AbstractCommand {

	private String text;
	private int start;
	private int end;
	private String delstr;

	public DeleteCmd(String text, int start, int end) {
		super(CommandType.normal);
		this.text = text;
		this.start = start;
		this.end = end;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getName'");
	}

	@Override
	public void doit() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'doit'");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'undo'");
	}

}
