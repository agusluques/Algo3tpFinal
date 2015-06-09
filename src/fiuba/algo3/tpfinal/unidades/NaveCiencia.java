package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.excepciones.UnidadInvalida;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class NaveCiencia extends UnidadesTerran {

	protected Energia miEnergia = new Energia(50);
	
	public NaveCiencia(){
		this.vida.inicializarVida(200);
		this.miDanio = new Danio(0,0);
		this.rango = new Rango(9,9);
		this.tiempoDeConstruccion = 10;
		this.suministro = 2;
		this.costo = new Costo(100,225);
		this.transporte = 0;
		
		
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
	}
	
	@Override
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
	
	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoAire();
	}

	public void pasarTurno() {
		this.miEnergia.aumentarEnergia(10);
	}
	
	public void irradiar(Atacable unidad) throws UnidadInvalida, EnergiaInsuficiente{
		if(unidad.getJugador().equals(this.jugador)){
			throw new UnidadInvalida();
		}else{
			if (this.estaEnRangoDeAtaque(unidad)){
				try{
					this.miEnergia.gastarEnergia(75);
					Radiacion radiacion = new Radiacion(unidad);
				}catch (EnergiaInsuficiente e){
					throw e;
				}
				

			}
		}
	}
}
