package fiuba.algo3.tpfinal.controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class AccionAcercaDe implements ActionListener {

	

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] opciones = {"Creadores", "Fecha De Creacion", "Corrector"};
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
	              "Verdana", Font.BOLD, 32)));
		String resultado = (String)JOptionPane.showInputDialog(
		                    null,
		                    "Seleccione la opcion:\n",
		                    "Acerca De \"TP Algoritmos 3 - FIUBA\"",
		                    JOptionPane.INFORMATION_MESSAGE,
		                    null,
		                    opciones,
		                    "Creadores");

		//ACA HAY MUCHOS IF, PERO NOS PARECIA INNECESARIO USAR ALGO CON POLIFORFISMO PARA ESTO
		if (resultado == "Creadores") {
			
		    JOptionPane.showMessageDialog(null,"Agustin Luques\n"
		    		+"Damian Cassinotti\n"
		    		+"Luciano Lopez", "Creadores", JOptionPane.PLAIN_MESSAGE);
		    
		}

		if (resultado == "Fecha De Creacion") {
			JOptionPane.showMessageDialog(null,"1er Cuatrimestre 2015", "Fecha", JOptionPane.PLAIN_MESSAGE);
		    
		}
		
		if (resultado == "Corrector"){
			JOptionPane.showMessageDialog(null,"Pablo Rodriguez Massuh", "Corrector", JOptionPane.PLAIN_MESSAGE);
		   
		}
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
	              "Verdana", Font.PLAIN, 11)));
	}

}
