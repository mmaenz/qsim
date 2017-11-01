package de.qsim.core.utils;

import de.qsim.core.gate.IGate;

public class Pair {
	private Object object;
	private String name;
	
	public Pair(Object object, String name) {
		this.object = object;
		this.name = name;
	}
	
	public Object getObject() {
		return this.object;
	}
	
	public String getName() {
		return this.name;
	}
}
