package Logica;

import javax.swing.JLabel;

public class Grilla {
		private Celda [][] celdas;
		private int cantFilas=9;
		
		public Grilla() {
			int g=0;
			celdas=new Celda[cantFilas][cantFilas];
			for(int i=0;i<cantFilas;i++)
				for(int j=0;j<cantFilas;j++) {
					g=calcularGrilla(i,j);
					celdas[i][j]=new Celda(g,i,j);
					}
		}
		
		public int CantFilas() {
			return cantFilas;
		}
		
		public Celda getCelda(int i,int j){
			return celdas[i][j];
		}
		private int calcularGrilla(int i,int j) {
			int salida;
			if(i<3)
				if(j<3)
					salida=0;
				else
					if(j<6)
						salida=1;
				else
						salida=2;
			else
				if(i<6)
					if(j<3)
						salida=3;
					else
						if(j<6)
							salida=4;
						else
							salida=5;
				else
					if(j<3)
						salida=6;
					else
						if(j<6)
							salida=7;
						else
							salida=8;
					
			return salida;
		}
		
	
		public Celda[] getNroGrilla(int g) {
			Celda[] c=new Celda[9];
			int k=0;
			for(int i=0;i<cantFilas;i++)
				for(int j=0;j<cantFilas;j++) {
					if(celdas[i][j].getGrilla()==g) {
						c[k]=celdas[i][j];
						k=k+1;
					}
				}
			return c;
 		}



}
