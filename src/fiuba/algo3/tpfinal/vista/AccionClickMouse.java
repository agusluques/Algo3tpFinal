package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;

public class AccionClickMouse implements MouseListener {

	private Mapa miMapa;
	private Observable unidadSeleccionada;

	public AccionClickMouse(Mapa mapa) {
		miMapa = mapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = arg0.getY();
		int columna = arg0.getX();
		System.out.println("Coordenada en el Dibujo: " + fila + " " + columna);
		System.out.println("Coordenada en el hash: " + (fila / 40 + 1) + "  "
				+ (columna / 40 + 1));
		Parcela parcela = miMapa.getParcela(new Coordenada(fila / 40 + 1,
				columna / 40 + 1));
		if (!parcela.estaVacia()) {
			Atacable unidad = miMapa.getParcela(
					new Coordenada(fila / 40 + 1, columna / 40 + 1))
					.getOcupante();

			if (unidadSeleccionada == null) {
				((Observable) unidad).notificarObservadorSobreSeleccion();

			}
			if (unidadSeleccionada != null
					&& !unidad.equals(unidadSeleccionada)) {
				unidadSeleccionada.notificarObservadorSobreSeleccion();
				((Observable) unidad).notificarObservadorSobreSeleccion();

			}
			;
			unidadSeleccionada = (Observable) unidad;
		} else {
			if (unidadSeleccionada != null) {
				unidadSeleccionada.notificarObservadorSobreSeleccion();
				unidadSeleccionada = null;
			}

		}

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
