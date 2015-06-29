package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveTransporteTerranVista extends Vista implements Observador {

	private NaveTransporteTerran miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();

	public NaveTransporteTerranVista() {
		setPreferredSize(new Dimension(40, 40));

	}

	@Override
	public void setObservable(Observable nave) {
		img = (new ImageIcon("imagenes/medivac_1.png")).getImage();
		miNave = (NaveTransporteTerran) nave;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("NaveDeTransporteTerran");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		miPanel.setVisible(false);

	}

	public void paint(Graphics g) {
		Coordenada miCoord = miNave.getCoordenada();
		Class<?> sup = miNave.getJugador().getMapa().getParcela(miCoord)
				.getSuperficie().getClass();

		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
