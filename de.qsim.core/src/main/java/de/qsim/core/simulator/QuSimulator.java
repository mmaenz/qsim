package de.qsim.core.simulator;

import java.io.File;
import java.security.MessageDigest;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import de.qsim.core.simulator.model.QuSimProject;

public class QuSimulator {
	private QuSimProject qusimproject = null;
	DocumentBuilder documentBuilder = null;
	private Document doc = null;

	public QuSimulator() {
		try {
			qusimproject = new QuSimProject(null);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public QuSimProject loadProjectFromFile(String fileName) {
		try {
			doc = documentBuilder.parse(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qusimproject;
	}
	
	public String getSourceFromProject() {
		Node node = doc.getElementsByTagName("source").item(0);
		String text = node.getTextContent();
		text = Base64.getEncoder().encodeToString(text.getBytes());
		return text;		
	}

	public boolean saveProjectToFile(String fileName) {
		return false;
	}

	public boolean saveProjectToFile(String fileName, String source) {
		Node node = doc.createElement("source");
		node.setTextContent(new String(Base64.getDecoder().decode(source)));
		return true;
	}

	public QuSimProject getProject() {
		return qusimproject;
	}
}
