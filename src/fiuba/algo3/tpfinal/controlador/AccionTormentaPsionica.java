package fiuba.algo3.tpfinal.controlador;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;

public class AccionTormentaPsionica extends AccionMagia {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			((AltoTemplario)miUnidad).lanzarTormentaPsionica(new Coordenada(fila,columna));
		}catch(EnergiaInsuficiente e){
			JOptionPane.showMessageDialog(ventanaMapa, "Energia insuficiente",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}

		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
	}
}
