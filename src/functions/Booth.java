package functions;

import dataStructures.Pair;

public class Booth extends Function{
	public Booth() {
		super();
		this.name = "Booth";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return Math.pow(x1+2d*x2-7d, 2) +
				Math.pow(2*x1+x2-5d, 2);
	}

	@Override
	public Pair getGlobalMinimum() {
		return new Pair(1.0d, 3.0d);
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-10d,10d);
	}

}
