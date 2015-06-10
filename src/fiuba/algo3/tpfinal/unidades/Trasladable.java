package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public interface Trasladable {

	void trasladarA(Coordenada coord, Mapa mapa);

	boolean sePuedeMoverA(Superficie superficie);

	boolean sePuedeMoverA(Tierra superficie);

	boolean sePuedeMoverA(Aire superficie);

	boolean sePuedeMoverA(DepositoDeMinerales superficie);

	boolean sePuedeMoverA(DepositoDeGas superficie);

}
