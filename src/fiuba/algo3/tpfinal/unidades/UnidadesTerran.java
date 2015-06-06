package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Terran;
import fiuba.algo3.tpfinal.programa.Danio;

public class UnidadesTerran extends Terran{
	
	protected Danio miDanio;
	protected Rango rango;
	
	public void atacar(Atacable enemigo) {
		if (this.estaEnRangoDeAtaque(enemigo)){
			enemigo.atacado(miDanio);
		}
		enemigo.atacado(new Danio(0,0));
		
	}

	private boolean estaEnRangoDeAtaque(Atacable enemigo) {
		int distanciaFila = enemigo.getCoordenada().getFila() - this.getCoordenada().getFila();
		int distanciaColumna = enemigo.getCoordenada().getColumna() - this.getCoordenada().getColumna();
		double distanciaTotal =Math.sqrt(Math.pow(distanciaFila, 2) + Math.pow(distanciaColumna, 2));
		
		boolean estaEnRango = (this.rangoDeAtaque() >= distanciaTotal);
		return estaEnRango;
	}

	private int rangoDeAtaque() {
		//HAY QUE ARREGLAR ESTO PORQUE ALGUNOS ATACAN A AIRE
		return this.rango.getRangoTierra();
	}
	
	public void mover(int fila, int columna){
		this.posicion.mover(fila, columna);
	}
}
