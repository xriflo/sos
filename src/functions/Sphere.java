package functions;

import dataStructures.Pair;

public class Sphere extends Function{
	public Sphere() {
		super();
		this.name = "Rosenbrock";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return Math.pow(x1, 2) + Math.pow(x2, 2);
	}

}
