package com.farhad.example.command_processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MacroCmd extends AbstractCommand {

	private String macroname;
	private Command first;
	private List<Command> commands;

	public MacroCmd(String name, Command first) {
		super(first.getCommandType());
		this.macroname = name;
		this.first = first;
		commands = new ArrayList<>();
		commands.add(first);

	}
	@Override
	public String getName() {
		return macroname;
	}

	// do every command in command s list
	@Override
	public void doit() {
		throw new UnsupportedOperationException("Unimplemented method 'doit'");
	}

	// undo all commands in commands list in reverse order
	@Override
	public void undo() {
		List<Command> reversecommands = new ArrayList<>(commands);
		Collections.reverse(reversecommands);
		reversecommands.forEach(c -> c.undo());
	}

	public void add(Command next) {
		commands.add(next);
		if (next.getCommandType() == CommandType.no_undo) {
			commandType = CommandType.no_undo;
		}
	}

	// delete commands in commands list
	public void finish() {

	}
}
