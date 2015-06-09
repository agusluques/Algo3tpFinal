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


public class Jugador {

	private String nombre;
	private Presupuesto presupuesto;
	private Collection<Constructible> construcciones;
	private Arquitecto arquitecto;
	private ArrayList<Atacable> unidades;
	private Mapa mapa;
	
	public Jugador(String nombre, Mapa mapa) {
		this.nombre = nombre;
		this.presupuesto = new Presupuesto(200,0);
		this.construcciones = new ArrayList<Constructible>();
		this.mapa = mapa;
		this.arquitecto = new Arquitecto(presupuesto, construcciones, mapa,this);
		this.unidades = new ArrayList<Atacable>();
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
		return this.contarCasas()*5;
		
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
	
	public void pasarTurno() {
		arquitecto.pasarTurno();
	}
	
	public void empezarTurno() {		
		eliminarUnidadesMuertas();
		eliminarConstruccionesMuertas();
		
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

}
