package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.vista.MapaVista;

public class JuegoVista {

	private JLabel miCapa;
	private Juego miJuego;

	public JuegoVista(JLabel capa, Juego juego) throws Exception {
		this.miJuego = juego;
		this.miCapa = capa;
		
		JInternalFrame frameJuego = new JInternalFrame("Juego");
		frameJuego.setSize(250, 250);
		frameJuego.setClosable(true);
		frameJuego.setVisible(true);
		
		JInternalFrame infoUnidades = new JInternalFrame("Informacion de unidades");
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
		
		JPanel panelMapa = new MapaVista(miJuego.getMapa());
		JScrollPane panelMapaConScroll = new JScrollPane(panelMapa);
		panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMapaConScroll.setBounds(300, 0, 2*miCapa.getMaximumSize().width/5, miCapa.getMaximumSize().height/2);
		miCapa.add(panelMapaConScroll);
		
		frameJuego.pack();
		frameJuego.setVisible(true);
        frameJuego.setSelected(true);
        miCapa.add(frameJuego);
	}

}
