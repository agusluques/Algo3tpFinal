package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;

public interface Atacante {

	void atacar(Atacable enemigo);

	int getCantidadDeAtaques();

}
