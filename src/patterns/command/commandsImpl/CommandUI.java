package patterns.command.commandsImpl;

public class CommandUI {
	private CommandInterface kill = new Kill();
	private CommandInterface res = new Ressurect();
	private volatile static  CommandUI _instance;
 private CommandUI(){}
 public static CommandUI getInstance(){
	 if (_instance==null)
		 synchronized (new Object()) {
			 if (_instance==null){
				 _instance = new CommandUI();
			 }
			
		}
	 return _instance;
 }
 public void kill(String name){
	 System.out.print(name+", ");
	 kill.execute();
 }
public void res(String name){
	 System.out.print(name+", ");
	 res.execute();
 }
}
