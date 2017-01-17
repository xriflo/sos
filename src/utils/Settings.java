package utils;

import java.util.ArrayList;

import functions.*;

public final class Settings {
	//Settings for ABC
	public static Integer ABC_MAX_ITERATIONS = 10000;
	public static Double ABC_NEIGHBOURHOOD = 0.01d;
	public static Integer ABC_START_TRIAL_COUNTER = 0;
	public static Integer ABC_END_TRIAL_COUNTER = 1000;
	
	//Settings for FIREFLIES
	public static Double FIREFLIES_ABSORTION = 0.2d;
	public static Integer FIREFLIES_MAX_ITERATIONS=10000;
	public static Double FIREFLIES_SOCIAL_INFLUENCE=0.3d;
	public static Double FIREFLIES_STEP_SIZE=0.01d;
	
	public static final ArrayList<Function> functions = new ArrayList<Function>() {{
		add(new Beale());
		add(new Bohachevsky1());
		add(new Booth());
		add(new Easom());
		add(new Griewank());
		add(new Rastrigin());
		add(new Rosenbrock());
		add(new Sphere());
		add(new SumSquare());
		add(new ThreeHumpCamel());
	}};
	

}
