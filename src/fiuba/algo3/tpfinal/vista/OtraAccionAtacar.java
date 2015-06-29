package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Marine;

public class OtraAccionAtacar implements MouseListener {

	private Marine miMarine;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;
	
	
	public OtraAccionAtacar(JPanel capaQueEscuchaClicks, Marine miMarine,
			JLayeredPane ventanaMapa) {
		this.miMarine = miMarine;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
	}

	//Lo que pasa cuando hago click en el mapa despues de haber tocado el boton de atacar
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("TOcaste la capa!");
		
		//Saco las coordenadas de donde hice click y hago una conversion a coordenadas
		//del mapa
		int fila = (arg0.getY()/40)+1;
		int columna = (arg0.getX()/40)+1;
		//Le pido al mapa la unidad que hay en el lugar donde hice click, si no hay nada 
		//va a tirar una excepcion, ahi cuando se la atrapa se podria hacer que reprodusca
		//un sonido que indique que no pudo atacar
		try{
			Atacable unidad = miMarine.getJugador().getMapa().getParcela(new Coordenada(fila,columna)).getOcupante();
			
		//Pongan la siguiente linea adentro de un for para atacar varias veces seguidas
		//asi ven como desaparece de la pantalla cuando muere
			miMarine.atacar(unidad);
		//Aca iria algun que otro sonido que diga que no puede atacar cuando atrapa la excepcion
		}catch (Exception e){
			System.out.println("No ataque");
		}
		
		//una vez que ataque, saco la capa invisible que usaba para escuchar los clicks,
		//asi el mouse listener que se encarga de la seleccion de unidades puede escuchar los
		//clicks normalmente
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
		//La AccionAtacar y el ControladorMarine irian en una sola clase, lo hice en dos ahora
		//para mostrarlo
		//Faltaria hacer que en el actualizar del zealot modifique la ventanita donde escribe
		//su vida y su escudo, asi cuando se le hace click, aparece lo que tiene
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
