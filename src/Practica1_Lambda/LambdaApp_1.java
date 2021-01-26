package Practica1_Lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class LambdaApp_1 {
	
	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("Luis Eduardo");
		lista.add("Mary");
		lista.add("Peter");
		lista.add("Ana");
		
		// Se usan muchas lineas de codigo solo para una comparacion
		//ordena lista de manera ascerndente
		/* JDK 7
		Collections.sort(lista, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) { 
				return o1.compareTo(o2);
			}
		});
		*/
		
		//Practica lambda JDK8
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		for (String elemento : lista) {
			System.out.println(elemento);
		}	
	}
	
	public void calcular () {
		//Enfoque imperativo JDK 7: como lo nececito
		//Una interfaz no se puede instanciar
		/*
		Operacion operacion = new Operacion() {
			
			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1+n2)/2;
			}
		};
		System.out.println(operacion.calcularPromedio(2, 3));
		*/
		
		//JDK8= enfoque declarativo: que es lo que nececito
		Operacion operacion = (double x, double y ) -> (x+y) / 2;
		System.out.println(operacion.calcularPromedio(2, 3));
		
	}
	
	
	public static void main(String[] args) {
		LambdaApp_1 lambdaApp = new LambdaApp_1();
		//lambdaApp.ordenar();
		lambdaApp.calcular();
		
	}

}
