package patterns.strategy.interfaces;

public class FilterByBody implements FilterInterface {

	@Override
	public  void breath() {
		System.out.println("I breath with my lung.");
	}

}
