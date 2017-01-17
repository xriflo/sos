package functions;

import dataStructures.Pair;

public abstract class Function {
	public String name;
	public abstract Double output(Pair pair);
	public Pair getGlobalMinimum() {
		return new Pair(0.0d, 0.0d);
	}
	public abstract Pair getDomain();
}
