package fiuba.algo3.tpfinal.vista;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Juego;

@SuppressWarnings("serial")
public abstract class Vista extends JPanel implements Observador {

	protected JInternalFrame miVentanaDeAccion;
	protected JPanel miPanel;
	protected JLayeredPane ventanaMapa;
	protected Juego miJuego; 

	@Override
	public void setObservable(Observable unidad) {
		
	}

	@Override
	public void actualizar() {
		
	}

	private void crearPanel(){
		
	}
	
	@Override
	public void imprimirMenuObservador() {
		crearPanel();
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
	}
	
	public void setJuego(Juego juego) {
		miJuego = juego;
	}

}
