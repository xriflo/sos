package main;

import algorithms.ABC;
import algorithms.Fireflies;
import dataStructures.Pair;
import functions.Function;
import utils.Settings;

public class MainFireflights {
	public static void main(String[] args) {
		for(Function f:Settings.functions) {
			Pair best_value = null;
			Double best_fitness = Double.MIN_VALUE;
			for(Integer it=0; it<10; it++) {
				Fireflies ff = new Fireflies(f, 6);
				ff.applyAlgorithm();
				if(ff.best_intensity > best_fitness) {
					best_fitness = ff.best_intensity;
					best_value = ff.best_solution;
				}
			}
			System.out.println(f.name+"   "+f.getGlobalMinimum()+"   "+best_value + " " + f.getGlobalMinimum().distance(best_value));
			
		}
	}
}
