package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Color;
import java.awt.Image;

import fiuba.algo3.tpfinal.vista.HashImagenesConColor;

public class ImagenesParaAlucinacion {

	@SuppressWarnings("rawtypes")
	public Image obtener(Class clase,Color color){
		HashImagenesConColor imagenes = new HashImagenesConColor(color);
		HashNombreUnidades nombres = new HashNombreUnidades();
		return imagenes.get(nombres.get(clase));
	}
}
