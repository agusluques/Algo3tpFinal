package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;

public class AccionCrearNaveCiencia implements ActionListener{
	
	private PuertoEstelarTerran miPuertoEstelar;

	public AccionCrearNaveCiencia(PuertoEstelarTerran puertoEstelar) {
		miPuertoEstelar = puertoEstelar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			miPuertoEstelar.fabricarNaveDeCiencia();
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
