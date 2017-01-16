package functions;

import dataStructures.Pair;

public class ThreeHumpCamel extends Function{
	public ThreeHumpCamel() {
		super();
		this.name = "ThreeHumpCamel";
	}
	
	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return 
				2*Math.pow(x1, 2)-
				1.05d*Math.pow(x1, 4)+
				Math.pow(x1, 6)/6d+
				x1*x2+Math.pow(x2, 2);
	}
}

