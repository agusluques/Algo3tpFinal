package fiuba.algo3.tpfinal.programa;

public class VidaSimple implements Vidaa {
	
	private int vida;

	public VidaSimple(int vidaInicial) {
		this.vida = vidaInicial;
	}

	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

	@Override
	public boolean estaMuerto() {
		return this.vida == 0;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	

}
