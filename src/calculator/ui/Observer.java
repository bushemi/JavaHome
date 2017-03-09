package calculator.ui;

import java.util.ArrayList;
import java.util.List;

public class Observer implements Listener {
private String _lastEvent;
private static Observer _instance;
private static List<Listener> listeners =new ArrayList<Listener>();
	@Override
	public void fireEvent(String eventToString) {
		//System.out.println("ActionFire");
		_lastEvent = (eventToString);
		System.out.println("poi "+_lastEvent);
		listeners.forEach((e)->e.fireEvent(eventToString));
		
	}
	public static void addActionListener(Listener l){
		for(int i=0;i<listeners.size();i++){
			if (listeners.get(i).equals(l)){
				return;
			}
		}
		listeners.add(l);
	}
	public static void removeActionListener(Listener l){
		for(int i=0;i<listeners.size();i++){
			if (listeners.get(i).equals(l)){
				listeners.remove(i);
				return;
			}
		}
	}
	public static Observer getInstance(){
		if(_instance ==null) _instance = new Observer();
		return _instance;
	}
	public String getValue(){
		return _lastEvent;
	}
}
