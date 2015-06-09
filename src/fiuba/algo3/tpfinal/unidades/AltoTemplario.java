package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.programa.Coordenada;
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
		this.rango = new Rango(0,0);
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
		
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
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}
}
