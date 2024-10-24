package Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {
	public final static String RUTA= System.getProperty("user.dir" + System.getProperty("file.separator")+
			"src" + System.getProperty("file.separator")+ "data" + System.getProperty("file.separator"));
	public final static String DOCTRABAJO_IN="imagen.jpg";

	public static void main(String[] args) throws IOException {
		File f = new File("imagen.jpg");
		File nuevoF = new File("copia.jpg");
		FileInputStream fis= new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream(nuevoF);
		int caracter ='0';
		while((caracter= fis.read())!=-1){
			fos.write(caracter);
		}
		fos.close();
		fis.close();
	}

}
