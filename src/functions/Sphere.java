package functions;

import dataStructures.Pair;

public class Sphere extends Function{
	public Sphere() {
		super();
		this.name = "Sphere";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return Math.pow(x1, 2) + Math.pow(x2, 2);
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-5.12d,5.12d);
	}

}
