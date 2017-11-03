package de.qsim.core.model.gate;

import java.util.stream.Stream;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;

public class GateFactory {

	public IGate createGate(GateType id, String name, Project project, IElement parent) throws Exception {
		switch (id) {
		case HGate:
			return new HGate(name, project, parent);
		case XGate:
			return new XGate(name, project, parent);
		case YGate:
			return new YGate(name, project, parent);
		case ZGate:
			return new ZGate(name, project, parent);
		case CNotGate:
			return new CNotGate(name, project, parent);
		case CPhaseShift:
			return new CPhaseShift(name, project, parent);
		case IdentityGate:
			return new IdentityGate(name, project, parent);
		default: return null;
		}
	}

	public IGate createGate(GateType id, String name) throws Exception {
		switch (id) {
		case HGate:
			return new HGate(name);
		case XGate:
			return new XGate(name);
		case YGate:
			return new YGate(name);
		case ZGate:
			return new ZGate(name);
		case CNotGate:
			return new CNotGate(name);
		case CPhaseShift:
			return new CPhaseShift(name);
		case IdentityGate:
			return new IdentityGate(name);
		default: return null;
		}
	}

	public IGate createGate(GateType id, Element xmlElement, Project project, IElement parent) throws Exception {
		switch (id) {
		case HGate:
			return new HGate(xmlElement, project, parent);
		case XGate:
			return new XGate(xmlElement, project, parent);
		case YGate:
			return new YGate(xmlElement, project, parent);
		case ZGate:
			return new ZGate(xmlElement, project, parent);
		case CNotGate:
			return new CNotGate(xmlElement, project, parent);
		case CPhaseShift:
			return new CPhaseShift(xmlElement, project, parent);
		case IdentityGate:
			return new IdentityGate(xmlElement, project, parent);
		default: return null;
		}
	}

	public Stream<GateType> getGateTypes() {
		return Stream.of(GateType.values());
	}
	
	public static GateFactory getGateFactory() {
		return new GateFactory();
	}
}
