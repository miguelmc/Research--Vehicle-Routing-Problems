package vrpApp;

/*
 * Miguel Martinez 
 * miguelmtz93@gmail.com
 * June 11, 2013
 */

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GUI extends javax.swing.JFrame {

	//Default path of the output. Change if needed
	private static final String DEFAULT_OUTPUT_PATH = System.getProperty("user.home");
	private static final long serialVersionUID = 1L;
	private Controller controller;

	public GUI(Controller controllerIn) {

		controller = controllerIn;
		initComponents();
	}

	private void initComponents() {
		//checks if default file path is a directory
		if(!(new File(DEFAULT_OUTPUT_PATH).isDirectory()))
				ErrorHandler.showError(16, "GUI.initComponents()", true);
		
		acceptBtn = new javax.swing.JButton();
		exitBtn = new javax.swing.JButton();
		title = new javax.swing.JLabel();
		configField = new javax.swing.JTextField();
		problemField = new javax.swing.JTextField();
		browseButton2 = new javax.swing.JButton();
		browseButton1 = new javax.swing.JButton();
		configLabel = new javax.swing.JLabel();
		problemLabel = new javax.swing.JLabel();
		outputLabel = new javax.swing.JLabel();
		statusLabel = new javax.swing.JLabel();
		outputField = new javax.swing.JTextField();
		browseButton3 = new javax.swing.JButton();

		configChooser = new JFileChooser();
		problemChooser = new JFileChooser();
		folderChooser = new JFileChooser();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Title");

		configLabel.setText("Configuration file");

		problemLabel.setText("Problem file(s)");
		
		outputLabel.setText("Output path");

		title.setText("VRP TEC");

		outputField.setText(DEFAULT_OUTPUT_PATH);
		folderChooser.setSelectedFile(new File(DEFAULT_OUTPUT_PATH));
		
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
		
		browseButton3.setText("Browse");
		browseButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseButton3ActionPerformed(evt);
			}
		});

		acceptBtn.setText("Accept");
		acceptBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				statusLabel.setText("");
				
				File dir;
				if(folderChooser.getSelectedFile().toString().equalsIgnoreCase(DEFAULT_OUTPUT_PATH)){
					dir = new File(DEFAULT_OUTPUT_PATH + 
							System.getProperty("file.separator") + "VRPSolutions");
				}else{
					dir = folderChooser.getSelectedFile();
				}
				// Send Files to be processed by program
				controller.processProblem(configChooser.getSelectedFile(),
											problemChooser.getSelectedFiles(), dir);
				
				statusLabel.setText("DONE!");
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
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(browseButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(problemField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(browseButton1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(configField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(browseButton2))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(acceptBtn))))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(configLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(problemLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(statusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(title)
                .addGap(54, 54, 54)
                .addComponent(configLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(configField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(problemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(problemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(browseButton1)))
                    .addComponent(browseButton2))
                .addGap(44, 44, 44)
                .addComponent(outputLabel)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(statusLabel)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(exitBtn))
                .addGap(49, 49, 49))
        );
	
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
	
	// Output file browse button
	private void browseButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// ONLY directories
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// NO multiple files
		folderChooser.setMultiSelectionEnabled(false);
		int returnValue = folderChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			outputField.setText(folderChooser.getSelectedFile().toString());
		}
	}

	private javax.swing.JLabel title;
	private javax.swing.JLabel configLabel;
	private javax.swing.JLabel problemLabel;
	private javax.swing.JLabel outputLabel;
	private javax.swing.JLabel statusLabel;
	private javax.swing.JButton browseButton1;
	private javax.swing.JButton browseButton2;
	private javax.swing.JButton browseButton3;
	private javax.swing.JButton acceptBtn;
	private javax.swing.JButton exitBtn;
	private javax.swing.JTextField configField;
	private javax.swing.JTextField problemField;
	private javax.swing.JTextField outputField;
	private JFileChooser configChooser;
	private JFileChooser problemChooser;
	private JFileChooser folderChooser;

}