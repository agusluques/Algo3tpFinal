package fiuba.algo3.tpfinal.vista;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Vista extends JPanel implements Observador {

	protected JInternalFrame miVentanaDeAccion;
	protected JPanel miPanel;
	protected JLayeredPane ventanaMapa;

	public void setObservable(Observable unidad) {
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirMenuObservador() {
		miVentanaDeAccion.add(miPanel);
		miPanel.setVisible(true);
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;

	}

	@Override
	public void ocultarMenuObservador() {
		miPanel.setVisible(false);
		miVentanaDeAccion.remove(miPanel);

	}

	public void setVentanaMapa(JLayeredPane mapa) {
		this.ventanaMapa = mapa;
		
	};

}
