package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private ArrayList<String> invalidChars;
	private Pattern p;
	private static Validator _instance;
	private Validator(){
		p = Pattern.compile("[a-z]");
		//System.out.println("bla-bla");
		invalidChars=new ArrayList<>();
		invalidChars.add("\\");
		invalidChars.add(",");
		invalidChars.add("|");
		invalidChars.add(" ");
		invalidChars.add("++");
		invalidChars.add("+-");
		invalidChars.add("-+");
		invalidChars.add("=");
		invalidChars.add("-/");
		invalidChars.add("-*");
	}
	public synchronized static Validator getInstance(){
		if (_instance ==null) _instance=new Validator();
		return _instance;
	}
public boolean check(String data){
	Matcher m= p.matcher(data.toLowerCase());
	if (m.find())return true;
	for ( String q :invalidChars){
		if (data.contains(q)){
			return true;
		}
	}
	return false;
}
public static  Double stringToDouble(Object o){
	String s="";
	Double d=0.0;
	try{
		
		d=Double.parseDouble(o.toString());
		if (d>Integer.MAX_VALUE) {s ="Число слишком большое";}
		if (d<Integer.MIN_VALUE) {s ="Число слишком маленькое";}
	}catch (Exception e){
		new RuntimeException("this is not a digit"+s);
	}
	return d;
}
}
