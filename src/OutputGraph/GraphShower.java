package OutputGraph;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class GraphShower extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	final private int FRAME_RANGE = 700;
	final private Dimension FRAME_DIMENSION = new Dimension(FRAME_RANGE + 50,
			FRAME_RANGE + 50);
	private ArrayList<Point> points;
	private ArrayList<Route> routes;
	
	public GraphShower(){
		initComponents();
	}
	private void initComponents() {
		this.getContentPane().setPreferredSize(FRAME_DIMENSION);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		pack();
	}
	
	
	public void display(final ArrayList<Point> points, final ArrayList<Route> routes) {
		
		this.points = points;
		this.routes = routes;
		
		this.setVisible(true);
	}
	
	//Does the actual board writing.
	@Override
	public void paint(Graphics g) {

		super.paint(g);

		for (Point i : points)
			System.out.println(i.getX() + ", " + i.getY());
		System.out.println("\n\n\n");

		//Points-----------------------------------------------------------------------------
		// Draws depot
		g.fillRect((int) points.get(0).getX(), (int) points.get(0).getY(), 7, 7);

		// Draws clients
		for (int i = 1; i < points.size(); i++)
			g.fillOval((int) points.get(i).getX(), (int) points.get(i).getY(), 4, 4);
		//-----------------------------------------------------------------------------------
		//Arches-----------------------------------------------------------------------------
		
		Point prev, curr;
		curr = null;
		for(Route route : routes) {
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
