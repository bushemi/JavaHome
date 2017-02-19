package patterns.observer;

import java.util.ArrayList;
import java.util.List;

import patterns.observer.implementation.WitnessListener;

public class RSS {
	private int count=0;
	private List<WitnessListener> listeners = new ArrayList<WitnessListener>();
	public  RSS(){}
	public void addListener(WitnessListener e){
		if (listeners.add(e)) System.out.println("add new listener");
		
	}
	public void removeListener(WitnessListener e,String cause){
		if(listeners.remove(e)) System.out.println("remove one listener because: "+cause);
	}
	public void GoodNews(){
		count++;
		System.out.println("Good news, everyone! "+count);
		listeners.forEach((e)->e.ISaw());
	}
}
