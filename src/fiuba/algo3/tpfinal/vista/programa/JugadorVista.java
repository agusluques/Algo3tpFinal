package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class JugadorVista extends Vista {
	
	private Jugador miJugador;
	private Juego miJuego;
	
	@Override
	public void setObservable(Observable jugador) {
		miJugador = (Jugador) jugador;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel(miJugador.getNombre());
		miPanel.add(capaNombre);
		
		JLabel capaPoblacion = new JLabel("Poblacion: "+miJugador.contarPoblacion()+"/"+miJugador.limitePoblacional());
		miPanel.add(capaPoblacion);
		
		JLabel capaMineral = new JLabel("Mineral: "+miJugador.getPresupuesto().cantidadDeMineral());
		miPanel.add(capaMineral);
		
		JLabel capaGas = new JLabel("Gas: "+miJugador.getPresupuesto().cantidadDeGas());
		miPanel.add(capaGas);
		
		JButton botonPasarTurno = new JButton("Pasar turno");
		botonPasarTurno.addActionListener(new AccionPasarTurno(miJuego, miJugador));
		miPanel.add(botonPasarTurno);
		
		miPanel.setVisible(false);	
	}
	
	public void setJuego(Juego juego) {
		miJuego = juego;
	}

}
