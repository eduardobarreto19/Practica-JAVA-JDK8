package Practica9_Optional;

import java.util.Optional;

public class OptionalApp {
	
	/*
	 * La idea de los Optional es redudir los errores de java.lang.NullPointerException
	 * Es un wrapper es como un envoltorio
	 */
	public void probar (String valor) {
		//System.out.println(valor.contains("eduardo")); arroja el error  java.lang.NullPointerException
		
		/*
		 * Arroja el error java.util.NoSuchElementException porque no encuentra un valor
		Optional op = Optional.empty();
		op.get();
		*/
		
		try {
			Optional op = Optional.empty();
			op.get();
			
		} catch (Exception e) {
			System.out.println("No hay elemento");
		}	
	}
	
	
	public void orElse(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElse("Predeterminado");
		System.out.println(x);
		
	}
	
	public void orElseThrow (String valor) {
		//si el valor es nulo vamos a poder lanzar una excepcion
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new);
		
	}
	
	public void isPresent(String valor) {
		//Valida si el valor fue inicializado o no
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent()); // True o False
		
	}
	
	

	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		//app.probar(null);
		//app.orElse(null);
		//app.orElseThrow(null);
		app.isPresent(null);
		
	
	}

}
