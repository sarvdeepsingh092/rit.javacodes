// original from: http://rosettacode.org/wiki/MandelbrotZoom_set#Java
// modified for color

/**
 * MandelbrotZoom.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.event.*;


/**
 * This class would first create the fractal and then perform the zoom in on mouse click and drag
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class MandelbrotZoom extends JFrame implements MouseListener, MouseMotionListener {

	//declare and initialize the variables needed to print the fractal
	private final int MAX = 5000;
	private final int LENGTH = 800;
	private final double ZOOM = 1000;
	public BufferedImage I;
	private double zx, zy, cX, cY, tmp;
	private int[] colors = new int[MAX];
	Graphics g1;
	static MandelbrotZoom aMandelbrot;

	//declare and initialize the variables which would store the co-ordinates of mouse click and release
	static int clickX = 0, clickY = 0, locX = -1, locY = -1;
	boolean drag = false;
	//initialize the width and the height to 800 initially
	static int w = 800, h = 800;

	/**
	 * Default constructor
	 */
	public MandelbrotZoom() {
		super("MandelbrotZoom Set");

		//call the method to set the colors for the pixels
		initColors();
		
		//set the bounds of the window
		setBounds(100, 100, w, h);
		
		//do not allow the window to be resized
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//incorporate the mouse listeners to the class
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	/**
	 * method to create the pixels and their colors
	 */
	public void createSet() {
		I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				zx = zy = 0;
				cX = (x - LENGTH) / ZOOM;
				cY = (y - LENGTH) / ZOOM;
				int iter = 0;
				while ((zx * zx + zy * zy < 4) && (iter < MAX - 1)) {
					tmp = zx * zx - zy * zy + cX;
					zy = 2.0 * zx * zy + cY;
					zx = tmp;
					iter++;
				}
				if (iter > 0)
					I.setRGB(x, y, colors[iter]);
				else
					I.setRGB(x, y, iter | (iter << 8));
				repaint();
			}
		}
	}

	public void initColors() {
		for (int index = 0; index < MAX; index++) {
			colors[index] = Color.HSBtoRGB(index / 256f, 1, index / (index + 8f));
		}
	}

	/**
	 * method to paint the image on the window
	 * @param g		The instance of the Graphics class 
	 */
	@Override
	public void paint(Graphics g) {

		//call the method to draw the image on the window
		g.drawImage(I, 0, 0, w, h, this);

	}

	/**
	 * main program
	 * @param args		command line arguments(ignored)
	 */
	public static void main(String[] args) {
		
		//create the instance of the class
		aMandelbrot = new MandelbrotZoom();
		
		//set the window visibility to true
		aMandelbrot.setVisible(true);
		
		//call the method to create the pixels and the colors
		aMandelbrot.createSet();
	}

	/**
	 * this method deals with mouse clicks at the same point
	 * @param ev		It is the MouseEvent object
	 */
	public void mouseClicked(MouseEvent ev) {

	}

	/**
	 * This method carries out actions when the mouse button is released
	 * It will note down the co-ordinates of the point where the mouse is released
	 * Calculate the width and the height of the rectangle generated
	 * Copy the image in that rectangle into the BufferedImage object
	 * Set the bounds of the window to be printed in
	 * call the method to print the image 
	 */
	public void mouseReleased(MouseEvent ev) {

		//declare a point
		Point p2 = ev.getPoint();
		//note down the x coordinate of the point
		locX = p2.x;
		//note down the y coordinate of the point
		locY = p2.y;

		//calculate the width and the height of the window
		w = locX - clickX;
		h = locY - clickY;

		//print out the point coordinates and the width and height of the window
		System.out.println("locX= " + locX + " locY= " + locY);
		System.out.println("width= " + w + " hieght= " + h);
		drag = true;

		//copy the image in the rectangle generated into the BufferedImage
		I = I.getSubimage(clickX, clickY, w, h);
		
		//set the bounds of the window
		setBounds(100, 100, w, h);

		//call the paint method
		repaint();

	}

	/**
	 * this method deals with actions when the mouse exits a certain area
	 * @param ev		The MouseEvent object
	 */
	public void mouseExited(MouseEvent ev) {

	}

	/**
	 * This method deals with actions when the mouse button is pressed
	 * @param ev		The MouseEvent object
	 */
	public void mousePressed(MouseEvent ev) {

		//create a point
		Point p1 = ev.getPoint();
		
		//note down the x and y coordinate of the point where the mouse was clicked
		clickX = p1.x;
		clickY = p1.y;
		
		//print out the x and y coordinates of the point
		System.out.println("clickX= " + clickX + " clickY= " + clickY);
	}

	/**
	 * This method deals with actions when mouse enters a certain area
	 * @param ev		The MouseEvent object
	 */
	public void mouseEntered(MouseEvent ev) {

	}

	/**
	 * This method deals with the actions when mouse pointer is dragged
	 * @param ev 		The MouseEvent object
	 */
	public void mouseDragged(MouseEvent ev) {

	}

	/**
	 * This method deals with actions when mouse pointer is moved
	 * @param ev		The MouseEvent object
	 */
	public void mouseMoved(MouseEvent ev) {

	}

}
