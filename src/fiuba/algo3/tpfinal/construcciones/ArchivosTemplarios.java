package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Rango;


public class ArchivosTemplarios extends ConstruccionProtoss {
	
	private Fabricable unidadEnConstruccion;
	
	public ArchivosTemplarios() {
		this.vida .inicializarVida(500);
		this.escudo.inicializarEscudo(500);
		this.tiempoDeConstruccion = 9;
		this.costo = new Costo(150, 200);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new PuertoEstelarProtoss());
	}

	
	public void fabricarAltoTemplario(){
		try{
			jugador.getPresupuesto().removerMineral(50);
			jugador.getPresupuesto().removerGas(150);
			unidadEnConstruccion = new AltoTemplario();
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
