package main;

import algorithms.ABC;
import dataStructures.Pair;
import functions.Function;
import functions.TestFunction;
import utils.Settings;

public class MainABC {

	public static void main(String[] args) {
		for(Function f:Settings.functions) {
			Pair best_value = null;
			Double best_fitness = Double.MIN_VALUE;
			for(Integer it=0; it<10; it++) {
				ABC abc = new ABC(f,6);
				abc.applyAlgorithm();
				if(abc.best_fitness_value > best_fitness) {
					best_fitness = abc.best_fitness_value;
					best_value = abc.best_food_source;
				}
			}
			System.out.println(f.name+"   "+f.getGlobalMinimum()+"   "+best_value + " " + f.getGlobalMinimum().distance(best_value));
			
		}
	}

}
