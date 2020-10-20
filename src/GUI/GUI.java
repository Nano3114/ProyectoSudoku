package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


import Logica.*;


@SuppressWarnings("serial")
public class GUI extends JFrame  {
	private Juego juego;
	
	
	private JPanel Manejo;
	private Timer relojito;
	private JPanel panelJuego,panelControl;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	
	//private JLabel [][]sudoku=new JLabel [9][9];
	private int [][] solucion=new int[9][9];
	JLabel otrolabel;
	JLabel otrolabe2;
	JLabel JLabelInicio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() {
		inicio();
		
	}

	private void inicio() {
		this.setSize(1200,700);

		Manejo = new JPanel();
		Manejo.setVisible(true);
		JLabelInicio=new JLabel();
		Manejo.add(JLabelInicio);
		
		JLabelInicio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Manejo.setVisible(false);
				empezar();
				crearSudoku();
				llenarSudoku();
				pintarBordes();
				liberarEspacios();

			
			}
		});
		JLabelInicio.setIcon(new ImageIcon(this.getClass().getResource("/img/inicio.gif")));
		
		getContentPane().add(Manejo);
		
	}
		
	private void empezar() {
		juego=new Juego();
		this.setSize(900,900);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelJuego = new JPanel();
		getContentPane().add(panelJuego,BorderLayout.CENTER);
		panelJuego.setLayout(new GridLayout(10,10));
				
		panelControl = new JPanel();
		getContentPane().add(panelControl, BorderLayout.EAST);
		
		
		//label que muestra los segundos		
		lblNewLabel = new JLabel("");
		panelControl.add(lblNewLabel);		
		lblNewLabel_1 = new JLabel("");
		panelControl.add(lblNewLabel_1);
		
		//label que muestra los minutos
		lblNewLabel_3 = new JLabel("");
		panelControl.add(lblNewLabel_3);		
		lblNewLabel_4 = new JLabel("");
		panelControl.add(lblNewLabel_4);
	
		//panelControl.add(textField);
		
		//label que muestra la hora		
		lblNewLabel_5 = new JLabel("");
		panelControl.add(lblNewLabel_3);		
		lblNewLabel_6 = new JLabel("");
		panelControl.add(lblNewLabel_4);
	 	Tiempo t = juego.getTiempo();
	 	
	   	otrolabel=new JLabel();
   		otrolabe2=new JLabel();

	 	
	 	relojito=new Timer(1000,new ActionListener(){
 			public void actionPerformed(ActionEvent e){ 		     	
 				
 				juego.accionar(t);	 				

 		   		//System.out.println(juego.getTiempo().get_pminuto()+"-"+juego.getTiempo().get_sminuto()+"-"+juego.getTiempo().get_psegundo()+"-"+juego.getTiempo().get_ssegundo());
 		   		 		   		
		   			   		
 		   		juego.getTiempo().setprimerdigSeg(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_psegundo()+".jpg")));
 		   		juego.getTiempo().setsegundodigSeg(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_ssegundo()+".jpg")));
 		   		juego.getTiempo().setsegundodigMin(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_sminuto()+".jpg")));
 		   		juego.getTiempo().setprimerdigMin(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_pminuto()+".jpg")));
 		   		juego.getTiempo().setsprimerdigHora(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_phora()+".jpg")));
 		   		juego.getTiempo().setssegundodigHora(new ImageIcon(getClass().getResource("/img/"+juego.getTiempo().get_shora()+".jpg")));

 		   		ImageIcon img_primerdigseg=juego.getTiempo().getprimerdigSeg();
 		   		ImageIcon img_segdigseg=juego.getTiempo().getsegundodigSeg();
 		   		ImageIcon img_segdigmin=juego.getTiempo().getsegundodigMin();
 		   		ImageIcon img_primerdigmin=juego.getTiempo().getprimerdigMin();
 		   		ImageIcon img_primerdighora=juego.getTiempo().getprimerdigHora();
 		   		ImageIcon img_segundodighora=juego.getTiempo().getsegundodigHora();
		   			   		
 		   		lblNewLabel_6.setIcon(img_segundodighora);
 		   		lblNewLabel_6.repaint();
		   		panelControl.add(lblNewLabel_6);
 		   		
 		   		lblNewLabel_5.setIcon(img_primerdighora);
 		   		lblNewLabel_5.repaint();
 		   		panelControl.add(lblNewLabel_5);
 		   		
		   		//-----------------------------------------------
 		   		ImageIcon otraimagen=new ImageIcon(getClass().getResource("/img/dospuntitos.jpg")); 		   		
 		   		 otrolabel.setIcon(otraimagen);
 		   		otrolabel.repaint();
		   		panelControl.add(otrolabel);
		   		//-----------------------------------------------

		   		
 		   	    lblNewLabel_3.setIcon(img_segdigmin);
	 		    lblNewLabel_3.repaint();
		   		panelControl.add(lblNewLabel_3); 		   		
		   		
		   		lblNewLabel_4.setIcon(img_primerdigmin);
		   		lblNewLabel_4.repaint();
		   		panelControl.add(lblNewLabel_4);
 		   		 
		   		//-----------------------------------------------
 		   		ImageIcon otraimagen2=new ImageIcon(getClass().getResource("/img/dospuntitos.jpg")); 		   		
 		   		 otrolabe2.setIcon(otraimagen2);
 		   		otrolabe2.repaint();
		   		panelControl.add(otrolabe2);
		   		//-----------------------------------------------
	 		   
		   		
		   		lblNewLabel_1.setIcon(img_segdigseg);
		   		lblNewLabel_1.repaint();
	 		    panelControl.add(lblNewLabel_1);
	 		   
	 		   lblNewLabel.setIcon(img_primerdigseg);
		   		lblNewLabel.repaint();
		   		panelControl.add(lblNewLabel);
 		   }});
	

	 	relojito.start();	

		
	}
	
	private void crearSudoku() {
				for(int x=0;x<9;x++)
					for(int y=0;y<9;y++) {
						
						juego.getGrilla().getCelda(x,y).setJLabel(new JLabel());
						Celda celda=juego.getGrilla().getCelda(x,y);
						
						juego.getGrilla().getCelda(x, y).getJLabel().addMouseListener(new MouseAdapter(){
							
							public void mouseClicked(MouseEvent e) {	
								celda.actualizar();
								if(juego.esvalido(celda))		{
									celda.getJLabel().setIcon(celda.getEntidadGrafica().getImageIcon());
									if(termine())
										fin();
									
									
								}
								else {
									celda.setValor((-1)*celda.Valor());
									celda.getJLabel().setIcon(celda.getEntidadGrafica().getImageIcon());
								}
								
							}

							
						});
						
						panelJuego.add(juego.getGrilla().getCelda(x,y).getJLabel());		
						
			        }
				
				//System.out.println("el sudoku es Correcto :   "+verificarCorrectitud());
	}

	protected boolean termine() {
		boolean si=true;;
		for(int i=0;i<juego.cantFilas() && si;i++)
			for(int j=0;j<juego.cantFilas() && si;j++)
				si=(juego.getGrilla().getCelda(i, j).Valor()==solucion[i][j]);
					
		return si;		
	}

	protected void fin() {
		panelJuego.setVisible(false);
		this.JLabelInicio.setIcon(new ImageIcon(this.getClass().getResource("/img/fin.gif")));
		this.JLabelInicio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}			
		});
		
		this.Manejo.setVisible(true);
		
	}

	private void liberarEspacios() {
		int valor;
		Random r=new Random();
		for(int i=0;i<juego.cantFilas();i++)
			for(int j=0;j<juego.cantFilas();j++) {

				valor=r.nextInt(100);
				if(valor<50) {
					juego.getGrilla().getCelda(i, j).setValor(0);
					juego.getGrilla().getCelda(i, j).getJLabel().setIcon(juego.getGrilla().getCelda(i, j).getEntidadGrafica().getImageIcon());
				}
			}
				
		
	}
	
	private void pintarBordes() {
		Color[] c= {Color.RED,Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY,Color.ORANGE,Color.BLUE,Color.PINK,Color.GREEN};
		for(int i=0;i<juego.cantFilas();i++) {
			for(int j=0;j<juego.cantFilas();j++) {
				juego.getGrilla().getCelda(i, j).getJLabel().setBorder(BorderFactory.createLineBorder(c[juego.getGrilla().getCelda(i, j).getGrilla()],3));
				juego.getGrilla().getCelda(i, j).getJLabel().setBackground(Color.BLACK);
				
			}
		}
		
	}
	/**
	private boolean verificarCorrectitud() {
		boolean cumple=true;
		for(int i=0;i<juego.cantFilas() && cumple;i++) {
			cumple=juego.verificarFila(i) && juego.verificarCol(i) ;
				
				
		}
		return cumple;
	}
	 */
	private void llenarSudoku() {
		InputStream  archivo = null;
	      BufferedReader br = null;
	      int valor;
	      
	      try {
	        
	         archivo =getClass().getResourceAsStream("sudoku1.txt");
	         //fr = new FileReader (archivo);
	         br = new BufferedReader(new InputStreamReader(archivo));

	         String linea;
	         int i=0;
	       
	         int leeNum=0;

	         while((linea=br.readLine())!=null) {
	        	 for(int j=0;j<juego.cantFilas();j++) {
	        		 valor=Integer.parseInt(""+linea.charAt(leeNum));
	        		 solucion[i][j]=valor;	        			 
	        		 juego.getGrilla().getCelda(i, j).setValor(valor);
	        		 if(juego.esvalido(juego.getGrilla().getCelda(i, j))) {
		        		 juego.getGrilla().getCelda(i, j).getJLabel().setIcon(juego.getGrilla().getCelda(i, j).getEntidadGrafica().getImageIcon());
	        		 	}
	        		 else {
		        		 juego.getGrilla().getCelda(i, j).setValor(-1*valor);
		        		 juego.getGrilla().getCelda(i, j).getJLabel().setIcon(juego.getGrilla().getCelda(i, j).getEntidadGrafica().getImageIcon());

	        		 }
	        		 //juego.getGrilla().getCelda(i,j).getEntidadGrafica().setImageIcon(new ImageIcon(getClass().getResource("/img/sudoku"+juego.getGrilla().getCelda(i,j).Valor()+".jpg")));
	        		 leeNum=leeNum+2; 
	        		 
	        	 }
	        	 
	        	 leeNum=0;
	        	 i++;
	       
	         }
	         
	      }
	      catch(Exception  e){
	    	  JOptionPane.showMessageDialog(null,"ERROR EN ARCHIVO.TXT ","ERROR",JOptionPane.ERROR_MESSAGE);
	    	  System.exit(0);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  
	      }
		
	}
	
}
