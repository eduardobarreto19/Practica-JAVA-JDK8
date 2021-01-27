package Practica15_FuncionAltoOrden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {
	
	/*
	 * Funciones de alto orden: Se enfocan en el paso o devolucion de funciones en programacion
	 */
	
	//Function<entrada, salida>
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();	
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir (Function <String, String> funcion, String valor) {
		System.out.println(funcion.apply(valor));
	}
	
	//Envio funciones y retorno  funciones para usar en el resultado
	public Function <String, String> mostrar (String mensaje) {
		//Al parametro de entrada se le adiciona un parametro de mensaje
		return (String x) -> mensaje + x;
	}
	
	/*
	 * El metodo filtrar
	 * Recibe una Lista de Strings, un condumidor basico y un entero
	 * Se le aplica un filtro a la lista a traves de una expresion lamdba de un metodo independiente
	 * La salida se aplica un foEach con una consumidor
	 */
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud) {
		lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public void filtrar2(List<String> lista, Consumer<String> consumidor, String  cadena) {
		lista.stream().filter(this.establecerCadenaFiltro(cadena)).forEach(consumidor);
	}
	
	public Predicate<String> establecerCadenaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	
	
	public static void main(String[] args) {
		HighApp a = new HighApp();
		a.imprimir(a.convertirMinusculas, "MENSAJE");
		a.imprimir(a.convertirMayusculas, "computador");
		
		String respuesta = a.mostrar("hola").apply(" mundo Funcion");
		System.out.println(respuesta);
		
		List<String> lista = new ArrayList<>();
		lista.add("Candada");
		lista.add("Colombia");
		lista.add("Chile");
		
		a.filtrar(lista, System.out::println, 6);
		System.out.println("*******");
		a.filtrar2(lista, System.out::println, "Colombia");
		

	}

}
