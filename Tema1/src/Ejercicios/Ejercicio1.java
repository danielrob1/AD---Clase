package Ejercicios;

import java.io.File;

public class Ejercicio1 {

	public static void main(String[] args) {
			File f = new File(System.getProperty("user.dir"));
			System.out.println("El directorio se llama " + f.getName());
			File[] ficheros = f.listFiles();
			System.out.println("En el directorio hay " + ficheros.length + " ficheros");
			for (int i = 0; i < ficheros.length; i++) {
				if (ficheros[i].isFile()) {
					System.out.println("El elemento " + ficheros[i].getName() + " es un archivo");
				} else
					System.out.println("El elemento " + ficheros[i].getName() + " es un directorio");
			}
	}
}
