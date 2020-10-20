package Logica;

import javax.swing.JLabel;

	public class Celda {
		private int valor;
		
		private int CoorX,CoorY;
		
		private EntidadGrafica entidad;
		private int grilla;
		private JLabel miJLabel;
		
		public Celda(int g,int x,int y){
			CoorX=x;
			CoorY=y;
			grilla=g;
			entidad=new EntidadGrafica();
		}
		
		public void setValor(int i) {
			valor=Math.abs(i);
			entidad.actualizar(i);
		}
		public int Valor() {
			return valor;
			
		}
		
		public void actualizar(){
			if(valor==9)
				valor=0;
			else
				valor=valor+1;
			
			entidad.actualizar(valor);
			
		}
		
		public void setJLabel(JLabel label) {
			miJLabel=label;
		}
		public JLabel getJLabel() {
			return miJLabel;
		}

		public EntidadGrafica getEntidadGrafica() {
			return entidad;
		}
		public void setEntidadGrafica(EntidadGrafica e) {
			entidad=e;
		}
		
		
		public int getGrilla() {
			return grilla;
		}
		
		public int getCoorX() {
			return CoorX;
		}
		public int getCoorY() {
			return CoorY;
		}
	}
