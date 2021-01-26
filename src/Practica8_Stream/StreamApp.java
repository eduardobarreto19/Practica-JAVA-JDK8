package Practica8_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApp {
	
	private List<String> lista;
	private List<Integer> numeros;
	
	public StreamApp() {
		lista = new ArrayList<>();
		lista.add("Canada");
		lista.add("Colomiba");
		lista.add("EEUU");
		lista.add("PERU");
		
		numeros = new ArrayList<>();
		numeros.add(1);
		numeros.add(5);
		numeros.add(3);
	}
	
	public void filtrar () {
		lista.stream().filter(x -> x.startsWith("C")).forEach(System.out::println);
		System.out.println("-");
	}
	
	
	public void ordenar() {
		//Ordenar de forma ascendente
		lista.stream().sorted().forEach(System.out::println);
		System.out.println("-");
		
		//Ordenar de forma descendente
		lista.stream().sorted((x,y)->y.compareToIgnoreCase(x)).forEach(System.out::println);
		System.out.println("-");
	}
	
	public void transformar () {
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("-");
		
		/*
		//Ejercicio JDK 7}
		for (Integer elemento : numeros) {
			int num = elemento + 1;
			System.out.println(num);
		}
		*/
		
		numeros.stream().map(x -> x + 1).forEach(System.out::println);
		System.out.println("-");
	
	}
	
	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
		System.out.println("-");
		
	}
	
	public void contar() {
		long valor =lista.stream().count();
		System.out.println(valor);
		
	}
	
	public void eliminarDistinto() {
		List numbers = Arrays.asList(7, 7, 7, 7, 2, 2, 2, 3, 3, 3, 3, 100, 100, 200, 200);
        numbers = (List) numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Lista con elementos distintos: "+numbers);

        System.out.println("******");

        Set nums = (Set) numbers.stream().collect(Collectors.toSet());
        System.out.println("SET con elementos distintos: "+numbers);

        System.out.println("******");
		
	}
	
	public void ejercicioDiplicados(){
		 //JDK8
        System.out.println("******************* JDK 8");
        Integer[] numbers = new Integer[] {1,2,3,4,5,1,3,5};

        //This array has duplicate elements
        System.out.println( "JDK8 con duplicados" + Arrays.toString(numbers) );


        //Opcion 1
        List numbersAux = (List)  Arrays.asList(numbers).stream().distinct().collect(Collectors.toList());
        ////Opcion 2
        //Set nums = (Set)   Arrays.asList(numbers).stream().collect(Collectors.toSet());
        System.out.println("JDK8 Sin dulicados: "+numbersAux);



        //JDK7
        System.out.println("******************* JDK 7");
        Integer[] numbers2 = new Integer[] {1,2,3,4,5,1,3,5};

        //This array has duplicate elements
        System.out.println( "JDK7 con duplicados" + Arrays.toString(numbers2) );

        //Create set from array elements
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>( Arrays.asList(numbers2) );

        //Get back the array without duplicates
        Integer[] numbersWithoutDuplicates = linkedHashSet.toArray(new Integer[] {});
        System.out.println( "JDK 7 Sin duplicados" +linkedHashSet );
		
		
	}

	public static void main(String[] args) {
		StreamApp app = new StreamApp();
		app.filtrar();
		app.ordenar();
		app.transformar();
		app.limitar();
		app.contar();
		app.eliminarDistinto();
		app.ejercicioDiplicados();
	}

}
