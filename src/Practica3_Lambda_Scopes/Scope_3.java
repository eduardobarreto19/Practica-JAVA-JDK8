package Practica3_Lambda_Scopes;

public class Scope_3 {
	//Scope ambito o alcance (locales, globales y estaticas y como la expresion lambda puede reconocerlas)
	
	public double probarLocalVariable() {
		final double n3 = 3; //la variable debe tener un alcance final(no va a cambiar su valor)
		// Una variable final no puede ser re asignada
		
		/* JDK 7
		Operacion3 op = new Operacion3() {

			@Override
			public double calcular(double n1, double n2) {
				return n1 + n2 + n3;
			}
			
		};
		*/
		
		//JDK 8
		// Tener cuidado con una variable tipo final, no se le puede cambiar el valor
		Operacion3 operacion3 = (x,y) -> {
			return x + y + n3;
		};
		return operacion3.calcular(1, 1);
	}
	
	/*Variables sean locales o globales,( o mas conocidas como atratibutos estaticos o no)
	tienen el mismo comportamiento que en un objeto anonimo que se instancia a traves de una interfaz donde se implementan los metodos
	El comportamiento es igual en los objetos anonimos o expresiones lambdas
	*/
	
	public static double atributo1;
	public double atributo2;
	
	public double probarAtributosStaticVariables() {
		Operacion3 operacion3 = (x,y) -> {
			atributo1 = x + y;
			atributo2 = atributo1;
			return atributo2;
		};
		return operacion3.calcular(2, 3);
	}
	
	public static void main(String[] args) {
		Scope_3 scope = new Scope_3();
		//System.out.println(scope.probarLocalVariable());
		System.out.println(scope.probarAtributosStaticVariables());
	}

}
