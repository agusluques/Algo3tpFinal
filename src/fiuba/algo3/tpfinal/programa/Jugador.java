package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.Recolector;
import fiuba.algo3.tpfinal.construcciones.RecolectorDeGas;
import fiuba.algo3.tpfinal.construcciones.RecolectorDeMinerales;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;

public class Jugador {

	private String nombre;
	private int cantidadDeGas;
	private int cantidadDeMineral;
	private Collection<Constructible> construcciones;
	private Arquitecto arquitecto;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cantidadDeGas = 0;
		this.cantidadDeMineral = 200;
		this.construcciones = new ArrayList<Constructible>();
		this.arquitecto = new Arquitecto();
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidadDeGas() {
		return this.cantidadDeGas;
	}
	
	public int getCantidadDeMineral() {
		return this.cantidadDeMineral;
	}

	public void agregarMineral(int cantidad) {
		this.cantidadDeMineral += cantidad;
	}
	
	public void agregarGas(int cantidad) {
		this.cantidadDeGas += cantidad;
	}

	public void gastarMineral(int cantidad) {
		if (this.cantidadDeMineral < cantidad) {
			throw new MineralInsuficiente();
		}
		this.cantidadDeMineral -= cantidad;		
	}
	
	public void gastarGas(int cantidad) {
		if (this.cantidadDeGas < cantidad) {
			throw new GasInsuficiente();
		}
		this.cantidadDeGas -= cantidad;		
	}
	
	public void recolectar(Recolector recolector) {
		recolector.recolectarPara(this);
	}
	
	public void recolectar(RecolectorDeGas recolector) {
		int gasRecolectado = recolector.recolectarGas();
		this.cantidadDeGas += gasRecolectado;
	}
	
	public void recolectar(RecolectorDeMinerales recolector) {
		int mineralRecolectado = recolector.recolectarMinerales();
		this.cantidadDeMineral += mineralRecolectado;
	}

	public void construir(Constructible construccion) throws ConstruccionRequeridaInexistente {
		this.arquitecto.construir(this, construccion);
		
	}

	public boolean posee(Constructible construccion) {
		return this.construcciones.contains(construccion);
		
	}

	public void agregarConstruccion(Constructible construccion) {
		this.construcciones.add(construccion);
		
	}

}
