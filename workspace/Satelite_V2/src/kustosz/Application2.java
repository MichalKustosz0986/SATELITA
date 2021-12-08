package kustosz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Application2 extends JFrame implements ActionListener{

	private JButton bStart;
	static double velocityVectorLongnes = 150;
	
	public Application2() {

		setSize(300, 50);
		setTitle(" satelita ");
		setLayout(null);
		
		
		bStart = new JButton("Uruchom mnie z konsoli komenda: java -jar sat_v2.jar ");
		bStart.setBackground(Color.red);
		bStart.setBounds(0, 0, 450, 70);
		bStart.addActionListener(this);
		add(bStart);
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		Circle satelite = new Circle();
		Circle sun = new Circle();
		Canvas c = Canvas.getCanvas();
		c.setAlwaysOnTop(true);
		
		SliderFrame sliderX = new SliderFrame(); 
		sliderX.setTitle("X_position");
		sliderX.setVisible(true);
		sliderX.setAlwaysOnTop(true);
		sliderX.setBounds(1100, 50, 300, 150);
		
		SliderFrame sliderY = new SliderFrame(); 
		sliderY.setTitle("Y_position");
		sliderY.setVisible(true);
		sliderY.setAlwaysOnTop(true);
		sliderY.setBounds(1100, 250, 300, 150);
		
		Application2 frameButon = new Application2();
		frameButon.setAlwaysOnTop(true);
		frameButon.setVisible(true);
		frameButon.setBounds(1100, 450, 450, 100);
		
		
		int t = 0;
		double dt = 1e-2;
		
//		double xSatelitePosition = sliderX.getSliderValue()*10;
//		double ySatelitePosition = sliderY.getSliderValue()*10;
		Scanner scan = new Scanner(System.in);
		System.out.println("**************************************************************");
		System.out.println("************punkt (0,0)>>>> lewy gorny rog ekranu*************");
		System.out.println("**************************************************************");
		
		System.out.println("podaj Xposition zakres [0:4000] :");
		double xSatelitePosition = scan.nextDouble();
		
		System.out.println("podaj Yposition zakres [0:4000] :");
		double ySatelitePosition = scan.nextDouble();
		
		double velocitySateliteX = 1*velocityVectorLongnes;
		double velocitySateliteY = -1*velocityVectorLongnes;
		
		
		double G = 1e2;
		double M = 5e6;
		double MG = G*M;
		double r = 0, rTo3 = 0;
		double MG_over_rTo3 = 0;
		double ax =0, ay=0;
		int rescaleFactor = 5;
		
		
		
		satelite.setXYPosition( (int)xSatelitePosition/rescaleFactor, (int)ySatelitePosition/rescaleFactor );
		satelite.changeSize( 10 );
		satelite.changeColor("red");
		
		sun.setXYPosition(0, 0);	//sun pozycja
		sun.changeSize(50);
		sun.changeColor("yellow");
		
		satelite.makeVisible();
		sun.makeVisible();
		
		//Thread.sleep(1000);
		
		while(true) {
			
			r = Math.sqrt(xSatelitePosition*xSatelitePosition + ySatelitePosition*ySatelitePosition );
			
			rTo3 = r*r*r;
			MG_over_rTo3 = ( MG/rTo3 ) ;
			
			ax = 0 - (MG_over_rTo3 * (xSatelitePosition)      );
			ay = 0 - (MG_over_rTo3 * (ySatelitePosition)     );
			
			velocitySateliteX += ax*dt;
			velocitySateliteY += ay*dt;
			
			xSatelitePosition += velocitySateliteX*dt;
			ySatelitePosition += velocitySateliteY*dt;
			
			satelite.setXYPosition((int)xSatelitePosition/rescaleFactor, (int)ySatelitePosition/rescaleFactor);
			satelite.draw();
			System.out.println("x= "+xSatelitePosition+" y= "+ySatelitePosition);
			//Thread.sleep(5);
		}
		

	}
//==================================================================================
	@Override
	public void actionPerformed(ActionEvent event) {
	
		
		Object source = event.getSource();

		if (source == bStart) {
			
			System.out.println("Start Clicked");
			

		}
		
	}
}