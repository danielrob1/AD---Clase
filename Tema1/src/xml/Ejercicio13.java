package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

public class Ejercicio13 {
	public static final String DOCTRABAJO_IN = "Ejercicio12.xml";

	public static void main(String[] args) {
		LeerXML();
	}
	public static void LeerXML() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(DOCTRABAJO_IN));
			LeeNodo(doc.getDocumentElement());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void LeeNodo(Node nodo) {
		if (nodo.getNodeType() == 1) {
			System.out.print("<"+nodo.getNodeName()+">");
			NodeList hijos = nodo.getChildNodes();
			if(hijos.item(0).getNodeType()==Node.ELEMENT_NODE) {
				System.out.println("\t");
			}
			for (int i = 0; i < hijos.getLength(); i++) {
				LeeNodo(hijos.item(i));
			}
			System.out.println("</"+nodo.getNodeName()+">");
		} else {
			System.out.print(nodo.getNodeValue());
		}
	}

}
