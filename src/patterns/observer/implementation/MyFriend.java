package patterns.observer.implementation;

public class MyFriend implements WitnessListener{
	private String name = "Michael";
	@Override
	public void ISaw() {
		System.out.println(name+": WTF just happen??");
		
	}

}
