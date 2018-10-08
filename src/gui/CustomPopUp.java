package gui;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class CustomPopUp extends JDialog implements ActionListener {

	private JButton button;
	private final JPanel contentPanel = new JPanel();

  public CustomPopUp(String message) {
		super();
		setModal(true);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		button = new JButton("Close");
	    button.addActionListener(this);
	    button.setBounds(124,169, 200, 43);
	    contentPanel.add(button);
	    
	    JLabel lblNewLabel = new JLabel(message);
	    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 10));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(12, 58, 424, 43);
	    contentPanel.add(lblNewLabel);
		setVisible(true);
				
  	}
  public void actionPerformed(ActionEvent e) {
	  dispose();
}
}