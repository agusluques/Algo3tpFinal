package fiuba.algo3.tpfinal.modelo.programa;

public class Coordenada {

	private int fila;
	private int columna;

	public Coordenada(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}

	@Override
	public boolean equals(Object o) {
		Coordenada coord = (Coordenada) o;
		return ((coord.getColumna() == this.columna) && (coord.getFila() == this.fila));
	}

	@Override
	public int hashCode() {
		return ((this.fila * 30000) + this.columna);

	}

	public void mover(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public double distancia(Coordenada coordenadaAtacante) {
		int distanciaFila = this.fila - coordenadaAtacante.getFila();
		int distanciaColumna = this.columna - coordenadaAtacante.getColumna();
		return Math.sqrt(Math.pow(distanciaFila, 2)
				+ Math.pow(distanciaColumna, 2));

	}
}
