package fiuba.algo3.tpfinal.vista;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.programa.Juego;

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

	protected void crearPanel(){
		
	}
	

	public void imprimirMenuObservador() {
		
		crearPanel();
		miPanel.setVisible(true);
		miVentanaDeAccion.add(miPanel);
		
		
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
