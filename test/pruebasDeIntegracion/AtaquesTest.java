package pruebasDeIntegracion;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Jugador;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.Espectro;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

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
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. El zealot lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(4, 1), mapa);
		zealot.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(100, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(40, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(40, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(48, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(80, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(88, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(86, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(86, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(94, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		Scout enemigoAire = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigoAire);

		// La unidad lo ataca una vez
		unidad.atacar(enemigoAire);
		Assert.assertEquals(100, enemigoAire.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigoAire.getCantidadDeVida());
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
		Assert.assertEquals(54, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(54, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(94, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 6), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(94, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(100, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(48, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 8), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(48, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(56, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(90, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(90, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(98, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(52, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(80, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo se escapa. La unidad lo trata de atacar pero no le hace
		// danio
		enemigo.trasladarA(new Coordenada(1, 7), mapa);
		unidad.atacar(enemigo);
		Assert.assertEquals(80, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());

		// El enemigo pasa el turno, se recupera su escudo
		// El jugador lo mando como null, total no lo necesito en este caso
		enemigo.pasarTurno();
		Assert.assertEquals(88, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigo.getCantidadDeVida());
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
		Assert.assertEquals(60, enemigo.getCantidadDeEscudo());
		Assert.assertEquals(100, enemigo.getCantidadDeVida());

		Scout enemigoAire = new Scout();
		mapa.insertarUnidad(new Coordenada(1, 2), enemigoAire);

		// La unidad lo ataca una vez
		unidad.atacar(enemigoAire);
		Assert.assertEquals(100, enemigoAire.getCantidadDeEscudo());
		Assert.assertEquals(150, enemigoAire.getCantidadDeVida());
	}

	@Test
	public void unJugadorMataAOtroSiLeMataTodasLasUnidades() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador1 = new JugadorTerran("Damian", mapa);
		jugador1.inicializarEnPrimeraBase();
		Jugador jugador2 = new JugadorProtoss("Juan", mapa);
		jugador2.inicializarEnUltimaBase();

		Assert.assertFalse(jugador1.estaExtinto());
		Assert.assertFalse(jugador1.estaExtinto());

		ArrayList<Atacable> unidades1 = jugador1.getUnidades();
		ArrayList<Atacable> unidades2 = jugador2.getUnidades();
		Marine marine = (Marine) unidades1.get(0);
		Zealot zealot = (Zealot) unidades2.get(0);

		zealot.trasladarA(new Coordenada(1, 88), mapa);
		while (!marine.estaMuerto()) {
			marine.atacar(zealot);
			jugador1.pasarTurno();
			jugador2.empezarTurno();
			zealot.atacar(marine);
			jugador2.pasarTurno();
			jugador1.empezarTurno();
		}

		Assert.assertEquals(60, zealot.getCantidadDeEscudo());
		Assert.assertEquals(100, zealot.getCantidadDeVida());
		Assert.assertTrue(marine.estaMuerto());
		Assert.assertTrue(jugador1.estaExtinto());
		Assert.assertFalse(jugador2.estaExtinto());
	}

}
