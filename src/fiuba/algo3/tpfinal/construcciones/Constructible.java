package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Parcela;

public interface Constructible {

	int getTiempoRestante();

	boolean equals(Object o);

	void avanzarConstruccion();

	int aumentoDePoblacion();

	boolean podesConstruirte(Parcela ubicacion, Collection<Constructible> construcciones );

	Costo getCosto();
}
