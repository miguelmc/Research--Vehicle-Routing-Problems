package OutputGraph;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package learn;

/**
 * 
 * @author mike
 */
class MaxMinCoords {
	private double xMin, xMax, yMin, yMax;

	public MaxMinCoords() {
		xMin = xMax = yMin = yMax = 0;
	}

	public void setXMin(double x) {
		xMin = x;
	}

	public void setXMax(double x) {
		xMax = x;
	}

	public void setYMin(double y) {
		yMin = y;
	}

	public void setYMax(double y) {
		yMax = y;
	}

	public double getXMin() {
		return xMin;
	}

	public double getXMax() {
		return xMax;
	}

	public double getYMin() {
		return yMin;
	}

	public double getYMax() {
		return yMax;
	}
}

public class OutputGraph extends javax.swing.JFrame {

	/**
	 * Creates new form OutputGraph
	 */
	public OutputGraph() {
		// fixed window dimension
		this.getContentPane().setPreferredSize(FRAME_DIMENSION);
		points = getPoints();
		// Window size according to the point range
		minMax = getMinMax(points);
		normalizePoints(points);

		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		pack();
	}

	public void normalizePoints(ArrayList<double[]> points) {
		double range;
		double xRange = minMax.getXMax() - minMax.getXMin();
		double yRange = minMax.getYMax() - minMax.getYMin();
		double difference = xRange - yRange;
		// To keep things in proportion, points adapt to the bigger range.
		if (xRange > yRange)
			range = xRange;
		else
			range = yRange;

		double xReal;
		double yReal;
		// point proportional to screen
		double xFinal;
		double yFinal;

		xReal = points.get(0)[0] - minMax.getXMin();
		yReal = points.get(0)[1] - minMax.getYMin();

		// Space distribution between the 2 sides
		if (difference < 0)
			xReal += Math.abs(difference / 2);
		else
			yReal += difference / 2;

		xFinal = ((xReal / range) * FRAME_RANGE) + 50;
		yFinal = ((yReal / range) * FRAME_RANGE) + 50;

		ListIterator<double[]> listIterator = points.listIterator();

		for (double[] i : points)
			System.out.println(i[0] + ", " + i[1]);
		System.out.println("\n\n\n");

		if (listIterator.hasNext()) {
			listIterator.next();
			listIterator.set(new double[] { xFinal, yFinal });
		}

		// Draws clients
		for (int i = 1; i < points.size(); i++) {
			xReal = points.get(i)[0] - minMax.getXMin();
			yReal = points.get(i)[1] - minMax.getYMin();

			if (difference < 0)
				xReal += Math.abs(difference / 2);
			else
				yReal += difference / 2;

			xFinal = ((xReal / range) * FRAME_RANGE) + 50;
			yFinal = ((yReal / range) * FRAME_RANGE) + 50;

			if (listIterator.hasNext()) {
				listIterator.next();
				listIterator.set(new double[] { xFinal, yFinal });
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		for (double[] i : points)
			System.out.println(i[0] + ", " + i[1]);
		System.out.println("\n\n\n");

		// Draws depot
		g.fillRect((int) points.get(0)[0], (int) points.get(0)[1], 7, 7);

		// Draws clients
		for (int i = 1; i < points.size(); i++)
			g.fillOval((int) points.get(i)[0], (int) points.get(i)[1], 4, 4);

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(OutputGraph.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(OutputGraph.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(OutputGraph.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(OutputGraph.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OutputGraph().setVisible(true);
			}
		});
	}

	public static ArrayList<double[]> getPoints() {
		final ArrayList<double[]> pts = new ArrayList<double[]>();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			final double[] point = new double[2];

			DefaultHandler handler = new DefaultHandler() {

				// used do find the tag's 'x' and 'y' value
				boolean tagX = false;
				boolean tagY = false;

				// temporary
				double[] point = new double[2];

				// looks for tag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					if (qName.equalsIgnoreCase("x")) {
						tagX = true;
					}

					if (qName.equalsIgnoreCase("y")) {
						tagY = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

				}

				// Once it finds a tag, it enters this method, only useful for
				// <x> and <y>
				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (tagX) {
						// System.out.print(new String(ch, start, length) +
						// ", ");
						point[0] = Double.parseDouble(new String(ch, start,
								length));
						tagX = false;
					}

					if (tagY) {
						// System.out.println(new String(ch, start, length));
						point[1] = Double.parseDouble(new String(ch, start,
								length));
						pts.add(point);
						point = new double[2];
						tagY = false;
					}
				}
			};

			// TODO: TO CHANGE
			saxParser.parse(
					"/home/mike/Dropbox/Michael Cobos/solomon_25_xml/R102.xml",
					handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// returns all the points on an ArrayList
		return pts;
	}

	public static MaxMinCoords getMinMax(ArrayList<double[]> points) {
		MaxMinCoords maxMinCoords = new MaxMinCoords();
		boolean start = true;
		for (double[] i : points) {
			if (start) {
				maxMinCoords.setXMin(i[0]);
				maxMinCoords.setXMax(i[0]);
				maxMinCoords.setYMin(i[1]);
				maxMinCoords.setYMax(i[1]);
				start = false;
			}

			if (i[0] < maxMinCoords.getXMin())
				maxMinCoords.setXMin(i[0]);
			else if (i[0] > maxMinCoords.getXMax())
				maxMinCoords.setXMax(i[0]);

			if (i[1] < maxMinCoords.getYMin())
				maxMinCoords.setYMin(i[1]);
			else if (i[1] > maxMinCoords.getYMax())
				maxMinCoords.setYMax(i[1]);
		}

		return maxMinCoords;
	}

	// Variables declaration - do not modify
	final private int FRAME_RANGE = 700;
	final private Dimension FRAME_DIMENSION = new Dimension(FRAME_RANGE + 50,
			FRAME_RANGE + 50);
	private ArrayList<double[]> points;
	private ArrayList<double[]> arches;
	private MaxMinCoords minMax;
	// End of variables declaration
}
