package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.Scout;

public class PuertoEstelarProtoss extends ConstruccionesProtoss {
	
	private Fabricable unidadEnConstruccion;
	
	public PuertoEstelarProtoss() {
		
		this.vida.inicializarVida(600);
		this.escudo.inicializarEscudo(600);
		this.tiempo = 10;
		this.costo = new Costo(150, 150);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Acceso());
	}

	public void fabricarScout(){
		this.fabricar(new Scout());
	}
	public void fabricarNaveDeTransporte(){
		this.fabricar(new NaveTransporteProtoss());
	}
	
	
	private void fabricar(Fabricable unidad){
		try{
			jugador.getPresupuesto().removerMineral(unidad.getCostoMineral());
			jugador.getPresupuesto().removerGas(unidad.getCostoGas());
			unidadEnConstruccion = unidad;
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
					this.jugador.agregarUnidad(unidadEnConstruccion);
					this.unidadEnConstruccion = null;
				}catch (LimitePoblacionalAlcanzado e){
					throw e;
				}
			}
		}
	}
}
