package Ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio5Temperaturas {

	private static RandomAccessFile raf;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		while (true) {
			raf = new RandomAccessFile("temperaturas.txt", "rw");
			System.out.println("\n--- Menú de opciones ---");
			System.out.println("1. Ver temperatura de un mes");
			System.out.println("2. Añadir un nuevo registro");
			System.out.println("3. Salir");
			System.out.print("Selecciona una opción: ");
			int opcion = in.nextInt();
			switch (opcion) {
			case 1:
				mostrarTemperatura(in);
				break;
			case 2:
				añadirRegistro( in);
				break;
			case 3:
				System.out.println("Saliendo...");
				in.close();
				System.exit(0);
			case 4:
				modificarRegistro(in);
				break;
			default:
				System.out.println("Opción inválida. Inténtalo de nuevo.");
			}
		}
	}
	public static void mostrarTemperatura( Scanner scanner) {
		System.out.print("Introduce el número del mes (1 para Ene, 2 para Feb, etc.): ");
		int mes = scanner.nextInt();
		try {
			raf.seek(0);
			boolean mesEncontrado = false;
			for (int i = 1; i <= mes; i++) {
				String linea = raf.readLine();

				if (linea == null) {
					System.out.println("Mes no válido.");
					return;
				}
				if (i == mes) {
					String[] datos = linea.trim().split(" ");
					if (datos.length >= 3) {
						String mesNombre = datos[0];
						int tempMax = Integer.parseInt(datos[1]);
						int tempMin = Integer.parseInt(datos[2]);
						System.out.println("Mes: " + mesNombre);
						System.out.println("Temperatura Máxima: " + tempMax);
						System.out.println("Temperatura Mínima: " + tempMin);
						mesEncontrado = true;
						raf.close();
					} else {
						System.out.println("El formato de la línea es incorrecto.");
					}
				}
			}
			if (!mesEncontrado) {
				System.out.println("Mes no encontrado.");
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error al leer el archivo o al procesar los datos: " + e.getMessage());
		}
	}

	public static void añadirRegistro(Scanner scanner) {
		System.out.print("Introduce el mes (tres letras, por ejemplo Ene): ");
		String mes = scanner.next().toLowerCase();
		System.out.print("Introduce la temperatura máxima: ");
		int tempMax = scanner.nextInt();
		System.out.print("Introduce la temperatura mínima: ");
		int tempMin = scanner.nextInt();
		try {
			raf.seek(raf.length());
			raf.writeBytes(mes + " " + tempMax + " " + tempMin + "\n");
			System.out.println("Registro añadido correctamente.");
			raf.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
	public static void modificarRegistro(Scanner scanner) {
		System.out.print("Introduce el número del mes (1 para Ene, 2 para Feb, etc.): ");
		int mes = scanner.nextInt();
		try {
			raf.seek(0);
			boolean mesEncontrado = false;
			for (int i = 1; i <= mes; i++) {
				String linea = raf.readLine();

				if (linea == null) {
					System.out.println("Mes no válido.");
					return;
				}
				if (i == mes) {
					raf.seek((13*(i+1))-1);
					String[] datos = linea.trim().split(" ");
					if (datos.length >= 3) {
						String mesNombre = datos[0];
						System.out.println("Introduce la temperatura maxima: ");
						int tempMax = scanner.nextInt();
						System.out.println("Introduce la temperatura minima: ");
						int tempMin = scanner.nextInt();
						raf.writeBytes(mesNombre + " " + tempMax + " " + tempMin);
						mesEncontrado = true;
						raf.close();
					} else {
						System.out.println("El formato de la línea es incorrecto.");
					}
				}
			}
			if (!mesEncontrado) {
				System.out.println("Mes no encontrado.");
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error al leer el archivo o al procesar los datos: " + e.getMessage());
		}
	}
	
}
