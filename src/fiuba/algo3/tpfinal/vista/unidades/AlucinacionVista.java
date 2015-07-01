package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Alucinacion;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AlucinacionVista extends Vista implements Observador {

	private Alucinacion miAlucinacion;
	private Image img;
	private Image fondo;
	private String urlTraslado = "trasladoZealot.wav";
	private int vidaFicticia;
	private ImagenesParaAlucinacion imagenes = new ImagenesParaAlucinacion();
	private HashNombreUnidades nombres = new HashNombreUnidades();

	public AlucinacionVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void actualizar() {
		if (miAlucinacion.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miVentanaDeAccion.add(miPanel);
			miPanel.setVisible(true);
		}
	}

	@Override
	public void setObservable(Observable alucinacion) {
		
		
	
		
		if (miAlucinacion == null)
			miAlucinacion = (Alucinacion) alucinacion;
			
		vidaFicticia = miAlucinacion.getUnidadCopiada().getCantidadDeVida();
		
		img = imagenes.obtener(miAlucinacion.getUnidadCopiada().getClass(), miAlucinacion.getJugador().getColor());
		
		crearPanel();
		
		miPanel.setVisible(false);
		
	}

	private void crearPanel() {
		miPanel = new JPanel();
				
		if(miJuego.jugadorActual.equals(miAlucinacion.getJugador())){
			JLabel capaNombre = new JLabel("Alucinacion");
			miPanel.add(capaNombre);
					
			JLabel capaEscudo = new JLabel("Escudo: " + miAlucinacion.getCantidadDeEscudo());
			miPanel.add(capaEscudo);
			crearControladores();
		}else{
			JLabel capaNombre = new JLabel(nombres.get(miAlucinacion.getUnidadCopiada().getClass()));
			miPanel.add(capaNombre);
			
			JLabel capaVida = new JLabel("Vida: " + vidaFicticia);
			miPanel.add(capaVida);
			
			JLabel capaEscudo = new JLabel("Escudo: " + miAlucinacion.getCantidadDeEscudo());
			miPanel.add(capaEscudo);
		}
		
	}

	private void crearControladores() {
			
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miAlucinacion, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}
	
	public void paint(Graphics g) {
	
		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miAlucinacion.estaMuerto())
			g.drawImage(img, 0, 0, 40, 40, null);

	}

}
