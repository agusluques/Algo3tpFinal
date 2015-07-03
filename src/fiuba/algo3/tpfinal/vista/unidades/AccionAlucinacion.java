package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaVacia;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;

public class AccionAlucinacion extends AccionMagia {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			UnidadProtoss unidad = (UnidadProtoss)miUnidad.getJugador().getMapa()
					.getParcela(new Coordenada(fila, columna)).getOcupante();
			((AltoTemplario)miUnidad).crearAlucinaciones(unidad);
		}catch(EnergiaInsuficiente e){
			JOptionPane.showMessageDialog(ventanaMapa, "Energia insuficiente",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}catch(ParcelaVacia e){} catch (LimitePoblacionalAlcanzado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParcelaOcupada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
	}
}
