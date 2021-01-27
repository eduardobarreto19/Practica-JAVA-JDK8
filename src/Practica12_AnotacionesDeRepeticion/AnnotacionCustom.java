package Practica12_AnotacionesDeRepeticion;

public @interface AnnotacionCustom {
	
	String nombre();
	boolean habilitado() default true;

}
