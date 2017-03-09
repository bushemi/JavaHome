package calculator.control;

import calculator.ui.Listener;
import calculator.ui.Observer;
import calculator.ui.UserInterface;

public class CalculatorController implements Listener{
	private String[] cases = { "b0", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "bComma", "bPlus", "bMulty",
			"bMinus", "bDivide", "bSqrt", "bExponent", "bPercent", "bLeftBracket", "bRightBracket", "bBackspace",
			"bLoad", "bSave", "bShowHistory", "bCalculations","unknown" };

	private UserInterface _ui;
	private Observer listener = Observer.getInstance();
	
	public CalculatorController(UserInterface ui) {
		_ui = ui;
		Observer.addActionListener(this);
	

	}

	private String getValue(String s) {
		int i;
		if (s.charAt(0)=='1'){return "unknown";}
		for (i = 0; i < cases.length; i++)
			if (s.contains(cases[i]))
				break;

		switch (i) {
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return ".";
		case 11:
			return "+";
		case 12:
			return "*";
		case 13:
			return "-";
		case 14:
			return "/";
		case 15:
			return "sqrt";
		case 16:
			return "^";
		case 17:
			return "%";
		case 18:
			return "(";
		case 19:
			return ")";
		case 20:
			return "del";
		case 21:
			return "load";
		case 22:
			return "save";
		case 23:
			return "show";
		case 24:
			return "calc";

		default:
			System.out.println("do nothing");
		}
		return cases[i];
	}

	

	@Override
	public void fireEvent(String eventtoString) {
		String s = getValue(eventtoString);
		
		//System.out.println("+++++++++");
		if (s.equals("1")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("2")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("3")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("4")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("5")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("6")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (!s.equals("unknown")){
			System.out.println(s+" Hit the button");
			listener.fireEvent(1+s);}
		if (s.equals("calc")){
		System.out.println(s+" Hit the button");
		listener.fireEvent(2+s);}
	}
}

	

