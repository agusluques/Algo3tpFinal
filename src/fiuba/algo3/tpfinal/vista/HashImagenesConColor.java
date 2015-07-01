package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class HashImagenesConColor extends HashMap<String, Image> {

	private HashMap<String, Image> hash = new HashMap<String, Image>();

	public HashImagenesConColor(Color color) {
		
		if(color == Color.RED)
			this.crearHashRojo();
		if(color == Color.BLUE)
			this.crearHashAzul();
		if(color == Color.GREEN)
			this.crearHashVerde();
				
		hash.put("EdificioEnConstruccionProtoss",(new ImageIcon("imagenes/edificios/protoss/edificioenconstruccionprotoss.png")).getImage());
		hash.put("EdificioEnConstruccionTerran",(new ImageIcon("imagenes/edificios/terran/edificioenconstruccionterran.png")).getImage());
			
	
	}


	private void crearHashRojo(){
	
				// Ingreso unidades Terran
				hash.put("Marine", (new ImageIcon("imagenes/unidades/terran/rojo/marine.png")).getImage());
				hash.put("Golliat", (new ImageIcon("imagenes/unidades/terran/rojo/golliat.png")).getImage());
				hash.put("Espectro", (new ImageIcon("imagenes/unidades/terran/rojo/espectro.png")).getImage());
				hash.put("NaveCiencia", (new ImageIcon("imagenes/unidades/terran/rojo/naveciencia.png")).getImage());
				hash.put("NaveTransporteTerran", (new ImageIcon("imagenes/unidades/terran/rojo/navetransporteterran.png")).getImage());

				// Ingreso unidades Protoss
				hash.put("Zealot", (new ImageIcon("imagenes/unidades/protoss/rojo/zealot.png")).getImage());
				hash.put("Dragon", (new ImageIcon("imagenes/unidades/protoss/rojo/dragon.png")).getImage());
				hash.put("Scout", (new ImageIcon("imagenes/unidades/protoss/rojo/scout.png")).getImage());
				hash.put("AltoTemplario", (new ImageIcon("imagenes/unidades/protoss/rojo/altotemplario.png")).getImage());
				hash.put("NaveTransporteProtoss", (new ImageIcon("imagenes/unidades/protoss/rojo/navetransporteprotoss.png")).getImage());

				// Ingreso construcciones Terran
				hash.put("CentroDeMineral", (new ImageIcon("imagenes/edificios/terran/rojo/centromineral.png")).getImage());
				hash.put("Barraca", (new ImageIcon("imagenes/edificios/terran/rojo/barraca.png")).getImage());
				hash.put("DepositoDeSuministros", (new ImageIcon("imagenes/edificios/terran/rojo/depositosuministros.png")).getImage());
				hash.put("Refineria", (new ImageIcon("imagenes/edificios/terran/rojo/refineria.png")).getImage());
				hash.put("Fabrica", (new ImageIcon("imagenes/edificios/terran/rojo/fabrica.png")).getImage());
				hash.put("PuertoEstelarTerran", (new ImageIcon("imagenes/edificios/terran/rojo/puertoestelar.png")).getImage());

				// Ingreso construcciones Protoss
				hash.put("NexoMineral", (new ImageIcon("imagenes/edificios/protoss/rojo/nexomineral.png")).getImage());
				hash.put("Pylon", (new ImageIcon("imagenes/edificios/protoss/rojo/pylon.png")).getImage());
				hash.put("Asimilador", (new ImageIcon("imagenes/edificios/protoss/rojo/asimilador.png")).getImage());
				hash.put("Acceso", (new ImageIcon("imagenes/edificios/protoss/rojo/acceso.png")).getImage());
				hash.put("ArchivosTemplarios", (new ImageIcon("imagenes/edificios/protoss/rojo/archivostemplarios.png")).getImage());
				hash.put("PuertoEstelarProtoss", (new ImageIcon("imagenes/edificios/protoss/rojo/puertoestelar.png")).getImage());
				
			}
	
	private void crearHashAzul(){
		
		// Ingreso unidades Terran
		hash.put("Marine", (new ImageIcon("imagenes/unidades/terran/azul/marine.png")).getImage());
		hash.put("Golliat", (new ImageIcon("imagenes/unidades/terran/azul/golliat.png")).getImage());
		hash.put("Espectro", (new ImageIcon("imagenes/unidades/terran/azul/espectro.png")).getImage());
		hash.put("NaveCiencia", (new ImageIcon("imagenes/unidades/terran/azul/naveciencia.png")).getImage());
		hash.put("NaveTransporteTerran", (new ImageIcon("imagenes/unidades/terran/azul/navetransporteterran.png")).getImage());

		// Ingreso unidades Protoss
		hash.put("Zealot", (new ImageIcon("imagenes/unidades/protoss/azul/zealot.png")).getImage());
		hash.put("Dragon", (new ImageIcon("imagenes/unidades/protoss/azul/dragon.png")).getImage());
		hash.put("Scout", (new ImageIcon("imagenes/unidades/protoss/azul/scout.png")).getImage());
		hash.put("AltoTemplario", (new ImageIcon("imagenes/unidades/protoss/azul/altotemplario.png")).getImage());
		hash.put("NaveTransporteProtoss", (new ImageIcon("imagenes/unidades/protoss/azul/navetransporteprotoss.png")).getImage());

		// Ingreso construcciones Terran
		hash.put("CentroDeMineral", (new ImageIcon("imagenes/edificios/terran/azul/centromineral.png")).getImage());
		hash.put("Barraca", (new ImageIcon("imagenes/edificios/terran/azul/barraca.png")).getImage());
		hash.put("DepositoDeSuministros", (new ImageIcon("imagenes/edificios/terran/azul/depositosuministros.png")).getImage());
		hash.put("Refineria", (new ImageIcon("imagenes/edificios/terran/azul/refineria.png")).getImage());
		hash.put("Fabrica", (new ImageIcon("imagenes/edificios/terran/azul/fabrica.png")).getImage());
		hash.put("PuertoEstelarTerran", (new ImageIcon("imagenes/edificios/terran/azul/puertoestelar.png")).getImage());

		// Ingreso construcciones Protoss
		hash.put("NexoMineral", (new ImageIcon("imagenes/edificios/protoss/azul/nexomineral.png")).getImage());
		hash.put("Pylon", (new ImageIcon("imagenes/edificios/protoss/azul/pylon.png")).getImage());
		hash.put("Asimilador", (new ImageIcon("imagenes/edificios/protoss/azul/asimilador.png")).getImage());
		hash.put("Acceso", (new ImageIcon("imagenes/edificios/protoss/azul/acceso.png")).getImage());
		hash.put("ArchivosTemplarios", (new ImageIcon("imagenes/edificios/protoss/azul/archivostemplarios.png")).getImage());
		hash.put("PuertoEstelarProtoss", (new ImageIcon("imagenes/edificios/protoss/azul/puertoestelar.png")).getImage());

	}
	
	private void crearHashVerde(){
		
		// Ingreso unidades Terran
		hash.put("Marine", (new ImageIcon("imagenes/unidades/terran/verde/marine.png")).getImage());
		hash.put("Golliat", (new ImageIcon("imagenes/unidades/terran/verde/golliat.png")).getImage());
		hash.put("Espectro", (new ImageIcon("imagenes/unidades/terran/verde/espectro.png")).getImage());
		hash.put("NaveCiencia", (new ImageIcon("imagenes/unidades/terran/verde/naveciencia.png")).getImage());
		hash.put("NaveTransporteTerran", (new ImageIcon("imagenes/unidades/terran/verde/navetransporteterran.png")).getImage());

		// Ingreso unidades Protoss
		hash.put("Zealot", (new ImageIcon("imagenes/unidades/protoss/verde/zealot.png")).getImage());
		hash.put("Dragon", (new ImageIcon("imagenes/unidades/protoss/verde/dragon.png")).getImage());
		hash.put("Scout", (new ImageIcon("imagenes/unidades/protoss/verde/scout.png")).getImage());
		hash.put("AltoTemplario", (new ImageIcon("imagenes/unidades/protoss/verde/altotemplario.png")).getImage());
		hash.put("NaveTransporteProtoss", (new ImageIcon("imagenes/unidades/protoss/verde/navetransporteprotoss.png")).getImage());

		// Ingreso construcciones Terran
		hash.put("CentroDeMineral", (new ImageIcon("imagenes/edificios/terran/verde/centromineral.png")).getImage());
		hash.put("Barraca", (new ImageIcon("imagenes/edificios/terran/verde/barraca.png")).getImage());
		hash.put("DepositoDeSuministros", (new ImageIcon("imagenes/edificios/terran/verde/depositosuministros.png")).getImage());
		hash.put("Refineria", (new ImageIcon("imagenes/edificios/terran/verde/refineria.png")).getImage());
		hash.put("Fabrica", (new ImageIcon("imagenes/edificios/terran/verde/fabrica.png")).getImage());
		hash.put("PuertoEstelarTerran", (new ImageIcon("imagenes/edificios/terran/verde/puertoestelar.png")).getImage());

		// Ingreso construcciones Protoss
		hash.put("NexoMineral", (new ImageIcon("imagenes/edificios/protoss/verde/nexomineral.png")).getImage());
		hash.put("Pylon", (new ImageIcon("imagenes/edificios/protoss/verde/pylon.png")).getImage());
		hash.put("Asimilador", (new ImageIcon("imagenes/edificios/protoss/verde/asimilador.png")).getImage());
		hash.put("Acceso", (new ImageIcon("imagenes/edificios/protoss/verde/acceso.png")).getImage());
		hash.put("ArchivosTemplarios", (new ImageIcon("imagenes/edificios/protoss/verde/archivostemplarios.png")).getImage());
		hash.put("PuertoEstelarProtoss", (new ImageIcon("imagenes/edificios/protoss/verde/puertoestelar.png")).getImage());

	}
	
			
	
	public Image get(String unidad) {
		return hash.get(unidad);
	}
	
}