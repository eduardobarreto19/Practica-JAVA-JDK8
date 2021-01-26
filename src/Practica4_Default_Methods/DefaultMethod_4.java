package Practica4_Default_Methods;

public class DefaultMethod_4 implements PersonaA, PersonaB {
	/*
	 * Metodo default: es un metodo que esta implementado en una interfaz para que cualquier clase
	 * que implemente esta interfaz ya tenga acceso al metodo definido
	 * 
	 * A veces se trabaja orientado a interfaces para tener codigo desacoplado
	 * 
	 * Cuando se requiere que todas las clases que tengas una determinada interfaz tenga un comportamiento por defecto
	 * Para ello se usa el metodo tradicional o crear un metodo por defecto.
	 */
	
	@Override
	public void caminar() {
		System.out.println("prueba interfaz tradicional");
		
	}
	
	@Override
	public void hablar() {
		//PersonaA.super.hablar();
		PersonaB.super.hablar();
	}

	public static void main(String[] args) {
		DefaultMethod_4 method_4 = new DefaultMethod_4();
		method_4.caminar();
		method_4.hablar();
		
	}
}
