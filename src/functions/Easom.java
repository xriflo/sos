package functions;

import dataStructures.Pair;

public class Easom extends Function{
	public Easom() {
		super();
		this.name = "Easom";
	}
	
	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return 
				-Math.cos(x1)*Math.cos(x2)*
				Math.exp(
						-Math.pow(x1-Math.PI, 2)
						-Math.pow(x2-Math.PI, 2)
						);
	}
	
	@Override
	public Pair getGlobalMinimum() {
		return new Pair(Math.PI, Math.PI);
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-100d,100d);
	}

}
