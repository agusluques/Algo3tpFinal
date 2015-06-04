package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Terran;
import fiuba.algo3.tpfinal.programa.Danio;

public class UnidadesTerran extends Terran{
	
	protected Danio miDanio;

	public void atacar(Atacable enemigo) {
		
		enemigo.atacado(miDanio);
		
	}
}
