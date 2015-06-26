package fiuba.algo3.tpfinal.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;

@SuppressWarnings("serial")
public class MapaVista extends JPanel {
	
	JFrame ventanaPrincipal;
	HashConector generadorParcelas = new HashConector();
	Mapa miMapa;
	
	public MapaVista(Mapa mapa) throws Exception {
		MouseListener clickEnMapa = new AccionClickMouse(mapa);
		this.addMouseListener(clickEnMapa);
		miMapa = mapa;
		
		setBounds(0, 0, 100, 100);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(miMapa.getAncho(), miMapa.getAlto()));

		this.imprimirMapa();
	}

	public void imprimirMapa() throws InstantiationException, IllegalAccessException {
		int ancho = miMapa.getAncho();
		int alto = miMapa.getAlto();
		
		for(int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++){
				Coordenada posicionActual = new Coordenada(i,j);
				Parcela parcelaActual = miMapa.getParcela(posicionActual);
				if (parcelaActual.estaVacia()){
				Class<?> claseVista = generadorParcelas.hash.get(parcelaActual.getSuperficie().getClass());
				Vista vista = (Vista) claseVista.newInstance();
				this.add(vista);
				}else{
					Class<?> claseVista = generadorParcelas.hash.get(parcelaActual.getOcupante().getClass());
					Vista vista = (Vista) claseVista.newInstance();
					this.add(vista);
				}
			}
		}
	
		
	
	}

	
}
