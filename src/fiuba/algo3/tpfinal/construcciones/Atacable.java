package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public interface Atacable {
	
	void atacado(Danio danio);

	Coordenada getCoordenada();

}
