package fiuba.algo3.tpfinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.modelo.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoError;

public class AccionBajarPasajerosProtoss implements ActionListener{

	private NaveTransporteProtoss miNave;
	
	public AccionBajarPasajerosProtoss(NaveTransporteProtoss nave) {
		miNave = nave;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			miNave.bajarPasajeros();
		} catch(NoHayPasajerosEnLaNave e1) {
			try {
				new SonidoError();
			} catch (MalformedURLException e11) {
				e11.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "No hay pasajeros en la nave",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		} catch (ParcelaOcupada e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
