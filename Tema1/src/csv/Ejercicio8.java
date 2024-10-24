package csv;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Ejercicio8 {
	private static final String DOCTRABAJO_IN="ejercicio08.csv";
	public static void main(String[] args) {
		try {
			File f = new File(DOCTRABAJO_IN);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String[] linea= br.readLine().split(",");
				for (int i = 0; i < linea.length; i++) {
					linea[i]= linea[i].trim().replaceAll("^\"", "");
					linea[i]= linea[i].trim().replaceAll("\"$", "");
					System.out.print(linea[i] + "\t");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {
			
		}
	}
}
