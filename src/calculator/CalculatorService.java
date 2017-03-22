package calculator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import calculator.commands.Calculate;

public class CalculatorService {
	private ArrayList<String> ls;
	private ArrayList<String> poriadokVipolnenia;
	private double sum=0;
	int u =0;
	private static SimpleDateFormat f;
	private static final String DELIMETER = ";";
	Calculate c=new Calculate();
	public CalculatorService(){
			ls= new ArrayList<String>();
			poriadokVipolnenia= new ArrayList<String>();
			f= new SimpleDateFormat("MM/DD/YY-HH:mm:ss a ");
			
	}


private void ggg(String s){
	int next=-1;
	int plus=-1;
	int minus=-1;
	int divide=-1;
	int multiply=-1;
	if (String.valueOf(s.charAt(0)).equals("+")){}
	else{ls.add("+");}
	
	
	while(s.length()>0){
		next=-1;
	if ((plus = s.indexOf("+")) >-1){
		

	}
	next = plus;

	if(( minus = s.indexOf("-")) >-1){
		if (next > minus){next = minus;
		
		}
		
	}
	
	if((divide = s.indexOf("/")) >-1){
		if (next > divide){next= divide;
		
		}
		
	}
	
	if (( multiply = s.indexOf("*")) >-1){
		if (next > multiply){next = multiply;
		
		}
		
	}

	if (next > -1){
		
		ls.add(s.substring(0,next));
		s=s.substring(next);
		ls.add(String.valueOf(s.charAt(0)));
		s=s.substring(1);
	}
	else
	{
		
		ls.add(s);
		s="";
	}} if (ls.get(0).equals("")){
		ls.remove(0);
	}
}
public void calculate(String s) {
	//System.out.println("rep");
	sum=0;
	ls.removeAll(ls);
	ggg(s+"+0");
	
	poriadokVipolnenia.removeAll(poriadokVipolnenia);
	Validator v = Validator.getInstance();
	if (v.check(s)){throw new RuntimeException("недопустимые символы");}
	
	ret();
	
	
	count();
}
public double getSum(){
	return   sum;
}
private void ret()
{
	
	for(int i=0;i<ls.size();i++){
	String s = ls.get(i);

	if ((s.contains("*"))||(s.contains("/"))) {
		poriadokVipolnenia.add(ls.get(i-2));
	poriadokVipolnenia.add(ls.get(i-1));
	poriadokVipolnenia.add(ls.get(i));
	poriadokVipolnenia.add(ls.get(i+1));
	
	ls.remove(i+1);
	ls.remove(i);
	ls.remove(i-1);
	ls.remove(i-2);
	
	
	
	//if (2>ls.size())ls.remove(i+2);
	i=0;
	
	}
//	System.out.println("rrr "+i+";;;" +ls.get(i));
	}
	while(0<ls.size()){
		poriadokVipolnenia.add(ls.get(0));	
		ls.remove(0);
	}
	
	}
	
private void count() {
	sum=0;
	String s="";
	try{
		
		c.setList(poriadokVipolnenia);
		//System.out.println("asd");
		s=c.execute(poriadokVipolnenia);
		//System.out.println(s);
	sum=Validator.stringToDouble(s);
}catch(Exception e){
	throw new RuntimeException("Неверный формат цифр:"+e.getMessage());
}
}
public static List<String> dataToHistory(List<String> list){
	
	return list;
}
public static List<String> historyToData(List<String> list){
	List<String> l = new ArrayList<String>();
	for (String s:list){
		if (!s.isEmpty())
		{
		String[] sl=s.split(DELIMETER);
		Date d= new Date(Long.parseLong(sl[0]));
		String q= sl[1];
		String sumString=sl[2];
		String fs=String.format(f.format(d)+"Query: %1s Result: %1s",q,sumString);
		l.add(fs);
		}
	}
	
	
	return l;
}

}
