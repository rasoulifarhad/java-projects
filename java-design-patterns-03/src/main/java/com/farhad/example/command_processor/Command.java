package com.farhad.example.command_processor;

public interface Command {

	public enum CommandType {
		no_change, normal, no_undo
	};

	void doit();

	void undo();

	CommandType getCommandType();

	String getName();

}
