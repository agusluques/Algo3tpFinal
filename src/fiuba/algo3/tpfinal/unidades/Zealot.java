package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Zealot extends Protoss{

	public Zealot(){
		vida = 100;
		escudo = 60;
	}

	public void atacar(Atacable enemigo) {
		
		Danio miDanio = new Danio(8);
		enemigo.atacado(miDanio);
		
	}
}
