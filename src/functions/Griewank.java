package functions;

import dataStructures.Pair;

public class Griewank extends Function {
	public Griewank() {
		super();
		this.name = "Griewank";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return (Math.pow(x1, 2)+Math.pow(x2, 2))/4000.0d -
				Math.cos(x1)*Math.cos(x2/Math.sqrt(2.0d)) +
				1;
	}

}
