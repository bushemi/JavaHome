package calculator.control;

import java.util.ArrayList;
import java.util.List;

import calculator.CalculatorService;
import calculator.Validator;
import calculator.ui.Listener;
import calculator.ui.UserInterface;

public class CalculatorController implements Listener{
	private static CalculatorController _instance;
	private Validator v;
	public static final String[] cases = { "b0", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "bComma", "bPlus", "bMulty",
			"bMinus", "bDivide", "bSqrt", "bExponent", "bPercent", "bLeftBracket", "bRightBracket", "bBackspace",
			"bLoad", "bSave", "bShowHistory", "bCalculations","unknown" };

	
	private static List<Listener> listeners =new ArrayList<Listener>();
	private CalculatorService cs =new CalculatorService();
	
	private CalculatorController() {
		v=Validator.getInstance();
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
			return s;
		}
	}

	@Override
	public void fireEvent(String eventtoString) {
		String s = getValue(eventtoString);
		
		

		if (s.equals("calc")){
		s="get";
		}
		if (s.charAt(0)=='$'){
			s=s.substring(1);
			try {
				s=new String("f"+workingWithBracket(s));
			}catch(RuntimeException re)
				{s=new String("f"+re.getMessage());}

		
		}
		update(s);
	}

 private String workingWithBracket(String text)throws RuntimeException{
	 String s=new String(text);
	 String result = "";
	 if (v.isOkayWithBrackets(s)){while(v.countingLeftBrackets(s)>0){
			int q1=s.lastIndexOf('(')+1;
			int q2=s.indexOf(')');
			String q3=s.substring(q1, q2);
			System.out.println("new string: "+q3);
			cs.calculate(q3);
			String newResult = String.valueOf(cs.getSum());
			String q4=s.replace('('+q3+')', newResult);
			//System.out.println(q4);
			s = new String(q4);
			System.out.println(s +":" + v.countingLeftBrackets(s));}
	 cs.calculate(s);
	 result=String.valueOf(cs.getSum());
		}
		else{
			throw new RuntimeException("fail");}
	 return result;
 }



	public static Listener getInstance() {
		if (_instance==null){
			_instance= new CalculatorController();
		}
		return _instance;
	}




	public static void addActionListener(Listener l){
		for(int i=0;i<listeners.size();i++){
			if (listeners.get(i).equals(l)){
				return;
			}
		}
		listeners.add(l);
	}
	public static void removeActionListener(Listener l){
		for(int i=0;i<listeners.size();i++){
			if (listeners.get(i).equals(l)){
				listeners.remove(i);
				return;
			}
		}
	}
	private void update(String event){
		listeners.forEach((e)->e.fireEvent(event));
		
	}
}

	

