package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiuba.algo3.tpfinal.excepciones.LargoDeNombreInvalido;
import fiuba.algo3.tpfinal.excepciones.NombresIguales;
import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;

@SuppressWarnings("unused")
public class CrearJuego implements ActionListener{
	
	private JTextField nombreJUno;
	@SuppressWarnings("rawtypes")
	private JComboBox razaJUno;
	@SuppressWarnings("rawtypes")
	private JComboBox colorJUno;
	private JTextField nombreJDos;
	@SuppressWarnings("rawtypes")
	private JComboBox razaJDos;
	@SuppressWarnings("rawtypes")
	private JComboBox colorJDos;

	@SuppressWarnings("rawtypes")
	public CrearJuego(JTextField nombreUno, JComboBox razaUno, JComboBox colorUno, JTextField nombreDos, JComboBox razaDos, JComboBox colorDos) {
		nombreJUno = nombreUno;
		razaJUno = razaUno;
		colorJUno = colorUno;
		nombreJDos = nombreDos;
		razaJDos = razaDos;
		colorJDos = colorDos;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		/*if ((nombreJUno.getText().length() < 4) || (nombreJDos.getText().length() < 4)) {
			throw new LargoDeNombreInvalido();
		}
		if (nombreJUno.getText().matches(nombreJDos.getText())) {
			throw new NombresIguales();
		}*/
		/*HashMap<String, Class<Jugador>> hashDeRazas = new HashMap<String, Class<Jugador>>();
		hashDeRazas.put("Terran", JugadorTerran.class);
		hashDeRazas.put("Protoss", JugadorProtoss.class);
		
		Jugador jugadorUno = hashDeRazas.get(razaJUno.getSelectedItem()).newInstance();*/
		
	}

}
