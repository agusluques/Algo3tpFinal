package fiuba.algo3.tpfinal.programa;

public class Vida {

	private int vida = 0;

	public int getVida() {
		return vida;
	}

	public void bajarVida(int danio) {
		this.vida -= danio;
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

	public void inicializarVida(int vidaInicial) {
		this.vida = vidaInicial;
	}
}
