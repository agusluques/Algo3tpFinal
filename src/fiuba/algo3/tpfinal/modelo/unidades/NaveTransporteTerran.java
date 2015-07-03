package fiuba.algo3.tpfinal.modelo.unidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;

public class NaveTransporteTerran extends UnidadTerran {

	private int capacidad;
	private Collection<UnidadTerran> pasajeros;

	public NaveTransporteTerran() {
		this.vida = new VidaSimple(150);
		this.miDanio = new Danio(0, 0);
		this.rangoDeAtaque = new RangoDeAtaque(0, 0);
		this.tiempoDeConstruccion = 7;
		this.suministro = 2;
		this.costo = new Costo(100, 100);
		this.capacidad = 8;
		this.pasajeros = new ArrayList<UnidadTerran>();
		this.transporte = 9;

	}

	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioAire());
		this.notificarObservador();
	}

	public void subirPasajero(UnidadTerran pasajero) {
		if (pasajero.transporte > this.capacidad) {
			throw new CapacidadInsuficiente();
		} else {
			pasajeros.add(pasajero);
			capacidad -= pasajero.transporte;
			
			Mapa mapa = jugador.getMapa();
			Parcela parcela = mapa.getParcela(pasajero.getCoordenada());
			parcela.desocupar();
			jugador.getMapa().notificarObservador();
			this.notificarObservador();
		}
	}

	public void bajarPasajeros() throws NoHayPasajerosEnLaNave, ParcelaOcupada {
		if (this.cantidadDePasajeros() == 0) {
			throw new NoHayPasajerosEnLaNave();
		}
		Iterator<UnidadTerran> iterador = this.pasajeros.iterator();
		while (iterador.hasNext()) {
			UnidadTerran unidad = iterador.next();
			Mapa mapa = jugador.getMapa();
			Parcela parcela = mapa.getParcela(this.posicion);
			if (unidad.sePuedeMoverA(parcela.getSuperficie())) {
				iterador.remove();
				mapa.ubicarCercaDe(unidad, this.posicion);
				this.capacidad = 8;
			}

		}
		this.notificarObservador();
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

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoAire();
	}
}
