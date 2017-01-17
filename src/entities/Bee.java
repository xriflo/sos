package entities;

import java.util.Random;

import dataStructures.Pair;
import utils.Settings;
import utils.Utils;

public class Bee {
	Random rand = new Random();
	//formula is: Vij = Xij + Oij*(Xij-Xkj)
	//k - random selected solution in the neighbourhood of i
	//j - random selected dimension of the problem
	public Pair computeNewSolution(Pair old_solution) {
		Pair new_solution = new Pair(old_solution);
		Double x1_neighbour = Utils.randomInRange(
				new_solution.x1-Settings.ABC_NEIGHBOURHOOD, 
				new_solution.x1+Settings.ABC_NEIGHBOURHOOD);
		Double x2_neighbour = Utils.randomInRange(
				new_solution.x2-Settings.ABC_NEIGHBOURHOOD, 
				new_solution.x2+Settings.ABC_NEIGHBOURHOOD);
		Pair neighbour = new Pair(x1_neighbour, x2_neighbour);
		Double phi = Utils.randomInRange(-1d, 1d);

		//choose dim x1
		if(rand.nextInt(2)==0) {
			new_solution.x1 = new_solution.x1 + phi*(new_solution.x1-neighbour.x1);
		}
		//choose dim x2
		else {
			new_solution.x2 = new_solution.x2 + phi*(new_solution.x2-neighbour.x2);
		}
		return new_solution;
	}
	
}
