package Practica10_StreamParalelo;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	/*
	 * Procesamiento paralelo de hilos
	 * Alivia el rendimiento en unas aplicaciones
	 * Abusar de paralem String no es recomendable en JAva EE container, cuando se usan muchos request de manera asincrona (afecta el rendimiento)
	 */
	
	private List<Integer> numeros;
	
	public void llenar() {
		numeros = new ArrayList<>();
		
		for(int i = 0; i<10; i++) {
			numeros.add(i);
		}
	}
	
	
	public void probarStream() {
		numeros.stream().forEach(System.out::println);
	}
	
	public void probarParalelo() {
		//Crea un procesamiento con hilos asincrono, implementa un for join pool
		numeros.parallelStream().forEach(System.out::println);
		
	}
	
	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
		//app.probarStream(); //Imprime del 1 al 9 secuencual
		app.probarParalelo(); // Imprime de manerea aleatorio
	}
	

}
