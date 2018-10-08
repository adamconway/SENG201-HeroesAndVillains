package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {
	
	
	private JButton btnBack;
	
	/**
	 * Create the panel.
	 */
	public HelpPanel() {
		setLayout(null);
		setSize(900, 600);
		
		btnBack = new JButton("Close Help");
		btnBack.setBounds(350, 513, 200, 50);
		buttonStyle(btnBack);
		
		JTextArea txtrLoremIpsumDolor = new JTextArea();
		txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce auctor accumsan eros, vel sodales dolor gravida ut. Maecenas diam urna, facilisis non augue sed, dignissim cursus arcu. Integer facilisis odio nisi, in eleifend massa cursus et. Integer ac tortor ac velit euismod auctor at ac sapien. Praesent scelerisque pretium venenatis. Nulla bibendum turpis et aliquam rhoncus. Praesent id justo a lacus venenatis posuere ac eget ligula. Nunc maximus risus quam, quis pretium augue blandit sit amet. Fusce accumsan libero ac erat elementum blandit. Aliquam semper, nulla in dapibus hendrerit, sem orci sagittis libero, ac blandit nisi elit non ipsum.\r\n" + 
				"\r\n" + 
				"Sed molestie lorem mi, sed lobortis lectus condimentum id. Vestibulum vel laoreet urna. Sed ornare, felis nec molestie maximus, tortor erat tincidunt odio, a feugiat eros erat molestie enim. Suspendisse nec fermentum nisi. Suspendisse laoreet suscipit tristique. Vivamus rhoncus quam et nisi porttitor laoreet a vitae mauris. Proin tellus est, efficitur id venenatis in, rhoncus et nibh. Nam bibendum ut sapien in convallis.\r\n" + 
				"\r\n" + 
				"Nunc lacinia egestas enim ut cursus. Pellentesque in ultrices nisl. Aenean mattis semper nibh, ac ultricies mauris elementum id. Quisque ut eleifend ex. In hac habitasse platea dictumst. Nulla vitae enim sed ex rutrum fermentum ut nec urna. Ut condimentum ullamcorper tortor ut maximus. Maecenas leo diam, pulvinar eget posuere sed, tincidunt ut diam. Praesent laoreet gravida ipsum. Praesent rutrum et sem eget aliquam. Proin tincidunt sem turpis, id facilisis diam faucibus eu. Nulla nec nunc neque. Aenean ornare interdum aliquam. Integer tristique posuere vehicula. Praesent arcu mi, accumsan quis enim in, tincidunt malesuada lectus. Sed commodo augue et nisi consequat porttitor.\r\n" + 
				"\r\n" + 
				"Duis fermentum porta quam nec consectetur. Phasellus volutpat magna at vulputate tristique. Ut vel quam ante. Etiam rutrum, velit ac varius condimentum, ante dolor efficitur diam, et eleifend quam dui vitae dolor. Praesent ullamcorper magna vitae imperdiet varius. Ut non risus aliquet, commodo lacus ut, hendrerit ipsum. Aenean lorem enim, semper in augue eu, elementum dapibus tellus. Cras tempus mauris lorem. Suspendisse interdum mi eget sollicitudin efficitur. Duis eu libero odio. Etiam sollicitudin pulvinar porttitor. Pellentesque varius ultricies velit.\r\n" + 
				"\r\n" + 
				"Nullam rhoncus, est et rhoncus dictum, diam quam sagittis massa, eu efficitur massa sapien sed quam. Integer sodales commodo libero, ac blandit erat tempor ut. Cras ligula turpis, rhoncus id commodo in, mattis ornare risus. Curabitur dictum euismod porttitor. Praesent dui nisi, pellentesque quis metus quis, faucibus posuere neque. Morbi sit amet vestibulum tellus. Fusce et lectus at magna tincidunt gravida. Phasellus scelerisque mi ut nisi mollis rutrum. Etiam eu metus consequat libero tristique aliquam ac nec est. Ut eget ligula vitae diam porta commodo. Maecenas eget vulputate justo. Aliquam eget pharetra velit. Aliquam hendrerit massa in auctor luctus. Aliquam interdum nisl diam, non elementum ligula vestibulum nec.");
		txtrLoremIpsumDolor.setBounds(10, 11, 880, 450);
		txtrLoremIpsumDolor.setWrapStyleWord(true);
		txtrLoremIpsumDolor.setLineWrap(true);
		add(txtrLoremIpsumDolor);
	}
	
	public JButton getBtnBack() {
		return btnBack;
	}
	
	private void buttonStyle(JButton button) {
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setBorderPainted(false); 
		button.setContentAreaFilled(false); 
		button.setFocusPainted(false); 
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button05.png")));
		        } else {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		        }
		    }
		});
		add(button);
	}
}
