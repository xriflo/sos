package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataStructures.Pair;

//Random Weighted Sampling
public class RWS {
	public static Pair generateChoice(List<Pair> choices,  List<Double> weights) {
		double totalWeight = 0.0d;
		for(Double weight:weights)
			totalWeight += weight;
		//for the first iteration
		if(totalWeight==0.0d) {
			Random random = new Random();
			return choices.get(random.nextInt(choices.size()));
		}
		if(choices.size()==1)
			return choices.get(0);
		//starting with second iteration
		else {
			int randomIndex = -1;
			double random = Math.random() * totalWeight;
			for(Integer i=0; i<choices.size(); i++) {
				random -= weights.get(i);
				if(random <= 0.0d) {
					randomIndex = i;
				}
			}
			return choices.get(randomIndex);
		}
	}
}
