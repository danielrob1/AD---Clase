package xml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ficheros.ejercicio6.*;
import java.io.*;

public class Ejercicio12 {
    public static final String DOCTRABAJO_IN = "FicheroPersonasSerializado.dat";
    public static final String DOCTRABAJO_OUT = "Ejercicio12.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = dBF.newDocumentBuilder();
            Document doc = dB.newDocument();
            FileInputStream fis = new FileInputStream(new File(DOCTRABAJO_IN));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Element raiz = doc.createElement("Personas");
            doc.appendChild(raiz);
            boolean seguir = true;
            while (seguir) {
                try {
                    Persona pers = (Persona) ois.readObject();
                    Element persona = doc.createElement("Persona");
                    raiz.appendChild(persona);
                    /*
                     *  Element nombre = doc.createElement("Nombre");
                    persona.appendChild(nombre);
                    Text nombreTexto = doc.createTextNode(pers.getNombre().toString());
                    nombre.appendChild(nombreTexto);

                    Element apellido1 = doc.createElement("Apellido1");
                    persona.appendChild(apellido1);
                    Text apellido1Texto = doc.createTextNode(pers.getApellido1().toString());
                    apellido1.appendChild(apellido1Texto);

                    Element apellido2 = doc.createElement("Apellido2");
                    persona.appendChild(apellido2);
                    Text apellido2Texto = doc.createTextNode(pers.getApellido2().toString());
                    apellido2.appendChild(apellido2Texto);

                    Element nacimiento = doc.createElement("Nacimiento");
                    persona.appendChild(nacimiento);
                    Text nacimientoTexto = doc.createTextNode(pers.getNacimiento().toString());
                    nacimiento.appendChild(nacimientoTexto);
                     */
                    CrearElemento("nombre",pers.getNombre().toString(),persona,doc);
                    CrearElemento("apellido1",pers.getApellido1().toString(),persona,doc);
                    CrearElemento("apellido2",pers.getApellido2().toString(),persona,doc);
                    CrearElemento("nacimiento",pers.getNacimiento().toString(),persona,doc);
                   
                } catch (EOFException e) {
                    seguir = false; 
                }
            }
            TransformerFactory tF = TransformerFactory.newInstance();
            Transformer t = tF.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(doc), new StreamResult(System.out));
            t.transform(new DOMSource(doc), new StreamResult(new File(DOCTRABAJO_OUT)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    
    private static void CrearElemento(String etiqueta, String valor, Element padre, Document doc) {
    	Element elem= doc.createElement(etiqueta);
    	Text texto = doc.createTextNode(valor);
    	padre.appendChild(elem);
    	elem.appendChild(texto);
    }
}

