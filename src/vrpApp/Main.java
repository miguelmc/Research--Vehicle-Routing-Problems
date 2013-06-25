package vrpApp;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();
		final GUI gui = new GUI(controller);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		});
	}

}
