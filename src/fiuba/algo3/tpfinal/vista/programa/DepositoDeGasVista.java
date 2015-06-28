package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DepositoDeGasVista extends Vista {

	private Image img;
    
	public DepositoDeGasVista(){
    	img = (new ImageIcon("imagenes/vespene.png")).getImage();
    
	}


	  public void paint(Graphics g) {
		 
	    
	        g.drawImage(img,0,0,40,40, null);

	   }

}
