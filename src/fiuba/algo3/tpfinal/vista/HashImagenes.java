package fiuba.algo3.tpfinal.vista;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;

@SuppressWarnings({ "rawtypes", "serial" })
public class HashImagenes extends HashMap<Class, Image> {

	private HashMap<Class, Image> hash = new HashMap<Class, Image>();

	public HashImagenes() {

		hash.put(Aire.class, (new ImageIcon("imagenes/superficies/aire.png")).getImage());
		hash.put(Tierra.class,
				(new ImageIcon("imagenes/superficies/tierra.png")).getImage());
		hash.put(DepositoDeGas.class,
				(new ImageIcon("imagenes/superficies/vespene.png")).getImage());
		hash.put(DepositoDeMinerales.class, (new ImageIcon(
				"imagenes/superficies/mineral.png")).getImage());
	}

	public Image get(Class clase) {
		return (hash.get(clase));

	}
}
