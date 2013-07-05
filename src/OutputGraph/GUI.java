package OutputGraph;

import java.awt.Container;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	public GUI(Controller controller){
		this.controller = controller;
		initComponents();
	}
	

	    private void initComponents() {

	        problemField = new javax.swing.JTextField();
	        problemBrowseButton = new javax.swing.JButton();
	        title = new javax.swing.JLabel();
	        acceptBtn = new javax.swing.JButton();
	        exitBtn = new javax.swing.JButton();
	        problemFileLabel = new javax.swing.JLabel();
	        solutionField = new javax.swing.JTextField();
	        solutionBrowseButton = new javax.swing.JButton();
	        solutionFileLabel = new javax.swing.JLabel();

	        problemChooser = new JFileChooser();
	        solutionChooser = new JFileChooser();
	        
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        problemBrowseButton.setText("Browse");
	        problemBrowseButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                problemBrowseButtonActionPerformed(evt);
	            }
	        });

	        title.setText("Output Graph");

	        acceptBtn.setText("Accept");
	        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                acceptBtnActionPerformed(evt);
	            }
	        });

	        exitBtn.setText("Exit");
	        exitBtn.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                exitBtnActionPerformed(evt);
	            }
	        });

	        problemFileLabel.setText("Problem file");

	        solutionBrowseButton.setText("Browse");
	        solutionBrowseButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                solutionBrowseButtonActionPerformed(evt);
	            }
	        });

	        solutionFileLabel.setText("Solution file");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(30, 30, 30)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(solutionFileLabel)
	                            .addComponent(problemFileLabel)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(problemField, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(problemBrowseButton))
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                                    .addComponent(solutionField, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                    .addComponent(solutionBrowseButton)))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(287, 287, 287)
	                        .addComponent(title)))
	                .addContainerGap(40, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(title)
	                .addGap(68, 68, 68)
	                .addComponent(problemFileLabel)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(problemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(problemBrowseButton))
	                .addGap(58, 58, 58)
	                .addComponent(solutionFileLabel)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(solutionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(solutionBrowseButton))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(exitBtn)
	                    .addComponent(acceptBtn))
	                .addGap(54, 54, 54))
	        );

	        pack();
	    }                        

	    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        controller.processGraph(problemChooser.getSelectedFile(),
	        							solutionChooser.getSelectedFile());
	    }                                         

	    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    	Container frame = exitBtn.getParent();
			do
				frame = frame.getParent();
			while (!(frame instanceof JFrame));
			((JFrame) frame).dispose();
	    }                                       

	    private void problemBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
	    	problemChooser.setMultiSelectionEnabled(false);
			int returnValue = problemChooser.showOpenDialog(null);
			// Makes sure that the user clicked accept (no null Files)
			if (returnValue == JFileChooser.APPROVE_OPTION)
				problemField.setText(problemChooser.getSelectedFile().toString());
	    }                                                   

	    private void solutionBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
	    	solutionChooser.setMultiSelectionEnabled(false);
			int returnValue = solutionChooser.showOpenDialog(null);
			// Makes sure that the user clicked accept (no null Files)
			if (returnValue == JFileChooser.APPROVE_OPTION)
				solutionField.setText(solutionChooser.getSelectedFile().toString());
	    }                                                    

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton acceptBtn;
	    private javax.swing.JButton exitBtn;
	    private javax.swing.JButton problemBrowseButton;
	    private javax.swing.JTextField problemField;
	    private javax.swing.JLabel problemFileLabel;
	    private javax.swing.JButton solutionBrowseButton;
	    private javax.swing.JTextField solutionField;
	    private javax.swing.JLabel solutionFileLabel;
	    private javax.swing.JLabel title;
	    
	    private JFileChooser problemChooser;
		private JFileChooser solutionChooser;
	    // End of variables declaration       
	
	
}
