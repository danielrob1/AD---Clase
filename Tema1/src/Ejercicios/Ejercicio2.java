package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce el nombre del fichero o directorio");
		File f = new File((System.getProperty("user.dir") + "/" + in.next()));
		if (f.exists()) {
			System.out.println("El archivo existe");
			if (f.isFile()) {
				infoFichero(f);
			} else {
				File archivos[] = f.listFiles();
				for (int i = 0; i < archivos.length; i++) {
					System.out.println(archivos[i].getName());
				}
			}
		} else
			System.out.println("El archivo no existe");
	}
	public static void infoFichero(File f) {
		System.out.println("El archivo pesa " + f.length() + " bytes");
		if (f.canWrite()) {
			System.out.println("El archivo se puede modificar");
		} else
			System.out.println("El archivo no puede modificarse");
		if (f.canRead()) {
			System.out.println("El archivo puede leerse");
		} else
			System.out.println("El archivo no puede leerse");
		if (f.canExecute()) {
			System.out.println("El archivo puede ejecutarse");
		} else
			System.out.println("El archivo no puede ejecutarse");
		
	}
}
