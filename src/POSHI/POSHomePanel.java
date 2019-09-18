package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Store;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
/**
 * 
 * @author Blaise Mahoro
 *
 */
public class POSHomePanel extends JPanel {

	/**
	 * Create the home panel.
	 */
	public POSHomePanel(Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(store.getName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(129, 75, 269, 16);
		add(lblNewLabel);
		

	}

}
