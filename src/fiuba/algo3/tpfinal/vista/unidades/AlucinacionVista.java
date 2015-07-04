package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.ControladorTraslado;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.Alucinacion;
import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AlucinacionVista extends Vista implements Observador {

	private Alucinacion miAlucinacion;
	private Image imgParaEnemigos;
	private Image imgParaAliados;
	private String urlTraslado = "trasladoZealot.wav";
	private int vidaFicticia;
	private ImagenesAlucinacionParaEnemigos imagenes = new ImagenesAlucinacionParaEnemigos();
	private HashNombreUnidades nombres = new HashNombreUnidades();
	private HashImagenes imgSuperficies = new HashImagenes();
	private ImagenesAlucinacionParaAliados imagenesAliados = new ImagenesAlucinacionParaAliados();

	public AlucinacionVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void actualizar() {
		if (miAlucinacion.estaMuerto()){
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
		
		imgParaEnemigos = imagenes.obtener(miAlucinacion.getUnidadCopiada().getClass(), miAlucinacion.getJugador().getColor());
		imgParaAliados = imagenesAliados.get(miAlucinacion.getUnidadCopiada().getClass());

		
	}
	@Override
	protected void crearPanel() {
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
		
		Coordenada miCoord = miAlucinacion.getCoordenada();
		Class<?> sup = miAlucinacion.getJugador().getMapa().getParcela(miCoord)
				.getSuperficie().getClass();
	
		g.drawImage(imgSuperficies.get(sup), 0, 0, 40, 40, null);
		if (!miAlucinacion.estaMuerto())
			if(miJuego.jugadorActual.equals(miAlucinacion.getJugador())){
				g.drawImage(imgParaAliados,0,0,40,40,null);
			}else{
				g.drawImage(imgParaEnemigos, 0, 0, 40, 40, null);
			}
			

	}

}
