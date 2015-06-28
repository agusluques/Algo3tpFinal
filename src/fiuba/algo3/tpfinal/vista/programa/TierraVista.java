package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Color;
import java.awt.Dimension;

import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class TierraVista extends Vista {

	/*
	 * public TierraVista() { super("/imagenes/superficies/tierra.png");
	 * //this.setBackground("/imagenes/superficies/tierra.png"); }
	 */

	/*
	 * public TierraVista() { this.miImagen =
	 * Toolkit.getDefaultToolkit().createImage
	 * ("/imagenes/superficies/tierra.png"); }
	 */

	public TierraVista() {
		setPreferredSize(new Dimension(40, 40));
		setBackground(Color.RED);

	}

}
