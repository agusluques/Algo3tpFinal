package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.VidaConEscudo;

public class AltoTemplario extends UnidadProtoss {

	protected Energia miEnergia = new Energia(50);

	public AltoTemplario() {
		this.vida = new VidaConEscudo(40, 40);
		this.miDanio = new Danio(0, 0);
		this.tiempoDeConstruccion = 7;
		this.suministro = 2;
		this.costo = new Costo(50, 150);
		this.transporte = 2;
		this.rangoDeAtaque = new RangoDeAtaque(7, 7);

	}

	// Solamente para probar que al recibir un EMP la unidad pierde la energia
	public int getEnergia() {
		return miEnergia.getEnergia();
	}

	public void crearAlucinaciones(UnidadProtoss unidad)
			throws EnergiaInsuficiente, LimitePoblacionalAlcanzado, ParcelaOcupada {
		if (unidad.getJugador().equals(this.jugador)) {
			try {
				this.miEnergia.gastarEnergia(100);
				this.jugador.agregarUnidad(new Alucinacion(unidad),
						unidad.getCoordenada());
			} catch (EnergiaInsuficiente e) {
				// TODO mejorar nombres !!! "e" ?
				throw e;
			}
		}
	}

	public void pasarTurno() throws ParcelaOcupada {
		this.miEnergia.aumentarEnergia(15);
		super.pasarTurno();
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	public void lanzarTormentaPsionica(Coordenada posicion)
			throws EnergiaInsuficiente {
		if (this.posicion.distancia(posicion) <= this.rangoDeAtaque
				.getRangoAire()) {
			try {
				this.miEnergia.gastarEnergia(75);
				TormentaPsionica tormenta = new TormentaPsionica(this.jugador,
						this.jugador.getMapa(), posicion);
				this.jugador.agregarMagia(tormenta);
			} catch (EnergiaInsuficiente e) {
				throw e;
			}
		}

	}

	@Override
	public void recibirImpactoEMP() {
		vida.destruirEscudo();
		this.miEnergia = new Energia(0);
	}

}
