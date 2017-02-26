package patterns.factory;

import patterns.factory.implementations.TransportInterface;

public class Main {
	 private static TransportInterface mototransport;
	 private static TransportInterface autotransport;
	 private static TransportInterface watertransport;
	
	 
	public static void main(String[] args) {
		TransportFactory tf = new TransportFactory();
		try{
		mototransport = tf.getTransport("moto");
		autotransport = tf.getTransport("auto");
		watertransport = tf.getTransport("water");
		}
		catch(RuntimeException re){System.out.println(re.getMessage());}
		mototransport.moveForward();
		autotransport.moveForward();
		watertransport.moveForward();
	}

}
