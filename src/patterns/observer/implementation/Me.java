package patterns.observer.implementation;

public class Me implements WitnessListener{
	private String name = "Vasil";
	private static Object obj= new Object();
	private static volatile Me me = null; 
	private Me(){}
	
	public static Me getInstance(){
		if (me==null){
			synchronized (obj) {
				if (me==null){
					me=new Me();
				}
			}
		}
		return me;
	}
	public void ISaw() {
		System.out.println(name + ": I saw something");
		
	}

}
