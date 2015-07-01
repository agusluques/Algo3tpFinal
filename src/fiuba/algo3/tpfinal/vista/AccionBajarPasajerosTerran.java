package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoError;

public class AccionBajarPasajerosTerran implements ActionListener{
	
	private NaveTransporteTerran miNave;
	private JLayeredPane ventanaMapa;
	
	public AccionBajarPasajerosTerran(NaveTransporteTerran nave) {
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
			JOptionPane.showMessageDialog(ventanaMapa, "No hay pasajeros en la nave",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		} catch (ParcelaOcupada e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}
	
	

}
