package fiuba.algo3.tpfinal.vista.unidades;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;

@SuppressWarnings("serial")
public class UnidadEnFabricacionVista extends JPanel {

	public UnidadEnFabricacionVista(Fabricable unidadActual){
		HashIconos hash = new HashIconos();
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		JLabel icono = new JLabel(hash.get(unidadActual.getClass()));
		this.add(icono);
		
		JLabel tiempoRestante = new JLabel("Tiempo restante: " + unidadActual.getTiempoRestante());
		this.add(tiempoRestante);
		this.setVisible(true);
	}
}
