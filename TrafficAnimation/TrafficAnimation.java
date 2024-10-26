import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Animates a simple java animation of a moving object and its surrounding using basic shapes like rectangle, oval, arc, line,etc.
 *
 * @author BSU CS 121 Instructors
 * @author Anup Bhattarai
 * 		   
 * 		
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.cyan);
		g.fillRect(0,0,width,height);

		

		
		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		

		
		

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

        //Drawing grass//

        int grassWidth= width;
        int grassHeight= height/5;
        int grassX=width/width;
        int grassY=height/3+height/2;

        g.setColor(Color.GREEN);
        g.fillRect(grassX, grassY, grassWidth, grassHeight);

		//Drawing Plane's Lane//

		int planeLaneWidth= width;
		int planeLaneHeight= height/5;
		int planeLaneX= width-width;
		int planeLaneY= height/8;

		g.setColor(new Color(98, 181, 155));
		g.fillRect(planeLaneX,planeLaneY,planeLaneWidth,planeLaneHeight);

         //Airplane mouth//
		
		int mouthHeight= height/20;
		int mouthWidth= width/19;
		int mouthX= xOffset+ width/6-width/60 ;
		int mouthY= height/5;

		g.setColor(new Color(245, 111, 34));
		g.fillArc(mouthX, mouthY, mouthWidth, mouthHeight,110,200);

		

		//Drawing airplane tail//

		int airplaneTailWidth= width/15;
		int airplaneTailHeight= height/5;
		int airplaneTailX= xOffset-width/20;
		int airplaneTailY= height/6-height/60;

		g.setColor(new Color(245, 111, 34));
		g.fillArc(airplaneTailX, airplaneTailY,airplaneTailWidth,airplaneTailHeight,0,90);

        // Drawing Plane body//

        int planeHeight = height/20;
		int planeWidth = width/6;
		int planeX = xOffset;
		int planeY = height/5;

		g.setColor(Color.white);
		g.fillRect(planeX, planeY, planeWidth, planeHeight);

		int planeBorderHeight=height/20;
		int planeBorderWidth= planeWidth;
		int planeBorderX= xOffset;
		int planeBorderY= planeY;

		g.setColor(new Color(245, 111, 34));
		g.drawRect(planeBorderX,planeBorderY,planeBorderWidth,planeBorderHeight);
		
		// Drawing plane's engine//

        int engineHeight= height/25;
		int engineWidth=planeWidth/6;
		int engineX=xOffset+planeWidth/2;
		int engineY=height/4-engineHeight/2;

		g.setColor(new Color(245, 111, 34));
		g.fillOval(engineX,engineY,engineWidth,engineHeight);

        // Drawing plane's windows//

        int windowWidth=engineWidth/5;
        int windowHeight=engineHeight/5;
        int windowX= xOffset+planeWidth/5;
        int windowY= height/5+planeHeight/3;

        g.setColor(Color.BLACK);
        g.fillOval(windowX, windowY, windowWidth, windowHeight);

        int windowX1= xOffset+planeWidth/3;
        int windowY1=windowY;
        
        g.fillOval(windowX1, windowY1, windowWidth, windowHeight);

        int windowX2= windowX1+planeWidth/7;
        int windowY2= windowY;

        g.fillOval(windowX2, windowY2, windowWidth, windowHeight);

        int windowX3= windowX2+planeWidth/7;
        int windowY3= windowY;

        g.fillOval(windowX3, windowY3, windowWidth, windowHeight);

        int windowX4= windowX3+planeWidth/7;
        int windowY4= windowY;

        g.fillOval(windowX4, windowY4, windowWidth, windowHeight);
        
        //Drawing House//

        int houseHeight= height/4;
        int houseWidth=width/5;
        int houseX=width/10;
        int houseY=height/2+planeHeight*2;

        g.setColor(new Color(252, 251, 154));
        g.fillRect(houseX, houseY, houseWidth, houseHeight);

        //Drawing House Door//

        int houseDoorWidth= houseWidth/5;
        int houseDoorHeight= houseHeight/3;
        int houseDoorX= houseWidth-houseWidth/10;
        int houseDoorY= houseY+houseHeight/2+houseHeight/6;

        g.setColor(new Color(92, 37, 10));
        g.fillRect(houseDoorX, houseDoorY, houseDoorWidth, houseDoorHeight);

        //Drawing Door knob//

        int doorKnobWidth= houseDoorWidth/8;
        int doorKnobHeight= houseDoorHeight/8;
        int doorKnobX= houseDoorX+houseDoorWidth/7;
        int doorKnobY= height/2+houseHeight+houseDoorHeight/2;

        g.setColor(Color.white);
        g.fillOval(doorKnobX, doorKnobY, doorKnobWidth, doorKnobHeight);

        //Drawing House Windows//

        int houseWindowWidth=houseDoorWidth;
        int houseWindowHeight=houseDoorHeight/2;
        int houseWindowX= width/8;
        int houseWindowY= height/2+houseDoorHeight*2;

        g.setColor(Color.CYAN);
        g.fillRect(houseWindowX, houseWindowY, houseWindowWidth, houseWindowHeight);

        int houseWindowX1= houseWindowX+houseWidth/2+houseWindowWidth/9;
        int houseWindowY1= houseWindowY;

        g.fillRect(houseWindowX1,houseWindowY1,houseWindowWidth,houseWindowHeight);

        // Drawing House Roof//

        int houseRoofWidth=houseWidth;
        int houseRoofHeight=houseHeight/3;
        int houseRoofX=width/10;
        int houseRoofY=height/2+houseWindowHeight/2;

        g.setColor(new Color(92, 37, 10));
        g.fillRect(houseRoofX,houseRoofY,houseRoofWidth,houseRoofHeight);

        int houseRoofArcHeight=houseRoofHeight*2;
        int houseRoofArcWidth=houseDoorWidth;
        int houseRoofArcX=houseRoofX-houseWindowWidth/2;
        int houseRoofArcY=houseRoofY;

        g.setColor(new Color(92, 37, 10));
        g.fillArc( houseRoofArcX, houseRoofArcY,houseRoofArcWidth,houseRoofArcHeight,0,180);
        
        int houseRoofArcX1= houseRoofArcX+houseRoofWidth;
        int houseRoofArcY1= houseRoofY;

        g.fillArc(houseRoofArcX1,houseRoofArcY1,houseRoofArcWidth,houseRoofArcHeight,0,180);

        //Drawing Road to house//

        int pavementWidth=houseDoorWidth;
        int pavementHeight=houseDoorHeight*2;
        int pavementX=houseRoofArcX+houseWidth/2;
        int pavementY=height/2+houseDoorHeight*4+houseWindowHeight/3;

        g.setColor(new Color(112, 101, 96));
        g.fillRect(pavementX,pavementY,pavementWidth,pavementHeight);


		//Drawing string//

		g.setFont(new Font("Arial",Font.ITALIC,width/20));
		g.setColor(Color.RED);
		g.drawString("HOME SWEET HOME!!",width-width+houseWidth/2,height/2);


		//Drawing Avatar//


		//Drawing Avatar's Face//

		int avatarFaceWidth= houseWindowWidth*2;
		int avatarFaceHeight= houseWindowHeight*2;
		int avatarFaceX= width/2+houseWidth;
		int avatarFaceY= height/2+houseHeight/9;
		int avatarFaceArcX=houseWindowWidth;
		int avatarFaceArcY=houseWindowHeight;

		g.setColor(new Color(230, 245, 169));
		g.fillRoundRect(avatarFaceX,avatarFaceY,avatarFaceWidth,avatarFaceHeight,avatarFaceArcX,avatarFaceArcY);

		//Drawing avatar's neck//

		int avatarNeckHeight= houseWindowHeight/2;
		int avatarNeckWidth= houseWindowWidth/2;
		int avatarNeckX= width/2+houseWidth+houseWindowWidth-houseWindowWidth/2+houseWindowWidth/3;
		int avatarNeckY= height/2+houseHeight/2-houseWindowHeight/2;

		g.fillRect(avatarNeckX, avatarNeckY, avatarNeckWidth, avatarNeckHeight);

		//Drawing avatar's eyes//

		int avatarEyesWidth= doorKnobWidth;
		int avatarEyesHeight= doorKnobHeight;
		int avatarEyesX= width/2+houseWidth+houseWindowWidth/2;
		int avatarEyesY= height/2+houseWindowHeight+houseWindowHeight/6;

		g.setColor(Color.BLACK);
		g.fillOval(avatarEyesX, avatarEyesY, avatarEyesWidth, avatarEyesHeight);

		int avatarEyesX1= avatarEyesX+houseWindowWidth-houseWindowWidth/5;
		int avatarEyesY1= avatarEyesY;

		g.fillOval(avatarEyesX1, avatarEyesY1, avatarEyesWidth, avatarEyesHeight);

		

		//Drawing avatar's mouth//

		int avatarMouthWidth= houseWindowWidth/2;
		int avatarMounthHeight= houseWindowHeight/2;
		int avatarMouthX= avatarEyesX+houseWindowWidth/4;
		int avatarMouthY= avatarEyesY+houseWindowHeight-houseWindowHeight/4;

		g.setColor(Color.red);
		g.fillOval(avatarMouthX, avatarMouthY, avatarMouthWidth, avatarMounthHeight);

		//Drawing avatar's nose//

		
		int avatarNoseX=avatarEyesX+houseWindowWidth/2;
		int avatarNoseY=avatarEyesY;

		g.setColor(Color.BLACK);
		g.drawLine(avatarNoseX, avatarNoseY,avatarMouthX+houseWindowWidth/4,avatarMouthY-houseWindowHeight/3);

		//Drawing avatar's body//

		int avatarBodyWidth= houseWidth/3;
		int avatarBodyHeight= houseHeight/2;
		int avatarBodyX= width/2+houseWidth+houseWindowWidth/6;
		int avatarBodyY= height/2+houseWindowHeight*3;
		int avatarBodyArcX=houseWindowWidth;
		int avatarBodyArcY=houseWindowHeight;

		g.setColor(Color.BLUE);
		g.fillRoundRect(avatarBodyX,avatarBodyY,avatarBodyWidth,avatarBodyHeight,avatarBodyArcX,avatarBodyArcY);

		//Drawing Avatar's Legs//

		int avatarLegsWidth= houseWindowWidth/3;
		int avatarLegsHeight= houseWindowHeight*2;
		int avatarLegsX= houseWidth*3+houseWindowWidth*3;
		int avatarLegsY= height/2+houseHeight-houseWindowHeight/10;

		g.setColor(Color.gray);
		g.fillRect(avatarLegsX, avatarLegsY, avatarLegsWidth, avatarLegsHeight);

		int avatarLegsX1= avatarLegsX+houseWindowWidth-houseWindowWidth/3;
		int avatarLegsY1= avatarLegsY;

		g.fillRect(avatarLegsX1,avatarLegsY1,avatarLegsWidth,avatarLegsHeight);


		//Drawing avatar's shoes//

		int avatarShoesWidth=avatarLegsWidth;
		int avatarShoesHeight=houseWindowHeight/3;
		int avatarShoesX= avatarLegsX;
		int avatarShoesY= height/2+houseHeight+houseWindowHeight*2-houseWindowHeight/5;

		g.setColor(Color.black);
		g.fillRect(avatarShoesX,avatarShoesY,avatarShoesWidth,avatarShoesHeight);

		int avatarShoesX1= avatarLegsX1;
		int avatarShoesY1= avatarShoesY;

		g.fillRect(avatarShoesX1,avatarShoesY1,avatarShoesWidth,avatarShoesHeight);

		//Drawing Avatar's Hands//

		int avatarHandsWidth= avatarLegsWidth;
		int avatarHandsHeight= avatarLegsHeight;
		int avatarHandsX= avatarBodyX-houseWindowWidth/3;
		int avatarHandsY= avatarBodyY+houseWindowHeight/2;

		g.setColor(Color.ORANGE);
		g.fillRect(avatarHandsX,avatarHandsY,avatarHandsWidth,avatarHandsHeight);

		int avatarHandsX1=avatarHandsX+avatarBodyWidth+houseWindowWidth/3;
		int avatarHandsY1=avatarHandsY;

		g.fillRect(avatarHandsX1,avatarHandsY1,avatarHandsWidth,avatarHandsHeight);

		//Drawing Avatar's Dress Design//

		int avatarDressWidth=avatarBodyWidth;
		int avatarDressHeight= houseWindowHeight;
		int avatarDressX=avatarBodyX;
		int avatarDressY=avatarBodyY+houseWindowHeight;
		int avatarDressArcX= avatarBodyArcX;
		int avatarDressArcY=avatarBodyArcY;

		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(avatarDressX, avatarDressY, avatarDressWidth, avatarDressHeight, avatarDressArcX, avatarDressArcY);


		



		
		
		
		
		


		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 800;
		int initHeight = 600;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
