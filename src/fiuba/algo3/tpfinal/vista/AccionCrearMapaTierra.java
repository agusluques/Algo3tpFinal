package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.unidades.Scout;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.unidades.MarineVista;
import fiuba.algo3.tpfinal.vista.unidades.NaveTransporteProtossVista;
import fiuba.algo3.tpfinal.vista.unidades.NaveTransporteTerranVista;
import fiuba.algo3.tpfinal.vista.unidades.ScoutVista;
import fiuba.algo3.tpfinal.vista.unidades.ZealotVista;

public class AccionCrearMapaTierra implements ActionListener {
	
	private JLabel miCapa;

	public AccionCrearMapaTierra(JLabel capa) {
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
			JugadorProtoss jugador = new JugadorProtoss("Luciano",mapa);
			JugadorProtoss jugador2 = new JugadorProtoss("Luciano2",mapa);
			JugadorTerran jugador3 = new JugadorTerran("Luciano3",mapa);
			JugadorProtoss jugador4 = new JugadorProtoss("Luciano4",mapa);
			
			JInternalFrame infoUnidades = new JInternalFrame("Informacion de unidades");
			infoUnidades.setSize(300, 300);
			infoUnidades.setLocation(0, 0);
			infoUnidades.setResizable(true);
			infoUnidades.setVisible(true);
			miCapa.add(infoUnidades);
			
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(2,2),marine);
			MarineVista vistaMarine = new MarineVista();
			vistaMarine.setVentanaDeAccion(infoUnidades);
			vistaMarine.setObservable(marine);
			((Observable)marine).agregarObservador(vistaMarine);
			
			Zealot zealot = new Zealot();
			mapa.insertarUnidad(new Coordenada(1,1), zealot);
			ZealotVista vistaZealot = new ZealotVista();
			vistaZealot.setVentanaDeAccion(infoUnidades);
			vistaZealot.setObservable(zealot);
			((Observable)zealot).agregarObservador(vistaZealot);
				
			Scout scout = new Scout();
			jugador.agregarUnidad(scout, new Coordenada(1,2));
			ScoutVista vistaScout = new ScoutVista();
			vistaScout.setVentanaDeAccion(infoUnidades);
			vistaScout.setObservable(scout);
			((Observable)scout).agregarObservador(vistaScout);
			
			Scout scout2 = new Scout();
			jugador2.agregarUnidad(scout2, new Coordenada(1,13));
			ScoutVista vistaScout2 = new ScoutVista();
			vistaScout2.setVentanaDeAccion(infoUnidades);
			vistaScout2.setObservable(scout2);
			((Observable)scout2).agregarObservador(vistaScout2);
			
			NaveTransporteTerran nave = new NaveTransporteTerran();
			jugador3.agregarUnidad(nave, new Coordenada(2,13));
			NaveTransporteTerranVista vistaNave = new NaveTransporteTerranVista();
			vistaNave.setVentanaDeAccion(infoUnidades);
			vistaNave.setObservable(nave);
			((Observable)nave).agregarObservador(vistaNave);
			
			NaveTransporteProtoss nave2 = new NaveTransporteProtoss();
			jugador4.agregarUnidad(nave2, new Coordenada(3,13));
			NaveTransporteProtossVista vistaNave2 = new NaveTransporteProtossVista();
			vistaNave2.setVentanaDeAccion(infoUnidades);
			vistaNave2.setObservable(nave2);
			((Observable)nave2).agregarObservador(vistaNave2);
			
			
			JPanel panelMapa = new MapaVista(mapa);
			JScrollPane panelMapaConScroll = new JScrollPane(panelMapa);
			panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(300, 0, 2*miCapa.getMaximumSize().width/5, miCapa.getMaximumSize().height/2);
			
			
	        frame.pack();
	        frame.setVisible(true);
	        miCapa.add(panelMapaConScroll);
			frame.setSelected(true);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
