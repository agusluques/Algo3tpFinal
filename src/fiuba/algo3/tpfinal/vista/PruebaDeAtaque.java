package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.modelo.construcciones.Acceso;
import fiuba.algo3.tpfinal.modelo.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.modelo.construcciones.Asimilador;
import fiuba.algo3.tpfinal.modelo.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class PruebaDeAtaque implements ActionListener {

	private JLabel miCapa;

	public PruebaDeAtaque(JLabel capa) {
		miCapa = capa;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JInternalFrame frame = new JInternalFrame("Mapa");
		frame.setSize(250, 250);
		frame.setLocation(10, 10);
		frame.setClosable(true);
		frame.setVisible(true);
		
		
		Mapa mapa;
		try {
			mapa = new Mapa("mapaTierra_1.txt");	
			JugadorTerran jugador = new JugadorTerran("Luciano",mapa);
			jugador.setColor(Color.RED);
			JugadorProtoss jugador2 = new JugadorProtoss("Luciano2",mapa);
			jugador2.setColor(Color.GREEN);
	
			Zealot zealot = new Zealot();
			jugador2.agregarUnidad(zealot, new Coordenada(2,2));
			
			Marine marine = new Marine();
			jugador.agregarUnidad(marine, new Coordenada(1,1));
			
			Golliat golliat = new Golliat();
			jugador.agregarUnidad(golliat, new Coordenada(4,4));
			
			Asimilador refineria = new Asimilador();
			NexoMineral centro = new NexoMineral();
			jugador2.construir(centro, new Coordenada(7,6));
			jugador2.construir(refineria, new Coordenada(7,7));
			for(int i=0; i<100; i++) {
				jugador2.pasarTurno();
			}
			
			Pilon pilon = new Pilon();
			jugador2.construir(pilon, new Coordenada(1,2));
			for(int i=0; i<5; i++) {
				jugador2.pasarTurno();
			}
			
			Acceso construccion = new Acceso();
			jugador2.construir(construccion, new Coordenada(7,8));
			for(int i=0; i<9; i++) {
				jugador2.pasarTurno();
			}
			
			PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
			jugador2.construir(puerto, new Coordenada(7,9));
			for(int i=0; i<10; i++) {
				jugador2.pasarTurno();
			}
			
			ArchivosTemplarios archivo = new ArchivosTemplarios();
			jugador2.construir(archivo, new Coordenada(7,10));
			for(int i=0; i<9; i++) {
				jugador2.pasarTurno();
			}
			
			JInternalFrame infoUnidades = new JInternalFrame("Informacion de unidades");
			infoUnidades.setSize(300, 300);
			infoUnidades.setLocation(0, 0);
			infoUnidades.setResizable(true);
			infoUnidades.setVisible(true);
			miCapa.add(infoUnidades);
			
			JLayeredPane panelConCapas = new JLayeredPane();
			panelConCapas.setPreferredSize(new Dimension(1000,1000));
		
			MapaVista panelMapa = new MapaVista(mapa);
			((Observable) mapa).agregarObservador((Observador) panelMapa);
			panelConCapas.add(panelMapa);
			
			JScrollPane panelMapaConScroll = new JScrollPane(panelConCapas);
			panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(300, 0, 2*miCapa.getMaximumSize().width/5, miCapa.getMaximumSize().height/2);			
			
			panelMapa.setPanelConCapasParaUnidades(panelConCapas);
			panelMapa.setVentanaDeAccionParaLasUnidades(infoUnidades);
			panelMapa.imprimirMapa();
			
	        frame.pack();
	        frame.setVisible(true);
	        miCapa.add(panelMapaConScroll);
			frame.setSelected(true);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
