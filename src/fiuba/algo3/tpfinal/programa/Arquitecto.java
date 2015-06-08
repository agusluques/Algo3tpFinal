package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.unidades.Fabricable;

public class Arquitecto {
	
	private Mapa mapa;
	private Presupuesto presupuesto;
	private Collection<Constructible> construcciones;
	private Jugador jugador;
	public Collection<Constructible> construccionesEnConstruccion;
	
	public Arquitecto(Presupuesto presupuesto,Collection<Constructible> construcciones, Mapa mapa, Jugador jugador ){
		this.mapa = mapa;
		this.presupuesto = presupuesto;
		this.construcciones = construcciones; 
		this.jugador = jugador;
		this.construccionesEnConstruccion = new ArrayList<Constructible>();
	}
	
	public void construir(Constructible construccion, Coordenada posicion) throws ConstruccionRequeridaInexistente {
		construccion.setJugador(this.jugador);
		try {
			this.verificarTerreno(construccion, posicion);
			this.verificarConstruccionesNecesarias(construccion);
			this.cobrarConstruccion(construccion);
			this.construccionesEnConstruccion.add(construccion);
			this.mapa.getParcela(posicion).ocupar((Atacable)construccion);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		} catch (ConstruccionRequeridaInexistente e) {
			throw e;
		} catch (TerrenoInapropiado e){
			throw e;
		} catch (ParcelaOcupada e){
			throw e;
		}
		
	}

	private void verificarConstruccionesNecesarias(Constructible construccion) throws ConstruccionRequeridaInexistente {
		Collection<Constructible> unidadesNecesarias = construccion.construccionesNecesarias();
		Iterator<Constructible> iterador = unidadesNecesarias.iterator();
		while (iterador.hasNext()) {
			if (!this.construcciones.contains(iterador.next())) {
				throw new ConstruccionRequeridaInexistente();
			}
		}
		
	}
	
	private void verificarTerreno(Constructible construccion, Coordenada posicion){
		if(this.mapa.getParcela(posicion).estaVacia()){
			Superficie supRequerida = construccion.superficieNecesaria();
			Superficie supEnLaQueQuieroConstruir = this.mapa.getParcela(posicion).getSuperficie();
			if(!supRequerida.equals(supEnLaQueQuieroConstruir)){
				throw new TerrenoInapropiado();
			}
		}else{
			throw new ParcelaOcupada();
		}
	}

	private void cobrarConstruccion(Constructible construccion) {
		try {
			int costoConstruccionMineral = construccion.getCostoMineral();
			int costoConstruccionGas = construccion.getCostoGas();
			this.presupuesto.removerMineral(costoConstruccionMineral);
			this.presupuesto.removerGas(costoConstruccionGas);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}
	
	public void pasarTurno() {
		Iterator<Constructible> iterador = construccionesEnConstruccion.iterator();
		while(iterador.hasNext()) {
			Constructible construccionEnConstruccion = iterador.next();
			construccionEnConstruccion.avanzarConstruccion();
			if (construccionEnConstruccion.getTiempoRestante() == 0) {
				construcciones.add(construccionEnConstruccion);
				iterador.remove();
			}
		}
	}
	

}
