package fiuba.algo3.tpfinal.unidades;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteProtoss extends UnidadesProtoss {

	private Collection<UnidadesProtoss> pasajeros;
	private int capacidad;

	public NaveTransporteProtoss(){
		this.vida.inicializarVida(80);
		this.escudo.inicializarEscudo(60);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(200);
		this.miDanio = new Danio(0,0);
		this.pasajeros = new ArrayList<UnidadesProtoss>();
		this.transporte = 9; //Decidi que sea 9 para que una nave no pueda estar en otra
		this.capacidad = 8;
		this.rango = new Rango(0,0);
		
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
	}
	
	public void atacado(Danio danio){
		this.escudo.bajarEscudo(danio.getDanioAire(), this.vida);
	}
	
	public void subirPasajero(UnidadesProtoss pasajero) {
		if (pasajero.transporte > this.capacidad) {
			throw new CapacidadInsuficiente();
		} else {
			pasajeros.add(pasajero);
			capacidad -= pasajero.transporte;
		}
	}
	
	public Collection<UnidadesProtoss> descenderPasajeros() {
		Collection<UnidadesProtoss> pasajerosDescendidos = this.pasajeros;
		this.pasajeros = new ArrayList<UnidadesProtoss>();
		this.capacidad = 8;
		return pasajerosDescendidos;
	}

	public int getCapacidad() {
		return this.capacidad;
	}
	
	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}
}
