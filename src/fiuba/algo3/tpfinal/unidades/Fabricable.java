package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public interface Fabricable {

	void avanzarFabricacion();

	int getTiempoRestante();

	int getSuministro();

	Costo getCosto();
}
