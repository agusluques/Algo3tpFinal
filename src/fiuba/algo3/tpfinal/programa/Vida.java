package fiuba.algo3.tpfinal.programa;

public abstract class Vida {

	protected int vida;

	public int getCantidadDeVida() {
		return this.vida;
	}

	public boolean estaMuerto() {
		return this.vida == 0;

	}

	public void recibirDanio(int danio) {
		this.vida -= danio;
		if (this.vida < 0) {
			this.vida = 0;
		}
	}
}
