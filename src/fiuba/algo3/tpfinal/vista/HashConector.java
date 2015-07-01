package fiuba.algo3.tpfinal.vista;

import java.util.HashMap;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.unidades.Alucinacion;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Espectro;
import fiuba.algo3.tpfinal.unidades.Golliat;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.unidades.Scout;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.construcciones.AccesoVista;
import fiuba.algo3.tpfinal.vista.construcciones.ArchivosTemplariosVista;
import fiuba.algo3.tpfinal.vista.construcciones.AsimiladorVista;
import fiuba.algo3.tpfinal.vista.construcciones.BarracaVista;
import fiuba.algo3.tpfinal.vista.construcciones.CentroDeMineralVista;
import fiuba.algo3.tpfinal.vista.construcciones.DepositoSuministroVista;
import fiuba.algo3.tpfinal.vista.construcciones.FabricaVista;
import fiuba.algo3.tpfinal.vista.construcciones.NexoMineralVista;
import fiuba.algo3.tpfinal.vista.construcciones.PilonVista;
import fiuba.algo3.tpfinal.vista.construcciones.PuertoEstelarProtossVista;
import fiuba.algo3.tpfinal.vista.construcciones.PuertoEstelarTerranVista;
import fiuba.algo3.tpfinal.vista.construcciones.RefineriaVista;
import fiuba.algo3.tpfinal.vista.programa.AireVista;
import fiuba.algo3.tpfinal.vista.programa.DepositoDeGasVista;
import fiuba.algo3.tpfinal.vista.programa.DepositoDeMineralesVista;
import fiuba.algo3.tpfinal.vista.programa.JugadorProtossVista;
import fiuba.algo3.tpfinal.vista.programa.JugadorTerranVista;
import fiuba.algo3.tpfinal.vista.programa.TierraVista;
import fiuba.algo3.tpfinal.vista.unidades.AltoTemplarioVista;
import fiuba.algo3.tpfinal.vista.unidades.AlucinacionVista;
import fiuba.algo3.tpfinal.vista.unidades.DragonVista;
import fiuba.algo3.tpfinal.vista.unidades.EspectroVista;
import fiuba.algo3.tpfinal.vista.unidades.GolliatVista;
import fiuba.algo3.tpfinal.vista.unidades.MarineVista;
import fiuba.algo3.tpfinal.vista.unidades.NaveCienciaVista;
import fiuba.algo3.tpfinal.vista.unidades.NaveTransporteProtossVista;
import fiuba.algo3.tpfinal.vista.unidades.NaveTransporteTerranVista;
import fiuba.algo3.tpfinal.vista.unidades.ScoutVista;
import fiuba.algo3.tpfinal.vista.unidades.ZealotVista;

public class HashConector {
	@SuppressWarnings("rawtypes")
	public HashMap<Class, Class> hash = new HashMap<Class, Class>();

	public HashConector() {
		
		//Ingreso los jugadores
		hash.put(JugadorTerran.class, JugadorTerranVista.class);
		hash.put(JugadorProtoss.class, JugadorProtossVista.class);

		// Ingreso unidades Terran
		hash.put(Marine.class, MarineVista.class);
		hash.put(Golliat.class, GolliatVista.class);
		hash.put(Espectro.class, EspectroVista.class);
		hash.put(NaveCiencia.class, NaveCienciaVista.class);
		hash.put(NaveTransporteTerran.class, NaveTransporteTerranVista.class);

		// Ingreso unidades Protoss
		hash.put(Zealot.class, ZealotVista.class);
		hash.put(Dragon.class, DragonVista.class);
		hash.put(Scout.class, ScoutVista.class);
		hash.put(AltoTemplario.class, AltoTemplarioVista.class);
		hash.put(NaveTransporteProtoss.class, NaveTransporteProtossVista.class);
		hash.put(Alucinacion.class, AlucinacionVista.class);

		// Ingreso construcciones Terran
		hash.put(CentroDeMineral.class, CentroDeMineralVista.class);
		hash.put(Barraca.class, BarracaVista.class);
		hash.put(DepositoSuministro.class, DepositoSuministroVista.class);
		hash.put(Refineria.class, RefineriaVista.class);
		hash.put(Fabrica.class, FabricaVista.class);
		hash.put(PuertoEstelarTerran.class, PuertoEstelarTerranVista.class);

		// Ingreso construcciones Protoss
		hash.put(NexoMineral.class, NexoMineralVista.class);
		hash.put(Pilon.class, PilonVista.class);
		hash.put(Asimilador.class, AsimiladorVista.class);
		hash.put(Acceso.class, AccesoVista.class);
		hash.put(ArchivosTemplarios.class, ArchivosTemplariosVista.class);
		hash.put(PuertoEstelarProtoss.class, PuertoEstelarProtossVista.class);

		// Ingreso superficies
		hash.put(Aire.class, AireVista.class);
		hash.put(Tierra.class, TierraVista.class);
		hash.put(DepositoDeGas.class, DepositoDeGasVista.class);
		hash.put(DepositoDeMinerales.class, DepositoDeMineralesVista.class);
	}
	
	@SuppressWarnings("rawtypes")
	public Class get(Class clase) {
		return hash.get(clase);
	}
}
