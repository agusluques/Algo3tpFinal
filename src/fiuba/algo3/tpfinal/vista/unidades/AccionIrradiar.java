package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.excepciones.ParcelaVacia;
import fiuba.algo3.tpfinal.excepciones.UnidadInvalida;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;

public class AccionIrradiar extends AccionMagia {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			Atacable unidad = ((Atacable) miUnidad).getJugador().getMapa()
					.getParcela(new Coordenada(fila, columna)).getOcupante();
			((NaveCiencia)miUnidad).irradiar(unidad);
		} catch (UnidadInvalida e) {
			JOptionPane.showMessageDialog(ventanaMapa, "No puedo atacar a esa unidad",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}catch(EnergiaInsuficiente e){
			JOptionPane.showMessageDialog(ventanaMapa, "Energia insuficiente",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}catch(ParcelaVacia e){}

		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
	}

}
