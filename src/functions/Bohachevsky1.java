package functions;

import dataStructures.Pair;

public class Bohachevsky1 extends Function{
	public Bohachevsky1() {
		super();
		this.name = "Bohachevsky";
	}

	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return Math.pow(x1, 2) +
				2*Math.pow(x2, 2) -
				0.3d*Math.cos(3*Math.PI*x1)-
				0.4d*Math.cos(4*Math.PI*x2)+
				0.7d;
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-100d,100d);
	}


}
