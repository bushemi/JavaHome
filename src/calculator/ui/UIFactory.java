package calculator.ui;

public class UIFactory {
	private UserInterface ui;
	private static UIFactory _instance;
	
	private UIFactory() {}
	
	public static UIFactory getInstance(){
		if(_instance == null) {_instance = new UIFactory();}
		return _instance;
	}

	public  UserInterface getUI(String s){
		if (s.equals("console")){
			ui=new ConsoleUserInterface();
		}else{
			ui=new ConsoleUserInterface();//Only one for now.
		}
		return ui;
	}

}
