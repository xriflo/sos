package functions;

import dataStructures.Pair;

public class Beale extends Function{
	public Beale() {
		super();
		this.name = "Beale";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return Math.pow(1.5d-x1+x1*x2, 2) + 
				Math.pow(2.25d-x1+x1*Math.pow(x2, 2), 2) +
				Math.pow(2.625d-x1+x1*Math.pow(x2, 3), 2);
	}

	@Override
	public Pair getGlobalMinimum() {
		return new Pair(3.0d, 0.5d);
	}

}
