package Principal;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de numeros: "));
		int[] arreglo = new int[cantidad];
		int buscado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento buscado: "));
		int existe = 0;
		System.out.println("Ingrese los " + cantidad + " numeros: ");

		for (int i = 0; i < cantidad; i++) {
			arreglo[i] = Integer.parseInt(entrada.nextLine());
		}

		existe = ocurrencias(buscado, arreglo, cantidad);

	}

	private static int ocurrencias(int buscado, int[] arreglo, int cantidad) {
		int cant = 0;
		for (int i = 0; i < cantidad; i++) {
			if (arreglo[i] == buscado) {
				cant = cant + 1;
			}
		}

		System.out.println("El elemento buscado aparecio: " + cant + " veces");
		return cant;
	}
}