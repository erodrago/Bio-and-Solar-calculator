
/*
		 Consider the following Parameters	where;
		 
		 
		Wp  =   Weight of bananas (Kg)	
		Mw1  =   initial moisture content	(%w.b.)
		Mw2  =   final moisture content (%w.b.)
		Cd  =   specific heat of banana (kJ/kg0C)
		T2  =   Drier temperature (0C)          
		T1  =   Ambient temperature	(0C)
		Cp  =   Specific heat of water	(kJ/kg0C)
		L   =   Latent heat of water	(kJ/kg)
		A   =   Surface Area (m2)	
	        I   =   solar radiation flux incident (w/m2)
	        t   =   Number of hour (hr)

        
	        Ww  =   Moisture removed	
	        Wd  =   Dry weight of bananas	
	        Tc  =   Change in temperature	
	        Mi  =   initial moisture content d.b.	
	        Qt  =   Total heat required	
	        Qin  =   solar energy available	
*/


import java.io.*;
import java.text.AttributedString;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.font.TextAttribute;



public class Combination extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declare and initiate some Global variables within the class
	double Mw1	= 80;	
	double Mw2	= 15;	
	double Cd	= 3.35;
	double T2	= 60;
	double T1	= 25;
	double Cp	= 4.2;
	double L	= 2264.76;
	double Be	= 0.8;	
	double Hv1	= 18000;
	double A	= 102.18;	
	double I	= 500;
	double T    = 0.5;
	double t, M1, Ww, Wd, Tc, Mi, Qt, Qin, Qb, Qavail;
	
	
	// Create textFields to display data on the form
	TextField textfieldWp = new TextField();
	TextField textfieldWw = new TextField();
	TextField textfieldWd = new TextField();
	TextField textfieldTc = new TextField();
	TextField textfieldMi = new TextField();
	TextField textfieldQt = new TextField();
	TextField textfieldQb = new TextField();
	TextField textfieldM1 = new TextField();
	TextField textfieldQin = new TextField();
	TextField textfieldt = new TextField();
	TextField textfieldQavail = new TextField();
	
	TextField textfieldMw1 = new TextField("80");
	TextField textfieldMw2 = new TextField("15");
	TextField textfieldCd = new TextField("3.35");
	TextField textfieldT1 = new TextField("25");
	TextField textfieldT2 = new TextField("60");
	TextField textfieldCp = new TextField("4.2");
	TextField textfieldL = new TextField("2264.76");
		
	TextField textfieldBe = new TextField("0.8");
	TextField textfieldHv1 = new TextField("1800");
	TextField textfieldI = new TextField("500");
	TextField textfieldA = new TextField("102.18");
	TextField textfieldtransmitters = new TextField("0.5");
			
	// Create button to help perform computations
	Button buttonComputeS = new Button("Compute(Solar mode)");
	Button buttonComputeB = new Button("Compute(Biomass mode)");
	Button buttonComputeSB = new Button("Compute(Solar&Biomass mode)");
			
			
			
	//This function updates the contents of the form
	public void formUpdateBS(){ 
		double Wp;
			
		Wp = Double.parseDouble( textfieldWp.getText() );
		Mw1 = Double.parseDouble( textfieldMw1.getText() );
		Mw2 = Double.parseDouble( textfieldMw2.getText() );
		Cd = Double.parseDouble( textfieldCd.getText() );
		T1 = Double.parseDouble( textfieldT1.getText() );
		T2 = Double.parseDouble( textfieldT2.getText() );
		Cp = Double.parseDouble( textfieldCp.getText() );
		L = Double.parseDouble( textfieldL.getText() );
		textfieldBe.setText("0.8");
		Be = Double.parseDouble( textfieldBe.getText() );
		textfieldHv1.setText("1800");
		Hv1 = Double.parseDouble( textfieldHv1.getText() );
		textfieldI.setText("500");
		I = Double.parseDouble( textfieldI.getText() );
		textfieldA.setText("102.18");
		A = Double.parseDouble( textfieldA.getText() );
		T = Double.parseDouble(textfieldtransmitters.getText());
				
				
				
				
				
				
		// Compute Moisture removed Ww
		
		Ww = (Wp*(Mw1-Mw2)/(100-Mw2));
			
		// Compute dry weight
		Wd = Wp - Ww;
				
		// Compute Change in temperature
        
		Tc = T2 - T1;
				
		// Compute initial moisture content d.b.

		Mi = (Mw1/(100-Mw1))*100;
				
		// Compute Total heat required
				

		Qt = Wd*Cd*Tc + Mi*Cp*Tc + Ww*L;
		// Qt should be equal to Qin = Qb
		Qb = Qt;
		Qin = Qt;

		// Compute Biomass heat supply
			
		Qavail = 0.5*(Qb + Qin);

		M1 = 0.5*(Qb/(Be*Hv1));
				
		// Compute Biomass heat supply

		t = 0.5*(Qin/(A*I*T));
				
				
					
		textfieldWp.setText(String.valueOf(new Double(Wp)));	
		textfieldWw.setText(String.valueOf(new Double(Ww)));
		textfieldWd.setText(String.valueOf(new Double(Wd)));
		textfieldTc.setText(String.valueOf(new Double(Tc)));
		textfieldMi.setText(String.valueOf(new Double(Mi)));
		textfieldQt.setText(String.valueOf(new Double(Qt)));
		textfieldQb.setText(String.valueOf(new Double(Qb)));
		textfieldM1.setText(String.valueOf(new Double(M1/10)));
		textfieldQin.setText(String.valueOf(new Double(Qin)));
		textfieldt.setText(String.valueOf(new Double(t)));
		textfieldQavail.setText(String.valueOf(new Double(Qavail)));
	}
			
	public void formUpdateB(){ 
		double Wp;
		textfieldBe.setText(textfieldBe.getText());
		textfieldHv1.setText(textfieldHv1.getText());
				
		Wp = Double.parseDouble( textfieldWp.getText() );
		Mw1 = Double.parseDouble( textfieldMw1.getText() );
		Mw2 = Double.parseDouble( textfieldMw2.getText() );
		Cd = Double.parseDouble( textfieldCd.getText() );
		T1 = Double.parseDouble( textfieldT1.getText() );
		T2 = Double.parseDouble( textfieldT2.getText() );
		Cp = Double.parseDouble( textfieldCp.getText() );
		L = Double.parseDouble( textfieldL.getText() );
		Be = Double.parseDouble( textfieldBe.getText() );
		Hv1 = Double.parseDouble( textfieldHv1.getText() );
			
		textfieldQin.setText("---");
		textfieldt.setText("---");
		textfieldQavail.setText("---");
		textfieldA.setText("---");
		textfieldI.setText("---");
		textfieldtransmitters.setText("---");
		// Compute Moisture removed Ww
				
		Ww = (Wp*(Mw1-Mw2)/(100-Mw2));
						
		// Compute dry weight
		Wd = Wp - Ww;
						
		// Compute Change in temperature
				        
		Tc = T2 - T1;
						
		// Compute initial moisture content d.b.

		Mi = (Mw1/(100-Mw1))*100;
						
		// Compute Total heat required
						

		Qt = Wd*Cd*Tc + Mi*Cp*Tc + Ww*L;
		// Qt should be equal to Qin
		Qb = Qt;
						
		// Compute Biomass heat supply

		M1 = Qb/(Be*Hv1);
						
				
				
				
		textfieldWp.setText(String.valueOf(new Double(Wp)));	
		textfieldWw.setText(String.valueOf(new Double(Ww)));
		textfieldWd.setText(String.valueOf(new Double(Wd)));
		textfieldTc.setText(String.valueOf(new Double(Tc)));
		textfieldMi.setText(String.valueOf(new Double(Mi)));
		textfieldQt.setText(String.valueOf(new Double(Qt)));
		textfieldQb.setText(String.valueOf(new Double(Qb)));
		textfieldM1.setText(String.valueOf(new Double(M1)));
	}
			
	public void formUpdateS(){ 
		double Wp;
		textfieldI.setText(textfieldI.getText());
		textfieldA.setText(textfieldA.getText());
		Wp = Double.parseDouble( textfieldWp.getText() );
		Mw1 = Double.parseDouble( textfieldMw1.getText() );
		Mw2 = Double.parseDouble( textfieldMw2.getText() );
		Cd = Double.parseDouble( textfieldCd.getText() );
		T1 = Double.parseDouble( textfieldT1.getText() );
		T2 = Double.parseDouble( textfieldT2.getText() );
		Cp = Double.parseDouble( textfieldCp.getText() );
		L = Double.parseDouble( textfieldL.getText() );
		A = Double.parseDouble( textfieldA.getText() );
		I = Double.parseDouble( textfieldI.getText() );
		T = Double.parseDouble(textfieldtransmitters.getText());
		textfieldBe.setText("---");
		textfieldHv1.setText("---");
			
				
		// Compute Moisture removed Ww
				
		Ww = (Wp*(Mw1-Mw2)/(100-Mw2));
						
		// Compute dry weight
		Wd = Wp - Ww;
						
		// Compute Change in temperature
				        
		Tc = T2 - T1;
						
		// Compute initial moisture content d.b.

		Mi = (Mw1/(100-Mw1))*100;
						
		// Compute Total heat required
						

		Qt = Wd*Cd*Tc + Mi*Cp*Tc + Ww*L;
		// Qt should be equal to Qin
		Qin = Qt;
				
		// Compute Biomass heat supply

		t = Qin/(A*I*T);
						
				
				
				
				
		textfieldWw.setText(String.valueOf(new Double(Ww)));
		textfieldWd.setText(String.valueOf(new Double(Wd)));
		textfieldTc.setText(String.valueOf(new Double(Tc)));
		textfieldMi.setText(String.valueOf(new Double(Mi)));
		textfieldQt.setText(String.valueOf(new Double(Qt)));
		textfieldQin.setText(String.valueOf(new Double(Qin)));
		textfieldt.setText(String.valueOf(new Double(t)));
		textfieldQb.setText("---");
		textfieldM1.setText("---");
		textfieldQavail.setText("---");
	}
				
			
	//This function updates the contents of the form upon the button click
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();	    // to know which Java button user clicked
		System.out.println("You clicked " + str + " button");  // just beginner's interest

		if(str.equals("Compute(Solar mode)")){
			formUpdateS();
		}
		else if(str.equals("Compute(Biomass mode)")){
			formUpdateB();
		}
		else if(str.equals("Compute(Solar&Biomass mode)")){
			formUpdateBS();
		}
				
	}	
			
			
				
			public void ConsoleOutput(){


				//Displaying the Results as the output
				System.out.println("M1 = " +M1 +" Kg");
				System.out.println("Ww = " +Ww +" Kg");
				System.out.println("Wd = " +Wd +" Kg");
				System.out.println("Tc = " + Tc +" deg Celc");
				System.out.println("Mi = " + Mi +" %d.b.");
				System.out.println("Qt = " + Qt +" kJ/kg");
				System.out.println("Qb = " + Qb +" kJ/kg");
				System.out.println("Tc = " + Tc +" deg Celc");
				System.out.println("Qin = " + Qin +" kJ/kg");
				System.out.println("T = " + t +" Hrs");
				System.out.println("Qavail = " + Qavail +" kJ/kg");
			}
				
			//This function creates the graphical user Interface(Form)
			public void GraphicalUserInterface()throws IOException{

				Frame frame = new Frame("All Modes");
				frame.setBackground(Color.gray);
				frame.setPreferredSize(new Dimension(700, 700));
				
				Label labelA = new Label();
				labelA.setBackground(Color.yellow);
				Label labelB = new Label();
				labelB.setBackground(Color.yellow);
				Label labelC = new Label();
				labelC.setBackground(Color.yellow);
				
				
				buttonComputeB.setBackground(Color.WHITE);
				buttonComputeS.setBackground(Color.WHITE);
				buttonComputeSB.setBackground(Color.WHITE);
				
				
				buttonComputeS.addActionListener(this);
				buttonComputeB.addActionListener(this);
				buttonComputeSB.addActionListener(this);
			  
				Label labelD = new Label();
				labelD.setBackground(Color.yellow);
				Label labelE = new Label();
				labelE.setBackground(Color.yellow);
				Label labelF = new Label();
				labelF.setBackground(Color.yellow);
				
				Label labelG = new Label();
				labelG.setBackground(Color.yellow);
				Label labelH = new Label();
				labelH.setBackground(Color.yellow);
				Label labelI = new Label();
				labelI.setBackground(Color.yellow);
				Label labelJ = new Label();
				labelJ.setBackground(Color.yellow);
				
				Label labelK = new Label();
				labelK.setBackground(Color.yellow);
				Label labelL = new Label("INPUT");
				 labelL.setAlignment(Label.CENTER); 
				labelL.setBackground(Color.yellow);
				Label labelM = new Label();
				labelM.setBackground(Color.yellow);
				
				
				
				Label labela = new Label("Initial moisture content (Mw\u2081)");
				Label labelb = new Label("%w.b.");
				Label labelc = new Label("Final moisture content (Mw\u2082)");
				Label labeld = new Label("%w.b.");
				Label labele = new Label("Specific heat of banana (Cd)");
				Label labelf = new Label("kJ/kg\u00b0C");
				Label labelg = new Label("Ambient temperature (T\u2082)");
				Label labelh = new Label("\u00b0C");
				Label labeli = new Label("Drier temperature (T\u2081)");
				Label labelj = new Label("\u00b0C");
				Label labelk = new Label("Specific heat of water (Cp)");
				Label labell = new Label("kJ/kg\u00b0C");
				Label labelm = new Label("Latent heat of water (L)");
				Label labeln = new Label("kJ/kg");
				Label labelo = new Label("Biomass stove efficiency (Be)");
				Label labelp = new Label("kJ/kg");
				Label labelq = new Label("Heating value of biomass (Hv\u2081)");
				Label labelr = new Label("kJ/kg");
				Label labels = new Label("solar radiation flux incident (I)");
				Label labelt = new Label("w/m\u00b2");
				Label labelu = new Label("Surface Area (A)");
				
				Label labelv = new Label("m\u00b2");
				Label labelw = new Label();
				Label transmitterslabel = new Label("Cover transmittance (T)");
				Label labeltr = new Label("");
				labelw.setBackground(Color.yellow);
				Label labelx = new Label();
				labelx.setBackground(Color.yellow);
				Label labely = new Label();
				labely.setBackground(Color.yellow);
				
				Label labelz = new Label();
				labelz.setBackground(Color.yellow);
				Label labelza = new Label("OUTPUT");
				labelza.setAlignment(Label.CENTER);
				labelza.setBackground(Color.yellow);
				Label labelzb = new Label();
				labelzb.setBackground(Color.yellow);
				Label labelzc = new Label();
				labelzc.setBackground(Color.yellow);
				Label labelzc1 = new Label();
				labelzc1.setBackground(Color.yellow);
				
				
				
				textfieldWp.setForeground(Color.darkGray);
				
				
				textfieldWp.setBackground(Color.white);
				frame.setLayout (new GridLayout(30,3));
				
				
				
				Label label1 = new Label("Weight of the bananas (Wp)");
				label1.setBackground(Color.yellow);
				Label label11 = new Label("kg");
				label11.setBackground(Color.yellow);
				Label label2 = new Label("Moisture Removed(Ww)");
				textfieldWw.setText(String.valueOf(new Double(Ww)));
				Label label22 = new Label("kg");
				Label label3 = new Label("Dry Weight (Wd)");
				textfieldWd.setText(String.valueOf(new Double(Wd)));
				Label label33 = new Label("kg");
				Label label4 = new Label("Temperature Change (Tc)");
				textfieldTc.setText(String.valueOf(new Double(Tc)));
				Label label44 = new Label("\u00b0C");
				Label label5 = new Label("Initial Moisture d.b (Mi)");
				textfieldMi.setText(String.valueOf(new Double(Mi)));
				Label label55 = new Label("%d.b.");
				Label label6 = new Label("Total heat required (Qt)");
				textfieldQt.setText(String.valueOf(new Double(Qt)));
				Label label66 = new Label("kJ/kg");
				Label label7 = new Label("Biomass heat supply (Qb)");
				textfieldQb.setText(String.valueOf(new Double(Qb)));
				Label label77 = new Label("kJ/kg");
				Label label8 = new Label("Biomass weight (M\u2081)");
				textfieldM1.setText(String.valueOf(new Double(M1)));
				Label label88 = new Label("kg");
				Label label30 = new Label("solar energy available (Qin)");
				textfieldQin.setText(String.valueOf(new Double(M1)));
				Label label31 = new Label("kJ/kg");
				Label label32 = new Label("Time (t)");
				textfieldt.setText(String.valueOf(new Double(t)));
				Label label34 = new Label("Hrs");
				Label label35 = new Label("Total energy available (Qavail)");
				textfieldQavail.setText(String.valueOf(new Double(Qavail)));
				Label label36 = new Label("kJ/kg");
				Label label99 = new Label();
				label99.setBackground(Color.yellow);
				
				
				frame.add(labelK);
				frame.add(labelL);
				frame.add(labelM);
				frame.add(label1);
				frame.add(textfieldWp);
				
				frame.add(label11);
				
				
				
				frame.add(labelA);
				frame.add(labelB);
				frame.add(labelC);
				frame.add(labela);
				
				frame.add(textfieldMw1);
				frame.add(labelb);
				frame.add(labelc);
				frame.add(textfieldMw2);
				frame.add(labeld);
				frame.add(labele);
				frame.add(textfieldCd);
				frame.add(labelf);
				frame.add(labelg);
				frame.add(textfieldT1);
				frame.add(labelh);
				frame.add(labeli);
				frame.add(textfieldT2);
				frame.add(labelj);
				frame.add(labelk);
				frame.add(textfieldCp);
				frame.add(labell);
				frame.add(labelm);
				frame.add(textfieldL);
				frame.add(labeln);
				frame.add(labelo);
				frame.add(textfieldBe);
				frame.add(labelp);
				frame.add(labelq);
				frame.add(textfieldHv1);
				frame.add(labelr);
				frame.add(labels);
				frame.add(textfieldI);
				frame.add(labelt);
				frame.add(labelu);
				frame.add(textfieldA);
				

				frame.add(labelv);
				frame.add(transmitterslabel);
				frame.add(textfieldtransmitters);
				frame.add(labeltr);
				frame.add(labelw);

				
//				frame.add(labelx);
//				frame.add(labely);
//				frame.add(labelz);
				frame.add(labelza);
				frame.add(labelzb);
				frame.add(label2);
				frame.add(textfieldWw);
				frame.add(label22);
				frame.add(label3);
				frame.add(textfieldWd);
				frame.add(label33);
				frame.add(label4);
				frame.add(textfieldTc);
				frame.add(label44);
				frame.add(label5);
				frame.add(textfieldMi);
				frame.add(label55);
				frame.add(label6);
				frame.add(textfieldQt);
				frame.add(label66);
				frame.add(label7);
				frame.add(textfieldQb);
				frame.add(label77);
				frame.add(label8);
				frame.add(textfieldM1);
				frame.add(label88);
				frame.add(label30);
				frame.add(textfieldQin);
				frame.add(label31);
				frame.add(label32);
				frame.add(textfieldt);
				frame.add(label34);
				frame.add(label35);
				frame.add(textfieldQavail);
				frame.add(label36);
				frame.add(labelD);
				frame.add(labelE);
				frame.add(labelF);
				frame.add(buttonComputeS);
				frame.add(buttonComputeB);
				frame.add(buttonComputeSB);
				frame.add(label99);
				
				frame.add(labelG);
				frame.add(labelH);
				
				frame.add(labelI);
				frame.add(labelJ);
				frame.add(labelzc1);
				frame.pack();
				frame.setVisible(true);
			}
			
			
			
			
	public static void main(String[] args) throws IOException {
				
		Combination combination = new Combination();
		combination.GraphicalUserInterface();
				
				
	}
				
	public Combination(){

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			        System.exit(0); 
			}
		   });
	}
			
}
