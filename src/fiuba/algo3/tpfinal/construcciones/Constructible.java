package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Parcela;

public interface Constructible {

	int getTiempoRestante();

	boolean equals(Object o);

	void avanzarConstruccion();

	int aumentoDePoblacion();

	boolean puedeConstruirseEn(Parcela ubicacion) throws ParcelaOcupada, TerrenoInapropiado, ConstruccionRequeridaInexistente;

	Costo getCosto();

	Coordenada getPosicion();
}
