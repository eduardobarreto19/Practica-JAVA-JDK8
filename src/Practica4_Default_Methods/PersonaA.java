package Practica4_Default_Methods;

public interface PersonaA {
	
	public void caminar();
	
	default public void hablar() {
		System.out.println("Metodo por defecto A requiere implementacion");
	}
}
