
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

	//changing font style of labels
	Font font = new Font("Verdana",Font.BOLD,12);

	// Create button to help perform computations
	Button buttonCompute = new Button("Compute");
			
			
	public void combinedChecked() {
		textfieldBe.setText("0.8");
		textfieldHv1.setText("1800");
		textfieldI.setText("500");
		textfieldA.setText("102.18");
		textfieldtransmitters.setText("0.5");
		
	}
	//This function updates form when compute solar bio is pressed
	public void computeAll(){ 
		double Wp;
			
		Wp = Double.parseDouble( textfieldWp.getText() );
		Mw1 = Double.parseDouble( textfieldMw1.getText() );
		Mw2 = Double.parseDouble( textfieldMw2.getText() );
		Cd = Double.parseDouble( textfieldCd.getText() );
		T1 = Double.parseDouble( textfieldT1.getText() );
		T2 = Double.parseDouble( textfieldT2.getText() );
		Cp = Double.parseDouble( textfieldCp.getText() );
		L = Double.parseDouble( textfieldL.getText() );
		textfieldBe.setText(textfieldBe.getText());
		Be = Double.parseDouble( textfieldBe.getText() );
		textfieldHv1.setText(textfieldHv1.getText());
		Hv1 = Double.parseDouble( textfieldHv1.getText() );
		textfieldI.setText(textfieldI.getText());
		I = Double.parseDouble( textfieldI.getText() );
		textfieldA.setText(textfieldA.getText());
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
	
	public void biomassChecked() {
		textfieldBe.setText("0.8");
		textfieldHv1.setText("1800");
		textfieldA.setText("---");
		textfieldI.setText("---");
		textfieldtransmitters.setText("---");
		
	}
			
	public void computeBiomass(){ 
		double Wp;
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
	
	public void solarChecked() {
		textfieldI.setText("500");
		textfieldA.setText("102.18");
		textfieldtransmitters.setText("0.5");
		textfieldBe.setText("---");
		textfieldHv1.setText("---");
	}
			
	public void computeSolar(){ 
		double Wp;
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
				
			
		
	public void addYellowLine(Frame frame) {
		for(int i=0; i<3; i++) {
		Label label = new Label();
		label.setBackground(Color.yellow);
		frame.add(label);
		}
	}
	
	public void addHeading(Frame frame, String heading) {
		Label yellolabel1 = new Label();
		yellolabel1.setBackground(Color.yellow);
		frame.add(yellolabel1);
		Label labelLheader = new Label(heading);
		labelLheader.setAlignment(Label.CENTER);
		labelLheader.setFont(font);
		labelLheader.setBackground(Color.yellow);
		frame.add(labelLheader);
		Label yellolabel2 = new Label();
		yellolabel2.setBackground(Color.yellow);
		frame.add(yellolabel2);
	}
			
			
	public void addRow(Frame frame,String rowTitle, TextField textfield, String rowUnit) {
		Label labela = new Label(rowTitle);			
		labela.setFont(font);
		frame.add(labela);
		frame.add(textfield);
		Label labelb = new Label(rowUnit);
		labelb.setFont(font);
		frame.add(labelb);
	}
				
	//This function creates the graphical user Interface(Form)
	public void GraphicalUserInterface()throws IOException{

		Frame frame = new Frame("All Modes");
		frame.setBackground(Color.gray);
		frame.setSize(new Dimension(700, 700));
			
		addYellowLine(frame);			
		addHeading(frame, "INPUT");
		
		Label labelBananWeight = new Label("Weight of the bananas (Wp)");
		labelBananWeight.setBackground(Color.yellow);
		labelBananWeight.setFont(font);
		frame.add(labelBananWeight);
				
		textfieldWp.setBackground(Color.white);
		textfieldWp.setForeground(Color.darkGray);
		frame.setLayout (new GridLayout(34,3));
		frame.add(textfieldWp);
				
		Label labelBananWeightUnit = new Label("kg");
		labelBananWeightUnit.setBackground(Color.yellow);
		labelBananWeightUnit.setFont(font);
		frame.add(labelBananWeightUnit);
				
		CheckboxGroup modeGroup = new CheckboxGroup();
		
		Checkbox chkSolar = new Checkbox("Solar",modeGroup,false);
		chkSolar.setBackground(Color.white);
		Checkbox chkBiomass = new Checkbox("Biomass",modeGroup,false);
		chkBiomass.setBackground(Color.white);
		Checkbox chkCombined = new Checkbox("Combined",modeGroup,false);
		chkCombined.setBackground(Color.white);
		
		chkSolar.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				solarChecked();
			}
		});
		chkBiomass.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				biomassChecked();
			}
		});
		chkCombined.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				combinedChecked();
			}
		});
		
		addHeading(frame, "Choose mode:");
		frame.add(chkSolar);
		frame.add(chkBiomass);
		frame.add(chkCombined);
		
		
		addYellowLine(frame);
		addYellowLine(frame);
				
		addRow(frame, "Initial moisture content (Mw\u2081)", textfieldMw1, "%w.b.");			
		addRow(frame, "Final moisture content (Mw\u2082)", textfieldMw2, "%w.b.");
		addRow(frame, "Specific heat of banana (Cd)", textfieldCd, "kJ/kg\u00b0C");
		addRow(frame, "Ambient temperature (T\u2082)", textfieldT1, "\u00b0C");
		addRow(frame, "Drier temperature (T\u2081)", textfieldT2, "\u00b0C");
		addRow(frame, "Specific heat of water (Cp)", textfieldCp, "kJ/kg\u00b0C");
		addRow(frame, "Latent heat of water (L)", textfieldL, "kJ/kg");
		addRow(frame, "Biomass stove efficiency (Be)", textfieldBe, "kJ/kg");
		addRow(frame, "Heating value of biomass (Hv\u2081)", textfieldHv1, "kJ/kg");
		addRow(frame, "solar radiation flux incident (I)", textfieldI, "w/m\u00b2");
		addRow(frame, "Surface Area (A)", textfieldA, "m\u00b2");
		addRow(frame, "Cover transmittance (T)", textfieldtransmitters, " ");
			
		addHeading(frame, "OUTPUT");
				
		textfieldWw.setText(String.valueOf(new Double(Ww)));
		textfieldWd.setText(String.valueOf(new Double(Wd)));
		textfieldTc.setText(String.valueOf(new Double(Tc)));
		textfieldMi.setText(String.valueOf(new Double(Mi)));
		textfieldQt.setText(String.valueOf(new Double(Qt)));
		textfieldQb.setText(String.valueOf(new Double(Qb)));
		textfieldM1.setText(String.valueOf(new Double(M1)));
		textfieldQin.setText(String.valueOf(new Double(M1)));
		textfieldt.setText(String.valueOf(new Double(t)));
		textfieldQavail.setText(String.valueOf(new Double(Qavail)));
				
		addRow(frame, "Moisture Removed(Ww)", textfieldWw, "kg");
		addRow(frame, "Dry Weight (Wd)", textfieldWd, "kg");
		addRow(frame, "Temperature Change (Tc)", textfieldTc, "\u00b0C");
		addRow(frame, "Initial Moisture d.b (Mi)", textfieldMi, "%d.b.");
		addRow(frame, "Total heat required (Qt)", textfieldQt, "kJ/kg");
		addRow(frame, "Biomass heat supply (Qb)", textfieldQb, "kJ/kg");
		addRow(frame, "Biomass weight (M\u2081)", textfieldM1, "kg");
		addRow(frame, "solar energy available (Qin)", textfieldQin, "kJ/kg");
		addRow(frame, "Time (t)", textfieldt, "Hrs");
		addRow(frame, "Total energy available (Qavail)", textfieldQavail, "kJ/kg");
			
				
		addYellowLine(frame);
		Label label = new Label();
		label.setBackground(Color.yellow);
		frame.add(label);
				
		buttonCompute.setBackground(Color.WHITE);
		buttonCompute.addActionListener(this);
		buttonCompute.setFont(font);
		
		buttonCompute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(chkSolar.getState() == true) {
					computeSolar();
				}else if(chkBiomass.getState() == true) {
					computeBiomass();
				}else if(chkCombined.getState()==true) {
					computeAll();
				}
			}
		});
		
		frame.add(buttonCompute);
				
		Label label1 = new Label();
		label1.setBackground(Color.yellow);
		frame.add(label1);
		addYellowLine(frame);
		addYellowLine(frame);
		frame.pack();
		frame.setVisible(true);
	}
			
			
			
			
	public static void main(String[] args) throws IOException {
				
		Combination combination = new Combination();
		combination.GraphicalUserInterface();			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
