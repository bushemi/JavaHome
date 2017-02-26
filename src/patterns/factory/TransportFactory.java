package patterns.factory;

import patterns.factory.implementations.AutoTransport;
import patterns.factory.implementations.MotoTransport;
import patterns.factory.implementations.TransportInterface;
import patterns.factory.implementations.WaterTransport;

public class TransportFactory {
	TransportInterface t;
public TransportFactory(){}
public TransportInterface getTransport(String s){
	if (s.toLowerCase().equals("moto")){
	return new MotoTransport();}
	else if (s.toLowerCase().equals("auto")){
		return new AutoTransport();}
	else if (s.toLowerCase().equals("water")){
		return new WaterTransport();}
	else throw new RuntimeException("I can make only moto, auto and water transport. And asked me to construct "+s+" for you.");
}
}
