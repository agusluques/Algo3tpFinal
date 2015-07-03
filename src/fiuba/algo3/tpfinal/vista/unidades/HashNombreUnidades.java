package fiuba.algo3.tpfinal.vista.unidades;

import java.util.HashMap;

import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

@SuppressWarnings({ "rawtypes", "serial" })
public class HashNombreUnidades extends HashMap<Class,String> {

	private HashMap<Class, String> hash = new HashMap<Class,String>();

	public HashNombreUnidades(){
		hash.put(Zealot.class, "Zealot");
		hash.put(Dragon.class, "Dragon");
		hash.put(Scout.class, "Scout");
		hash.put(AltoTemplario.class, "AltoTemplario");
		hash.put(NaveTransporteProtoss.class, "NaveTransporteProtoss");
	}

	public String get(Class clase){
		return (hash.get(clase));
	}
}
