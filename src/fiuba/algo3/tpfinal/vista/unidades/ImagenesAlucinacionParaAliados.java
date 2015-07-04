package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

@SuppressWarnings({ "rawtypes", "serial" })
public class ImagenesAlucinacionParaAliados extends HashMap<Class,Image> {
	
	private HashMap<Class, Image> hash = new HashMap<Class, Image>();

	public ImagenesAlucinacionParaAliados(){
		// Ingreso unidades Protoss
		hash.put(Zealot.class, (new ImageIcon("imagenes/unidades/protoss/alucinacion/zealot.png")).getImage());
		hash.put(Dragon.class, (new ImageIcon("imagenes/unidades/protoss/alucinacion/dragon.png")).getImage());
		hash.put(Scout.class, (new ImageIcon("imagenes/unidades/protoss/alucinacion/scout.png")).getImage());
		hash.put(AltoTemplario.class, (new ImageIcon("imagenes/unidades/protoss/alucinacion/altotemplario.png")).getImage());
		hash.put(NaveTransporteProtoss.class, (new ImageIcon("imagenes/unidades/protoss/alucinacion/navetransporteprotoss.png")).getImage());

		
	}
	

	public Image get(Class clase) {
		return hash.get(clase);
	}
}
