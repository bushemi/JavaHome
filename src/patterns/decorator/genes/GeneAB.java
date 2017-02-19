package patterns.decorator.genes;

public class GeneAB extends Gene {
private String gene="AB";
	public GeneAB(Gene g) {
		gene=g.getGene()+":"+gene;
	}
	public String getGene() {
		return gene;
	}

}
