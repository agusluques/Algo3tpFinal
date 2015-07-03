package fiuba.algo3.tpfinal.vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

import fiuba.algo3.tpfinal.controlador.AccionClickMouse;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;

@SuppressWarnings("serial")
public class MapaVista extends Vista {

	JFrame ventanaPrincipal;
	HashConector generadorParcelas = new HashConector();
	Mapa miMapa;
	private JInternalFrame ventanaDeAccionDeUnidades;
	private JLayeredPane panelConCapasParaUnidades;

	public MapaVista(Mapa mapa) throws Exception {
		MouseListener clickEnMapa = new AccionClickMouse(mapa);
		this.addMouseListener(clickEnMapa);
		this.addMouseMotionListener((MouseMotionListener) clickEnMapa);
		miMapa = mapa;

		setBounds(0, 0, miMapa.getAncho()*40, miMapa.getAlto()*40);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(miMapa.getAncho(), miMapa.getAlto()));
	
	}
	

	public void imprimirMapa() throws InstantiationException,
			IllegalAccessException {
		int ancho = miMapa.getAncho();
		int alto = miMapa.getAlto();

		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++) {
				Coordenada posicionActual = new Coordenada(i, j);
				Parcela parcelaActual = miMapa.getParcela(posicionActual);
				if (parcelaActual.estaVacia()) {
					Class<?> claseVista = generadorParcelas.hash
							.get(parcelaActual.getSuperficie().getClass());
					Vista vista = (Vista) claseVista.newInstance();
					vista.setVentanaDeAccion(ventanaDeAccionDeUnidades);
					vista.setVentanaMapa(panelConCapasParaUnidades);
					vista.setObservable((Observable) parcelaActual.getSuperficie());
					((Observable) parcelaActual.getSuperficie()).agregarObservador(vista);
					this.add(vista);

				} else {
					Class<?> claseVista = generadorParcelas.hash
							.get(parcelaActual.getOcupante().getClass());
					Vista vista = (Vista) claseVista.newInstance();
					vista.setVentanaDeAccion(ventanaDeAccionDeUnidades);
					vista.setVentanaMapa(panelConCapasParaUnidades);
					vista.setJuego(miJuego);
					vista.setObservable((Observable) parcelaActual
							.getOcupante());
					((Observable) parcelaActual.getOcupante()).agregarObservador(vista);
					this.add(vista);
				}
			}
		}

	}

	public Mapa getMapa() {
		return miMapa;
	}
	 
	@Override
	public void actualizar() {
		this.removeAll();
		try {
			this.imprimirMapa();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVentanaDeAccionParaLasUnidades(JInternalFrame infoUnidades) {
		this.ventanaDeAccionDeUnidades = infoUnidades;		
	}
	
	public void setPanelConCapasParaUnidades(JLayeredPane panelConCapas) {
		this.panelConCapasParaUnidades = panelConCapas;
	}

}
