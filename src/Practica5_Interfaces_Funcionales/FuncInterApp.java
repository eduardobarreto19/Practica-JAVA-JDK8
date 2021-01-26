package Practica5_Interfaces_Funcionales;

public class FuncInterApp {
	/*
	 * Interfaces funcionales: son aquellas que definene una unica operacion o unico metodo
	 * Si creo otro metodo en la interfaz sale un error (para eso JDK8 creo una anotacion @FunctionalInterface)
	 */
	
	
	public double operar (double x, double y) {
		//se invoca interfaz y pasa expresion lamdba
		Operacion operacion = (n1,n2) ->  n1 + n2 ;
		return operacion.calcular(x, y);
	}
	
	
	public static void main(String[] args) {
		FuncInterApp app = new FuncInterApp();
		double respuesta  = app.operar(2, 3);
		System.out.println(respuesta);
	}
	

}
