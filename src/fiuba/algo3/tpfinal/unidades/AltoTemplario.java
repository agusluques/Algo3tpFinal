package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class AltoTemplario extends UnidadProtoss {

	protected Energia miEnergia = new Energia(50);

	public AltoTemplario() {
		this.vida.inicializarVida(40);
		this.escudo.inicializarEscudo(40);
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
			throws EnergiaInsuficiente {
		if (unidad.getJugador().equals(this.jugador)) {
			try {
				this.miEnergia.gastarEnergia(100);
				//TODO sacar casteo...
				this.jugador.agregarUnidad((UnidadProtoss)new Alucinacion(unidad),
						unidad.getCoordenada());
				//TODO porqué está 2 veces !??
				this.jugador.agregarUnidad(new Alucinacion(unidad),
						unidad.getCoordenada());
			} catch (EnergiaInsuficiente e) {
				//TODO mejorar nombres !!! "e" ?
				throw e;
			}
		}
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.miEnergia.aumentarEnergia(15);
		super.pasarTurno(jugador, mapa);
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	public void lanzarTormentaPsionica(Coordenada posicion)
			throws EnergiaInsuficiente {
		// esto que estoy haciendo aca es un asco, pero queria usar el metodo
		// que ya teniamos
		//TODO SACAR ESTO ! ¿Para qué instancias OTRO !? 
		AltoTemplario nuevoTemplario = new AltoTemplario();
		nuevoTemplario.setCoordenada(posicion);
		if (this.estaEnRangoDeAtaque(nuevoTemplario)) {
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
		escudo.destruirEscudo();
		this.miEnergia = new Energia(0);
	}

}
