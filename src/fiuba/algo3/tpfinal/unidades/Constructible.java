package fiuba.algo3.tpfinal.unidades;

import java.util.Collection;


public interface Constructible {
	public int getCostoMineral();
	public int getCostoGas();
	public int getTiempo();
	public boolean equals(Object o);
	public Collection<Constructible> construccionesNecesarias();
}

