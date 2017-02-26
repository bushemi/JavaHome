package patterns.factory.implementations;

public class WaterTransport implements TransportInterface {

	@Override
	public void moveForward() {
		System.out.println("I know I can move faster, but I am the boat :(");

	}

}
