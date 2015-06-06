package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.Recolector;
import fiuba.algo3.tpfinal.construcciones.RecolectorDeGas;
import fiuba.algo3.tpfinal.construcciones.RecolectorDeMinerales;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;

public class Jugador {

	private String nombre;
	private Presupuesto presupuesto;
	private Collection<Constructible> construcciones;
	private Arquitecto arquitecto;
	@SuppressWarnings("unused")
	private ArrayList<Atacable> unidades;
	private Mapa mapa;
	
	public Jugador(String nombre, Mapa mapa) {
		this.nombre = nombre;
		this.presupuesto = new Presupuesto(200,0);
		this.construcciones = new ArrayList<Constructible>();
		this.mapa = mapa;
		this.arquitecto = new Arquitecto(presupuesto, construcciones, mapa);
		this.unidades = new ArrayList<Atacable>();
		this.unidades = new ArrayList<Atacable>();
	}
	
			

	
	public String getNombre() {
		return this.nombre;
	}

	
	/*public void recolectar(RecolectorDeGas recolector) {
		int gasRecolectado = recolector.recolectarGas();
		this.presupuesto.agregarGas(gasRecolectado);
	}*/
	
	/*public void recolectar(RecolectorDeMinerales recolector) {
		int mineralRecolectado = recolector.recolectarMinerales();
		this.presupuesto.agregarMineral(mineralRecolectado);
	}*/

	public void construir(Constructible construccion, Coordenada posicion) throws ConstruccionRequeridaInexistente {
		this.arquitecto.construir(construccion, posicion);
		
	}
	
	public Presupuesto getPresupuesto(){
		return this.presupuesto;
	}
	
	public Collection<Constructible> getConstrucciones(){
		return construcciones;
	}



}
