package fiuba.algo3.tpfinal.modelo.unidades;

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
				&& this.sePuedeMoverA(parcelaNueva.getSuperficie())) {
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
}
