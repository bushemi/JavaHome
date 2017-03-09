package calculator.commands.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import calculator.commands.CommandInterface;

public class Load implements CommandInterface,FileOperationsInterface {
private static Load _inst;
private String name;
private int counter;
private List loadedList = new ArrayList();
private Load(){
	
}
public static Load getInst(){
	if(_inst==null)_inst= new Load();
	return _inst;
	}

	@Override
	public String execute(Object data) throws Exception {
		counter=0;
		StringBuilder sb=new StringBuilder();
		String result="";
try(Scanner in = new Scanner(new File(name))) {
			
			while (in.hasNextLine()) {
				counter++;
			
				String s= in.nextLine();
				sb.append(s+"\n");
				loadedList.add(s);
				//	System.out.println(s);
				
			}
			//System.out.println(counter);
			result=sb.toString();
			//System.out.println(result);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			return result;
		}
	}
	@Override
	public void setFile(String fileName) {
		name=fileName;
		
	}
	public List getLoadedList() {
		return loadedList;
	}
	public void setLoadedList(List loadedList) {
		this.loadedList = loadedList;
	}

}
