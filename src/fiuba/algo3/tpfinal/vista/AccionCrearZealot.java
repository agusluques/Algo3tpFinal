package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;

public class AccionCrearZealot implements ActionListener {
	
	private Acceso miAcceso;
	private JLayeredPane ventanaMapa;

	public AccionCrearZealot(Acceso acceso) {
		miAcceso = acceso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			miAcceso.fabricarZealot();
		} catch (GasInsuficiente e1) {
			JOptionPane.showMessageDialog(ventanaMapa, "No te alcanza el gas",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		} catch (MineralInsuficiente e1) {
			JOptionPane.showMessageDialog(ventanaMapa, "No te alcanza el mineral",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
	}

}
