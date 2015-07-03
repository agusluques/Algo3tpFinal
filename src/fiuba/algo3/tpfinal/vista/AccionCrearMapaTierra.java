package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

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
			
			MapaVista panelMapa = new MapaVista(mapa);
			JScrollPane panelMapaConScroll = new JScrollPane(panelMapa);
			panelMapaConScroll
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(300, 0,
					2 * miCapa.getMaximumSize().width / 5,
					miCapa.getMaximumSize().height / 2);
			
			JInternalFrame infoUnidades = new JInternalFrame("Informacion de unidades");
			infoUnidades.setSize(300, 300);
			infoUnidades.setLocation(0, 0);
			infoUnidades.setResizable(true);
			infoUnidades.setVisible(true);
			miCapa.add(infoUnidades);
			
			panelMapa.setVentanaDeAccionParaLasUnidades(infoUnidades);

			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(2, 2), marine);

			Zealot zealot = new Zealot();
			mapa.insertarUnidad(new Coordenada(1, 1), zealot);

			Scout scout = new Scout();
			jugador.agregarUnidad(scout, new Coordenada(1, 2));

			Scout scout2 = new Scout();
			jugador2.agregarUnidad(scout2, new Coordenada(1, 13));

			NaveCiencia nave = new NaveCiencia();
			jugador3.agregarUnidad(nave, new Coordenada(2, 13));
			
			NaveTransporteProtoss nave2 = new NaveTransporteProtoss();
			jugador4.agregarUnidad(nave2, new Coordenada(3,13));
			
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
