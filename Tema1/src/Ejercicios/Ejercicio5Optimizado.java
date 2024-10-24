package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio5Optimizado {

	public final static String RUTA = System.getProperty("user.dir" + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "data" + System.getProperty("file.separator"));
	public final static String DOCTRABAJO_IN = "numeritos.txt";

	public static void main(String[] args) throws IOException {
		File f = new File("numeritos.txt");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		int contador = 1;
		escribir(raf, contador);
		consultar(raf, 3);
		leer(raf);
		leer(raf);
		leer(raf);
	}

	/**
	 * Escribe numeros del 1 al 100 en un fichero de acceso aleatorio o modifica el
	 * valor de una posicion determinada (ambos valores, posicion y nuevo valor, se
	 * pasan como parametros) o añade al final del fichero un nuevo valor
	 * 
	 * @param raf
	 * @param valores si vacio, inicializa el fichero con valores del 1 al 100 si
	 *                tiene uno, se añade al final si tiene dos, el primero es la
	 *                posicion y el segundo el nuevo valor
	 */
	public static void escribir(RandomAccessFile raf, int... valores) throws IOException {
		if (valores.length == 0) {
			for (int i = 0; i <= 100; i++) {
				raf.writeInt(i);
			}
		} else if (valores.length == 1) {
			raf.seek(raf.length());
			raf.writeInt(valores[0]);
			raf.seek(0);
		} else if (valores.length == 2) {
			// Primer paramatero lo tomo como posicion y el segundo como nuevo valor
			long mostrar = ((valores[0] - 1) * 4);
			// Comprobar que la posicion sea corecta no superior al tamaño del fichero ni
			// inferior a 0
			if (mostrar >= raf.length() || mostrar < 0) {
				System.out.println("La posicion no es correcta");
			} else {
				raf.seek(mostrar);
				raf.writeInt(valores[1]);
				raf.seek(0);
			}

		}

	}

	/**
	 * Lee el contenido del fichero, o el valor de una posicion que se pasa como
	 * parametro
	 * 
	 * @param raf
	 * @param valores si vacio, lee y muestra el contenido de todo el fichero si 1
	 *                valor, muestra el elemento contenido en esa posicion
	 * @throws IOException
	 */
	public static void leer(RandomAccessFile raf, int... valores) throws IOException {
		if (valores.length == 0) {
			raf.seek(0);
			while ((raf.getFilePointer() != raf.length())) {
				System.out.println(raf.readInt());
			}

		} else if (valores.length == 1) {
			long mostrar = ((valores[0] - 1) * 4);
			// Comprobar que la posicion sea corecta no superior al tamaño del fichero ni
			// inferior a 0
			if (mostrar >= raf.length() || mostrar < 0) {
				System.out.println("La posicion no es correcta");
			} else {
				raf.seek(mostrar);
				System.out.println(raf.readInt());
				raf.seek(0);
			}
		}
	}

	public static void consultar(RandomAccessFile raf, int posicion) throws IOException {
		long mostrar = ((posicion - 1) * 4);
		// Comprobar que la posicion sea corecta no superior al tamaño del fichero ni
		// inferior a 0
		if (mostrar >= raf.length() || mostrar < 0) {
			System.out.println("La posicion no es correcta");
		} else {
			raf.seek(mostrar);
			System.out.println(raf.readInt());
			raf.seek(0);
		}

	}

}

/**
 * posicion -1 * tamaño bloque
 **/