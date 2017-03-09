package calculator;

import calculator.ui.UIFactory;
//import calculator.ui.ConsoleUserInterface;
//import calculator.ui.DesktopUserInterface;
import calculator.ui.UserInterface;

public class Main {

	public static void main(String[] args) {
		//	UserInterface ui = new DesktopFXUserInterface();
		//	CalculatorController control = new CalculatorController(ui);
		UIFactory factory = UIFactory.getInstance();
		UserInterface ui = factory.getUI("console");
		ui.run();
		
	}

}
