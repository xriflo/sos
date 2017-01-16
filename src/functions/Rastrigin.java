package functions;

import dataStructures.Pair;

public class Rastrigin extends Function {
	public Rastrigin() {
		super();
		this.name = "Rastrigin";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return 20 + 
				Math.pow(x1, 2) - 10.0d*Math.cos(2.0d*Math.PI*x1) +
				Math.pow(x2, 2) - 10.0d*Math.cos(2.0d*Math.PI*x2);
	}

}
