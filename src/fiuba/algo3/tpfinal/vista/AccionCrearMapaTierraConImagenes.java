package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.management.GarbageCollectorMXBean;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.unidades.MarineVista;
import fiuba.algo3.tpfinal.vista.unidades.PruebaMarineVista;
import fiuba.algo3.tpfinal.vista.unidades.ZealotVista;

public class AccionCrearMapaTierraConImagenes implements ActionListener {

	private JLabel miCapa;
	
	public AccionCrearMapaTierraConImagenes(JLabel capa) {
		miCapa = capa;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Creo la ventanita del mapa
		JInternalFrame frame = new JInternalFrame("Mapa");
		frame.setSize(250, 250);
		frame.setResizable(true);
		frame.setLocation(50, 50);
		frame.setClosable(true);
		frame.setVisible(true);
		
		
		Mapa mapa;
		try {
			//creo el mapa
			mapa = new Mapa("mapaTierra_1.txt");
			int fila = mapa.getAlto();
			int columna = mapa.getAncho();
		
			
			
			//Esto iria en un hash
			ImageIcon imagenTierra = new ImageIcon("imagenes/tierra.png");
			ImageIcon imagenAire = new ImageIcon("imagenes/aire.png");
			ImageIcon imagenMineral = new ImageIcon("imagenes/mineral.png");
			ImageIcon imagenVespeno = new ImageIcon("imagenes/vespene.png");
			
			//Si el archivo no existe, lo creo
			if(!(new File("mapaTierra_1.png")).exists()){
			
				//creo la imagen en memoria
				
				BufferedImage img = new BufferedImage(mapa.getAlto()*50, mapa.getAncho()*50,
					    BufferedImage.TYPE_INT_RGB);
				
				Graphics2D graficos = img.createGraphics();
			
			
				
				//lleno esa imagen con las imagencitas del terreno, en la version definitiva, pediria 
				//al hash de imagenes
				for (int y=1;y<=fila;y++){
					for (int x=1;x<=columna;x++){
							Superficie sup = mapa.getParcela(new Coordenada(y,x)).getSuperficie();
							if (sup.equals(new Tierra())){
								graficos.drawImage(imagenTierra.getImage(), (x-1)*50, (y-1)*50, null);
														
							}
							if (sup.equals(new Aire())){
								graficos.drawImage(imagenAire.getImage(),  (x-1)*50, (y-1)*50, null);
							}
							if (sup.equals(new DepositoDeMinerales())){
								graficos.drawImage(imagenMineral.getImage(),  (x-1)*50, (y-1)*50, null);
							}
							if (sup.equals(new DepositoDeGas())){
								graficos.drawImage(imagenVespeno.getImage(),  (x-1)*50, (y-1)*50, null);
							}
					
					}
				}
				//creo el archivo con la imagen en memoria que tenia
				File f = new File("mapaTierra_1.png");
				ImageIO.write(img, "PNG", f);
			
				//setteo las variables en null y llamo al garbage collector (es una cagada, pero la 
				//imagen en memoria te come recursos a lo loco)
				img= null;
				graficos = null;
				System.gc();
				
			}
			JLayeredPane panelConCapas = new JLayeredPane();	
	
			panelConCapas.setPreferredSize(new Dimension (1250,1250));
			panelConCapas.setVisible(true);
		
				
				
			//creo la capa con la imagen del mapa
			ImageIcon imagenDelMapa = new ImageIcon("mapaTierra_1.png");
			JLabel label = new JLabel(imagenDelMapa);
		

			JPanel pirulo = new JPanel();
		    pirulo.setPreferredSize(new Dimension(1250, 1250));
		    pirulo.setSize(new Dimension(1250, 1250));
		    pirulo.setBounds(0, 0, 1250, 1250);
		    pirulo.setLayout(new GridLayout());
		    pirulo.setOpaque(false);
		    pirulo.add(label);
			
			
		    JPanel panelTerrestre = new JPanel();
	        panelTerrestre.setPreferredSize(new Dimension(1250, 1250));
	        panelTerrestre.setSize(new Dimension(1250, 1250));
	        panelTerrestre.setBounds(0, 0, 1250, 1250);
	        panelTerrestre.setLayout(new GridLayout(25,25));
	        panelTerrestre.setOpaque(false);

	
			
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(4,4),marine);
		
			
			
			Marine marine2 = new Marine();
			mapa.insertarUnidad(new Coordenada(3,3),marine2);
		
			
			Marine marine3 = new Marine();
			mapa.insertarUnidad(new Coordenada(1,2),marine3);
	
			Marine marine4 = new Marine();
			mapa.insertarUnidad(new Coordenada(1,1),marine4);
		
			
	
			//Este seria el imprimir del mapa, esta hardcodeado, pero aca usaria el hash
			 
			for(int y=1;y<=25;y++){
				for (int x=1;x<=25;x++){
					if (mapa.getParcela(new Coordenada(y,x)).estaVacia()){
						JPanel panel = new JPanel();
						Dimension tamanio = new Dimension(50, 50);
						panel.setPreferredSize(tamanio);
						panel.setVisible(false);
						panelTerrestre.add(panel);
					}else{
						if (mapa.getParcela(new Coordenada(y,x)).getOcupante().getClass()==(new Marine()).getClass()){
							PruebaMarineVista vistaMarine = new PruebaMarineVista();
							vistaMarine.setModelo((Marine) mapa.getParcela(new Coordenada(y,x)).getOcupante());
							
							panelTerrestre.add(vistaMarine);
							vistaMarine.setVisible(true);
					
							System.out.println("pase por aca");
						}
					}
					
				}
			}
			panelConCapas.add(pirulo);
			panelConCapas.add(panelTerrestre);
			panelConCapas.moveToFront(panelTerrestre);
			
			
			//la meto en el scrollpane
			JScrollPane panelMapaConScroll = new JScrollPane(panelConCapas);
			panelMapaConScroll.setLayout(new ScrollPaneLayout());
			panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(300, 0, 2*miCapa.getMaximumSize().width/5, miCapa.getMaximumSize().height/2);
		
	        frame.pack();
	        frame.setVisible(true);
	        miCapa.add(panelMapaConScroll);
			frame.setSelected(true);
			
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}//La creacion de la imagen del mapa iria en una clase aparte, a la cual uno le pasaria la dir del
//mapa y nos devuelve la imagen (obviamente buscaria primero la imagen del mapa en la carpeta del
//juego, asi si ya esta creada, no lo hace de nuevo).
