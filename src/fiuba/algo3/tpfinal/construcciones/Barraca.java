package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Marine;

public class Barraca extends ConstruccionesTerran {


	private Fabricable unidadEnConstruccion;
	private Jugador jugador;
	
	public Barraca(){
		this.vida.inicializarVida(1000);
		this.costo = new Costo(150);
		this.tiempo = 12;
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}

	public void fabricarMarine(){
		try{
			jugador.getPresupuesto().removerMineral(50);
			unidadEnConstruccion = new Marine();
		}catch (MineralInsuficiente e){
			throw e;
		}
	}
	
	public void haceLoTuyo(){
		if (unidadEnConstruccion != null){
			unidadEnConstruccion.avanzarFabricacion();
			if(this.unidadEnConstruccion.getTiempoRestante() == 0){
				try{
					this.jugador.agregarUnidad(unidadEnConstruccion);
					this.unidadEnConstruccion = null;
				}catch (LimitePoblacionalAlcanzado e){
					throw e;
				}
			}
		}
	}
}
//Lo hice sin usar poliformismo porque cuando tenga implementada una interfaz grafica, uno va a clickear
//en una fabrica (o sea, va a obtener una referencia a esa fabrica) y va a tocar el boton Marine. Seria
//como que cuando apreto el boton, se la pasa a ese objeto(el cual ya tenia seleccionado) el mensaje
//"fabricarMarine". El metodo haceLoTuyo se supone que va a venir de una interfaz despues. La cual la van
//a implimentar todas las clases que hagan algo, asi el juego directamente va a agarrar a todos los
//objetos y les va a decir "haceLoTuyo". Hay que hacerle algunos cambios, como que la interfaz Fabricable
//la implementen las clases UnidadesProtoss y UnidadesTerran en vez de cada unidad (lo hice asi para que
//vean el metodo que se me ocurrio, a ver que les parece). Tambien habria que hacer que la barraca se
//cree directamente con una referencia al jugador (desde mi punto de viste los edificios deberian saber
//a quien pertenecen). Por ultimo, el hecho de que te deje poner a fabricar un marine a pesar de estar
//al limite de unidades es porque en el Starcraft te permite poolear unidades, o sea, hacer eso.