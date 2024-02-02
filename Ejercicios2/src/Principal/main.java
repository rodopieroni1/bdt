package Principal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de numeros: "));
		
		int[] arreglo = new int[cantidad];
		int[] arregloAComparar = new int[cantidad];

		int buscado = 0;
		
		System.out.println("Ingrese los " + cantidad + " numeros: ");
		for (int i = 0; i < cantidad; i++) {
			arreglo[i] = Integer.parseInt(entrada.nextLine());
		}

		System.out.println("Ingrese los " + cantidad + " Elementos a comparar ");
		for (int i = 0; i < cantidad; i++) {
			arregloAComparar[i] = Integer.parseInt(entrada.nextLine());
		}

		Arrays.sort(arregloAComparar);
		Set<Integer> listaFinal = new HashSet<>();
		for (int i = 0; i < cantidad; i++) {
			listaFinal.add(arregloAComparar[i]);
		}
		
		System.out.println("La lista final es");
		for (Integer i : listaFinal) {
			buscado = i;
			ocurrencias(buscado, arreglo, cantidad);
		}
	}

	private static void ocurrencias(int buscado, int[] arreglo, int cantidad) {
		boolean esta = false;
		for (int i = 0; i < cantidad; i++) {
			if (arreglo[i] == buscado) {
				esta = true;
			}
		}
		if (esta) {
			System.out.println(buscado + " *");

		} else {
			System.out.println(buscado + "");
		}

	}
}