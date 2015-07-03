package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Costo;

public interface Fabricable {

	void avanzarFabricacion();

	int getTiempoRestante();

	int getSuministro();

	Costo getCosto();
}
