package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
	public final static String RUTA= System.getProperty("user.dir" + System.getProperty("file.separator")+
			"src" + System.getProperty("file.separator")+ "data" + System.getProperty("file.separator"));
	public final static String DOCTRABAJO="3_Ejercicio.csv";

	public static void main(String[] args) throws IOException {
		File f = new File(RUTA+DOCTRABAJO);
		FileReader fr= new FileReader(f);
		FileWriter fw = new FileWriter(f,true);
		BufferedReader br= new BufferedReader(fr);
		BufferedWriter bw= new BufferedWriter(fw);
		String linea;
		while((linea=br.readLine())!=null) {
			System.out.println(linea);
		}
		bw.write("Daniel;Robles;DAM;2");
		bw.close();
		br.close();
		
		

	}

}
/*
 * BufferedReader bfrd = new BufferedReader(new FileReader(RUTA+DOCTRABAJO));
 * String linea
 * while((linea = bfrd.readLine())!=null){
 * sysout(linea);
 * }
 * bfrd.close;
 * PrintWriter pw = new PrintWriter(new FileWriter(RUTA+DOCTRABAJO));
 * pw.println("datos");
 * */
