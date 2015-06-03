package fiuba.algo3.tpfinal.programa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import fiuba.algo3.tpfinal.unidades.Atacable;

 

public class Ambiente {
	
	
	private HashMap<Coordenada, Parcela> mapa;
	int fila = 1;
	BufferedReader buffer = null;

	public Ambiente(String dirDelMapa) throws Exception{
		mapa = new HashMap<>();
		this.leerArchivoMapa(dirDelMapa);
	}	
	
		
	//lee cada caracter del archivo y lo manda junto con su posicion a agregarAlMapa()
	private void leerArchivoMapa(String dirDelMapa) throws Exception{
		
		try {

			String lineaActual;
			buffer = new BufferedReader(new FileReader(dirDelMapa));

			while ((lineaActual = buffer.readLine()) != null) {
				for (int columna= 1;columna <= lineaActual.length();columna++){
					Coordenada coord = new Coordenada(fila,columna);
					this.agregarAlMapa(coord,lineaActual.charAt(columna-1));
				}
				fila++;
			}

		}catch (FileNotFoundException e) {
			throw e;
        } 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null)buffer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	
	//agrega al HashMap las clases Aire y Tierra
	private void agregarAlMapa(Coordenada coord, char caracter) {
		if (caracter == '0'){
			Parcela parcela = new Parcela(new Aire());
			mapa.put(coord, parcela);
		}
		if (caracter == '1'){
			Parcela parcela = new Parcela(new Tierra());
			mapa.put(coord, parcela);
		}
		if (caracter == '2'){
			Parcela parcela = new Parcela(new DepositoDeMinerales());
			mapa.put(coord, parcela);
		}
		if (caracter == '3'){
			Parcela parcela = new Parcela(new DepositoDeGas());
			mapa.put(coord, parcela);
		}
		
		
	}


	public Boolean mapaEstaVacio(){
		
		for (Parcela parcela : mapa.values()) {
			if (!parcela.estaVacia()){
				return false;				
			}
		}
		return true;
	}


	public HashMap<Coordenada, Parcela> getMapa(){
		return mapa;
	}


	public void insertarUnidad(Coordenada coord, Atacable unidad) {
		
		(mapa.get(coord)).ocupar(unidad);
		
	}

	public Parcela gerParcela(Coordenada coord) {
		
		return mapa.get(coord);
	}

	
	
}
