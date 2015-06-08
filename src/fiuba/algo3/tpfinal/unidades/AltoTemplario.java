package fiuba.algo3.tpfinal.unidades;

import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class AltoTemplario extends UnidadesProtoss {
	
	protected Energia miEnergia = new Energia(50);
	
	public AltoTemplario(){
		this.vida.inicializarVida(40);
		this.escudo.inicializarEscudo(40);
		this.miDanio = new Danio(0,0);
		this.tiempoDeConstruccion = 7;
		this.suministro = 2;
		this.costo = new Costo(50,150);
		this.transporte = 2;
		
	}
	
	public void crearAlucinaciones() throws EnergiaInsuficiente{
		try{
			this.miEnergia.gastarEnergia(100);
			this.jugador.agregarUnidad(new Alucinacion(this.escudo.getEscudo()), this.posicion);
			this.jugador.agregarUnidad(new Alucinacion(this.escudo.getEscudo()), this.posicion);
		}catch(EnergiaInsuficiente e){
			throw e;
		}
	}
	
	public void pasarTurno() {
		this.miEnergia.aumentarEnergia(15);
	}
}
