package com.farhad.example.design_principles02.versioned_interface;

public interface ReversibleCommand extends Command {
	void undo();
}
