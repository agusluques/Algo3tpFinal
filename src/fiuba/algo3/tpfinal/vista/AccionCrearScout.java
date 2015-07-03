package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;

public class AccionCrearScout implements ActionListener{
	
	private PuertoEstelarProtoss miPuertoEstelar;

	public AccionCrearScout(PuertoEstelarProtoss puertoEstelar) {
		miPuertoEstelar = puertoEstelar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			miPuertoEstelar.fabricarScout();
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
