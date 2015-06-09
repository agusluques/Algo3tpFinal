package fiuba.algo3.tpfinal.construcciones;

public class Escudo {
	
	private int escudo = 0;
	private int escudoLimite;

	public int getEscudo() {
		return this.escudo;
	}

	public void bajarEscudo(int danio, Vida vida) {
		this.escudo -= danio;
		if (this.escudo < 0){
			vida.bajarVida(Math.abs(this.escudo));
			this.escudo = 0;
		}
	}

	public void inicializarEscudo(int escudoInicial) {
		this.escudo = escudoInicial;
		this.escudoLimite = escudoInicial;
	}

	public void pasarTurno() {
		/*this.escudo += 10;
		if (this.escudo > escudoLimite) {
			this.escudo = escudoLimite;
		}*/
		this.escudo = escudoLimite;
	}
	
	
}
