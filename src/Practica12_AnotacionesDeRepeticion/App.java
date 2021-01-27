package Practica12_AnotacionesDeRepeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.swing.DefaultBoundedRangeModel;

public class App {
	/*
	 * Anotaciones de repeticion que da la JDK 8
	 * API reflection permite tener operaciones de manipulacion (en tiempo de ejecucion)
	 * El uso de anotaciones customizables, sirve para indicar metadatos. Se puede poner informacion en lugar de un simple comentario.
	 */
	
	//Crear anotacion en JAVA
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes{
		Lenguaje[] value() default {};
	}
	
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje{
		String value();
		String nombreUsuario() default "ValorDefecto"; 
	}
	
	/*
	//USANDO JDK 1.7
	@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Python")
		
	})
	public interface LenguajeProgramacion{
		
	}
	
	*/
		
	//USANDO JDK 8
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LenguajeProgramacion{
		
	}

	public static void main(String[] args) {
		//API REFLECTION PARA CONSULTAR Y USAR ESTAS ANOTACIONES
		//Arreglo de anotaciones llamado lenguaje
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tiene " + lenguajeArray.length + " Anotaciones en el arreglo Lenguaje []");
		
		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		for (Lenguaje elemento : len.value()) {
			System.out.println(elemento.value());
			
		}



	}

}
