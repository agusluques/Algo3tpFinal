package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Protoss;
import fiuba.algo3.tpfinal.programa.Danio;

public abstract class UnidadesProtoss extends Protoss {
	
	protected Danio miDanio;

	public void atacar(Atacable enemigo) {
		
		enemigo.atacado(miDanio);
		
	}
}
