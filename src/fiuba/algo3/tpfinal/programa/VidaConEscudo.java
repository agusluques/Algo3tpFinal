package fiuba.algo3.tpfinal.programa;

public class VidaConEscudo extends Vida {

	private int escudo;
	private int escudoLimite;

	public VidaConEscudo(int vidaInicial, int escudoInicial) {
		this.vida = vidaInicial;
		this.escudo = escudoInicial;
		this.escudoLimite = escudoInicial;
	}

	@Override
	public void recibirDanio(int danio) {
		this.escudo -= danio;
		if (this.escudo < 0) {
			this.vida -= (Math.abs(this.escudo));
			this.escudo = 0;
			if (this.vida < 0) {
				this.vida = 0;
			}
		}

	}

	@Override
	public boolean estaMuerto() {
		return (vida == 0 && escudo == 0);
	}

	public int getCantidadDeEscudo() {
		return this.escudo;
	}




	public void pasarTurno() {
		this.escudo += 8;
		if (this.escudo >= escudoLimite) {
			this.escudo = escudoLimite;
		}
	}

	public void destruirEscudo() {
		this.escudo = 0;

	}

}
