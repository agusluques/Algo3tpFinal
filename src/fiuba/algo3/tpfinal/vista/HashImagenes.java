package fiuba.algo3.tpfinal.vista;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Tierra;

@SuppressWarnings({ "rawtypes", "serial" })
public class HashImagenes extends HashMap<Class, Image> {
	
	private HashMap<Class, Image> hash = new HashMap<Class, Image>();

	public HashImagenes() {

		hash.put(Aire.class, (new ImageIcon("imagenes/aire.png")).getImage());
		hash.put(Tierra.class, (new ImageIcon("imagenes/tierra.png")).getImage());
		hash.put(DepositoDeGas.class, (new ImageIcon("imagenes/vespene.png")).getImage());
		hash.put(DepositoDeMinerales.class, (new ImageIcon("imagenes/mineral.png")).getImage());
	}
	public Image get(Class clase){
		return (hash.get(clase));
		
	}
}
