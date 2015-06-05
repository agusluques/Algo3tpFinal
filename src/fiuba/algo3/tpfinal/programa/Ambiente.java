package fiuba.algo3.tpfinal.programa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.MapaInvalido;

 

public class Ambiente {
	
	
	private HashMap<Coordenada, Parcela> mapa;
	

	public Ambiente(String dirDelMapa) throws Exception{
		mapa = new HashMap<>();
		this.leerArchivoMapa(dirDelMapa);
		if (!this.mapaEsCorrecto()) {
			throw new MapaInvalido();
		}
	}	
	
		
	//lee cada caracter del archivo y lo manda junto con su posicion a agregarAlMapa()
	private void leerArchivoMapa(String dirDelMapa) throws Exception{
		
		BufferedReader buffer = null;
		int fila = 1;
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


	
	public void insertarUnidad(Coordenada coord, Atacable unidad) {
		
		(mapa.get(coord)).ocupar(unidad);
		
	}

	public Parcela getParcela(Coordenada coord) {
		
		return mapa.get(coord);
	}


	public int getAncho() {
		Set<Coordenada> coordenadas = mapa.keySet();
		Iterator<Coordenada> iterador = coordenadas.iterator();
		int anchoMax = 0;
		while (iterador.hasNext()) {
			Coordenada coordenadaActual = iterador.next();
			if (anchoMax < coordenadaActual.getColumna()) {
				anchoMax = coordenadaActual.getColumna();
			}
		}
		return anchoMax;
	}
	
	public int getAlto() {
		Set<Coordenada> coordenadas = mapa.keySet();
		Iterator<Coordenada> iterador = coordenadas.iterator();
		int altoMax = 0;
		while (iterador.hasNext()) {
			Coordenada coordenadaActual = iterador.next();
			if (altoMax < coordenadaActual.getFila()) {
				altoMax = coordenadaActual.getFila();
			}
		}
		return altoMax;
	}
	
	private boolean mapaEsCorrecto() {

		int ancho = this.getAncho();
		int alto = this.getAlto();

		// Primer cuarto
		Coordenada coordenadaInicial = new Coordenada(1,1);
		Coordenada coordenadaFinal = new Coordenada(alto/2, ancho/2);
		int cantidadDeBases1 = this.contarBases(coordenadaInicial, coordenadaFinal);

		// Segundo cuarto
		coordenadaInicial = new Coordenada(1, ancho/2 + 1);
		coordenadaFinal = new Coordenada(alto/2, ancho);
		int cantidadDeBases2 = this.contarBases(coordenadaInicial, coordenadaFinal);

		// Tercer cuarto
		coordenadaInicial = new Coordenada(alto/2 + 1, 1);
		coordenadaFinal = new Coordenada(alto, ancho/2);
		int cantidadDeBases3 = this.contarBases(coordenadaInicial, coordenadaFinal);
		

		// Cuarto cuarto
		coordenadaInicial = new Coordenada(alto/2 + 1, ancho/2 + 1);
		coordenadaFinal = new Coordenada(alto, ancho);
		int cantidadDeBases4 = this.contarBases(coordenadaInicial, coordenadaFinal);
		
		System.out.println(cantidadDeBases1);
		System.out.println(cantidadDeBases2);
		System.out.println(cantidadDeBases3);
		System.out.println(cantidadDeBases4);
		return (cantidadDeBases1 > 0
				&& cantidadDeBases1 == cantidadDeBases2
				&& cantidadDeBases1 == cantidadDeBases3
				&& cantidadDeBases1 == cantidadDeBases4);

	}
	
	private int contarBases(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		int cantidadDeMinerales = 0;
		int cantidadDeVolcanes = 0;
		int cantidadDeBases = 0;
		for (int i = coordenadaInicial.getFila(); i <= coordenadaFinal.getFila(); i++) {
			for (int j = coordenadaInicial.getColumna(); j <= coordenadaFinal.getColumna(); j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = this.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(
						new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales >= 8 && cantidadDeVolcanes == 1) {
					cantidadDeBases += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}
		return cantidadDeBases;
	}

	
	
}
