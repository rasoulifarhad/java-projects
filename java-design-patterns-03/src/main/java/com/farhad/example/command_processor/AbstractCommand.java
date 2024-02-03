package com.farhad.example.command_processor;

import lombok.Getter;

public abstract class AbstractCommand implements Command {

	@Getter
	protected  CommandType commandType;

	public AbstractCommand() {
		this(CommandType.no_change);
	}

	public AbstractCommand(CommandType commandType) {
		this.commandType = commandType;
	}

	public abstract void doit();

	public abstract void undo();

}
