package ficheros.ejercicio6mio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;

public class Ejercicio6 {
	private final static String DOCTRABAJO_IN = "FicheroPersonasSerializado.dat";
	private static Scanner in = new Scanner(System.in);
	private static ObjectOutputStream oos;
	
	public static void inicializar() {
		 try {
			 File file = new File(DOCTRABAJO_IN);
			 if(file.exists() && file.length()>0) {
				 oos = new MiObjectOutputStream(new FileOutputStream(file, true));
			 }else {
				 oos = new ObjectOutputStream(new FileOutputStream(new File(DOCTRABAJO_IN), true));
			 }		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Persona obtenerDatos() {
		Persona persona = new Persona();
		System.out.println("Datos del usuario:\n\tNombre:  ");
		persona.setNombre(new StringBuilder(in.nextLine()));
		System.out.println("\tPrimer Apellido: ");
		persona.setApellido1(new StringBuilder(in.nextLine()));
		System.out.println("\tSegundo Apellido: ");
		persona.setApellido2(new StringBuilder(in.nextLine()));
		System.out.println("\tFecha de nacimiento(dd-MM-yyyy): ");
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			persona.setNacimiento(formatter.parse(in.nextLine()));
		} catch (ParseException e) {
			System.out.println("Error en el formato de la fecha");
			e.printStackTrace();
		}
		return persona;
	}

	public static void escribirObjeto(Persona persona) {
		try {
			oos.writeObject(persona);
			//oos.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		}
	}

	public static void leerObjeto() {
		try {
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(new File(DOCTRABAJO_IN)));
			try {
			Persona persona = new Persona();
			while (true) {
					persona = (Persona) oIS.readObject();
					System.out.println(persona);
			}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					oIS.close();
				}

		} catch (FileNotFoundException e) {
		} catch (IOException e1) {
			
		} 
	}
	public static void main(String[] args) {
		leerObjeto();
		inicializar();
		escribirObjeto(obtenerDatos());
		escribirObjeto(obtenerDatos());
		leerObjeto();
		try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
