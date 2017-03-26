package calculator;

import calculator.ui.UIFactory;
import calculator.ui.UserInterface;

public class CalculatorLauncher {
		private static final String CALCULATOR_TYPE = "desktop";
		
		public static void main(String[] args) {

			UIFactory factory = UIFactory.getInstance();
			UserInterface ui = factory.getUI(CALCULATOR_TYPE);
			System.out.println(CALCULATOR_TYPE);
			ui.run();
		
		}

}
