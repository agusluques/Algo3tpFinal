package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.modelo.programa.Juego;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.vista.HashConector;
import fiuba.algo3.tpfinal.vista.MapaVista;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;

public class JuegoVista {

	private JLabel miCapa;
	private Juego miJuego;
	private Mapa miMapa;
	private HashConector hash = new HashConector();

	public JuegoVista(JLabel capa, Juego juego) throws Exception {
		this.miJuego = juego;
		this.miCapa = capa;
		this.miMapa = miJuego.getMapa();
		
		JInternalFrame infoUnidades = new JInternalFrame(
				"Informacion de unidades");
		infoUnidades.setSize(300, 300);
		infoUnidades.setLocation(0, 0);
		infoUnidades.setResizable(true);
		infoUnidades.setVisible(true);
		miCapa.add(infoUnidades);

		JInternalFrame infoJuego = new JInternalFrame("Informacion del juego");
		infoJuego.setSize(300, 300);
		infoJuego.setLocation(0, 300);
		infoJuego.setResizable(true);
		infoJuego.setVisible(true);
		miCapa.add(infoJuego);
	
		JugadorVista jugador1Vista = (JugadorVista) hash.get(miJuego.jugadorUno.getClass()).newInstance();
		
		JugadorVista jugador2Vista = (JugadorVista) hash.get(miJuego.jugadorDos.getClass()).newInstance();
		
		JLayeredPane panelConCapas = new JLayeredPane();
		panelConCapas.setPreferredSize(new Dimension(miMapa.getAncho()*40,miMapa.getAlto()*40));//se multiplica por el ancho y largo de cada cuadradito
																								//TODO: hardcodeo
	
		MapaVista panelMapa = new MapaVista(miJuego.getMapa());
		((Observable) miJuego.getMapa()).agregarObservador((Observador) panelMapa);
		panelMapa.setJuego(juego);
		panelConCapas.add(panelMapa);
		
		JScrollPane panelMapaConScroll = new JScrollPane(panelConCapas);
		panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMapaConScroll.setBounds(300, 0, 850, 600);
		
		panelMapa.setPanelConCapasParaUnidades(panelConCapas);
		panelMapa.setVentanaDeAccionParaLasUnidades(infoUnidades);
		panelMapa.imprimirMapa();
		
		jugador1Vista.setVentanaMapa(panelConCapas);
		jugador1Vista.setMapaVista(panelMapa);
		jugador1Vista.setJuego(miJuego);
		jugador1Vista.setVentanaDeAccion(infoJuego);
		jugador1Vista.setObservable(miJuego.jugadorUno);
		(miJuego.jugadorUno).agregarObservador(jugador1Vista);
		
		jugador2Vista.setVentanaMapa(panelConCapas);
		jugador2Vista.setMapaVista(panelMapa);
		jugador2Vista.setJuego(miJuego);
		jugador2Vista.setVentanaDeAccion(infoJuego);
		jugador2Vista.setObservable(miJuego.jugadorDos);
		(miJuego.jugadorDos).agregarObservador(jugador2Vista);
		
		miCapa.add(panelMapaConScroll);
		
		miJuego.jugadorActual.notificarObservadorSobreSeleccion();
		
		
	}

}
