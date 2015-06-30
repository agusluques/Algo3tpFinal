package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ArchivosTemplariosVista extends Vista{
	
	private ArchivosTemplarios miArchivoTemplario;
	private Image img;
	private Image fondo;
	
	public ArchivosTemplariosVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable archivoTemplario) {
		img = (new ImageIcon("imagenes/construcciones/ArchivosTemplarios.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miArchivoTemplario == null){
			miArchivoTemplario = (ArchivosTemplarios) archivoTemplario;
		}
		crearPanel();
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Archivo Templario");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miArchivoTemplario.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miArchivoTemplario.getEscudo());
		miPanel.add(capaEscudo);
		
		miPanel.setVisible(false);
	}
	
	public void actualizar() {
		if (miArchivoTemplario.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
