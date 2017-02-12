package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private ArrayList<String> invalidChars;
	private Pattern p;
	public Validator(){
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
}
