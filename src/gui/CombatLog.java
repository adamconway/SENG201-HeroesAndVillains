package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import classes.SmartScroller;

import java.awt.Font;

public class CombatLog extends JPanel {
	
	private JScrollPane logScroll;
	private DefaultListModel<String> logListModel = new DefaultListModel<>();
	private JList<String> logList = new JList<String>(logListModel);
	/**
	 * Create the panel.
	 */
	public CombatLog() {
		setSize(250,520);
		setLayout(null);
		setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel lblNewLabel = new JLabel("Combat Log");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 230, 26);
		add(lblNewLabel);
		
		logScroll = new JScrollPane(logList,
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(logScroll);
		logScroll.setBounds(10,45,230,420);
		new SmartScroller(logScroll);
	}
	
	public void clearLog() {
		
	}
	
	public void addLine(String string) {
		logListModel.addElement(string);
	}
	
	public void reset() {
		logListModel.clear();
	}

}
