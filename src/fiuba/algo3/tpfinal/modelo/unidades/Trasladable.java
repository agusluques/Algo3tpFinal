package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.Jugador;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;

public interface Trasladable {

	void trasladarA(Coordenada coord, Mapa mapa) throws ParcelaOcupada;

	boolean sePuedeMoverA(Superficie superficie);

	boolean sePuedeMoverA(Tierra superficie);

	boolean sePuedeMoverA(Aire superficie);

	boolean sePuedeMoverA(DepositoDeMinerales superficie);

	boolean sePuedeMoverA(DepositoDeGas superficie);

	Jugador getJugador();

}
