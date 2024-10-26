import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Position;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author <you>
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		Point anchor=new Point(mid,top);//@keyterms constructor////@keyterms initiating an object//

		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		MiniFig anup= new MiniFig(g,scaleFactor,anchor);//@keyterms initiatiating an object//
		// TODO: 3. Create a new custom Color object. An example is shown below.
		Color torsoColor= new Color(155, 184, 101);//@keyterms attribute///@keyterms method
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		anup.setTorsoColor(torsoColor);
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
	    anup.draw();
		Point capPoint= anup.getCapPoint();
		int faceHeight= anup.getFaceHeight();
		int faceWidth= anup.getFaceWidth();

		int hatX= capPoint.x-faceWidth/2;
		int hatY= capPoint.y-faceHeight/2;
		g.fillArc(hatX, hatY, faceWidth, faceHeight, 0, 180);

		//Drawing stick//

		Point stickPoint= anup.getRightHandCenterPoint();//@keyterms initiating an object////@keyterms constructor//
		int stickHeight= anup.getHeight();
		int stickWidth= anup.getFaceWidth()/16;
		int stickUp= anup.getFaceHeight();

		int stickX= stickPoint.x;
		int stickY= stickPoint.y-stickUp;
		Color stickColor= new Color(120, 33, 6);//@keyterms attribute//
		g.setColor(stickColor);
		g.fillRect(stickX, stickY, stickWidth, stickHeight);//@keyterms method//

		//Drawing setting Sun//

		Point settingSun= anup.getBaseMidPoint();//@keyterms initiating an object////@keyterms constructor//
		int sunHeight= anup.getFaceHeight()*4;
		int sunWidth= anup.getFaceWidth()*3;
		
		int sunX= settingSun.x-anup.getWidth()*2;
		int sunY= settingSun.y-anup.getFaceHeight()/2;
		g.setColor(Color.yellow);//@keyterms attribute//
		g.fillArc(sunX,sunY,sunWidth,sunHeight,0,180);//@keyterms method//

		//Drawing tower//

		Point tower= anup.getTopMidPoint();//@keyterms initiating an object////@keyterms constructor//
		int towerHeight= anup.getHeight();
		int towerWidth= anup.getFaceWidth()/2;

		int towerX= tower.x+anup.getFaceWidth()/7+anup.getWidth();
		int towerY= tower.y;
		Color home= new Color(112, 122, 109);//@keyterms attribute//
		g.setColor(home);
		g.fillRect(towerX,towerY,towerWidth,towerHeight);//@keyterms method//

		Point first= anup.getLeftHandCenterPoint();//@keyterms initiating an object////@keyterms constructor//
		int firstHeight= anup.getHeight();
		int firstWidth= anup.getFaceWidth()*2;

		int firstX= first.x+anup.getFaceWidth();
		int firstY= first.y;
		g.fillRect(firstX,firstY,firstWidth,firstHeight);//@keyterms method//

		Point second= anup.getLeftShoulderPoint();//@keyterms initiating an object////@keyterms constructor//
		int secondHeight= anup.getHeight();
		int secondWidth= anup.getFaceWidth();

		int secondX= second.x+anup.getFaceWidth()*2;
		int secondY= second.y;
		g.fillRect(secondX,secondY,secondWidth,secondHeight);//@keyterms method/

		
		
		
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point.
		Point baseMidpoint=anup.getBaseMidPoint();
		int baseY= (int)baseMidpoint.getY();
	     int grassYOffset = baseY;
		
		Color grassGreen = new Color (49, 148, 13);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);

		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED);
        
		
	        // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why?
		
		
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}
