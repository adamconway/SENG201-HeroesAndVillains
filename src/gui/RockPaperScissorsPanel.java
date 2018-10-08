package gui;

import javax.swing.JPanel;

import classes.HelperFunction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RockPaperScissorsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JButton btnRock;
	private JButton btnPaper;
	private JButton btnScissors;
	private JLabel lblVillainMove;
	private JLabel lblHeroMove;
	
	
	public RockPaperScissorsPanel() { 
		setLayout(null);
		setSize(650,420);
		
		btnRock = new JButton("");
		btnRock.setIcon(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/rock.png")), 75,75));
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHeroMove.setIcon(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/rock.png")), 100,100));
			}
		});
		btnRock.setBounds(64, 100, 75, 75);
		add(btnRock);
		
		btnPaper = new JButton(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/paper.png")), 70,70));
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHeroMove.setIcon(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/paper.png")), 100,100));
			}
		});
		btnPaper.setBounds(64, 200, 75, 75);
		add(btnPaper);
		
		btnScissors = new JButton(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/scissors.png")), 70,70));
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHeroMove.setIcon(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/scissors.png")), 100,100));
			}
		});
		btnScissors.setBounds(64, 300, 75, 75);
		add(btnScissors);
		
		lblVillainMove = new JLabel("");
		lblVillainMove.setBounds(480, 170, 100, 100);
		add(lblVillainMove);
		
		lblHeroMove = new JLabel("");
		lblHeroMove.setBounds(280, 170, 100, 100);
		add(lblHeroMove);
		
		JLabel lblNewLabel = new JLabel("Villain Move");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(440, 115, 180, 40);
		add(lblNewLabel);
		
		JLabel lblHeroMove_1 = new JLabel("Select a Move:");
		lblHeroMove_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHeroMove_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroMove_1.setBounds(12, 46, 194, 27);
		add(lblHeroMove_1);
		
		JLabel lblHeroMove_2 = new JLabel("Hero Move");
		lblHeroMove_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroMove_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHeroMove_2.setBounds(240, 115, 180, 40);
		add(lblHeroMove_2);
		
		

	}
	public void setVillainMove(String string) {
		lblVillainMove.setIcon(HelperFunction.resizeIcon(new ImageIcon(RockPaperScissorsPanel.class.getResource("/images/locations/villainlair/"+string+".png")), 100,100));
	}
	public JButton getBtnRock() {
		return btnRock;
	}


	public JButton getBtnPaper() {
		return btnPaper;
	}


	public JButton getBtnScissors() {
		return btnScissors;
	}
 

	public JLabel getLblVillainMove() {
		return lblVillainMove;
	}


	public JLabel getLblHeroMove() {
		return lblHeroMove;
	}

	
	public void reset() {
		btnRock.setEnabled(true);
		btnScissors.setEnabled(true);
		btnPaper.setEnabled(true);
		lblVillainMove.setIcon(new ImageIcon(""));
		lblHeroMove.setIcon(new ImageIcon(""));
		
	}
	
	public void lock() {
		btnRock.setEnabled(false);
		btnScissors.setEnabled(false);
		btnPaper.setEnabled(false);
	}
}
