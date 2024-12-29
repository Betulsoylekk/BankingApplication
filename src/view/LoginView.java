package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.Bank;
import user.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Button;

public class LoginView extends JFrame {

	private JPanel contentPane;
	Bank bank;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	JComboBox<Client> comboBox;

	/**
	 * Launch the application.
	 */
	
	private void updateAccountComboBox() {
		comboBox.removeAllItems();
		for(Client client: bank.getClients() ) {
			 comboBox.addItem(client);
		}
	}
	
	private void selectExistingAccount() {
		JLabel lblSelect = new JLabel("Select Existing Account");
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelect.setBounds(188, 41, 80, 22);
		contentPane.add(lblSelect);
	}
	private void setFrameInvisible() {
		this.setVisible(false);
	}	
	/**
	 * Create the frame.
	 */
	public LoginView(Bank bank) {
		this.bank=bank;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		Panel panel_1 = new Panel();
		panel.add(panel_1, "name_25021832742000");
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2, "name_25126370303600");
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(47, 62, 74, 13);
		panel_2.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(47, 100, 74, 13);
		panel_2.add(lblLastName);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(47, 143, 109, 13);
		panel_2.add(lblAccountNumber);
		
		JLabel lblAccountNumberValue = new JLabel("New label");
		lblAccountNumberValue.setText(Integer.toString(bank.getNextAccountNumber()));
		lblAccountNumberValue.setBounds(189, 143, 45, 13);
		panel_2.add(lblAccountNumberValue);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(189, 97, 173, 19);
		panel_2.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(189, 59, 173, 19);
		panel_2.add(textFieldLastName);
		
		JButton btnRegister = new JButton("Create Account");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String firstName=textFieldName.getText();
				String lastName=textFieldLastName.getText();
				Client client=new Client(firstName,lastName);
				bank.registerClient(client);
				updateAccountComboBox();
				panel_1.setVisible(true);
				panel_2.setVisible(false);

			}
		});
		btnRegister.setBounds(171, 184, 128, 30);
		panel_2.add(btnRegister);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(187, 10, 31, 16);
		panel_1.add(lblLogin);
		
		comboBox = new JComboBox<Client>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() !=null) {
					String selection=comboBox.getSelectedItem().toString();
				}
			}
		});
		for(Client client: bank.getClients() ) {
			 comboBox.addItem(client);
		}
		
		comboBox.setBounds(102, 59, 226, 19);
		panel_1.add(comboBox);
		
		JLabel lbIInfo = new JLabel("Select an Existing Account To Login as Client");
		lbIInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbIInfo.setBounds(102, 36, 211, 13);
		panel_1.add(lbIInfo);
		
		JLabel lblNewLabel = new JLabel("Dont Have An Account? Create New User Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(102, 180, 226, 13);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Client Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton.setBounds(144, 194, 135, 59);
		panel_1.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Client selectedClient=(Client) comboBox.getSelectedItem();
				//Client client=bank.getClientByName(selectedClient);
				if(selectedClient!=null) {
					ClientView clientView=new ClientView(selectedClient);
					setFrameInvisible();
					clientView.setVisible(true);
					
				}
			}
		});
		btnLogin.setBounds(158, 80, 103, 37);
		panel_1.add(btnLogin);
		
		JButton btnLoginAsBank = new JButton("Login As Bank");
		btnLoginAsBank.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BankView bankView=new BankView(bank);
				setFrameInvisible();
				bankView.setVisible(true);
			}
		});
		btnLoginAsBank.setBounds(144, 127, 135, 37);
		panel_1.add(btnLoginAsBank);
		
	
		
		
	}
}
