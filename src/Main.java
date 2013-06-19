
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//CLI
		if(args.length>0);
		else
		{
			final GUI gui = new GUI();
	
			java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	              gui.setVisible(true);
	          }
			});
		}
	}

}
