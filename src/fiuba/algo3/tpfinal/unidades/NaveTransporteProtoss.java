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

public class NaveTransporteProtoss extends UnidadProtoss {

	private Collection<UnidadProtoss> pasajeros;
	private int capacidad;

	public NaveTransporteProtoss() {
		this.vida.inicializarVida(80);
		this.escudo.inicializarEscudo(60);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(200);
		this.miDanio = new Danio(0, 0);
		this.pasajeros = new ArrayList<UnidadProtoss>();
		this.transporte = 9; // Decidi que sea 9 para que una nave no pueda
								// estar en otra
		this.capacidad = 8;
		this.rangoDeAtaque = new RangoDeAtaque(0, 0);

		// se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0, 0);
	}

	public void atacado(Danio danio) {
		this.escudo.bajarEscudo(danio.getDanioAire(), this.vida);
	}

	public void subirPasajero(UnidadProtoss pasajero) {
		if (pasajero.transporte > this.capacidad) {
			throw new CapacidadInsuficiente();
		} else {
			pasajeros.add(pasajero);
			capacidad -= pasajero.transporte;
		}
	}

	public void bajarPasajeros() throws NoHayPasajerosEnLaNave {
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
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public int cantidadDePasajeros() {
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
