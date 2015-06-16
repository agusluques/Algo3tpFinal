package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Espectro;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.unidades.UnidadTerran;

public class PuertoEstelarTerran extends ConstruccionTerran {

	private Fabricable unidadEnConstruccion;
	private ArrayList<Constructible> construccionesNecesarias;
	public PuertoEstelarTerran() {
		this.vida.inicializarVida(1300);
		this.tiempoDeConstruccion = 10;
		this.costo = new Costo(150, 100);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Fabrica());
		this.construccionesNecesarias.add(new Barraca());
	}

	public void fabricarEspectro() {
		this.fabricar(new Espectro());
	}

	public void fabricarNaveDeTransporte() {
		this.fabricar(new NaveTransporteTerran());
	}

	public void fabricarNaveDeCiencia() {
		this.fabricar(new NaveCiencia());
	}

	private void fabricar(Fabricable unidad) {
		try {
			jugador.getPresupuesto().gastar(unidad.getCosto());
			unidadEnConstruccion = unidad;
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		if (unidadEnConstruccion != null) {
			unidadEnConstruccion.avanzarFabricacion();
			if (this.unidadEnConstruccion.getTiempoRestante() == 0) {
				try {
					this.jugador.agregarUnidad((UnidadTerran)unidadEnConstruccion,
							this.posicion);
					this.unidadEnConstruccion = null;
				} catch (LimitePoblacionalAlcanzado e) {
					throw e;
				}
			}
		}
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	protected boolean construccionesRequeridasEncontradas(Collection<Constructible> construcciones){
		boolean aux = true;
		for (Constructible construccionRequerida : this.construccionesNecesarias){
			if(!construcciones.contains(construccionRequerida)){
				aux = false;
			}
		}
		return aux;
		
	}

	
	@Override
	public boolean podesConstruirte(Parcela ubicacion, Collection<Constructible> construcciones ){
		return (this.esValidaLaUbicacion(ubicacion) && this.construccionesRequeridasEncontradas(construcciones));
	}
}
