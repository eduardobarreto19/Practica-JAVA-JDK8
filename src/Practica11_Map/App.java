package Practica11_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class App {
	
	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Colombia");
		map.put(2, "Canada");
		map.put(3, "EEUU");
		map.put(4, "Alemania");
	}
	
	public void imprimirV7() {
		//JDK7
		for( Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
		}
	}
	
	public void imprimirV8() {
		//JDK8
		//map.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void insertarSiAsente() {
		map.putIfAbsent(5, "España");
		//map.putIfAbsent(1, "España"); //No sobre escribe es solo si esta ausente
		
	}
	
	public void operarSiPresente() {
		map.computeIfPresent(2, (k,v) -> k + v);
		System.out.println(map.get(2));
		
	}
	
	public void obtenerOrPredeterminado() {
		String valor = map.getOrDefault(6, "Valor por defecto");
		System.out.println(valor);
	}
	
	public void recolectar() {
		//es comun en operaciones en listas y mapas
		//filtrar elementos bajo un criterio y pasarlos a otro mapa
		
		Map<Integer, String> mapaRecolenctado = map.entrySet().stream()
				.filter(e->e.getValue().contains("Ca")) //prediado
				.collect(Collectors.toMap(p-> p.getKey(), p->p.getValue()));
		
		mapaRecolenctado.forEach((k,v) -> System.out.println("Llave: " + k+ " Valor: " + v));
		
	}
	
	public static void main(String[] args) {
		App a = new App();
		a.poblar();
		//a.imprimirV7();
		//a.insertarSiAsente();
		//a.operarSiPresente();
		//a.imprimirV8(); 
		//a.obtenerOrPredeterminado();
		a.recolectar();
	}

}
