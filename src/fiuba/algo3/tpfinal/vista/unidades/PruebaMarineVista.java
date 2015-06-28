package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;


public class PruebaMarineVista extends JPanel{
    private  int x;
    private  int y;
    private Image img;
    private Marine miModelo;

    public PruebaMarineVista(){
    	img = (new ImageIcon("imagenes/Golliat.png")).getImage();
    }
    public void setModelo(Marine marine){
    	this.miModelo = marine;
    	this.y = miModelo.getCoordenada().getFila();
    	this.x = miModelo.getCoordenada().getColumna();
    	Dimension tamanio = new Dimension(50, 50);
        setPreferredSize(tamanio);
      

    }

   public void paint(Graphics g) {
   
    
        g.drawImage(img,0,0, null);

   }

}
