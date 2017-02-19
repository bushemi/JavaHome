package patterns.decorator;

import patterns.decorator.genes.Gene;
import patterns.decorator.genes.GeneAB;
import patterns.decorator.genes.GeneBA;

public class Main {

	public static void main(String[] args) {
		Gene g = new Gene();
		System.out.println(g.getGene());
		g=new GeneAB(g);
		System.out.println(g.getGene());
		g=new GeneBA(g);
		System.out.println(g.getGene());
	}

}
