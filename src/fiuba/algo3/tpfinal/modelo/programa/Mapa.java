package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.Observable;

public class Mapa extends Observable{

	private HashMap<Coordenada, Parcela> mapa;
	private CreadorMapa creador = new CreadorMapa();

	public Mapa(String dirDelMapa) throws Exception {
		mapa = creador.construirMapa(dirDelMapa);
	}

	public Boolean mapaEstaVacio() {

		for (Parcela parcela : mapa.values()) {
			if (!parcela.estaVacia()) {
				return false;
			}
		}
		return true;
	}

	public void insertarUnidad(Coordenada coord, Atacable unidad) throws ParcelaOcupada {
			(mapa.get(coord)).ocupar(unidad);
			unidad.setCoordenada(coord);
		
			this.notificarObservador();
	}

	public Parcela getParcela(Coordenada coord) {
		return mapa.get(coord);
		
	}

	public int getAncho() {
		Set<Coordenada> coordenadas = mapa.keySet();
		Iterator<Coordenada> iterador = coordenadas.iterator();
		int anchoMax = 0;
		while (iterador.hasNext()) {
			Coordenada coordenadaActual = iterador.next();
			if (anchoMax < coordenadaActual.getColumna()) {
				anchoMax = coordenadaActual.getColumna();
			}
		}
		return anchoMax;
	}

	public int getAlto() {
		Set<Coordenada> coordenadas = mapa.keySet();
		Iterator<Coordenada> iterador = coordenadas.iterator();
		int altoMax = 0;
		while (iterador.hasNext()) {
			Coordenada coordenadaActual = iterador.next();
			if (altoMax < coordenadaActual.getFila()) {
				altoMax = coordenadaActual.getFila();
			}
		}
		return altoMax;
	}

	public void moverUnidad(Coordenada coord1, Coordenada coord2) throws ParcelaOcupada {
		Parcela parcela1 = this.getParcela(coord1);
		Parcela parcela2 = this.getParcela(coord2);

		parcela2.ocupar(parcela1.desocupar());
		this.notificarObservador();
	}

	public void ubicarCercaDe(Atacable unidad, Coordenada posicion) throws ParcelaOcupada {
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
		int mod = 0;
		Parcela parcela;
		boolean ubicada = false;
		while (!ubicada) {
			for (int y = fila - mod; y <= fila + mod; y++) {
				for (int x = columna - mod; x <= columna + mod; x++) {
					parcela = this.mapa.get(new Coordenada(y, x));
					if (parcela != null) {
						if (parcela.estaVacia()
								&& !ubicada
								&& parcela.getSuperficie().puedeRecibir(
										(Trasladable) unidad)) {
							parcela.ocupar(unidad);
							unidad.setCoordenada(new Coordenada(y, x));
							ubicada = true;
							this.notificarObservador();
						}

					}
				}
			}

			if (!ubicada) {
				mod++;

			}
		}
		
	}

	public ArrayList<Atacable> unidadesEnUnRadio(Coordenada centro, int radio) {
		int fila = centro.getFila();
		int columna = centro.getColumna();
		Parcela parcela;
		ArrayList<Atacable> unidadesEncontradas = new ArrayList<Atacable>();
		for (int y = fila - radio; y <= fila + radio; y++) {
			for (int x = columna - radio; x <= columna + radio; x++) {
				parcela = this.mapa.get(new Coordenada(y, x));
				if (parcela != null && !parcela.estaVacia()) {
					unidadesEncontradas.add(parcela.getOcupante());
				}
			}
		}
		return unidadesEncontradas;
	}

	public Coordenada encontrarPrimeraBase() {
		Coordenada primeraBase = new Coordenada(0, 0);
		for (int i = 1; i <= this.getAlto(); i++) {
			for (int j = 1; j <= this.getAncho(); j++) {
				primeraBase = new Coordenada(i, j);
				Parcela parcelaActual = this.getParcela(primeraBase);
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					return primeraBase;
				}
			}
		}
		return primeraBase;
	}

	public Coordenada encontrarUltimaBase() {
		Coordenada ultimaBase = new Coordenada(0, 0);
		for (int i = this.getAlto(); i >= 1; i--) {
			for (int j = this.getAncho(); j >= 1; j--) {
				ultimaBase = new Coordenada(i, j);
				Parcela parcelaActual = this.getParcela(ultimaBase);
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					return ultimaBase;
				}
			}
		}
		return ultimaBase;

	}
	
	public void pasarTurno(){
		for (Parcela parcelaActual : mapa.values()){
			if(!parcelaActual.estaVacia()){
				if(parcelaActual.getOcupante().estaMuerto()){
					parcelaActual.desocupar();
				}
			}
		}
		this.notificarObservador();
	}
}
