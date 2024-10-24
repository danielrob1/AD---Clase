package ficherosconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio7 {
	//TODO capturar excepciones ¿Number format? para que se devuelva la peticion
	private final static String DOCTRABAJO_IN="configuracion.props";
	private final static Properties prop= new Properties();
	private final static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		crearConfiguracion();
		System.out.println("Config inicial: ");
		leerConfiguracion();
		modificarConfiguracion();
		System.out.println("Config modificada");
		leerConfiguracion();
	}
	private static void modificarConfiguracion() {
		try {
			prop.load(new FileInputStream(DOCTRABAJO_IN));
			System.out.println("Modificando config: ");
			System.out.println("User:");
			prop.setProperty("user", in.nextLine());
			System.out.println("Valor a sumar al puerto: ");
			prop.setProperty("port", String.valueOf(Integer.valueOf(in.nextLine())+ Integer.valueOf(prop.getProperty("port"))));
			System.out.println("Nuevo mes para la fecha: ");
			int mes = Integer.valueOf(in.nextLine());
			prop.setProperty("date",
					String.valueOf(LocalDate.parse(prop.getProperty("date")).withMonth(mes)));
			prop.setProperty("power",
					String.valueOf(!Boolean.valueOf(prop.getProperty("power")))); 
			prop.store(new FileOutputStream((DOCTRABAJO_IN)), "Fichero de Configuracion");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void leerConfiguracion() {
		try {
			prop.load(new FileInputStream(DOCTRABAJO_IN));
			prop.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void crearConfiguracion() {
		prop.setProperty("user", "usuario");
		prop.setProperty("password", "micontrasena");
		prop.setProperty("server", "localhost");
		prop.setProperty("port", "3306");
		prop.setProperty("date", "2000-12-10");
		prop.setProperty("power", "true");
		try {
			prop.store(new FileOutputStream((DOCTRABAJO_IN)), "Fichero de Configuracion");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
