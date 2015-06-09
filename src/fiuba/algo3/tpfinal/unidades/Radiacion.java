package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;

public class Radiacion extends Magia {

	protected Atacable afectado;
	protected Mapa mapa;
	protected Jugador jugador;
	
	public Radiacion(Atacable afectado){
		this.afectado = afectado;
		this.jugador = afectado.getJugador();
		this.mapa = afectado.getJugador().getMapa();
		
	}
	
	public boolean estaMuerto(){
		return this.afectado.estaMuerto();
	}
	
	public void pasarTurno(){
		if(!estaMuerto()){
			int fila = afectado.getCoordenada().getFila();
			int columna = afectado.getCoordenada().getColumna();
			Parcela parcela;
			for(int y=fila-1;y<=fila+1;y++){
				for(int x=columna-1;x<=columna+1;x++){
					parcela = mapa.getParcela(new Coordenada(y,x));
					if (parcela!=null && !parcela.estaVacia() && afectado.getJugador().equals(parcela.getOcupante().getJugador())){
						parcela.getOcupante().atacado(new Danio(30,30));
					}
				}
			}
		}
	}
}

