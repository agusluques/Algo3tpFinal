package fiuba.algo3.tpfinal.programa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Magia;
import fiuba.algo3.tpfinal.vista.Observable;

public abstract class Jugador extends Observable{

	protected String nombre;
	protected Presupuesto presupuesto;
	protected Collection<Constructible> construcciones;
	protected Arquitecto arquitecto;
	protected ArrayList<Atacable> unidades;
	protected Mapa mapa;
	protected ArrayList<Magia> magias;
	protected int limitePoblacionalInicial;
	protected int limitePoblacionalMaximo;
	protected Coordenada baseInicial;
	protected Color color;

	public Jugador(String nombre, Mapa mapa) {
		this.nombre = nombre;
		this.presupuesto = new Presupuesto(200, 0);
		this.construcciones = new ArrayList<Constructible>();
		this.mapa = mapa;
		this.unidades = new ArrayList<Atacable>();
		this.magias = new ArrayList<Magia>();
		this.limitePoblacionalInicial = 5;
		this.limitePoblacionalMaximo = 200;
		this.arquitecto = new Arquitecto(mapa, this);
	}

	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return this.color;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int contarPoblacion() {
		int i = 0;
		for (Atacable unidad : unidades) {
			i += ((Fabricable) unidad).getSuministro();
		}

		return i;
	}

	private int contarCasas() {
		int i = 0;
		for (Constructible cons : this.construcciones) {
			i = i + cons.aumentoDePoblacion();
		}
		return i;
	}

	public int limitePoblacional() {
		if (limitePoblacionalInicial + this.contarCasas() >= limitePoblacionalMaximo) {
			return limitePoblacionalMaximo;
		} else {
			return limitePoblacionalInicial + this.contarCasas();

		}

	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public Collection<Constructible> getConstrucciones() {
		return construcciones;
	}

	public ArrayList<Atacable> getUnidades() {
		return this.unidades;
	}

	public void agregarMagia(Magia magia) {
		this.magias.add(magia);
	}

	public void pasarTurno() throws ParcelaOcupada {
		for (Atacable unidad : unidades) {
			unidad.pasarTurno();
		}
		for (Constructible construccion : construcciones) {
			try {
				((Atacable) construccion).pasarTurno();
			} catch (Exception e) {
			}

		}
		for (Magia magiaActual : magias) {
			magiaActual.pasarTurno();
		}
		arquitecto.pasarTurno();
	}

	public void empezarTurno() {
		eliminarUnidadesMuertas();
		eliminarConstruccionesMuertas();
		eliminarMagiasMuertas();
	}

	private void eliminarConstruccionesMuertas() {
		Iterator<Constructible> iteradorConstrucciones = construcciones
				.iterator();
		while (iteradorConstrucciones.hasNext()) {
			Atacable unidadActual = (Atacable) iteradorConstrucciones.next();
			if (unidadActual.estaMuerto()) {
				iteradorConstrucciones.remove();
			}
		}
	}

	private void eliminarUnidadesMuertas() {
		Iterator<Atacable> iteradorUnidades = unidades.iterator();
		while (iteradorUnidades.hasNext()) {
			Atacable unidadActual = iteradorUnidades.next();
			if (unidadActual.estaMuerto()) {
				iteradorUnidades.remove();
			}
		}
	}

	private void eliminarMagiasMuertas() {
		Iterator<Magia> iteradorMagias = magias.iterator();
		while (iteradorMagias.hasNext()) {
			Magia magiaActual = iteradorMagias.next();
			if (magiaActual.estaMuerto()) {
				iteradorMagias.remove();
			}
		}
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	@Override
	public boolean equals(Object o) {
		Jugador jugador = (Jugador) o;
		return (jugador.getNombre() == this.nombre);
	}

	@Override
	public int hashCode() {
		return this.nombre.hashCode();
	}

	public boolean estaExtinto() {
		return this.construcciones.isEmpty() && this.unidades.isEmpty();
	}

	public void inicializarEnPrimeraBase() {
		this.baseInicial = mapa.encontrarPrimeraBase();
		this.agregarUnidadBasica();
	}

	public void inicializarEnUltimaBase() {
		this.baseInicial = mapa.encontrarUltimaBase();
		this.agregarUnidadBasica();
	}

	protected abstract void agregarUnidadBasica();

	

}
