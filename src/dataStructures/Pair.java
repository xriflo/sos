package dataStructures;


public class Pair {
	public Double x1, x2;
	
	public Pair(Pair other) {
		this.x1 = other.x1;
		this.x2 = other.x2;
	}

	public Pair(Double x1, Double x2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
	}

	@Override
	public String toString() {
		return String.format("(%.3f,%.3f)", x1, x2);
	}
	
	public Double distance(Pair other) {
		return Math.sqrt(
				Math.pow(this.x1-other.x1, 2) +
				Math.pow(this.x2-other.x2, 2)
				);
	}
	
	public Pair add(Pair other) {
		return new Pair(
				this.x1+other.x1,
				this.x2+other.x2
				);
	}
	
	public Pair add(Double ct) {
		return new Pair(
				this.x1+ct,
				this.x2+ct
				);
	}
	
	public Pair multiply(Pair other) {
		return new Pair(
				this.x1*other.x1,
				this.x2*other.x2
				);
	}
	
	public Pair multiply(Double ct) {
		return new Pair(
				ct*this.x1, 
				ct*this.x2
				);
	}
	
	public Pair substract(Pair other) {
		return new Pair(
				this.x1-other.x1,
				this.x2-other.x2
				);
	}
}
