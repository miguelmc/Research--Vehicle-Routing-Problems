package vrpApp;

/*
 * Miguel Martinez 
 * miguelmtz93@gmail.com
 * June 11, 2013
 */

import java.awt.Container;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	public GUI(Controller controllerIn) {

		controller = controllerIn;
		initComponents();
	}

	private void initComponents() {
		acceptBtn = new javax.swing.JButton();
		exitBtn = new javax.swing.JButton();
		title = new javax.swing.JLabel();
		configField = new javax.swing.JTextField();
		problemField = new javax.swing.JTextField();
		browseButton2 = new javax.swing.JButton();
		browseButton1 = new javax.swing.JButton();
		configLabel = new javax.swing.JLabel();
		problemLabel = new javax.swing.JLabel();

		configChooser = new JFileChooser();
		problemChooser = new JFileChooser();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Title");

		configLabel.setText("Configuration file");

		problemLabel.setText("Problem file(s)");

		title.setText("VRP TEC");

		browseButton1.setText("Browse");
		browseButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseButton1ActionPerformed(evt);
			}
		});

		browseButton2.setText("Browse");
		browseButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseButton2ActionPerformed(evt);
			}
		});

		acceptBtn.setText("Accept");
		acceptBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				// Send Files to be processed by program
				controller.processProblem(configChooser.getSelectedFile(),
						problemChooser.getSelectedFiles());
			}
		});

		exitBtn.setText("Exit");
		exitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Container frame = exitBtn.getParent();
				do
					frame = frame.getParent();
				while (!(frame instanceof JFrame));
				((JFrame) frame).dispose();
			}
		});

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
								.addGap(292, 292, 292))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(58, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		problemLabel)
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		configLabel)
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										configField,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										460,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										32,
																										Short.MAX_VALUE)
																								.addComponent(
																										browseButton2))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										problemField,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										460,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										browseButton1))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										exitBtn,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										67,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										acceptBtn)))
																.addGap(89, 89,
																		89)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(22, 22, 22)
								.addComponent(title)
								.addGap(54, 54, 54)
								.addComponent(configLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		configField,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		66,
																		Short.MAX_VALUE)
																.addComponent(
																		problemLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						problemField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						browseButton1))
																.addGap(102,
																		102,
																		102)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						acceptBtn)
																				.addComponent(
																						exitBtn))
																.addGap(49, 49,
																		49))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		browseButton2)
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))));

		pack();
	}

	// Problem browse button
	private void browseButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// Multiple files allowed
		problemChooser.setMultiSelectionEnabled(true);
		int returnValue = problemChooser.showOpenDialog(null);

		// Makes sure that the user clicked accept (no null Files)
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			// Displays all paths by iterating all files, assuming they al
			// belong on same directory
			problemField.setText(problemChooser.getSelectedFiles()[0]
					.toString());
			for (int i = 1; i < problemChooser.getSelectedFiles().length; i++) {
				String[] path = problemChooser.getSelectedFiles()[i].toString()
						.split("/");
				problemField.setText(problemField.getText() + ", \"\"/"
						+ path[path.length - 1]);
			}
		}
	}

	// Configuration browse button
	private void browseButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		configChooser.setMultiSelectionEnabled(false);
		int returnValue = configChooser.showOpenDialog(null);
		// Makes sure that the user clicked accept (no null Files)
		if (returnValue == JFileChooser.APPROVE_OPTION)
			configField.setText(configChooser.getSelectedFile().toString());
	}

	private javax.swing.JLabel title;
	private javax.swing.JLabel configLabel;
	private javax.swing.JLabel problemLabel;
	private javax.swing.JButton browseButton1;
	private javax.swing.JButton browseButton2;
	private javax.swing.JButton acceptBtn;
	private javax.swing.JButton exitBtn;
	private javax.swing.JTextField configField;
	private javax.swing.JTextField problemField;
	private JFileChooser configChooser;
	private JFileChooser problemChooser;

}