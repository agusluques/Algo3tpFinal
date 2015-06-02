package fiuba.algo3.tpfinal.programa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class Ambiente {
	
	
	private HashMap<Integer, Superficie> mapa;
	private int poblacion;
	
	
	
	public Ambiente() throws Exception{
		mapa = new HashMap<>();
		this.leerArchivoMapa();
		this.poblacion = 0;
	}
	
	//lee cada caracter del archivo y lo manda junto con su posicion a agregarAlMapa()
	private void leerArchivoMapa() throws Exception{
		String nombreFichero = "mapa1.txt";
		FileReader archivo = null;
		try{
			archivo = new FileReader(nombreFichero);
			int caracter = archivo.read();
			int posicion = 0;
			while(caracter != -1) {
				this.agregarAlMapa(posicion,(char)caracter);
				caracter = archivo.read();
				posicion ++;
			}
		}
		catch (FileNotFoundException e) {
			throw e;
        }
		catch (Exception e) {
			throw e;
        }
        finally {
        	try {
        		if(archivo != null)
                    archivo.close();
            }
            catch (Exception e) {
                throw e;
            }
        }
		
	}


	
	//agrega al HashMap las clases Aire y Tierra
	private void agregarAlMapa(int posicion, char caracter) {
		if (caracter == '0'){
			mapa.put(posicion, new Aire());
		}
		if (caracter == '1'){
			mapa.put(posicion, new Tierra());
		}
		
		
	}


	public Boolean mapaEstaVacio(){
		return (this.poblacion == 0);
	}

	public int cantidadDePoblacion() {
		return this.poblacion;
	}

	public HashMap<Integer, Superficie> getMapa(){
		return mapa;
	}


	
	
	
}
