package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Magia;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Zealot;


public class Jugador {

	private String nombre;
	private Presupuesto presupuesto;
	private Collection<Constructible> construcciones;
	private Arquitecto arquitecto;
	private ArrayList<Atacable> unidades;
	private Mapa mapa;
	private ArrayList<Magia> magias;
	
	public Jugador(String nombre, Mapa mapa) {
		this.nombre = nombre;
		this.presupuesto = new Presupuesto(200,0);
		this.construcciones = new ArrayList<Constructible>();
		this.mapa = mapa;
		this.arquitecto = new Arquitecto(presupuesto, construcciones, mapa,this);
		this.unidades = new ArrayList<Atacable>();
		this.magias = new ArrayList<Magia>();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public int contarPoblacion(){
		int i = 0;
		for (Atacable unidad : unidades){
			i += ((Fabricable)unidad).getSuministro();
		}
		
		return i;
	}
	
	private int contarCasas(){
		int i = 0;
		for ( Constructible cons : this.construcciones){
			if(cons.equals(new Pilon()) || cons.equals(new DepositoSuministro())) {
				i++;
			}
		}
		return i;
	}

	public int limitePoblacional(){
		return 5 + this.contarCasas()*5;
		
	}
	public void construir(Constructible construccion, Coordenada posicion) throws ConstruccionRequeridaInexistente {
		this.arquitecto.construir(construccion, posicion);
		
	}
	
	public Presupuesto getPresupuesto(){
		return this.presupuesto;
	}
	
	public Collection<Constructible> getConstrucciones(){
		return construcciones;
	}

	public ArrayList<Atacable> getUnidades(){
		return this.unidades;
	}

	public void agregarUnidad(Fabricable unidad, Coordenada coord) throws LimitePoblacionalAlcanzado {
		if( (this.contarPoblacion()+unidad.getSuministro()) <= this.limitePoblacional()){
			this.unidades.add((Atacable) unidad);
			this.mapa.ubicarCercaDe((Atacable)unidad, coord);
			((Atacable)unidad).setJugador(this);
		}else{
			throw new LimitePoblacionalAlcanzado();
		}
		
	}
	
	public void agregarMagia(Magia magia){
		this.magias.add(magia);
	}
	
	public void pasarTurno() {
		for(Atacable unidad : unidades) {
			unidad.pasarTurno(this, mapa);
		}
		for(Constructible construccion : construcciones) {
			((Atacable) construccion).pasarTurno(this, mapa);
		}
		for(Magia magiaActual : magias) {
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
		Iterator<Constructible> iteradorConstrucciones = construcciones.iterator();
		while(iteradorConstrucciones.hasNext()) {
			Atacable unidadActual = (Atacable) iteradorConstrucciones.next();
			if (unidadActual.estaMuerto()) {
				iteradorConstrucciones.remove();
			}
		}
	}

	private void eliminarUnidadesMuertas() {
		Iterator<Atacable> iteradorUnidades = unidades.iterator();
		while(iteradorUnidades.hasNext()) {
			Atacable unidadActual = iteradorUnidades.next();
			if (unidadActual.estaMuerto()) {
				iteradorUnidades.remove();
			}
		}
	}
	
	private void eliminarMagiasMuertas() {
		Iterator<Magia> iteradorMagias = magias.iterator();
		while(iteradorMagias.hasNext()) {
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
	public boolean equals(Object o){
		Jugador jugador = (Jugador)o;
		return (jugador.getNombre()== this.nombre);
	}
	
	@Override
	public int hashCode(){
		return this.nombre.hashCode();
	}
	
	public boolean estaExtinto() {
		return this.construcciones.isEmpty() && this.unidades.isEmpty();
	}
	
	public void setRaza(String raza) {
		Fabricable unidadBasica;
		if (raza == "Terran") {
			unidadBasica = new Marine();
		} else {
			unidadBasica = new Zealot();
		}
		this.agregarUnidad(unidadBasica, mapa.encontrarPrimeraBase());
	}

}
