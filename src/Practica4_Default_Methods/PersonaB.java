package Practica4_Default_Methods;

public interface PersonaB {
	
	default public void hablar() {
		System.out.println("Metodo por defecto B requiere implementacion");
	}

}
