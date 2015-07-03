package fiuba.algo3.tpfinal.modelo.unidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Protoss;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;

public abstract class UnidadProtoss extends Protoss implements Fabricable,
		Atacante, Trasladable {

	protected Danio miDanio;
	protected int suministro;
	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected int transporte; // El espacio que ocupa en la nave
	protected RangoDeAtaque rangoDeAtaque;
	
	public int getTiempoRestante() {
		return this.tiempoDeConstruccion;
	}

	public void avanzarFabricacion() {
		if (this.tiempoDeConstruccion > 0) {
			this.tiempoDeConstruccion -= 1;
		}
	}

	// Es la cantidad que aumenta la poblacion cuando se construye uno
	public int getSuministro() {
		return this.suministro;
	}

	@Override
	public Costo getCosto() {
		return this.costo;
	}
	
	@Override
	public void atacar(Atacable enemigo) {
		if (!this.estaEnRangoDeAtaque(enemigo)) {
			enemigo.atacado(new Danio(0, 0));
		}else {
			enemigo.atacado(miDanio);
			ataques = 1;
		}
	}

	protected boolean estaEnRangoDeAtaque(Atacable enemigo) {
		Coordenada coordenadaEnemigo = enemigo.getCoordenada();
		Coordenada coordenadaAtacante = this.getCoordenada();
		double distancia = coordenadaEnemigo.distancia(coordenadaAtacante);

		boolean estaEnRango = (this.obtenerRangoDeAtaqueDelEnemigo(enemigo) >= distancia);
		return estaEnRango;
	}

	private int obtenerRangoDeAtaqueDelEnemigo(Atacable enemigo) {
		return enemigo.rangoDeAtaqueCorrespondiente(this.rangoDeAtaque);
	}

	public void mover(int fila, int columna) {
		this.posicion.mover(fila, columna);
	}

	@Override
	public int getCantidadDeAtaques(){
		return ataques;
	}
	
	@Override
	public void trasladarA(Coordenada coord, Mapa mapa) throws ParcelaOcupada {
		Parcela parcelaNueva = mapa.getParcela(coord);
		if (parcelaNueva.estaVacia()
				&& this.sePuedeMoverA(parcelaNueva.getSuperficie())
				&& this.hayCaminoHasta(coord, mapa)) {
			mapa.moverUnidad(posicion, coord);
			this.posicion = coord;
		} else {
			throw new MovimientoInvalido();
		}
	}

	@Override
	public boolean sePuedeMoverA(Superficie superficie) {
		return superficie.puedeRecibir(this);
	}

	@Override
	public boolean sePuedeMoverA(Tierra superficie) {
		return true;
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return false;
	}

	@Override
	public boolean sePuedeMoverA(DepositoDeMinerales superficie) {
		return false;
	}

	@Override
	public boolean sePuedeMoverA(DepositoDeGas superficie) {
		return false;
	}

	public RangoDeAtaque getRangoCompleto() {
		return this.rangoDeAtaque;
	}
	
	protected boolean hayCaminoHasta(Coordenada posicionFinal, Mapa mapa) {
		//Utilizo el algoritmo A*
		Collection<Coordenada> posicionesEvaluadas = new ArrayList<Coordenada>();
		Collection<Coordenada> posicionesAEvaluar = new ArrayList<Coordenada>();
		posicionesAEvaluar.add(this.posicion);
		
		HashMap<Coordenada, Double> distanciaDesdeInicio = new HashMap<Coordenada, Double>();
		distanciaDesdeInicio.put(this.posicion, (double) 0);
		
		HashMap<Coordenada, Double> distanciaDesdeInicioPasandoPor = new HashMap<Coordenada, Double>();
		distanciaDesdeInicioPasandoPor.put(posicion, distanciaDesdeInicio.get(this.posicion) + this.posicion.distancia(posicionFinal));
		
		while(!posicionesAEvaluar.isEmpty()) {
			Coordenada coordenadaActual = encontrarCoordenadaConDistanciaMinima(posicionesAEvaluar,
					distanciaDesdeInicioPasandoPor);
			if(coordenadaActual.equals(posicionFinal)) {
				return true;
			}
			posicionesAEvaluar.remove(coordenadaActual);
			posicionesEvaluadas.add(coordenadaActual);
			for(Coordenada vecino : encontrarVecinos(coordenadaActual, mapa)) {
				if(posicionesEvaluadas.contains(vecino)) {
					continue;
				}
				double distanciaDesdeInicioAproximada = distanciaDesdeInicio.get(coordenadaActual) + coordenadaActual.distancia(vecino);
				if(!posicionesAEvaluar.contains(vecino) || distanciaDesdeInicioAproximada < distanciaDesdeInicio.get(vecino)) {
					distanciaDesdeInicio.put(vecino, distanciaDesdeInicioAproximada);
					distanciaDesdeInicioPasandoPor.put(vecino, distanciaDesdeInicio.get(vecino) + vecino.distancia(posicionFinal));
					if(!posicionesAEvaluar.contains(vecino)) {
						posicionesAEvaluar.add(vecino);
					}
				}
			}
		}
		
		throw new MovimientoInvalido();
	}

	protected Collection<Coordenada> encontrarVecinos(Coordenada coordenadaActual, Mapa mapa) {
		//Devuelve una coleccion con las coordenadas vecinas a las cual la unidad puede acceder
		int fila = coordenadaActual.getFila();
		int columna = coordenadaActual.getColumna();
		Collection<Coordenada> vecinos = new ArrayList<Coordenada>();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int filaVecina = fila -1 + i;
				int columnaVecina = columna - 1 + j;
				if(filaVecina <= 0 || columnaVecina <= 0 || filaVecina>mapa.getAlto() || columnaVecina > mapa.getAncho()) {
					continue;
				}
				Coordenada vecino = new Coordenada(filaVecina, columnaVecina);
				Parcela parcelaVecina = mapa.getParcela(vecino);
				if(parcelaVecina.estaVacia() && this.sePuedeMoverA(parcelaVecina.getSuperficie())) {
					vecinos.add(vecino);
				}
			}
		}
		return vecinos;
	}

	protected Coordenada encontrarCoordenadaConDistanciaMinima(
			Collection<Coordenada> posicionesAEvaluar,
			HashMap<Coordenada, Double> distanciaDesdeInicioPasandoPor) {
		Iterator<Coordenada> iterador = posicionesAEvaluar.iterator();
		Coordenada coordenadaActual = iterador.next();
		double minimaDistancia = distanciaDesdeInicioPasandoPor.get(coordenadaActual);
		while(iterador.hasNext()) {
			Coordenada siguienteCoordenada = iterador.next();
			if(distanciaDesdeInicioPasandoPor.get(siguienteCoordenada) < minimaDistancia) {
				minimaDistancia = distanciaDesdeInicioPasandoPor.get(siguienteCoordenada);
				coordenadaActual = siguienteCoordenada;
			}
		}
		return coordenadaActual;
	}
}
