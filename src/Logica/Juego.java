package Logica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Logica.Celda;
	public class Juego {	
		private int cantFilas;
		private Grilla  grilla;
		private Tiempo tiempo;
		
		public Juego() {
			cantFilas=9;		
			grilla=new Grilla();
					
			    
			tiempo=new Tiempo();
		}
		
		public int cantFilas() {
			return cantFilas;
		}
		
		public Grilla getGrilla() {
			return grilla;
		}
		
		public Tiempo getTiempo() {
			return tiempo;
		}



		public void accionar(Tiempo t) {
			t.actualizar();
			
		}
		public boolean esvalido(Celda celda) {
			
			boolean valido=false;
			int fila=celda.getCoorX(),columna=celda.getCoorY();
			if(verificarFila(fila))
				if(verificarCol(columna))
					if(verificaGrilla(celda.getGrilla()))
						valido=true;
						
			System.out.println(valido);			
			return valido;
		}	
		
		public boolean verificaGrilla(int grilla) {
			boolean [] b= {false,false,false,false,false,false,false,false,false};
			boolean cumple =true;
			int valor;
			Celda [] c=this.getGrilla().getNroGrilla(grilla);
			for(int i=0;i<c.length && cumple;i++) {
				
				valor=c[i].Valor();		
				if(valor>0 && valor<10) {
					if(b[valor-1]==false) {
						cumple=true;
						b[valor-1]=true;
					}
				else
					cumple=false;
				}
			}
			return cumple;	
		}	

		public boolean verificarFila(int i) {
			boolean [] b= {false,false,false,false,false,false,false,false,false};
			boolean cumple =true;
			int valor;

			for(int j=0;j<cantFilas() && cumple ;j++) {
				valor=this.getGrilla().getCelda(i, j).Valor();
				if(valor>0 && valor<10) {
					if(b[valor-1]==false) {
						cumple=true;
						b[valor-1]=true;
					}
					else
						cumple=false;
				}
			}	
			return cumple;	
		}
		
		public boolean verificarCol(int i) {
			boolean [] b= {false,false,false,false,false,false,false,false,false};
			int k=0;
			boolean cumple =true;
			int valor;
			for(int j=0;j<cantFilas() && cumple ;j++) {
				valor=this.getGrilla().getCelda(j, i).Valor();
				
				if(valor>0 && valor<10) {
					if(b[valor-1]==false) {
						cumple=true;
						b[valor-1]=true;
					}
					else
						cumple=false;
				}
			}
			return cumple;
			
		}
		
		

	}
