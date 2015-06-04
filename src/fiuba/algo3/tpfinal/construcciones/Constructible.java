package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;


public interface Constructible {
	int getCostoMineral();
	int getCostoGas();
	int getTiempo();
	boolean equals(Object o);
	Collection<Constructible> construccionesNecesarias();
}

