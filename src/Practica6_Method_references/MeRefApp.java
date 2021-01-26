package Practica6_Method_references;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
	/*
	 * Referencias a metodos:
	 * Mejora la sintaxis para escribir codigo en java, mas legigle, menos lienas de codigo
	 * usa ::  invoco al metodo a traves de estos 4 puntos, no se pueden enviar parametros (no implementa currificacion)
	 * Metodos a referencias no aceptan el paso de parametros
	 */
	
	public static void referenciarMetodoStatic() {
		System.out.println("Metodo referido static");
		
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String [] nombres = {"panama", "colombia", "alemania"};
		
		/*
		LOGICA 1: Todo est es muy verboso JDK 7 (clase anonima)
		Arrays.sort(nombres, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		*/
		
		//LOGIA 2: JDK 8 con lambda expression y evitando clase anonima
		//Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
		
		//LOGICA 3: esto se puede reducir mas usando referencia a metodos
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Metodo referido instancia de clase");
		
	}
	
	public void referenciarConstructor() {
		/*
		//JDK 7
		//usamos de manera tradicional clase anonima
		Ipersona iper = new Ipersona() {
			
			@Override
			public Persona crear(int id, String nombre) {
				// TODO Auto-generated method stub
				return new Persona(id, nombre);
			}
		};
		
		iper.crear(1, "Luis");
		*/
		
		//JDK 8
		Ipersona iper = (x,y) ->(new Persona(x, y));
		Persona per = iper.crear(1, "Luis");
		System.out.println(per.getId() + " - "+per.getNombre());
		
		//Reducir usando metodos a referencia
		Ipersona ipersona = Persona::new;
		Persona per2 = ipersona.crear(2, "Maria");
		System.out.println(per2.getId() + " - "+per2.getNombre());
		
		
	}
	
	
	
	public void operar() {
		//Operacion op = () -> MeRefApp.referenciarMetodoStatic();
		//op.saludar();
		
		//Referencia a metodo estatico con :: no llea parametros 
		Operacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		//app.operar();
		//app.referenciarMetodoInstanciaObjetoArbitrario();
		
		//Metodo de referencia se apoya en las interfaces funcionales
		//Se indica el metodo que va a implementar el metodo saludar de una interzaz
		// implicitamente java usa metodos como si fueras parametros para usar otros metodos
		
		//Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		//op.saludar();
		
		app.referenciarConstructor();
	
	}

}
