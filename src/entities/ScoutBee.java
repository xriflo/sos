package entities;

import algorithms.ABC;
import dataStructures.Pair;
import utils.Settings;
import utils.Utils;

public class ScoutBee {
	public static void generateNewSolutions(ABC abc) {
		for(Integer i=0; i<abc.no_food_sources; i++) {
			Integer counter = abc.trial_counter.get(i);
			if(counter>Settings.ABC_END_TRIAL_COUNTER) {
				Pair new_solution = Utils.randomDouble(
						abc.f.getDomain().x1, 
						abc.f.getDomain().x2);
				abc.food_sources.set(i, new_solution);
			}
		}
	}
}
