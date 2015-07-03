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
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;

public class NaveTransporteProtoss extends UnidadProtoss {

	private Collection<UnidadProtoss> pasajeros;
	private int capacidad;

	public NaveTransporteProtoss() {
		this.vida = new VidaConEscudo(80, 60);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(200);
		this.miDanio = new Danio(0, 0);
		this.pasajeros = new ArrayList<UnidadProtoss>();
		this.transporte = 9; // Decidi que sea 9 para que una nave no pueda
								// estar en otra
		this.capacidad = 8;
		this.rangoDeAtaque = new RangoDeAtaque(0, 0);

	}

	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioAire());
		this.notificarObservador();
	}

	public void subirPasajero(UnidadProtoss pasajero) {
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
		Iterator<UnidadProtoss> iterador = this.pasajeros.iterator();
		while (iterador.hasNext()) {
			UnidadProtoss unidad = iterador.next();
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

	private int cantidadDePasajeros() {
		return pasajeros.size();
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoAire();
	}

}
