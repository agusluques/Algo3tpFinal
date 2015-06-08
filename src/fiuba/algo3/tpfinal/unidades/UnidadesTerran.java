package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Terran;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;

public class UnidadesTerran extends Terran implements Fabricable, Atacante{
	
	protected Danio miDanio;
	protected int tiempoDeConstruccion;
	protected int suministro;
	protected Rango rango;
	protected Costo costo;
	protected int transporte;
	protected Jugador jugador;
	
	public int getTiempoRestante(){
		return this.tiempoDeConstruccion;
	}
	
	public void avanzarFabricacion(){
		if (this.tiempoDeConstruccion > 0){
			this.tiempoDeConstruccion -= 1;
		}
	}
	
	//Es la cantidad que aumenta la poblacion cuando se construye uno
	public int getSuministro(){
		return this.suministro;
	}
	
	@Override
	public void atacar(Atacable enemigo) {
		if (this.estaEnRangoDeAtaque(enemigo)){
			enemigo.atacado(miDanio);
		}
		enemigo.atacado(new Danio(0,0));
		
	}

	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	private boolean estaEnRangoDeAtaque(Atacable enemigo) {
		Coordenada coordenadaEnemigo = enemigo.getCoordenada();
		Coordenada coordenadaAtacante = this.getCoordenada();
		double distancia = coordenadaEnemigo.distancia(coordenadaAtacante);
		
		boolean estaEnRango = (this.rangoDeAtaque() >= distancia);
		return estaEnRango;
	}

	private int rangoDeAtaque() {
		//HAY QUE ARREGLAR ESTO PORQUE ALGUNOS ATACAN A AIRE
		return this.rango.getRangoTierra();
	}
	
	public void mover(int fila, int columna){
		this.posicion.mover(fila, columna);
	}
	
	@Override
	public int getCostoMineral() {
		int mineralNecesario = this.costo.getMinerales();
		return mineralNecesario;
	}

	@Override
	public int getCostoGas() {
		int gasNecesario = this.costo.getGas();
		return gasNecesario;
	}


}
