package functions;

import dataStructures.Pair;

public class TestFunction extends Function{
	public TestFunction() {
		super();
		this.name = "TestFunction";
	}
	
	@Override
	public Double output(Pair pair) {
		Double x1, x2;
		x1 = pair.x1;
		x2 = pair.x2;
		return 
				Math.pow(x1, 2) + Math.pow(x2, 2);
	}
	
	@Override
	public Pair getDomain() {
		return new Pair(-5d,5d);
	}
}
