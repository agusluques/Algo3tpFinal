package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;

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

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.presupuesto = new Presupuesto(200,0);
		this.construcciones = new ArrayList<Constructible>();
		this.arquitecto = new Arquitecto();
	}

	public String getNombre() {
		return nombre;
	}

	public void recolectar(Recolector recolector) {
		recolector.recolectarPara(this);
	}
	
	public void recolectar(RecolectorDeGas recolector) {
		int gasRecolectado = recolector.recolectarGas();
		this.presupuesto.agregarGas(gasRecolectado);
	}
	
	public void recolectar(RecolectorDeMinerales recolector) {
		int mineralRecolectado = recolector.recolectarMinerales();
		this.presupuesto.agregarMineral(mineralRecolectado);
	}

	public void construir(Constructible construccion) throws ConstruccionRequeridaInexistente {
		this.arquitecto.construir(construcciones, construccion, presupuesto);
		
	}
	
	public Presupuesto getPresupuesto(){
		return this.presupuesto;
	}
	
	public Collection<Constructible> getConstrucciones(){
		return construcciones;
	}



}
