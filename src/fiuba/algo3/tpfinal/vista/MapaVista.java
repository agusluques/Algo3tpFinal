package fiuba.algo3.tpfinal.vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Tierra;

@SuppressWarnings("serial")
public class MapaVista extends JPanel {
	
	JFrame ventanaPrincipal;
	HashMap<Class<?>, Class<?>> generadorDeParcelas;
	Mapa miMapa;
	
	public MapaVista(Mapa mapa) throws Exception {
	
		miMapa = mapa;
		
		setBounds(0, 0, miMapa.getAncho(), miMapa.getAlto());
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(miMapa.getAncho(), miMapa.getAlto()));
		
		this.generarVistaDeParcelas();
		this.imprimirMapa();
	}

	public void imprimirMapa() throws InstantiationException, IllegalAccessException {
		int ancho = miMapa.getAncho();
		int alto = miMapa.getAlto();
		
		for(int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++){
				Coordenada posicionActual = new Coordenada(i,j);
				Parcela parcelaActual = miMapa.getParcela(posicionActual);
				Class<?> claseVista = generadorDeParcelas.get(parcelaActual.getSuperficie().getClass());
				SuperficieVista vista = (SuperficieVista) claseVista.newInstance();
				this.add(vista);
			}
		}
	}

	private void generarVistaDeParcelas () {
		generadorDeParcelas = new HashMap<Class<?>, Class<?>>();
		generadorDeParcelas.put(Tierra.class, TierraVista.class);
		generadorDeParcelas.put(DepositoDeMinerales.class, DepositoDeMineralesVista.class);
		generadorDeParcelas.put(DepositoDeGas.class, DepositoDeGasVista.class);
		generadorDeParcelas.put(Aire.class, AireVista.class);
	}
}
