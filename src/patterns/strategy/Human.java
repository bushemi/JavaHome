package patterns.strategy;

import patterns.strategy.interfaces.FilterByBody;
import patterns.strategy.interfaces.FilterInterface;

public class Human {
	private FilterInterface filter;
	public FilterInterface getFilter() {
		return filter;
	}
	public void setFilter(FilterInterface filter) {
		this.filter = filter;
	}
	public Human(){
		filter = new FilterByBody();
		}
	public Human(FilterInterface fl){
		filter=fl;
	}
	public void breath(){
		filter.breath();
	}

}
