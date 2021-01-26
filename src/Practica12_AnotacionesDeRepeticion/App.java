package Practica12_AnotacionesDeRepeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {
	/*
	 * Anotaciones de repeticion que da la JDK 8
	 * API reflection permite tener operaciones de manipulacion (en tiempo de ejecucion)
	 */
	
	//Crear anotacion en JAVA
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes{
		Lenguaje[] value() default {};
	}
	
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje{
		String value();
	}
	
	/*
	//JDK 1.7
	@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Python")
		
	})
	public interface LenguajeProgramacion{
		
	}
	
	*/
	
	
	
	//JDK 8
	@Lenguaje("Java"),
	@Lenguaje("Python")
	public interface LenguajeProgramacion{
		
	}

	public static void main(String[] args) {
		//API REFLECTION PARA CONSULTAR Y USAR ESTAS ANOTACIONES
		//Arreglo de anotaciones llamado lenguaje
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tiene " + lenguajeArray.length + " Anotaciones en el arreglo Lenguaje []");



	}

}
