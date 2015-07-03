package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;

public interface Constructible {

	int getTiempoRestante();

	boolean equals(Object o);

	void avanzarConstruccion();

	int aumentoDePoblacion();

	boolean puedeConstruirseEn(Parcela ubicacion) throws ParcelaOcupada, TerrenoInapropiado, ConstruccionRequeridaInexistente;

	Costo getCosto();

	Coordenada getPosicion();
}
