package fiuba.algo3.tpfinal.programa;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;


public class Juego {
	
	private Rectangle mapa;
	private Collection<Recolectables> minerales;
	private Collection<Recolectables> volcanes;
	private int poblacion;
	
	//Constructor
	//inicializa el juego con un mapa(200x200) que contiene 4 islas en cada punta
	public Juego(){
		mapa = new Rectangle();
		this.agregarIslas();
		this.agregarMinerales();
		this.agregarVolcanes();
		this.poblacion = 0;
	}
	
	private void agregarVolcanes() {
		Recolectables volcanUno = new Volcan (new Point(35,30));
		Recolectables volcanDos = new Volcan (new Point (35,170));
		Recolectables volcanTres = new Volcan (new Point (175,30));
		Recolectables volcanCuatro = new Volcan (new Point(175,170));
		
		mapa.add(volcanUno.areaOcupada());
		mapa.add(volcanDos.areaOcupada());
		mapa.add(volcanTres.areaOcupada());
		mapa.add(volcanCuatro.areaOcupada());
		
		/*volcanes.add(volcanUno);
		volcanes.add(volcanDos);
		volcanes.add(volcanTres);
		volcanes.add(volcanCuatro);*/
	}

	private void agregarMinerales() {
		Recolectables mineralesUno = new Mineral(new Point (30,30));
		Recolectables mineralesDos = new Mineral(new Point (170,30));
		Recolectables mineralesTres = new Mineral(new Point (30,170));
		Recolectables mineralesCuatro = new Mineral(new Point (170,170));
		
		mapa.add(mineralesUno.areaOcupada());
		mapa.add(mineralesDos.areaOcupada());
		mapa.add(mineralesTres.areaOcupada());
		mapa.add(mineralesCuatro.areaOcupada());

		/*minerales.add(mineralesUno);
		minerales.add(mineralesDos);
		minerales.add(mineralesTres);
		minerales.add(mineralesCuatro);*/
	}

	private void agregarIslas() {
		Rectangle islaUno = new Rectangle (new Point(0,50), new Dimension(50,50));
		Rectangle islaDos = new Rectangle (new Point(150,50), new Dimension(50,50));
		Rectangle islaTres = new Rectangle (new Point(0,200), new Dimension(50,50));
		Rectangle islaCuatro = new Rectangle (new Point(150,200), new Dimension(50,50));

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

	public boolean quedanMinerales() {
		return minerales.isEmpty();
	}

	public boolean quedanVolcanes() {
		return volcanes.isEmpty();
	}

	
	
	
}
