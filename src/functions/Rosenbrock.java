package functions;

import dataStructures.Pair;

public class Rosenbrock extends Function{
	public Rosenbrock() {
		super();
		this.name = "Rosenbrock";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return 100.0d*Math.pow(x2-Math.pow(x1, 2), 2) + 
				Math.pow(x1-1, 2);
	}

	@Override
	public Pair getGlobalMinimum() {
		return new Pair(1.0d, 1.0d);
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-5d,10d);
	}


}
