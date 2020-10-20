package Logica;

import javax.swing.ImageIcon;

public class Tiempo {
	private int pseg;
	private int sseg;
	
	private int pmin;
	private int smin;
	
	private int phs;
	private int shs;
	
	private EntidadGrafica ipSeg; 
	private EntidadGrafica isSeg; 
	private EntidadGrafica ipMin; 
	private EntidadGrafica isMin; 
	private EntidadGrafica ipHs; 
	private EntidadGrafica isHs; 

	
	public Tiempo() {
		
		pseg=0;
		sseg=0;
		
		pmin=0;
		smin=0;
		
		phs=0;
		shs=0;
		
		ipSeg=new EntidadGrafica();
		isSeg=new EntidadGrafica();
		ipMin=new EntidadGrafica();
		isMin=new EntidadGrafica();
		ipHs=new EntidadGrafica();
		isHs=new EntidadGrafica();
			
	}	
	
	
	
	public void actualizar() {
		if(pseg<9) {
			pseg++;
		}
		else
			if(pseg==9){
				pseg=0;
				if(sseg<5)
					sseg++;
				else {
					sseg=0;
					if(pmin<9)
						pmin++;
					else {
						pmin=0;
						if(smin<5)
							smin++;
						else {
							smin=0;
							if(phs<9)
								phs++;
							else {
								phs=0;
								shs++;
						    }
						}
					}
			    }
			
			}
	}

	public String get_pminuto() {
		return ""+pmin;
	}
	public String get_sminuto() {
		return ""+smin;
	}
	public String get_psegundo() {
		return ""+pseg;
	}
	public String get_ssegundo() {
		return ""+sseg;
	}
	public String get_phora() {
		return ""+phs;
	}
	public String get_shora() {
		return ""+shs;
	}


	public void setprimerdigSeg(ImageIcon imageIcon) {
		ipSeg.setImageIcon(imageIcon);
	}

	public void setsegundodigSeg(ImageIcon imageIcon) {
		isSeg.setImageIcon(imageIcon);		
	}

	public void setsegundodigMin(ImageIcon imageIcon) {
		ipMin.setImageIcon(imageIcon);
	}

	public void setprimerdigMin(ImageIcon imageIcon) {
		isMin.setImageIcon(imageIcon);
	}

	public void setsprimerdigHora(ImageIcon imageIcon) {
		ipHs.setImageIcon(imageIcon);
	}

	public void setssegundodigHora(ImageIcon imageIcon) {
		isHs.setImageIcon(imageIcon);;
	}

	public ImageIcon getprimerdigSeg() {
		return ipSeg.getImageIcon();
	}

	public ImageIcon getsegundodigSeg() {
		return isSeg.getImageIcon();
	}

	public ImageIcon getsegundodigMin() {
		return ipMin.getImageIcon();
	}

	public ImageIcon getprimerdigMin() {
		return isMin.getImageIcon();
	}

	public ImageIcon getprimerdigHora() {
		return ipHs.getImageIcon();
	}

	public ImageIcon getsegundodigHora() {
		return isHs.getImageIcon();
	}
		
}
