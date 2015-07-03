package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.util.HashMap;

@SuppressWarnings("serial")
public class HashColores extends HashMap<String, Color> {

	private HashMap<String, Color> hash = new HashMap<String, Color>();

	public HashColores() {

		hash.put("Rojo", Color.RED);
		hash.put("Azul", Color.BLUE);
		hash.put("Verde", Color.GREEN);

	}

	public Color get(String color) {
		return (hash.get(color));

	}
}