package utils;

import dataStructures.Pair;
import functions.Function;

public class Fitness {
	public static double compute(Function f, Pair params) {
		double output=f.output(params);
		if(output>=0d)
			return 1d/(1d+output);
		else
			return 1+Math.abs(output);
	}
}
