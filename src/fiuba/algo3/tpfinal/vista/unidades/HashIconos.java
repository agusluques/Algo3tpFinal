package fiuba.algo3.tpfinal.vista.unidades;

import java.util.HashMap;

import javax.swing.ImageIcon;

import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.Espectro;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

@SuppressWarnings({ "serial", "rawtypes" })
public class HashIconos extends HashMap<Class, ImageIcon> {

	private HashMap<Class, ImageIcon> hash = new HashMap<Class, ImageIcon>();

	public HashIconos() {
		// Ingreso unidades Terran
		hash.put(Marine.class,  new ImageIcon("imagenes/iconos/marine.png"));
		hash.put(Golliat.class, new ImageIcon("imagenes/iconos/golliat.png"));
		hash.put(Espectro.class, new ImageIcon("imagenes/iconos/espectro.png"));
		hash.put(NaveCiencia.class,new ImageIcon("imagenes/iconos/naveciencia.png"));
		hash.put(NaveTransporteTerran.class, new ImageIcon("imagenes/iconos/navetransporteterran.png"));

		// Ingreso unidades Protoss
		hash.put(Zealot.class, new ImageIcon("imagenes/iconos/zealot.png"));
		hash.put(Dragon.class, new ImageIcon("imagenes/iconos/dragon.png"));
		hash.put(Scout.class,  new ImageIcon("imagenes/iconos/scout.png"));
		hash.put(AltoTemplario.class, new ImageIcon("imagenes/iconos/altotemplario.png"));
		hash.put(NaveTransporteProtoss.class, new ImageIcon("imagenes/iconos/navetransporteprotoss.png"));
	
	}

	public ImageIcon get(Class clase) {
		return (hash.get(clase));

	}

}
