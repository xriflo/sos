package algorithms;

import functions.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataStructures.Pair;
import utils.Fitness;
import utils.Settings;
import utils.Utils;

public class Fireflies {
	Random rand = new Random();
	public Function f;
	public Integer colony_size;
	public List<Pair> locations_fireflies;
	public Pair best_solution = null;
	public Double best_intensity = Double.MIN_VALUE;

	public Fireflies(Function f, Integer colony_size) {
		this.f = f;
		this.colony_size = colony_size;
		this.locations_fireflies = new ArrayList<Pair>(colony_size);
		for(Integer i=0; i<colony_size; i++) {
			Pair location = Utils.randomDouble(f.getDomain().x1, f.getDomain().x2);
			this.locations_fireflies.add(location);
		}
	}
	
	public void applyAlgorithm() {
		for(Integer cycle=0; cycle<Settings.FIREFLIES_MAX_ITERATIONS; cycle++) {
			for(Integer firefly_i=0; firefly_i<colony_size; firefly_i++) {
				for(Integer firefly_j=0; firefly_j<colony_size; firefly_j++) {
					Pair location_i = this.locations_fireflies.get(firefly_i);
					Pair location_j = this.locations_fireflies.get(firefly_j);
					Double Ii = Fitness.compute(f, location_i);
					Double Ij = Fitness.compute(f, location_j);
					Double distance = location_i.distance(location_j);
					if(Ii>Ij) {
						Pair new_location_i = 
								location_i.add(
										(location_j.substract(location_i).multiply(
												Settings.FIREFLIES_SOCIAL_INFLUENCE*Math.exp(-Settings.FIREFLIES_ABSORTION*
														distance
														)
												)).add(
														Settings.FIREFLIES_STEP_SIZE*rand.nextDouble()
														)
										);
				
					}
				}
			}
			for(Integer i=0; i<colony_size; i++) {
				Pair location = locations_fireflies.get(i);
				Double intensity = Fitness.compute(f, location);
				if(intensity>best_intensity) {
					best_intensity = intensity;
					best_solution = location;
				}
			}
		}
	}
}
