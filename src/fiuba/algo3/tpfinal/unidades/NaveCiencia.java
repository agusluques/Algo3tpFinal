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
		this.rango = new Rango(10,10);
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
					this.jugador.agregarMagia(radiacion);
				}catch (EnergiaInsuficiente e){
					throw e;
				}
				

			}
		}
	}
	
	public int getEnergia(){
		return this.miEnergia.getEnergia();
	}
	public void lanzarEMP(Coordenada posicion) throws EnergiaInsuficiente{
		NaveCiencia nuevaNave = new NaveCiencia();
		nuevaNave.setCoordenada(posicion);
		if (this.estaEnRangoDeAtaque(nuevaNave)){
			try{
				this.miEnergia.gastarEnergia(100);
				for(Atacable unidadActual : this.getJugador().getMapa().unidadesEnUnRadio(posicion, 1)){
					if (!this.jugador.equals(unidadActual.getJugador())){
						((AfectablePorEMP)unidadActual).recibirImpactoEMP();
					}
				}
			}catch (EnergiaInsuficiente e){
				throw e;
			}
			

		}
	}
	
	@Override
	public void recibirImpactoEMP(){
		this.miEnergia = new Energia(0);
	}
}
