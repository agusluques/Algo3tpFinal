package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;

public class ControladorMarine implements ActionListener {

	private Marine miMarine;
	private JLayeredPane ventanaMapa;
	
	public ControladorMarine(Observable marine) {
		miMarine = (Marine)marine;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Hiciste cliick en le boton de atacar!");
		
		//Cuando le hacen click al boton de atacar, crea un panel invisible y lo
		//agrega al layeredPane que teniamos, este panel invisible es el que va a
		//escuchar los clicks para saber donde atacar
		JPanel capaQueEscuchaClicks = new JPanel();
		capaQueEscuchaClicks.setBounds(0, 0, 1000, 1000);
		capaQueEscuchaClicks.setBackground(new Color(0,0,0,0));
		
		//Crea un AccionAtacar, que es un mouse listener, lo instanceo pasandole la capa
		//invisible que cree, el layeredPane donde esta el mapa y el marine
		OtraAccionAtacar accion = new OtraAccionAtacar(capaQueEscuchaClicks,miMarine,ventanaMapa);
		
		//Agrego el mouse listener que cree a la capa invisible
		capaQueEscuchaClicks.addMouseListener(accion);
		capaQueEscuchaClicks.setVisible(true);
		
		//Agrego la capa invisible al layeredPane donde esta el mapa y la muevo adelante
		//de todo
		ventanaMapa.add(capaQueEscuchaClicks);
		ventanaMapa.moveToFront(capaQueEscuchaClicks);
	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}

}