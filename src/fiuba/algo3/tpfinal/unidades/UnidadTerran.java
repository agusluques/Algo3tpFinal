package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Terran;
import fiuba.algo3.tpfinal.programa.Tierra;

public abstract class UnidadTerran extends Terran implements Fabricable,
		Atacante, Trasladable {

	protected Danio miDanio;
	protected int tiempoDeConstruccion;
	protected int suministro;
	protected RangoDeAtaque rangoDeAtaque;
	protected Costo costo;
	protected int transporte;

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
	public void atacar(Atacable enemigo) {
		if (this.estaEnRangoDeAtaque(enemigo)) {
			enemigo.atacado(miDanio);
		}
		enemigo.atacado(new Danio(0, 0));
	}

	protected boolean estaEnRangoDeAtaque(Atacable enemigo) {
		Coordenada coordenadaEnemigo = enemigo.getCoordenada();
		Coordenada coordenadaAtacante = this.getCoordenada();
		double distancia = coordenadaEnemigo.distancia(coordenadaAtacante);

		boolean estaEnRango = (this.rangoDeAtaque(enemigo) >= distancia);
		return estaEnRango;
	}

	private int rangoDeAtaque(Atacable enemigo) {
		return enemigo.rangoDeAtaqueCorrespondiente(this.rangoDeAtaque);
	}

	@Override
	public Costo getCosto() {
		return this.costo;
	}

	@Override
	public void trasladarA(Coordenada coord, Mapa mapa) {
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

}
