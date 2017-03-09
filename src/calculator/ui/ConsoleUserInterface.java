package calculator.ui;

import java.awt.event.ActionListener;
import java.util.Scanner;

import calculator.CommandController;

public class ConsoleUserInterface  implements UserInterface{
	public void run(){
		Scanner in =new Scanner((System.in));
		String s;
		
		System.out.println("введите пример или команду и нажмите enter");
		CommandController cc = new CommandController();
		while ((in.hasNextLine()))
		{
		if	((s = in.nextLine().toLowerCase()).trim().equals("exit")){
			break;
		}
		
		
		
		
		
		try{
			System.out.println(cc.calculation(s));
		}catch(Exception e){
			System.out.println("Something wrong.We are working on this.");
		}
		System.out.println("введите следующий пример или команду");
		}
		System.out.println("we are finished");
		in.close();
	}

	@Override
	public void setUIListener(Listener a) {
		// TODO Auto-generated method stub
		
	}
}
