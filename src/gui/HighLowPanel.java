package gui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HighLowPanel extends JPanel {

	private JSlider numberGuess;
	private JButton btnGuess1,btnGuess2;
	private JLabel lblResult, lblVillainGuess, lblVillainsNumber;
	/**
	 * Create the panel.
	 */
	public HighLowPanel() {
		setLayout(null);
		setSize(650,520);
		
		numberGuess = new JSlider();
		numberGuess.setFont(new Font("Tahoma", Font.PLAIN, 11));
		numberGuess.setPaintTicks(true);
		numberGuess.setPaintLabels(true);
		numberGuess.setMajorTickSpacing(1);
		numberGuess.setValue(1);
		numberGuess.setMaximum(10);
		numberGuess.setMinimum(1);
		numberGuess.setSnapToTicks(true);
		numberGuess.setBounds(118, 63, 400, 45);
		add(numberGuess);
		
		btnGuess1 = new JButton("Guess");
		btnGuess1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuess1.setBounds(248, 150, 148, 45);
		add(btnGuess1);
		
		btnGuess2 = new JButton("Guess");
		btnGuess2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuess2.setBounds(248, 150, 148, 45);
		add(btnGuess2);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(248, 227, 148, 66);
		add(lblResult);
		
		lblVillainGuess = new JLabel("");
		lblVillainGuess.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainGuess.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblVillainGuess.setBounds(248, 350, 148, 66);
		add(lblVillainGuess);
		
		lblVillainsNumber = new JLabel("Villain's Number");
		lblVillainsNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainsNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVillainsNumber.setBounds(248, 290, 148, 66);
		add(lblVillainsNumber);
		
		
	}
	
	public JButton getGuessButton1() {
		return btnGuess1;
	}
	
	public JButton getGuessButton2() {
		return btnGuess2;
	}
	
	public int guess() {
		return numberGuess.getValue();
	}
	
	public JLabel getLblResult() {
		return lblResult;
	}
	
	public JLabel getLblVillainNumber() {
		return lblVillainGuess;
	}
	
	public void showVillainGuess() {
		lblVillainsNumber.setVisible(true);
	}
	
	public void setBtnGuess2() {
		btnGuess1.setEnabled(false);
		btnGuess1.setVisible(false);
		btnGuess2.setEnabled(true);
		btnGuess2.setEnabled(true);
	}
	
	public void reset() {
		lblVillainsNumber.setVisible(false);
		lblVillainGuess.setText("");
		lblResult.setText("");
		numberGuess.setValue(1);
		numberGuess.setEnabled(true);
		btnGuess1.setEnabled(true);
		btnGuess1.setVisible(true);
		btnGuess2.setEnabled(false);
		btnGuess2.setEnabled(false);
	}
	
	public void lock() {
		btnGuess1.setEnabled(false);
		btnGuess2.setEnabled(false);
		numberGuess.setEnabled(false);
	}
}
