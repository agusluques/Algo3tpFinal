package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

public class AccionCerrarVentanaEmergente implements ActionListener {

	private JInternalFrame ventana;

	public AccionCerrarVentanaEmergente(JInternalFrame emergente) {
		this.ventana = emergente;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ventana.setClosed(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

}
