package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataStructures.Pair;
import entities.*;
import functions.Function;
import utils.Fitness;
import utils.RWS;
import utils.Settings;
import utils.Utils;
import utils.Settings.*;

public class ABC {
	public Function f;
	Integer dim=2;
	public Integer colony_size, no_food_sources, no_scouts, no_onlookers;
	public List<Pair> food_sources;
	List<Double> fitness_values;
	public List<Integer> trial_counter;
	List<EmployedBee> employed_bees;
	ScoutBee scout_bee;
	List<OnlookerBee> onlooker_bees;
	public Pair best_food_source;
	public Double best_fitness_value;
	
	public ABC(Function f, Integer colony_size) {
		this.f = f;
		this.colony_size = colony_size;
		this.no_food_sources = colony_size/2;
		this.no_onlookers = colony_size-no_food_sources;
		this.no_scouts = colony_size*dim/2;
		this.food_sources = new ArrayList<Pair>();
		
		this.employed_bees = new ArrayList<EmployedBee>(no_food_sources);
		this.onlooker_bees = new ArrayList<OnlookerBee>(no_food_sources);
		this.scout_bee = new ScoutBee();
		this.fitness_values = new ArrayList<Double>();
		this.trial_counter = new ArrayList<Integer>();
		best_fitness_value = Double.MIN_VALUE;
		best_food_source = null;
		
	}
	
	public void applyAlgorithm() {
		Random rand = new Random();
		//init food sources
		for(Integer i=0; i<no_food_sources; i++) {
			Pair food_value = Utils.randomDouble(f.getDomain().x1, f.getDomain().x2);
			double fitness_value = Fitness.compute(f, food_value);
			employed_bees.add(new EmployedBee());
			food_sources.add(food_value);
			fitness_values.add(fitness_value);
			trial_counter.add(Settings.ABC_START_TRIAL_COUNTER);
			
			if(fitness_value>best_fitness_value) {
				best_fitness_value = fitness_value;
				best_food_source = food_value;
			}
		}
		
		//start cycles
		for(Integer cycle=0; cycle<Settings.ABC_MAX_ITERATIONS; cycle++) {
/********************************EMPLOYEED BEES********************************/
			//here come the employee bees
			for(Integer i=0; i<no_food_sources; i++) {
				EmployedBee bee = employed_bees.get(i);
				Pair new_solution = bee.computeNewSolution(food_sources.get(i));
				double fitness_value = Fitness.compute(f, new_solution);
				//no improvement
				if(fitness_value<best_fitness_value) {
					trial_counter.set(i, trial_counter.get(i)+1);
				}
				//improvement
				else {
					trial_counter.set(i, Settings.ABC_START_TRIAL_COUNTER);
					best_fitness_value = fitness_value;
					best_food_source = new_solution;
					food_sources.set(i, new_solution);
					fitness_values.set(i, fitness_value);
				}
			}
/********************************ONLOOKERS BEES********************************/
		
			for(Integer i=0; i<no_onlookers; i++) {
				OnlookerBee bee = new OnlookerBee();
				Pair old_solution = RWS.generateChoice(food_sources, fitness_values);
				bee.computeNewSolution(old_solution);
				Pair select_solution = food_sources.get(rand.nextInt(no_food_sources));
				double fitness_value = Fitness.compute(f, select_solution);
				//no improvement
				if(fitness_value<best_fitness_value) {
					trial_counter.set(i, trial_counter.get(i)+1);
				}
				//improvement
				else {
					trial_counter.set(i, Settings.ABC_START_TRIAL_COUNTER);
					best_fitness_value = fitness_value;
					best_food_source = select_solution;
					food_sources.set(i, select_solution);
					fitness_values.set(i, fitness_value);
				}
			}
/********************************SCOUT BEES********************************/
			//abandon solutions
			scout_bee.generateNewSolutions(this);

		}
		
	}
}
