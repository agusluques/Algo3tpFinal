package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.excepciones.GasInsuficienteException;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficienteException;

public class Jugador {

	private String nombre;
	private int cantidadDeGas;
	private int cantidadDeMineral;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cantidadDeGas = 0;
		this.cantidadDeMineral = 200;
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
			throw new MineralInsuficienteException();
		}
		this.cantidadDeMineral -= cantidad;		
	}
	
	public void gastarGas(int cantidad) {
		if (this.cantidadDeGas < cantidad) {
			throw new GasInsuficienteException();
		}
		this.cantidadDeGas -= cantidad;		
	}

}
