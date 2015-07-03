package fiuba.algo3.tpfinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.modelo.construcciones.Acceso;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;

public class AccionCrearZealot implements ActionListener {
	
	private Acceso miAcceso;

	public AccionCrearZealot(Acceso acceso) {
		miAcceso = acceso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			miAcceso.fabricarZealot();
		} catch (GasInsuficiente e1) {
			JOptionPane.showMessageDialog(null, "No te alcanza el gas",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		} catch (MineralInsuficiente e1) {
			JOptionPane.showMessageDialog(null, "No te alcanza el mineral",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

}
