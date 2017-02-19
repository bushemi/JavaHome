package patterns.decorator.genes;

public class GeneBA extends Gene {
private String gene="BA";
	public GeneBA(Gene g) {
		gene=g.getGene()+":"+gene;
	}
	public String getGene() {
		return gene;
	}

}