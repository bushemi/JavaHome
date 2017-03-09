package fileGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

import calculator.CalculatorService;

public class FileGenerator {
private static StringBuilder sb;
private static Random r = new Random();
private static String[] array = {"+","-","*","/"};
private static int MAX_COUNT = 1_000_000;
	public static void main(String[] args) {
		sb= new StringBuilder();

		for(int i=0;i<MAX_COUNT;i++){
			genStr();
			
		}
		save();
	}
	private static void genStr(){
		sb.append(String.valueOf(r.nextInt(10))+array[r.nextInt(4)]+String.valueOf(r.nextInt(10))+"\n");
	}
	private static boolean save(){
		
		boolean result = false;
		
		
		System.out.println("save1");
		try(Writer w = new FileWriter("Math.txt")){
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

}
