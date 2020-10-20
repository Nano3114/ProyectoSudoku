package Logica;
import javax.swing.ImageIcon;

	public class EntidadGrafica {
		private ImageIcon grafico;
		
		
		public EntidadGrafica(){
			grafico=new ImageIcon();
			
		}
		
		public void actualizar(int valor) {
			if(valor<0)
				grafico=new ImageIcon(this.getClass().getResource("/img/sudoku"+Math.abs(valor)+"-error.jpg"));
			else
				if(valor==0)
					grafico=new ImageIcon(this.getClass().getResource("/img/vacio.png"));
				else
					grafico=new ImageIcon(this.getClass().getResource("/img/sudoku"+valor+".jpg"));
			
		}
		
		public void setImageIcon(ImageIcon i){
			grafico=i;	
		}
		
		public ImageIcon getImageIcon() {
			return grafico;
		}
		
	}
