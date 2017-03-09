package calculator.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import calculator.Validator;

public class Calculate implements CommandInterface {
List list = new ArrayList();

	public void setList(List list) {
	this.list = list;
}
	public String execute(Object data) {
		String s;
		Double sum=0.0;
		
			 List tempArrayList =  new ArrayList(list);
			// tempArrayList.forEach((e)->System.out.println(e.toString()));
		for (int i=0;i<tempArrayList.size();i=i+2){
			
			s = getStringFromArrayList(tempArrayList,i);//tempArrayList.get(i).toString().toLowerCase();
			//System.out.println(s+"//////s");
		switch (s){
		case("-"):
		
					if ((i+2<tempArrayList.size())){
						if ((getStringFromArrayList(tempArrayList,i+2).equals("*"))||((getStringFromArrayList(tempArrayList,i+2).equals("/"))))
						{if ((getStringFromArrayList(tempArrayList,i+2).equals("*"))){
							sum=-(Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+1))*Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+3)))+sum;
							//System.out.println("-+"+sum);
							i=i+2;}
						if ((getStringFromArrayList(tempArrayList,i+2).equals("/"))){
							sum=-(Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+2))/Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+3)))+sum;
							i=i+2;}
						}else{sum=sum-Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+1));}
						}
			else{
				sum=-Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+1))+sum;}
			
		
		break;
		case("+"):
		if (i+2<tempArrayList.size()){
				if ((getStringFromArrayList(tempArrayList,i+2).equals("*"))||
						(getStringFromArrayList(tempArrayList,i+2).equals("/"))){	
					if (getStringFromArrayList(tempArrayList,i+2).equals("*"))
							{sum=(Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+1))*
									Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+3)))+sum;
							}
					if (getStringFromArrayList(tempArrayList,i+2).equals("/"))
						{sum=(Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+1))/Validator.stringToDouble(getStringFromArrayList(tempArrayList,i+3)))+sum;
						}
			i=i+2;
		}
			else{
				sum=Validator.stringToDouble(tempArrayList.get(i+1))+sum;
				
			}
		}
			else{sum=Validator.stringToDouble(tempArrayList.get(i+1))+sum;}
		break;
		case("/"):
		
			sum=sum/Validator.stringToDouble(tempArrayList.get(i+1));
			break;
		case("*"):

			sum=(sum*Validator.stringToDouble(tempArrayList.get(i+1)));
			break;
	}
	}
	//	System.out.println(sum);
		return String.valueOf(sum);
	}
private String getStringFromArrayList(List tempArrayList,int index){
	
	return tempArrayList.get(index).toString().toLowerCase();
}
	

}
