package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.unidades.Rango;

public class ArchivosTemplariosTest {

	private ConstruccionProtoss archivo;

	@Test
	public void unArchivoTemplarioDebeTener500DeVidaInicial()
			throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getVida() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeTener500DeEscudoInicial()
			throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getEscudo() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeCostar150Minerales()
			throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getCostoMineral() == 150);
	}

	@Test
	public void unArchivoTemplarioDebeCostar200Gases()
			throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getCostoGas() == 200);
	}

	@Test
	public void unArchivoTemplarioDebeCrearseEn9Turnos()
			throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getTiempoRestante() == 9);
	}

	@Test
	public void dosArchivosTemplariosDeberianSerIguales() {
		this.archivo = new ArchivosTemplarios();
		Constructible otroArchivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.equals(otroArchivo));
	}

	@Test
	public void siFabricoUnAltoTemplarioElMismoApareceEnLaListaDeUnidadesDelJugador()
			throws Exception {
		this.archivo = new ArchivosTemplarios();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Acceso(), new Coordenada(2, 2));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new PuertoEstelarProtoss(), new Coordenada(8, 8));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.archivo, new Coordenada(4, 4));
		for (int i = 0; i < 9; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(), new Coordenada(6, 6));
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		((ArchivosTemplarios) this.archivo).fabricarAltoTemplario();
		for (int i = 0; i < 7; i++) {
			((ArchivosTemplarios) this.archivo).pasarTurno(null, null);
		}

		int cantUnidadCorrespondiente=0;
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass()==(new AltoTemplario()).getClass()){
				cantUnidadCorrespondiente++;
			}
		}
		Assert.assertTrue(cantUnidadCorrespondiente == 1);

	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		this.archivo = new ArchivosTemplarios();
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(1, this.archivo.rangoDeAtaqueCorrespondiente(rango));
	}

}
