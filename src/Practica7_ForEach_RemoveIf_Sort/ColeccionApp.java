package Practica7_ForEach_RemoveIf_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		lista.add("Zomaira");
		lista.add("Alemania");
		lista.add("Canada");
		lista.add("china");
		lista.add("Francia");
	
		
	}
	
	public void usarForEach() {
		//for each tradicional JDK 7
		System.out.println("Usando JDK 7");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		System.out.println("********************");
		
		//Expresion lambda
		System.out.println("Usando JDK 8");
		lista.forEach(x -> System.out.println(x));
		
		//Metodo a referencias
		System.out.println("********************");
		lista.forEach(System.out::println);
		
	}
	
	public void usarRemoveIf() {
		/*
		//JDK 7, logica de eliminacion cuando coiniciden elementos en particular
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase("Francia")) {
				it.remove();
			}
			
		}
		*/
		
		//JDK 8
		//Ejemplo predicado
		lista.removeIf(x -> x.equalsIgnoreCase("Francia"));
	}
	
	public void usarSort() {
		//JDK 8
		lista.sort((x,y) -> x.compareTo(y));
		
	}

	
	
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		//app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();
		

	}



}
