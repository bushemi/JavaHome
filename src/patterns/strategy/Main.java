package patterns.strategy;

import java.util.ArrayList;
import java.util.List;

import patterns.strategy.interfaces.FilterByBody;
import patterns.strategy.interfaces.FilterByMagic;

public class Main {
	public static void main(String[] args) {
	System.out.println("1");
	Human h1= new Human();
	Human h2= new Human(new FilterByBody());
	Human h3= new Human(new FilterByMagic());
	List<Human> list = new ArrayList<Human>();
	list.add(h1);
	list.add(h2);
	list.add(h3);
	for(Human h:list){
		h.breath();
		h.setFilter(new FilterByMagic());
		h.breath();
	}
}
}
