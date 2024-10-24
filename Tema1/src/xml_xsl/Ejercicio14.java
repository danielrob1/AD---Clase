package xml_xsl;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Ejercicio14 {

	public static void main(String[] args) {
		TransformerFactory fabrica = TransformerFactory.newInstance();
		try {
			Transformer transformador = fabrica.newTransformer(new StreamSource("Ejercicio14.xsl"));
			
			transformador.transform(new StreamSource("Ejercicio14.xml"), 
					new StreamResult("Ejercicio14.html"));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
