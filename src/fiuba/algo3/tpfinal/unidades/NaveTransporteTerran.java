package fiuba.algo3.tpfinal.unidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;

public class NaveTransporteTerran extends UnidadesTerran {

	private int capacidad;
	private Collection<UnidadesTerran> pasajeros;

	public NaveTransporteTerran(){
		this.vida.inicializarVida(150);
		this.miDanio = new Danio(0,0);
		this.rango = new Rango(0,0);
		this.tiempoDeConstruccion = 7;
		this.suministro = 2;
		this.costo = new Costo(100,100);
		this.capacidad = 8;
		this.pasajeros = new ArrayList<UnidadesTerran>();
		this.transporte = 9;
		
		
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
	}
	
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
	
	public void subirPasajero(UnidadesTerran pasajero) {
		if (pasajero.transporte > this.capacidad) {
			throw new CapacidadInsuficiente();
		} else {
			pasajeros.add(pasajero);
			capacidad -= pasajero.transporte;
		}
	}
	
	public void bajarPasajeros() throws NoHayPasajerosEnLaNave{
		if (this.cantidadDePasajeros() == 0){
			throw new NoHayPasajerosEnLaNave();
		}
		Iterator<UnidadesTerran> iterador = this.pasajeros.iterator();
		while(iterador.hasNext()) {
			UnidadesTerran unidad = iterador.next();
			Mapa mapa = jugador.getMapa();
			Parcela parcela = mapa.getParcela(this.posicion);
			while (unidad.sePuedeMoverA(parcela.getSuperficie())){
				iterador.remove();
				mapa.ubicarCercaDe(unidad, this.posicion);
				this.capacidad = 8;
			}
			
		}
	}

	public int getCapacidad() {
		return this.capacidad;
	}
	
	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}
	
	public int cantidadDePasajeros() {
		return pasajeros.size();
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoAire();
	}
}
