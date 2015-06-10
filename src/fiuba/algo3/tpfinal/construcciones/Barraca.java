package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Rango;

public class Barraca extends ConstruccionTerran {


	private Fabricable unidadEnConstruccion;
		
	public Barraca(){
		this.vida.inicializarVida(1000);
		this.costo = new Costo(150);
		this.tiempoDeConstruccion = 12;
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

	
	public void fabricarMarine(){
		try{
			jugador.getPresupuesto().removerMineral(50);
			unidadEnConstruccion = new Marine();
		}catch (MineralInsuficiente e){
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
