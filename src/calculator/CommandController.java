package calculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import calculator.commands.fileOperations.Load;
import calculator.commands.fileOperations.Save;



public class CommandController {
	private String sumString="poi";
	private CalculatorService cs;
	
	private StringBuilder sb;
	private long date;
	private List<String> history;
	private final String DELIMETER = ";";
	private Save save = Save.getInst();
	private Load load = Load.getInst();
	private List<String> exampleList=new ArrayList();
	private List<String> resultList=new ArrayList();
	private ExecutorService executor ;
	private int counter;
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
	private void executors(String ss) {
		executor=Executors.newFixedThreadPool(4);
		executor.submit(() -> resultList.add(calculation(ss)));
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
		  System.out.println(e.getMessage());
		}

		counter++;
		if(counter>=resultList.size()/10){
			
			System.out.print("10%");
		
		counter=0;}
	}
	private String checkForCommands(String q) throws Exception{
		if (q.toLowerCase().trim().equals("load")){
			if(load("history.csv")){
				
			}
			throw new RuntimeException("succes load");
			
		};
		if (q.toLowerCase().trim().equals("save")){
			if(save("history.csv")){
				
			}
			throw new RuntimeException("succes save");
		};
		if (q.toLowerCase().trim().equals("show")){
			 if (show()){};
			 throw new RuntimeException("succes show");
		};
		if (q.toLowerCase().trim().equals("loader")){
			if(load("Math.txt")){
				
				exampleList.forEach((e)->executors(e));
				
				System.out.println("Done!!!!!");
				
				save("Math2.txt");
			}
			throw new RuntimeException("succes load");
			
		};
		return new String("");
	}
	public String calculation(String q) {
		
		
		date=new Date().getTime();
		try{
			checkForCommands(q);
			Double d;
	synchronized(this){	cs.calculate(q);
		d =cs.getSum();}
		if (d>Integer.MAX_VALUE) {sumString ="Число слишком большое";}
		if (d<Integer.MIN_VALUE) {sumString ="Число слишком маленькое";}
		else{
		sumString = String.format("%.2f", d);}
		
		
		}catch(Exception re){
			sumString=re.getMessage();
		}
		
		String sb1=new String();
		sb1=(String.valueOf(date)+DELIMETER+q+DELIMETER+sumString);
		
		history.add(sb1);
		
		return new String("Quary: "+q+" Result = "+ sumString);
	}
	
	
	@SuppressWarnings("finally")
	private boolean save(String fileName){
		boolean result = false;
		if(fileName.equals("history.csv")){CalculatorService.dataToHistory(history).forEach((e)->sb.append(e+"\n"));}
		if(fileName.equals("Math2.txt")){CalculatorService.dataToHistory(resultList).forEach((e)->sb.append(e+"\n"));}
		save.setFile(fileName);
		try {
				if(save.execute(sb).equals("done")){
												result=true;}
			
			} catch (Exception e1) {
			throw new RuntimeException("ошибка записи",e1);
			
			} finally{
				return result;
				}
		
	}
	@SuppressWarnings("finally")
	private boolean load(String fileName) throws Exception{
		System.out.println("load");
		load.setFile(fileName);
		if (fileName.equals("Math.txt")){
			exampleList.clear();
			
		try{
		 load.execute(new Object());
		//String[] splinter=s.split("");
		 exampleList=new ArrayList(load.getLoadedList());
//		for(int i = 0;i<splinter.length;i++){
//			exampleList.add(splinter[i]);
//			//if (i==9999999){System.out.println("wetry");}
//		}
		System.out.println("Loaded "+exampleList.size());
		}catch (Exception e1) {
			throw new RuntimeException("ошибка записи",e1);
			
			} finally{
				return true;
				}}
		//history.add(s);
	return true;
	}
	private boolean show(){
		
		System.out.println("---History---");
		CalculatorService.historyToData(history).forEach(System.out::println);
		System.out.println("-------------");
		return true;
	}

}
