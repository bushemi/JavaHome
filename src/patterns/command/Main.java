package patterns.command;

import patterns.command.commandsImpl.CommandUI;

public class Main {
	private static CommandUI ui;

	public static void main(String[] args) {
		ui = CommandUI.getInstance();
		ui.kill("Peter");
		ui.kill("Stewie");
		ui.kill("Meg");
		ui.res("Evgen");

	}

}
