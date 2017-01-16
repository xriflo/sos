package utils;

import java.util.ArrayList;

import functions.*;

public final class Settings {
	
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
