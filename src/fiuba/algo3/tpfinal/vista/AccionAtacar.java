package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Atacante;

public class AccionAtacar implements MouseListener {

	private Atacante miUnidad;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;
	
	
	public AccionAtacar(JPanel capaQueEscuchaClicks, Atacante miUnidad,
			JLayeredPane ventanaMapa) {
		this.miUnidad = miUnidad;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("TOcaste la capa!");
		
		int fila = (arg0.getY()/40)+1;
		int columna = (arg0.getX()/40)+1;
		
		try{
			Atacable unidad = ((Atacable) miUnidad).getJugador().getMapa().getParcela(new Coordenada(fila,columna)).getOcupante();
			miUnidad.atacar(unidad);
		}catch (Exception e){
			System.out.println("No ataque");
		}
		
		
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
		
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
