package calculator.commands.fileOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import calculator.CalculatorService;
import calculator.commands.CommandInterface;

public class Save implements CommandInterface,FileOperationsInterface {

	private static Save _inst;
	private String name="history.csv";
	private Save(){
		
	}
	public static Save getInst(){
		if(_inst==null)_inst= new Save();
		return _inst;
	}

	@SuppressWarnings("finally")
	@Override
	public String execute(Object data) throws Exception {
		synchronized (this) {
			
			String result="";
			String sb=data.toString();
			
			System.out.println("save1");
			try(Writer w = new FileWriter(name)){
				w.write(sb);
				result="Done";
				System.out.println("success");
			}catch(IOException e){
				System.out.println("fail");
				result="fail";
				throw new RuntimeException("ошибка записи",e);
			} finally{
				return result;
			}
		}
		
	}
	@Override
	public void setFile(String fileName) {
		name=fileName;
		
	}

}
