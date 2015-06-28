package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.unidades.MarineVista;
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
			mapa = new Mapa("mapaTierra.txt");

			JInternalFrame infoUnidades = new JInternalFrame(
					"Informacion de unidades");
			infoUnidades.setSize(300, 300);
			infoUnidades.setLocation(0, 0);
			infoUnidades.setResizable(true);
			infoUnidades.setVisible(true);
			miCapa.add(infoUnidades);

			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(2, 2), marine);
			MarineVista vistaMarine = new MarineVista();
			vistaMarine.setVentanaDeAccion(infoUnidades);
			vistaMarine.setObservable(marine);
			((Observable) marine).agregarObservador(vistaMarine);

			Zealot zealot = new Zealot();
			mapa.insertarUnidad(new Coordenada(1, 1), zealot);
			ZealotVista vistaZealot = new ZealotVista();
			vistaZealot.setVentanaDeAccion(infoUnidades);
			vistaZealot.setObservable(zealot);
			((Observable) zealot).agregarObservador(vistaZealot);

			JPanel panelMapa = new MapaVista(mapa);
			JScrollPane panelMapaConScroll = new JScrollPane(panelMapa);
			panelMapaConScroll
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(300, 0,
					2 * miCapa.getMaximumSize().width / 5,
					miCapa.getMaximumSize().height / 2);

			frame.pack();
			frame.setVisible(true);
			miCapa.add(panelMapaConScroll);
			frame.setSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
