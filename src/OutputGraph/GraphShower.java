package OutputGraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class GraphShower extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	final private int FRAME_RANGE = 900;
	final private Dimension FRAME_DIMENSION = new Dimension(FRAME_RANGE, FRAME_RANGE);
	private ArrayList<Point> points;
	private ArrayList<Route> routes;
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN,
									Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
									Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
	
	public GraphShower(){
		initComponents();
	}
	private void initComponents() {
		this.getContentPane().setPreferredSize(FRAME_DIMENSION);
		this.getContentPane().setBackground(BACKGROUND_COLOR);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	
	public void display(final ArrayList<Point> points, final ArrayList<Route> routes) {
		
		this.points = points;
		this.routes = routes;
		
		this.repaint();
		this.setVisible(true);
	}
	
	//Does the actual board writing.
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		
		
		final int storageSize = 7;
		final int clientSize = 4;
		final int letterSize = 6;
		int x,y;
		String number;
		Point current;
		
		//Set font
		Font font = new Font(Font.SERIF, Font.PLAIN, 10);
		g.setFont(font);
		
		
		
		//Points-----------------------------------------------------------------------------
		// Draws depot
		current = points.get(0);
		x = (int) current.getX()-storageSize/2;
		y = (int) current.getY()-storageSize/2;
		g.fillRect(x, y, storageSize, storageSize);
		
		number = current.getNumberAsString();
		x = (int)(current.getX()-((double)number.length()/2)*letterSize);
		y = (int)(current.getY()-9);
		g.drawString(number, x, y);
		
		// Draws clients
		for (int i = 1; i < points.size(); i++) {
			current = points.get(i);
			x = (int) current.getX()-clientSize/2;
			y = (int) current.getY()-clientSize/2;
			g.fillOval(x, y, clientSize, clientSize);
			
			number = current.getNumberAsString();
			x = (int)(current.getX()-((double)number.length()/2)*letterSize);
			y = (int)(current.getY()-clientSize);
			g.drawString(number, x, y);
		}
		//-----------------------------------------------------------------------------------
		//Arches-----------------------------------------------------------------------------
		
		Point prev, curr;
		int routeColor = 0;
		curr = null;
		for(Route route : routes) {
			g.setColor(colors[routeColor]);
			routeColor = (routeColor+1)%colors.length;
			
			prev = points.get(0);
			for(Point point : route.getPoints()) {
				curr = point;
				g.drawLine((int)prev.getX(), (int)prev.getY(), (int)curr.getX(), (int)curr.getY());
				prev = curr;
			}
			g.drawLine((int)curr.getX(), (int)curr.getY(), 
								(int)points.get(0).getX(), (int)points.get(0).getY());
		}
		//------------------------------------------------------------------------------------
	}

}
