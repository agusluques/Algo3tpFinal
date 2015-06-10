package pruebasDeIntegracion;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Espectro;
import fiuba.algo3.tpfinal.unidades.Golliat;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.unidades.Scout;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class AtaquesTest {

	// Ataques del Zealot
	@Test
	public void unZealotPuedeAtacarATierraEnRango1() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Zealot zealot = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 1), zealot);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigo);

		// El zealot lo ataca una vez
		zealot.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. El zealot lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(4, 1), mapa);
		zealot.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unZealotNoPuedeAtacarAAire() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Zealot zealot = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 1), zealot);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigo);

		// El zealot lo ataca una vez
		zealot.atacar(enemigo);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques del Dragon
	@Test
	public void unDragonPuedeAtacarATierraConDanio20YRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Dragon unidad = new Dragon();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 5), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(40, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(40, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unDragonPuedeAtacarAAireCon20DeDanioYRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Dragon unidad = new Dragon();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques Scout
	@Test
	public void unScoutPuedeAtacarATierraConDanio8YRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Scout unidad = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 5), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unScoutPuedeAtacarAAireConDanio14YRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Scout unidad = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(86, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(86, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques Alto Templario
	@Test
	public void unAltoTemplarioNoPuedeAtacarATierraNiAAire() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		AltoTemplario unidad = new AltoTemplario();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 5), enemigo);

		// Lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		Scout enemigoAire = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigoAire);

		// La unidad lo ataca una vez
		unidad.atacar(enemigoAire);
		Assert.assertEquals(100, enemigoAire.getEscudo());
		Assert.assertEquals(150, enemigoAire.getVida());
	}

	// Ataques Marine
	@Test
	public void unMarinePuedeAtacarATierraConDanio6YRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Marine unidad = new Marine();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 5), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(54, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(54, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unMarinePuedeAtacarAAireConDanio6YRango4() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Marine unidad = new Marine();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(94, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(94, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques Golliat
	@Test
	public void unGolliatPuedeAtacarATierraConDanio12YRango6() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Golliat unidad = new Golliat();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 7), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(48, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 8), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(48, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unGolliatPuedeAtacarAAireConDanio10YRango5() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Golliat unidad = new Golliat();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 6), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(90, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(90, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques Espectro
	@Test
	public void unEspectroPuedeAtacarATierraConDanio8YRango5() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Espectro unidad = new Espectro();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 6), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());
	}

	@Test
	public void unEspectroPuedeAtacarAAireConDanio20YRango5() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Espectro unidad = new Espectro();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Scout enemigo = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 6), enemigo);

		// La unidad lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno(null, mapa);
		Assert.assertEquals(100, enemigo.getEscudo());
		Assert.assertEquals(150, enemigo.getVida());
	}

	// Ataques Nave Ciencia
	@Test
	public void unaNaveCienciaPuedeAtacarATierraConDanio6YRango4()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		NaveCiencia unidad = new NaveCiencia();
		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Zealot enemigo = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 5), enemigo);

		// Lo ataca una vez
		unidad.atacar(enemigo);
		Assert.assertEquals(60, enemigo.getEscudo());
		Assert.assertEquals(100, enemigo.getVida());

		Scout enemigoAire = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigoAire);

		// La unidad lo ataca una vez
		unidad.atacar(enemigoAire);
		Assert.assertEquals(100, enemigoAire.getEscudo());
		Assert.assertEquals(150, enemigoAire.getVida());
	}
	
	@Test
	public void unJugadorMataAOtroSiLeMataTodasLasUnidades() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador1 = new Jugador("Damian", mapa);
		jugador1.setRaza("Terran");
		Jugador jugador2 = new Jugador("Juan", mapa);
		jugador2.setRaza("Protoss");
		
		Assert.assertFalse(jugador1.estaExtinto());
		Assert.assertFalse(jugador1.estaExtinto());
		
		ArrayList<Atacable> unidades1 = jugador1.getUnidades();
		ArrayList<Atacable> unidades2 = jugador2.getUnidades();
		Marine marine = (Marine) unidades1.get(0);
		Zealot zealot = (Zealot) unidades2.get(0);
		
		while( !marine.estaMuerto()) {
			marine.atacar(zealot);
			jugador1.pasarTurno();
			jugador2.empezarTurno();
			zealot.atacar(marine);
			jugador2.pasarTurno();
			jugador1.empezarTurno();
		}
		
		Assert.assertEquals(60, zealot.getEscudo());
		Assert.assertEquals(100, zealot.getVida());
		Assert.assertTrue(marine.estaMuerto());
		Assert.assertTrue(jugador1.estaExtinto());
		Assert.assertFalse(jugador2.estaExtinto());
	}

}
