package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.*;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Blaise Mahoro
 *
 */
public class POSCreditPayment extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 private DefaultComboBoxModel<String> ComboBoxModel;
	/**
	 * Create the credit payment panel.
	 */
	public POSCreditPayment(JFrame currentFrame, Store store, Session session, Sale sale, JTextField saleTotal,JTextField AmtTendered,JButton btnPaymentComplete) {
		setLayout(null);
		
		JLabel lblEnterCreditPayment = new JLabel("Enter Credit Payment");
		lblEnterCreditPayment.setBounds(12, 0, 121, 16);
		add(lblEnterCreditPayment);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(22, 28, 56, 16);
		add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(90, 25, 129, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCardType = new JLabel("Card Type:");
		lblCardType.setBounds(12, 57, 75, 16);
		add(lblCardType);
		ComboBoxModel= new DefaultComboBoxModel<String>();
		
		    ComboBoxModel.addElement("VISA");
		    ComboBoxModel.addElement("MasterCard");
		JComboBox<String> comboBox = new JComboBox<String>(ComboBoxModel);
		comboBox.setBounds(100, 54, 129, 22);
		add(comboBox);
		
		JLabel lblAccountNum = new JLabel("Account Num:");
		lblAccountNum.setBounds(12, 89, 85, 16);
		add(lblAccountNum);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 86, 129, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setBounds(12, 118, 85, 16);
		add(lblExpiryDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 127, 129, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String amt =sale.calcAmount(new BigDecimal(textField.getText())).toString();
				Credit credit = new Credit((String)comboBox.getSelectedItem(),textField_1.getText(),textField_2.getText(),amt,textField.getText());
				if(credit.isAuthorized())
				{
				sale.addPayment(credit);
				saleTotal.setText(sale.calcAmount(new BigDecimal(textField.getText())).toString());
				AmtTendered.setText(sale.calcAmtTendered().toString());
				if(sale.isPaymentEnough())
					btnPaymentComplete.setEnabled(true);
				else
					btnPaymentComplete.setEnabled(false);
				}
			
			}
		});
		btnSave.setBounds(12, 159, 97, 25);
		add(btnSave);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnCancle.setBounds(143, 162, 97, 25);
		add(btnCancle);
		
		JLabel lblDdmyyyy = new JLabel("DD/M/YYYY");
		lblDdmyyyy.setBounds(12, 130, 66, 16);
		add(lblDdmyyyy);

	}
}
