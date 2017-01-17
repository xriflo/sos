package utils;

import java.util.Random;

import dataStructures.Pair;

public class Utils {
	static Random rand = new Random();
	
	public static Pair randDouble(Integer bound) {
	    Double x1 = 2*bound*Math.random()-bound;
	    Double x2 = 2*bound*Math.random()-bound;
	    return new Pair(x1, x2);
	}
	
	public static double randomInRange(double min, double max) {
		  double range = max - min;
		  double scaled = rand.nextDouble() * range;
		  double shifted = scaled + min;
		  return shifted; // == (rand.nextDouble() * (max-min)) + min;
	}
	
	public static Pair randomDouble(double min, double max) {
		return new Pair(
				randomInRange(min, max),
				randomInRange(min, max)
				);
	}
}
