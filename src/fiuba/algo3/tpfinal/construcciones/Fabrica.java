package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Golliat;
import fiuba.algo3.tpfinal.unidades.Rango;

public class Fabrica extends ConstruccionesTerran {


	private Fabricable unidadEnConstruccion;
	
	public Fabrica() {
		this.vida.inicializarVida(1250);
		this.tiempoDeConstruccion = 12;
		this.costo = new Costo (200, 100);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Barraca());
	}
	
	public void fabricarGolliat(){
		try{
			jugador.getPresupuesto().removerMineral(100);
			jugador.getPresupuesto().removerGas(50);
			unidadEnConstruccion = new Golliat();
		}catch (MineralInsuficiente e){
			throw e;
		}catch (GasInsuficiente e){
			throw e;
		}
	}
	
	public void haceLoTuyo(){
		if (unidadEnConstruccion != null){
			unidadEnConstruccion.avanzarFabricacion();
			if(this.unidadEnConstruccion.getTiempoRestante() == 0){
				try{
					this.jugador.agregarUnidad(unidadEnConstruccion,this.posicion);
					this.unidadEnConstruccion = null;
				}catch (LimitePoblacionalAlcanzado e){
					throw e;
				}
			}
		}
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}

}
