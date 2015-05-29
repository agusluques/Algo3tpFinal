package fiuba.algo3.tpfinal.programa;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;


public class Juego {
	
	private Rectangle mapa;
	private int poblacion;
	
	//Constructor
	//inicializa el juego con un mapa(200x200) que contiene 4 islas en cada punta
	public Juego(){
		mapa = new Rectangle();
		this.agregarIslas();
		this.poblacion = 0;
	}
	
	private void agregarIslas() {
		Rectangle islaUno = new Rectangle (new Point(0,0), new Dimension(20,20));
		Rectangle islaDos = new Rectangle (new Point(0,180), new Dimension(20,20));
		Rectangle islaTres = new Rectangle (new Point(180,0), new Dimension(20,20));
		Rectangle islaCuatro = new Rectangle (new Point(180,180), new Dimension(20,20));

		this.mapa.add(islaUno);
		this.mapa.add(islaDos);
		this.mapa.add(islaTres);
		this.mapa.add(islaCuatro);
	}

	public Boolean mapaEstaVacio(){
		return mapa.isEmpty();
	}

	public int cantidadDePoblacion() {
		return this.poblacion;
	}

	
	
	
}
