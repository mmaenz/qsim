package de.qsim.core.simulator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.qsim.core.model.Project;
import de.qsim.core.simulator.exception.NoProjectException;

public class Simulator {
	private Project project = null;
	DocumentBuilder documentBuilder = null;
	private Document doc = null;

	public Simulator() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			documentBuilder = dbf.newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Project createProject() {
		this.project = new Project();
		return this.project; 
	}
	
	public Project loadProjectFromFile(String fileName) {
		try {
			doc = documentBuilder.parse(new File(fileName));
			project = new Project(doc.getDocumentElement());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	public String getSourceFromProject() {
		NodeList nl = doc.getElementsByTagName("source");
		if (nl.getLength() > -1) {
			String text = nl.item(0).getTextContent();
			try {
				text = new String(Base64.getDecoder().decode(text.getBytes()), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}
		return null;
	}

	public boolean saveProjectToFile(String fileName) {
		Document document = documentBuilder.newDocument();
		project.saveElement(document);
		return writeOutput(document, fileName);
	}

	public boolean saveProjectToFile(String fileName, String source) {
		Document document = documentBuilder.newDocument();
		project.saveElement(document);
		Node node = document.createElement("source");
		
		try {
			node.setTextContent(new String(Base64.getEncoder().encode(source.getBytes("UTF-8"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		document.getDocumentElement().appendChild(node);
		return writeOutput(document, fileName);
	}

	private boolean writeOutput(Document document, String fileName) {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			tr.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileName)));

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	public boolean run() throws Exception {
		if (project == null) {
			throw new NoProjectException();
		}
		project.perform();
		return true;
	}
	
	public Project getProject() {
		return project;
	}
}
