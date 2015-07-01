package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Superficie;

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
		System.out.println("Coordenada en el Dibujo: " + fila + " " + columna);
		System.out.println("Coordenada en el hash: " + (fila / 40 + 1) + "  "
				+ (columna / 40 + 1));
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
