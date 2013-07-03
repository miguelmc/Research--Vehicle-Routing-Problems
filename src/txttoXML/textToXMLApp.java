package txttoXML;

import java.awt.Container;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author mike
 */
public class textToXMLApp extends javax.swing.JFrame {

	/**
	 * Creates new form textToXML
	 */
	public textToXMLApp() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		txtFileField = new javax.swing.JTextField();
		browseBtn1 = new javax.swing.JButton();
		title = new javax.swing.JLabel();
		acceptBtn = new javax.swing.JButton();
		exitBtn = new javax.swing.JButton();
		textFileLabel = new javax.swing.JLabel();
		folderField = new javax.swing.JTextField();
		browseBtn2 = new javax.swing.JButton();
		OuputLabel = new javax.swing.JLabel();

		textFileChooser = new JFileChooser();
		folderChooser = new JFileChooser();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		browseBtn1.setText("Browse");
		browseBtn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseBtn1ActionPerformed(evt);
			}
		});

		title.setText("Solomon text intance to XML");

		acceptBtn.setText("Accept");
		acceptBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					acceptBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		exitBtn.setText("Exit");
		exitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitBtnActionPerformed(evt);
			}
		});

		textFileLabel.setText("Solomon text file(s)");

		browseBtn2.setText("Browse");
		browseBtn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseBtn2ActionPerformed(evt);
			}
		});

		OuputLabel.setText("Output folder");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(title)
								.addGap(238, 238, 238))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(OuputLabel)
												.addComponent(textFileLabel)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		txtFileField,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		527,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		browseBtn1))
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						exitBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						98,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						acceptBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						94,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		layout.createSequentialGroup()
																				.addComponent(
																						folderField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						527,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(
																						browseBtn2))))
								.addContainerGap(40, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(title)
								.addGap(68, 68, 68)
								.addComponent(textFileLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														txtFileField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(browseBtn1))
								.addGap(58, 58, 58)
								.addComponent(OuputLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														folderField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(browseBtn2))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										87, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(exitBtn)
												.addComponent(acceptBtn))
								.addGap(54, 54, 54)));

		pack();
	}// </editor-fold>

	private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt)
			throws IOException {
		// Goes through all the files selected and executes the convert action
		String OS = System.getProperty("os.name").toLowerCase();
		for (File i : textFileChooser.getSelectedFiles()) {

			String[] temp;
			temp = i.toString().split("\\.");
			String inputName = i.toString();
			// Renames output as the input but with ".xml".
			String outputName = temp[0] + ".xml";
			// Splitting differs on operating systems. Avoids problem from
			// different path format on windows.
			if (OS.equals("win")) {
				temp = outputName.split("\\\\");
				outputName = folderChooser.getSelectedFile().toString()
						+ "\\\\" + temp[temp.length - 1];
			}
			// mac, solaris, linux, etc.
			else {
				temp = outputName.split("/");
				outputName = folderChooser.getSelectedFile().toString() + "/"
						+ temp[temp.length - 1];
			}
			textToXML.convert(inputName, outputName);
			// Exits after converting; assuming that is what the user wants.
			// Erase otherwise.
			exitAction();
		}
	}

	private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {
		exitAction();
	}

	private void browseBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
		// gets operating system
		String OS = System.getProperty("os.name").toLowerCase();
		// Multiple files allowed
		textFileChooser.setMultiSelectionEnabled(true);
		int returnValue = textFileChooser.showOpenDialog(null);

		// Makes sure that the user clicked accept (no null Files)
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			// Displays all paths by iterating all files, assuming they al
			// belong on same directory

			txtFileField.setText(textFileChooser.getSelectedFiles()[0]
					.toString());
			for (int i = 1; i < textFileChooser.getSelectedFiles().length; i++) {
				String[] path;
				if (OS.equals("win")) {
					path = textFileChooser.getSelectedFiles()[i].toString()
							.split("\\\\");
					txtFileField.setText(txtFileField.getText() + ", \"\"\\\\"
							+ path[path.length - 1]);
				} else {
					path = textFileChooser.getSelectedFiles()[i].toString()
							.split("/");
					txtFileField.setText(txtFileField.getText() + ", \"\"/"
							+ path[path.length - 1]);
				}
			}
		}
	}

	private void browseBtn2ActionPerformed(java.awt.event.ActionEvent evt) {
		// ONLY directories
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// NO multiple files
		folderChooser.setMultiSelectionEnabled(false);
		int returnValue = folderChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			folderField.setText(folderChooser.getSelectedFile().toString());
		}
	}

	private void exitAction() {
		Container frame = exitBtn.getParent();
		do
			frame = frame.getParent();
		while (!(frame instanceof JFrame));
		((JFrame) frame).dispose();
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
			java.util.logging.Logger.getLogger(textToXML.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(textToXML.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(textToXML.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(textToXML.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new textToXMLApp().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel OuputLabel;
	private javax.swing.JButton acceptBtn;
	private javax.swing.JButton browseBtn1;
	private javax.swing.JButton browseBtn2;
	private javax.swing.JButton exitBtn;
	private javax.swing.JTextField folderField;
	private javax.swing.JLabel textFileLabel;
	private javax.swing.JLabel title;
	private javax.swing.JTextField txtFileField;

	// woops
	private JFileChooser textFileChooser;
	private JFileChooser folderChooser;
	// End of variables declaration
}
