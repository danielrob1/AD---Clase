package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Ejercicio10 {
	private final static String DOCTRABAJO_IN="Ejercicio10.xml";
	public static void main(String[] args) {
		DocumentBuilderFactory dBF= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dB= dBF.newDocumentBuilder();
			Document doc =dB.parse(new File(DOCTRABAJO_IN));
			URI uri = new URI("https://acortar.link/dO4FNx");
			Document docWeb = dB.parse(uri.toURL().openStream());
			TransformerFactory tF = TransformerFactory.newInstance();
			Transformer t=tF.newTransformer();
			t.transform(new DOMSource(doc),new StreamResult(System.out));
			System.out.println();
			t.transform(new DOMSource(docWeb),new StreamResult(System.out));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
