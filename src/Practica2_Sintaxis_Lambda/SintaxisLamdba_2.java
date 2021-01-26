package Practica2_Sintaxis_Lambda;

public class SintaxisLamdba_2 {
	
	public double probarSintaxis() {
		
		//caso 1: uso de llaves
		//Operacion operacion = (double x, double y) -> {return (x+y)/2;};
		//return operacion.calcularPromedio(2, 3);
		
		
		//caso 2: uso de llaves para multiples lineas
		/* 
		Operacion operacion = (double x, double y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x+y)/2+a;
		};
			return operacion.calcularPromedio(2, 3);
		*/
		
		//caso 3:llava supone implicitamente el tipo de datos de los parametros de la operacion
		//Operacion operacion = (x, y) -> {return (x+y)/2;};
		//return operacion.calcularPromedio(2, 3);
		
		
		//Caso 4: Cuando no se desea tener parametros en la expresion landa () parentesis vacios
		//Operacion2 operacion2 = () -> 2;
		//return operacion2.calcularPromedio();
		
		
		// Caso 5: 
		Operacion2 operacion2 = () -> {
			int x = 2;
			int y = 3;
			return x+y;
		};
		return operacion2.calcularPromedio();
			
	}
	
	
	public static void main(String[] args) {
		SintaxisLamdba_2 lamdba = new SintaxisLamdba_2();
		System.out.println(lamdba.probarSintaxis());
		
	}

}
