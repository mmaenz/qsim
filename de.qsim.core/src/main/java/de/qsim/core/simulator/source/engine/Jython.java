package de.qsim.core.simulator.source.engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Jython {
	private ScriptEngine engine;
	
	public Jython() {
		engine = new ScriptEngineManager().getEngineByName("python");
	}

	public ScriptEngine getEngine() {
		return engine;
	}
}
