package calculator;

import calculator.ui.UIFactory;
import calculator.ui.UserInterface;

public class Main {

	public static void main(String[] args) {

		UIFactory factory = UIFactory.getInstance();
		UserInterface ui = factory.getUI("console");
		ui.run();
		
	}

}
