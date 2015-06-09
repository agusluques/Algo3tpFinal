package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;

public class TormentaPsionica extends Magia {

	protected Mapa mapa;
	protected Jugador lanzador;
	protected Coordenada posicion;
	protected int duracion = 2;
	
	public TormentaPsionica(Jugador lanzador,Mapa mapa,Coordenada posicion){
		this.mapa = mapa;
		this.posicion = posicion;
		this.lanzador = lanzador;
	}

	public boolean estaMuerto(){
		return (duracion<=0);
	}
	
	public void pasarTurno(){
		if (!estaMuerto()){
			int fila = posicion.getFila();
			int columna = posicion.getColumna();
			Parcela parcela;
			for(int y=fila-1;y<=fila+1;y++){
				for(int x=columna-1;x<=columna+1;x++){
					parcela = mapa.getParcela(new Coordenada(y,x));
					if (parcela!=null && !parcela.estaVacia() && !this.lanzador.equals(parcela.getOcupante().getJugador())){
						parcela.getOcupante().atacado(new Danio(100,100));
					}
				}
			}
			duracion--;
		}
	}
}
