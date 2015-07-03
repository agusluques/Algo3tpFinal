package fiuba.algo3.tpfinal.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import fiuba.algo3.tpfinal.modelo.construcciones.Acceso;
import fiuba.algo3.tpfinal.modelo.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.modelo.construcciones.Asimilador;
import fiuba.algo3.tpfinal.modelo.construcciones.Barraca;
import fiuba.algo3.tpfinal.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.construcciones.Fabrica;
import fiuba.algo3.tpfinal.modelo.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.modelo.construcciones.Refineria;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Juego;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.vista.programa.JuegoVista;

public class AccionCrearJuegoAvanzado implements ActionListener {
	
	private JLabel miCapa;

	public AccionCrearJuegoAvanzado(JLabel capa) {
		miCapa = capa;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Mapa mapa = new Mapa("mapaTierra_1.txt");
			JugadorTerran jugadorPablo = new JugadorTerran("Pablo", mapa);
			jugadorPablo.setColor(Color.RED);
			JugadorProtoss jugadorNico = new JugadorProtoss("Nico", mapa);
			jugadorNico.setColor(Color.BLUE);
			Juego juegoAvanzado = new Juego(jugadorPablo, jugadorNico, mapa);
			
			CentroDeMineral centro1 = new CentroDeMineral();
			jugadorPablo.construir(centro1, new Coordenada(4, 6));
			CentroDeMineral centro2 = new CentroDeMineral();
			jugadorPablo.construir(centro2, new Coordenada(4, 7));
			Refineria refineria1 = new Refineria();
			jugadorPablo.construir(refineria1, new Coordenada(7,7));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			NexoMineral nexo1 = new NexoMineral();
			jugadorNico.construir(nexo1, new Coordenada(23, 5));
			NexoMineral nexo2 = new NexoMineral();
			jugadorNico.construir(nexo2, new Coordenada(22, 5));
			Asimilador asimilador1 = new Asimilador();
			jugadorNico.construir(asimilador1, new Coordenada(23, 6));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 50; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			DepositoSuministro deposito1 = new DepositoSuministro();
			jugadorPablo.construir(deposito1, new Coordenada(1,1));
			DepositoSuministro deposito2 = new DepositoSuministro();
			jugadorPablo.construir(deposito2, new Coordenada(1,2));
			DepositoSuministro deposito3 = new DepositoSuministro();
			jugadorPablo.construir(deposito3, new Coordenada(1,3));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			Pilon pilon1 = new Pilon();
			jugadorNico.construir(pilon1, new Coordenada(23,1));
			Pilon pilon2 = new Pilon();
			jugadorNico.construir(pilon2, new Coordenada(23,2));
			Pilon pilon3 = new Pilon();
			jugadorNico.construir(pilon3, new Coordenada(23,3));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 6; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			CentroDeMineral centro3 = new CentroDeMineral();
			jugadorPablo.construir(centro3, new Coordenada(5, 6));
			CentroDeMineral centro4 = new CentroDeMineral();
			jugadorPablo.construir(centro4, new Coordenada(5, 7));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			NexoMineral nexo3 = new NexoMineral();
			jugadorNico.construir(nexo3, new Coordenada(22, 7));
			NexoMineral nexo4 = new NexoMineral();
			jugadorNico.construir(nexo4, new Coordenada(22, 6));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 50; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			Barraca barraca1 = new Barraca();
			jugadorPablo.construir(barraca1, new Coordenada(2,10));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			Acceso acceso1 = new Acceso();
			jugadorNico.construir(acceso1, new Coordenada(22,9));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 12; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			Fabrica fabrica1 = new Fabrica();
			jugadorPablo.construir(fabrica1, new Coordenada(10,9));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			PuertoEstelarProtoss puertoProtoss1 = new PuertoEstelarProtoss();
			jugadorNico.construir(puertoProtoss1, new Coordenada(15,5));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 12; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			PuertoEstelarTerran puertoTerran1 = new PuertoEstelarTerran();
			jugadorPablo.construir(puertoTerran1, new Coordenada(8,3));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			ArchivosTemplarios archivos1 = new ArchivosTemplarios();
			jugadorNico.construir(archivos1, new Coordenada(22,3));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 10; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			barraca1.fabricarMarine();
			fabrica1.fabricarGolliat();
			puertoTerran1.fabricarEspectro();
			puertoTerran1.fabricarNaveDeCiencia();
			puertoTerran1.fabricarNaveDeTransporte();
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			acceso1.fabricarDragon();
			acceso1.fabricarZealot();
			puertoProtoss1.fabricarNaveDeTransporte();
			puertoProtoss1.fabricarScout();
			archivos1.fabricarAltoTemplario();
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			CentroDeMineral centro5 = new CentroDeMineral();
			jugadorPablo.construir(centro5, new Coordenada(6, 6));
			CentroDeMineral centro6 = new CentroDeMineral();
			jugadorPablo.construir(centro6, new Coordenada(6, 7));
			juegoAvanzado.pasarTurno(jugadorPablo);
			
			NexoMineral nexo5 = new NexoMineral();
			jugadorNico.construir(nexo5, new Coordenada(21, 7));
			NexoMineral nexo6 = new NexoMineral();
			jugadorNico.construir(nexo6, new Coordenada(21, 6));
			juegoAvanzado.pasarTurno(jugadorNico);
			
			for(int i = 0; i < 25; i++) {
				juegoAvanzado.pasarTurno(jugadorPablo);
				juegoAvanzado.pasarTurno(jugadorNico);
			}
			
			new JuegoVista(miCapa, juegoAvanzado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
