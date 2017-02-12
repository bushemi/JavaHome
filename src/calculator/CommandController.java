package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class CommandController {
	private String sumString="poi";
	private CalculatorService cs;
	
	private StringBuilder sb;
	private long date;
	private List<String> history;
	private final String DELIMETER = ";";
	public CommandController(){
		//MM/DD/YYYY-HH:mm:SS<AM|PM> Query:<query> Result: <Result>
		//06/02/2016-12:12:41 PM Query: 2+2 Result: 4
		//06/02/2016-12:12:55 PM Query: 2+q Result: Invalid Query
		//long date;query;result List<String> list = new ArrayList<>(); строку режу и вывожу историю текстом, но храню листом 
		
		
		sb=new StringBuilder();
		history=new ArrayList<String>();
		new ArrayList<Object>();
		cs= new CalculatorService();
		
	}
	private String checkForCommands(String q){
		if (q.toLowerCase().trim().equals("load")){
			if(load()){
				
			}
			throw new RuntimeException("succes load");
			
		};
		if (q.toLowerCase().trim().equals("save")){
			if(save()){
				
			}
			throw new RuntimeException("succes save");
		};
		if (q.toLowerCase().trim().equals("show")){
			 if (show()){};
			 throw new RuntimeException("succes show");
		};
		return new String("");
	}
	public String calculation(String q){
		
		
		date=new Date().getTime();
		try{
			checkForCommands(q);
		cs.rep(q);
		Double d =cs.getSum();
		if (d>Integer.MAX_VALUE) {sumString ="Число слишком большое";}
		if (d<Integer.MIN_VALUE) {sumString ="Число слишком маленькое";}
		else{
		sumString = String.format("%.2f", d);}
		
		
		}catch(RuntimeException re){
			sumString=re.getMessage();
		}
		
		String sb1=new String();
		sb1=(String.valueOf(date)+DELIMETER+q+DELIMETER+sumString);
		
		history.add(sb1);
		
		return new String("Quary: "+q+" Result = "+ sumString);
	}
	
	@SuppressWarnings("finally")
	private boolean save(){
		boolean result = false;
		
		CalculatorService.dataToHistory(history).forEach((e)->sb.append(e+"\n"));
		System.out.println("save1");
		try(Writer w = new FileWriter("history.csv")){
			w.write(String.valueOf(sb));
			result=true;
			System.out.println("success");
		}catch(IOException e){
			System.out.println("fail");
			result=false;
			throw new RuntimeException("ошибка записи",e);
		} finally{
			return result;
		}
		
		
	}
	private boolean load(){
		System.out.println("load");
		
		try(Scanner in = new Scanner(new File("history.csv"))) {
			
			while (in.hasNextLine()) {
				String s= in.nextLine();
				history.add(s);
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} 
		return true;
	}
	private boolean show(){
		
		System.out.println("---History---");
		CalculatorService.historyToData(history).forEach(System.out::println);
		System.out.println("-------------");
		return true;
	}

}
