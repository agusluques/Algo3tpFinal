package fiuba.algo3.tpfinal.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.vista.Observable;

public class AccionClickMouse implements MouseListener {

	private Mapa miMapa;
	public Observable unidadSeleccionada;

	public AccionClickMouse(Mapa mapa) {
		miMapa = mapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = arg0.getY();
		int columna = arg0.getX();
		
		Parcela parcela = miMapa.getParcela(new Coordenada(fila / 40 + 1,
				columna / 40 + 1));
		Observable observado;
		if (!parcela.estaVacia()) {
			Atacable unidad = miMapa.getParcela(
					new Coordenada(fila / 40 + 1, columna / 40 + 1))
					.getOcupante();
			observado = (Observable) unidad;
		} else {
			
			Superficie superficie = miMapa.getParcela(new Coordenada(fila / 40 + 1, columna / 40 + 1)).getSuperficie();
			observado = (Observable) superficie;

		}
		if (unidadSeleccionada == null) {
			((Observable) observado).notificarObservadorSobreSeleccion();

		}else {
			unidadSeleccionada.notificarObservadorSobreSeleccion();
			((Observable) observado).notificarObservadorSobreSeleccion();

		}
		unidadSeleccionada = (Observable) observado;

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
