package view;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import account.Account;
import account.RegularAccountWithoutInterest;
import accountgroup.AccountGroup;
import accountgroup.IAccountComponent;
import accounttype.AccountType;
import currency.Currency;
import user.Client;

import java.awt.CardLayout;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import account.InvesmentAccount;
import invesment.Stock;
import invesment.Bond;

public class ClientView extends JFrame {

	private JPanel contentPane;
	Client client;
	private JTextField textFieldDayAmount;
	JComboBox<Account> comboBoxAccounts;
	JLabel lblBalance;
	JLabel lblBalanceValue;
	JLabel lblExpectedBalance;
	JLabel lblExpectedBalanceValue;
	JPanel rightPanel;
	private JTextField textFieldDeposit;
	JComboBox<Account> comboBoxRegularAccounts;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldNewAccountGroup;
	private JTextField textFieldAccountGroupDays;
	private JTextField textFieldStockAmount;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ClientView(Client client) {
		this.client=client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 706, 648);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		panel.add(mainPanel, "name_30313866719700");
		mainPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		mainPanel.setLayout(null);
		
		rightPanel = new JPanel();
		mainPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel);
		rightPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelRightSelectAccount = new JPanel();
		rightPanel.add(panelRightSelectAccount, "name_41933455973700");
		panelRightSelectAccount.setLayout(null);
		
		comboBoxAccounts = new JComboBox<Account>();
		
		comboBoxAccounts.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Account account=(Account) comboBoxAccounts.getSelectedItem();
				if(account!=null) {
					lblBalanceValue.setText(Double.toString(account.getBalance()));
				}	
			}
		});
		
		comboBoxAccounts.setBounds(10, 43, 264, 21);
		panelRightSelectAccount.add(comboBoxAccounts);
		
		JLabel lblNewLabel_1 = new JLabel("/Select Accounts");
		lblNewLabel_1.setBounds(10, 10, 97, 13);
		panelRightSelectAccount.add(lblNewLabel_1);
		
		lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(10, 96, 97, 13);
		panelRightSelectAccount.add(lblBalance);
		
		lblBalanceValue = new JLabel("#Balance");
		lblBalanceValue.setBounds(146, 96, 108, 13);
		panelRightSelectAccount.add(lblBalanceValue);
		
		textFieldDayAmount = new JTextField();
		textFieldDayAmount.setBounds(17, 205, 257, 19);
		panelRightSelectAccount.add(textFieldDayAmount);
		textFieldDayAmount.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Expected Balance Calculation");
		lblNewLabel_1_1.setBounds(10, 142, 264, 13);
		panelRightSelectAccount.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Please enter amount of days (for the selected account above):");
		lblNewLabel_1_1_1.setBounds(10, 182, 362, 13);
		panelRightSelectAccount.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleCalculateExpectedBalance();
			}
		});
		btnNewButton.setBounds(177, 234, 97, 36);
		panelRightSelectAccount.add(btnNewButton);
		
		lblExpectedBalance = new JLabel("");
		lblExpectedBalance.setBounds(10, 278, 129, 13);
		panelRightSelectAccount.add(lblExpectedBalance);
		
		lblExpectedBalanceValue = new JLabel("");
		lblExpectedBalanceValue.setBounds(187, 280, 248, 13);
		panelRightSelectAccount.add(lblExpectedBalanceValue);
		
		JPanel panelRightDeposit = new JPanel();
		rightPanel.add(panelRightDeposit, "name_41939333907600");
		panelRightDeposit.setLayout(null);
		
		textFieldDeposit = new JTextField();
		textFieldDeposit.setBounds(23, 112, 264, 19);
		panelRightDeposit.add(textFieldDeposit);
		textFieldDeposit.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/Deposit");
		lblNewLabel_2.setBounds(23, 22, 212, 13);
		panelRightDeposit.add(lblNewLabel_2);
		
		comboBoxRegularAccounts = new JComboBox<Account>();
		comboBoxRegularAccounts.setBounds(23, 48, 264, 21);
		panelRightDeposit.add(comboBoxRegularAccounts);
		
		JLabel lblNewLabel_3 = new JLabel("Enter deposit amount:");
		lblNewLabel_3.setBounds(23, 89, 154, 13);
		panelRightDeposit.add(lblNewLabel_3);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleDeposit();
			}
		});
		btnDeposit.setBounds(161, 164, 114, 36);
		panelRightDeposit.add(btnDeposit);
		leftPanel.setLayout(null);
		
		JPanel panelRightExchangeSelect = new JPanel();
		rightPanel.add(panelRightExchangeSelect, "name_132321658392200");
		panelRightExchangeSelect.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("Exchange From AU/Currency Account To TRY Account ");

		btnNewButton_1_2.setBounds(10, 79, 449, 50);
		panelRightExchangeSelect.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Exchange From TRY Account to AU/Currency Account ");
	
		btnNewButton_1_1_1.setBounds(10, 139, 449, 50);
		panelRightExchangeSelect.add(btnNewButton_1_1_1);
		
		
		JButton btnNewButton_1_1_1_2 = new JButton("Exchange Between Two Same Currency Accounts");
		btnNewButton_1_1_1_2.setBounds(10, 199, 449, 50);
		panelRightExchangeSelect.add(btnNewButton_1_1_1_2);
		
		JPanel panelRightFromTRY = new JPanel();
		rightPanel.add(panelRightFromTRY, "name_132433782637200");
		panelRightFromTRY.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("/Exchange From TRY Account To Gold/Currency Account");
		lblNewLabel_4.setBounds(23, 22, 321, 13);
		panelRightFromTRY.add(lblNewLabel_4);
		
		JComboBox comboBoxFromTryRegAccounts = new JComboBox();
		comboBoxFromTryRegAccounts.setBounds(23, 65, 277, 21);
		panelRightFromTRY.add(comboBoxFromTryRegAccounts);
		
		JLabel lblNewLabel_5 = new JLabel("Select TRY Account To Deposit From For Exchange");
		lblNewLabel_5.setBounds(23, 45, 309, 13);
		panelRightFromTRY.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Select Gold/Currency Account To Deposit To For Exchange");
		lblNewLabel_5_1.setBounds(23, 96, 321, 13);
		panelRightFromTRY.add(lblNewLabel_5_1);
		
		JComboBox comboBoxFromTryOtherAccounts = new JComboBox();
		comboBoxFromTryOtherAccounts.setBounds(23, 119, 277, 21);
		panelRightFromTRY.add(comboBoxFromTryOtherAccounts);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Enter amount in TRY: ");
		lblNewLabel_5_1_1.setBounds(23, 150, 289, 13);
		panelRightFromTRY.add(lblNewLabel_5_1_1);
		
		textField = new JTextField();
		textField.setBounds(23, 173, 277, 19);
		panelRightFromTRY.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Exchange");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Account fromAccount= (Account) comboBoxFromTryRegAccounts.getSelectedItem();
				Account toAccount= (Account) comboBoxFromTryOtherAccounts.getSelectedItem();
				double amount= Double.parseDouble(textField.getText());
				
				client.getBank().transferMoneyFromTryAccountToCurrencyAccount(fromAccount, toAccount, amount);
			}
		});
		btnNewButton_1.setBounds(156, 214, 144, 21);
		panelRightFromTRY.add(btnNewButton_1);
		
		JPanel panelRightToTRY = new JPanel();
		rightPanel.add(panelRightToTRY, "name_133520706744700");
		panelRightToTRY.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("/Exchange From  Gold/Currency Account To TRY Account");
		lblNewLabel_4_1.setBounds(10, 21, 351, 13);
		panelRightToTRY.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Select Gold/Currency Account To Deposit From For Exchange");
		lblNewLabel_5_2.setBounds(10, 48, 351, 13);
		panelRightToTRY.add(lblNewLabel_5_2);
		
		JComboBox comboBoxToTryOtherAccounts = new JComboBox();
		comboBoxToTryOtherAccounts.setBounds(10, 71, 277, 21);
		panelRightToTRY.add(comboBoxToTryOtherAccounts);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Select TRY Account To Deposit To For Exchange");
		lblNewLabel_5_2_1.setBounds(10, 102, 351, 13);
		panelRightToTRY.add(lblNewLabel_5_2_1);
		
		JComboBox comboBoxToTryRegAccounts = new JComboBox();
		comboBoxToTryRegAccounts.setBounds(10, 126, 277, 21);
		panelRightToTRY.add(comboBoxToTryRegAccounts);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Enter amount in Selected Account's Type(Selected Currency/Gold): ");
		lblNewLabel_5_1_1_1.setBounds(10, 157, 427, 13);
		panelRightToTRY.add(lblNewLabel_5_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 180, 277, 19);
		panelRightToTRY.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("Exchange");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Account fromAccount= (Account) comboBoxToTryOtherAccounts.getSelectedItem();
				Account toAccount= (Account) comboBoxToTryRegAccounts.getSelectedItem();
				double amount= Double.parseDouble(textField_1.getText());
				
				client.getBank().transferMoneyFromCurrencyAccountToTryAccount(fromAccount, toAccount, amount);
			}
		});
		btnNewButton_1_1.setBounds(146, 219, 144, 21);
		panelRightToTRY.add(btnNewButton_1_1);
		
		JPanel rightPanelCreateAccount = new JPanel();
		rightPanel.add(rightPanelCreateAccount, "name_7051254203500");
		rightPanelCreateAccount.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("/Create New Account");
		lblNewLabel_6.setBounds(10, 21, 312, 13);
		rightPanelCreateAccount.add(lblNewLabel_6);
		
		String[] accountTypes= {"Regular Account","USD Account","EU Account","Gold Account","Investment Account"};
		JComboBox comboBox = new JComboBox(accountTypes);
		comboBox.setBounds(10, 82, 285, 21);
		rightPanelCreateAccount.add(comboBox);
		
		
		JLabel lblNewLabel_6_1 = new JLabel("Select The Account Type (For Accounts Other Than Investment)");
		lblNewLabel_6_1.setBounds(10, 44, 328, 13);
		rightPanelCreateAccount.add(lblNewLabel_6_1);
		
		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.setBounds(159, 157, 146, 32);
		rightPanelCreateAccount.add(btnNewButton_2);
		
		JRadioButton rdbtnInterest = new JRadioButton("Account With Interest");
		rdbtnInterest.setBounds(10, 120, 153, 21);
		rightPanelCreateAccount.add(rdbtnInterest);
		
		JRadioButton rdbtnWoInterest = new JRadioButton("Account W/O Interest");
		rdbtnWoInterest.setBounds(180, 120, 186, 21);
		rightPanelCreateAccount.add(rdbtnWoInterest);
		
		JPanel panelRightInterestExchange = new JPanel();
		rightPanel.add(panelRightInterestExchange, "name_23400414480500");
		panelRightInterestExchange.setLayout(null);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("/Exchange For Interest Accounts");
		lblNewLabel_4_1_1.setBounds(10, 21, 351, 13);
		panelRightInterestExchange.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("<html> Please select two different accounts with same currency. Otherwise exchange will fail. </html>");
		lblNewLabel_4_1_1_1.setBounds(10, 44, 472, 48);
		panelRightInterestExchange.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Select Account W/O Interest To Deposit From");
		lblNewLabel_5_2_2.setBounds(10, 102, 351, 13);
		panelRightInterestExchange.add(lblNewLabel_5_2_2);
		
		JComboBox comboInterestExchangeWithoutInterest = new JComboBox();
		comboInterestExchangeWithoutInterest.setBounds(10, 125, 277, 21);
		panelRightInterestExchange.add(comboInterestExchangeWithoutInterest);
		
		JLabel lblNewLabel_5_2_2_1 = new JLabel("Select Account With Interest To Deposit To");
		lblNewLabel_5_2_2_1.setBounds(10, 156, 351, 13);
		panelRightInterestExchange.add(lblNewLabel_5_2_2_1);
		
		JComboBox comboInterestExchangeWithInterest = new JComboBox();
		comboInterestExchangeWithInterest.setBounds(10, 179, 277, 21);
		panelRightInterestExchange.add(comboInterestExchangeWithInterest);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 233, 277, 19);
		panelRightInterestExchange.add(textField_2);
		
		JLabel lblNewLabel_5_2_2_1_1 = new JLabel("Amount:");
		lblNewLabel_5_2_2_1_1.setBounds(10, 210, 351, 13);
		panelRightInterestExchange.add(lblNewLabel_5_2_2_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Exchange");
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Account fromAccount= (Account) comboInterestExchangeWithoutInterest.getSelectedItem();
				Account toAccount= (Account) comboInterestExchangeWithInterest.getSelectedItem();
				double amount= Double.parseDouble(textField_2.getText());
				
				client.getBank().transferMoneyFromAccountToAccount(fromAccount, toAccount, amount);
			}
		});
		btnNewButton_1_1_2.setBounds(142, 262, 144, 21);
		panelRightInterestExchange.add(btnNewButton_1_1_2);
		
		JPanel panelRightAccountGroups = new JPanel();
		rightPanel.add(panelRightAccountGroups, "name_28688694551600");
		panelRightAccountGroups.setLayout(null);
		
		JLabel lblAccountGroup = new JLabel("Account Groups");
		lblAccountGroup.setBounds(10, 10, 147, 13);
		panelRightAccountGroups.add(lblAccountGroup);
		
		DefaultListModel<AccountGroup> listModel = new DefaultListModel<>();
		JList listAccountGroups = new JList();
		listAccountGroups.setModel(listModel);
		
		listAccountGroups.setBounds(10, 63, 166, 168);
		panelRightAccountGroups.add(listAccountGroups);
		
		JLabel lblSelectAnAccount = new JLabel("Select an Account Group To See Its Accounts");
		lblSelectAnAccount.setBounds(10, 22, 336, 13);
		panelRightAccountGroups.add(lblSelectAnAccount);
		
		DefaultListModel<String> listModel_2 = new DefaultListModel<>();
		JList listSelectedGroupAccountComponents = new JList();
		listSelectedGroupAccountComponents.setModel(listModel_2);
		listSelectedGroupAccountComponents.setBounds(199, 63, 166, 168);
		panelRightAccountGroups.add(listSelectedGroupAccountComponents);
				
		JLabel lblAccountGroup_1_1 = new JLabel("Accounts In Selected Account Group ");
		lblAccountGroup_1_1.setBounds(199, 40, 189, 13);
		panelRightAccountGroups.add(lblAccountGroup_1_1);
		
		JLabel lblAccountGroups = new JLabel("Account Groups");
		lblAccountGroups.setBounds(10, 40, 177, 13);
		panelRightAccountGroups.add(lblAccountGroups);
		
		textFieldNewAccountGroup = new JTextField();
		textFieldNewAccountGroup.setBounds(10, 287, 336, 19);
		panelRightAccountGroups.add(textFieldNewAccountGroup);
		textFieldNewAccountGroup.setColumns(10);
		
		JLabel lblCreateNewAccount_1 = new JLabel("Create New Account Group");
		lblCreateNewAccount_1.setBounds(10, 264, 247, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1);
		
		JButton btnCreateAccountGroup = new JButton("Create");
		
		btnCreateAccountGroup.setBounds(260, 316, 85, 21);
		panelRightAccountGroups.add(btnCreateAccountGroup);
		
		JLabel lblCreateNewAccount_1_1 = new JLabel("Select An Account Group and An Account Component to Add To Group");
		lblCreateNewAccount_1_1.setBounds(10, 347, 428, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1);
		
		JComboBox comboBoxAccountGroups = new JComboBox<AccountGroup>();
		comboBoxAccountGroups.setBounds(10, 393, 166, 21);
		panelRightAccountGroups.add(comboBoxAccountGroups);
		
		JComboBox comboBoxAccountComponents = new JComboBox<IAccountComponent>();
		comboBoxAccountComponents.setBounds(209, 393, 166, 21);
		panelRightAccountGroups.add(comboBoxAccountComponents);
		
		JButton btnAddAccountToGroup = new JButton("Add Account To Group");
		btnAddAccountToGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AccountGroup selectedGroup = (AccountGroup) comboBoxAccountGroups.getSelectedItem();
				IAccountComponent selectedComponent=(IAccountComponent) comboBoxAccountComponents.getSelectedItem();
				selectedGroup.add(selectedComponent);
			}
		});
		btnAddAccountToGroup.setBounds(147, 424, 228, 21);
		panelRightAccountGroups.add(btnAddAccountToGroup);
		
		JLabel lblCreateNewAccount_1_1_1 = new JLabel("All Account Groups");
		lblCreateNewAccount_1_1_1.setBounds(10, 370, 121, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1_1);
		
		JLabel lblCreateNewAccount_1_1_1_1 = new JLabel("All Account Components");
		lblCreateNewAccount_1_1_1_1.setBounds(225, 370, 121, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1_1_1);
		
		JLabel lblGroupBalance = new JLabel("Selected Group Balance:");
		lblGroupBalance.setBounds(10, 241, 166, 13);
		panelRightAccountGroups.add(lblGroupBalance);
		
		JLabel lblSelectedGroupBalanceValue = new JLabel("");
		lblSelectedGroupBalanceValue.setBounds(209, 241, 121, 13);
		panelRightAccountGroups.add(lblSelectedGroupBalanceValue);
		
		JLabel lblCreateNewAccount_1_1_2 = new JLabel("Account Group Excpected Balance Calculation");
		lblCreateNewAccount_1_1_2.setBounds(10, 469, 378, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1_2);
		
		JComboBox<AccountGroup> comboBoxAccountGroups_1 = new JComboBox<AccountGroup>();
		comboBoxAccountGroups_1.setBounds(260, 492, 178, 21);
		panelRightAccountGroups.add(comboBoxAccountGroups_1);
		
		JLabel lblCreateNewAccount_1_1_1_2 = new JLabel("Select An Account Group ");
		lblCreateNewAccount_1_1_1_2.setBounds(10, 496, 166, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1_1_2);
		
		textFieldAccountGroupDays = new JTextField();
		textFieldAccountGroupDays.setBounds(260, 523, 178, 19);
		panelRightAccountGroups.add(textFieldAccountGroupDays);
		textFieldAccountGroupDays.setColumns(10);
		
		JLabel lblCreateNewAccount_1_1_1_2_1 = new JLabel("Enter Number Of Days");
		lblCreateNewAccount_1_1_1_2_1.setBounds(10, 526, 166, 13);
		panelRightAccountGroups.add(lblCreateNewAccount_1_1_1_2_1);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalculate.setBounds(225, 552, 218, 21);
		panelRightAccountGroups.add(btnCalculate);
		
		JLabel lblNewLabel_7 = new JLabel("Excepted Balance for Selected Account Group:");
		lblNewLabel_7.setBounds(10, 583, 273, 13);
		panelRightAccountGroups.add(lblNewLabel_7);
		
		JLabel lblAccountGroupExpectedBalanceValue = new JLabel("");
		lblAccountGroupExpectedBalanceValue.setBounds(315, 583, 135, 13);
		panelRightAccountGroups.add(lblAccountGroupExpectedBalanceValue);
		
		JPanel panelRightStocksAndBonds = new JPanel();
		rightPanel.add(panelRightStocksAndBonds, "name_94260394840400");
		panelRightStocksAndBonds.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("/Stocks and Bonds");
		lblNewLabel_8.setBounds(10, 10, 197, 13);
		panelRightStocksAndBonds.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Buy Stock");
		lblNewLabel_9.setBounds(10, 141, 147, 13);
		panelRightStocksAndBonds.add(lblNewLabel_9);
		
		JComboBox<Stock> comboBoxStocks = new JComboBox<Stock>();
		comboBoxStocks.setBounds(10, 179, 330, 21);
		panelRightStocksAndBonds.add(comboBoxStocks);
		
		JLabel lblNewLabel_9_1 = new JLabel("All Stocks");
		lblNewLabel_9_1.setBounds(10, 156, 147, 13);
		panelRightStocksAndBonds.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("Selected Stock Price:");
		lblNewLabel_10.setBounds(10, 210, 160, 13);
		panelRightStocksAndBonds.add(lblNewLabel_10);
		
		JLabel lblSelectedStockPriceValue = new JLabel("");
		lblSelectedStockPriceValue.setBounds(232, 210, 160, 13);
		panelRightStocksAndBonds.add(lblSelectedStockPriceValue);
		
		JLabel lblNewLabel_10_1 = new JLabel("Selected Stock Amount:");
		lblNewLabel_10_1.setBounds(10, 233, 160, 13);
		panelRightStocksAndBonds.add(lblNewLabel_10_1);
		
		JLabel lblSelectedStockAmountValue = new JLabel("");
		lblSelectedStockAmountValue.setBounds(232, 233, 160, 13);
		panelRightStocksAndBonds.add(lblSelectedStockAmountValue);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Write The Amount To Purchase:");
		lblNewLabel_10_1_1.setBounds(10, 256, 160, 13);
		panelRightStocksAndBonds.add(lblNewLabel_10_1_1);
		
		textFieldStockAmount = new JTextField();
		textFieldStockAmount.setBounds(232, 253, 141, 19);
		panelRightStocksAndBonds.add(textFieldStockAmount);
		textFieldStockAmount.setColumns(10);
		
		JButton btnBuyStock = new JButton("Buy Stock");
		btnBuyStock.setBounds(239, 282, 134, 33);
		panelRightStocksAndBonds.add(btnBuyStock);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("All Bonds");
		lblNewLabel_9_1_1.setBounds(10, 329, 147, 13);
		panelRightStocksAndBonds.add(lblNewLabel_9_1_1);
		
		JComboBox<Bond> comboBoxBonds = new JComboBox<Bond>();
		comboBoxBonds.setBounds(10, 352, 356, 21);
		panelRightStocksAndBonds.add(comboBoxBonds);
		
		JLabel lblNewLabel_10_2 = new JLabel("Selected Bond Price:");
		lblNewLabel_10_2.setBounds(10, 383, 160, 13);
		panelRightStocksAndBonds.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_1_2 = new JLabel("Selected Bond Interest:");
		lblNewLabel_10_1_2.setBounds(10, 406, 160, 13);
		panelRightStocksAndBonds.add(lblNewLabel_10_1_2);
		
		JButton btnBuyBond = new JButton("Buy Bond");
		btnBuyBond.setBounds(232, 438, 134, 33);
		panelRightStocksAndBonds.add(btnBuyBond);
		
		JLabel lblSelectedBondPriceValue = new JLabel("");
		lblSelectedBondPriceValue.setBounds(213, 383, 160, 13);
		panelRightStocksAndBonds.add(lblSelectedBondPriceValue);
		
		JLabel lblNewLabel_9_2 = new JLabel("Select The Investment Account To Buy The Stock/Bond To:");
		lblNewLabel_9_2.setBounds(17, 33, 356, 13);
		panelRightStocksAndBonds.add(lblNewLabel_9_2);
		
		JComboBox<InvesmentAccount> comboBoxInvestmentAccounts = new JComboBox<InvesmentAccount>();
		comboBoxInvestmentAccounts.setBounds(10, 56, 330, 21);
		panelRightStocksAndBonds.add(comboBoxInvestmentAccounts);
		
		JLabel lblSelectedBondInterestValue = new JLabel("");
		lblSelectedBondInterestValue.setBounds(213, 406, 160, 13);
		panelRightStocksAndBonds.add(lblSelectedBondInterestValue);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Select TRY Account To Deposit The Purchase Amount From:");
		lblNewLabel_9_2_1.setBounds(10, 87, 356, 13);
		panelRightStocksAndBonds.add(lblNewLabel_9_2_1);
		
		JComboBox<Account> comboBoxFundsTryAccounts = new JComboBox<Account>();
		comboBoxFundsTryAccounts.setBounds(10, 110, 330, 21);
		panelRightStocksAndBonds.add(comboBoxFundsTryAccounts);
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String accountType=comboBox.getSelectedItem().toString();
				boolean isInterestAccount=rdbtnInterest.isSelected();
				AccountType selectedAccountType = null;
				Currency currency = null;
				
				switch(accountType) {
					case "Regular Account":
						if(isInterestAccount)
							selectedAccountType=AccountType.RW;
						else
							selectedAccountType=AccountType.RWO;
						currency=Currency.TRY;
						break;
					case "USD Account" :
						if(isInterestAccount)
							selectedAccountType=AccountType.FCW;
						else
							selectedAccountType=AccountType.FCWO;
						currency=Currency.USD;
						break;
					case "EU Account" :
						if(isInterestAccount)
							selectedAccountType=AccountType.FCW;
						else
							selectedAccountType=AccountType.FCWO;
						currency=Currency.EUR;
						break;
					case "Gold Account" :
						if(isInterestAccount)
							selectedAccountType=AccountType.GW;
						else
							selectedAccountType=AccountType.GWO;
						currency=Currency.XAU;
						break;
					case "Investment Account":
						selectedAccountType=AccountType.I;
						currency=Currency.TRY;
						break;	
				}
			client.createNewAccount(selectedAccountType, currency);	
			fillComboBoxAccounts();
			}
		});
		
		JPanel panelSelectAccount = new JPanel();
		panelSelectAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				//comboBoxRegularAccounts.removeAllItems();
				comboBoxAccounts.removeAllItems();
				for(Account account: client.getAccounts() ) {
					 comboBoxAccounts.addItem(account);
				}	
				panelRightSelectAccount.setVisible(true);
			}
		});
		panelSelectAccount.setBackground(new Color(215, 215, 215));
		panelSelectAccount.setForeground(new Color(192, 192, 192));
		panelSelectAccount.setBounds(0, 31, 207, 28);
		leftPanel.add(panelSelectAccount);
		panelSelectAccount.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Account");
		lblNewLabel.setBounds(22, 10, 96, 13);
		panelSelectAccount.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				listModel.clear();
				comboBoxAccountGroups.removeAllItems();
				comboBoxAccountGroups_1.removeAllItems();
				comboBoxAccountComponents.removeAllItems();
				listModel.addElement(client.getAccountGroup());
				comboBoxAccountGroups.addItem(client.getAccountGroup());
				comboBoxAccountGroups_1.addItem(client.getAccountGroup());
				for(AccountGroup accountGroup : client.getAccountGroup().getAccountGroupChildren()) {
					listModel.addElement(accountGroup);
					comboBoxAccountGroups.addItem(accountGroup);
					comboBoxAccountGroups_1.addItem(accountGroup);
					comboBoxAccountComponents.addItem(accountGroup);
				}
						
				for(Account accountComponent : client.getAccounts()) {
					comboBoxAccountComponents.addItem(accountComponent);
				}
				
				
				panelRightAccountGroups.setVisible(true);
				
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(Color.LIGHT_GRAY);
		panel_1_1.setBackground(new Color(215, 215, 215));
		panel_1_1.setBounds(0, 68, 207, 28);
		leftPanel.add(panel_1_1);
		
		JLabel lblViewAccountGroups = new JLabel("Account Group Operations");
		lblViewAccountGroups.setBounds(0, 10, 197, 13);
		panel_1_1.add(lblViewAccountGroups);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				rightPanelCreateAccount.setVisible(true);
			}
		});
		panel_1_2.setLayout(null);
		panel_1_2.setForeground(Color.LIGHT_GRAY);
		panel_1_2.setBackground(new Color(215, 215, 215));
		panel_1_2.setBounds(0, 106, 207, 28);
		leftPanel.add(panel_1_2);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setBounds(10, 10, 176, 13);
		panel_1_2.add(lblCreateNewAccount);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();		
				panelRightExchangeSelect.setVisible(true);
			}
		});
		panel_1_3.setLayout(null);
		panel_1_3.setForeground(Color.LIGHT_GRAY);
		panel_1_3.setBackground(new Color(215, 215, 215));
		panel_1_3.setBounds(0, 144, 207, 28);
		leftPanel.add(panel_1_3);
		
		JLabel lblExchangeCurauWith = new JLabel("Exchange ");
		lblExchangeCurauWith.setBounds(24, 10, 144, 13);
		panel_1_3.add(lblExchangeCurauWith);
		
		JPanel panelDeposit = new JPanel();
		panelDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();	
				comboBoxRegularAccounts.removeAllItems();
				for(Account account:client.getAccounts())
				{
					if(account.getAccountType().equals(AccountType.RWO)) {
						comboBoxRegularAccounts.addItem(account);
					}
				}				
				panelRightDeposit.setVisible(true);
			}
		});
		panelDeposit.setLayout(null);
		panelDeposit.setForeground(Color.LIGHT_GRAY);
		panelDeposit.setBackground(new Color(215, 215, 215));
		panelDeposit.setBounds(0, 182, 207, 28);
		leftPanel.add(panelDeposit);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(25, 10, 131, 13);
		panelDeposit.add(lblDeposit);
		
		JPanel panel_1_3_1_1 = new JPanel();
		panel_1_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				comboBoxInvestmentAccounts.removeAllItems();
				comboBoxFundsTryAccounts.removeAllItems();
				for(Account account:client.getAccounts())
				{	if(account.getAccountType().equals(AccountType.I)) {
					comboBoxInvestmentAccounts.addItem((InvesmentAccount) account);
					}
				
					else if(account.getAccountType().equals(AccountType.RW) || account.getAccountType().equals(AccountType.RWO)) {
						comboBoxFundsTryAccounts.addItem((Account) account);
					}
				}
				
				
				comboBoxStocks.removeAllItems();
				for(Stock stock: client.getBank().getStocks()) {
					comboBoxStocks.addItem(stock);
				}
				comboBoxBonds.removeAllItems();
				for(Bond bond: client.getBank().getBonds()) {
					comboBoxBonds.addItem(bond);
				}

				
				panelRightStocksAndBonds.setVisible(true);
			}
		});
		panel_1_3_1_1.setLayout(null);
		panel_1_3_1_1.setForeground(Color.LIGHT_GRAY);
		panel_1_3_1_1.setBackground(new Color(215, 215, 215));
		panel_1_3_1_1.setBounds(0, 220, 207, 28);
		leftPanel.add(panel_1_3_1_1);
		
		JLabel lblStocksfunds = new JLabel("Stocks&Funds");
		lblStocksfunds.setBounds(22, 10, 149, 13);
		panel_1_3_1_1.add(lblStocksfunds);
		
		JPanel panelSelectAccount_1 = new JPanel();
		panelSelectAccount_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setFrameInvisible();
				LoginView loginView=new LoginView(client.getBank());
				loginView.setVisible(true);
			}
		});
		panelSelectAccount_1.setLayout(null);
		panelSelectAccount_1.setForeground(Color.LIGHT_GRAY);
		panelSelectAccount_1.setBackground(new Color(215, 215, 215));
		panelSelectAccount_1.setBounds(0, 258, 207, 28);
		leftPanel.add(panelSelectAccount_1);
		
		JLabel lblLogoutBack = new JLabel("Logout - Back To Login ");
		lblLogoutBack.setBounds(10, 10, 149, 13);
		panelSelectAccount_1.add(lblLogoutBack);
		splitPane.setBounds(0, 0, 696, 648);
		splitPane.setResizeWeight(0.30); 
		mainPanel.add(splitPane);
		
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				comboBoxFromTryRegAccounts.removeAllItems();
				comboBoxFromTryOtherAccounts.removeAllItems();
				for(Account account: client.getAccounts() ) {
					if(account.getAccountType().equals(AccountType.RW) || account.getAccountType().equals(AccountType.RWO)) {
						comboBoxFromTryRegAccounts.addItem(account);
					}
					
					if(account.getAccountType().equals(AccountType.FCW) || account.getAccountType().equals(AccountType.FCWO)
							|| account.getAccountType().equals(AccountType.GW) || account.getAccountType().equals(AccountType.GWO) ) {
						comboBoxFromTryOtherAccounts.addItem(account);
					}
				}
				panelRightFromTRY.setVisible(true);
			}
		});
		
		
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				closeAllPanels();
				comboBoxToTryRegAccounts.removeAllItems();
				comboBoxToTryOtherAccounts.removeAllItems();
				for(Account account: client.getAccounts() ) {
					if(account.getAccountType().equals(AccountType.RW) || account.getAccountType().equals(AccountType.RWO)) {
						comboBoxToTryRegAccounts.addItem(account);
					}
					
					if( account.getAccountType().equals(AccountType.FCWO) || account.getAccountType().equals(AccountType.FCW)
						|| account.getAccountType().equals(AccountType.GWO) || account.getAccountType().equals(AccountType.GW )) {
						comboBoxToTryOtherAccounts.addItem(account);
					}
				}
				panelRightToTRY.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1_1 = new JButton("Exchange For Accounts With Interest");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				comboInterestExchangeWithoutInterest.removeAllItems();
				comboInterestExchangeWithInterest.removeAllItems();
				
				for(Account account: client.getAccounts()) {
					
					if(account.getAccountType().equals(AccountType.FCWO) || account.getAccountType().equals(AccountType.GWO)) {
						comboInterestExchangeWithoutInterest.addItem(account);
						comboInterestExchangeWithInterest.addItem(account);
					}
					
				
					else if(account.getAccountType().equals(AccountType.FCW) || account.getAccountType().equals(AccountType.GW)) {
						comboInterestExchangeWithInterest.addItem(account);
					}
					
				}
				
			}
		});
		
		btnNewButton_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				comboInterestExchangeWithoutInterest.removeAllItems();
				comboInterestExchangeWithInterest.removeAllItems();
				
				for(Account account: client.getAccounts()) {
					//if(account.getAccountType().equals(AccountType.FCWO) || account.getAccountType().equals(AccountType.GWO) || account.getAccountType().equals(AccountType.RWO)) {
					if( !account.getAccountType().equals(AccountType.I)) {	
						comboInterestExchangeWithoutInterest.addItem(account);
						comboInterestExchangeWithInterest.addItem(account);
					}
				}
				
				panelRightInterestExchange.setVisible(true);

			}
		});
		
		listAccountGroups.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				  AccountGroup selectedAccountGroup=(AccountGroup) listAccountGroups.getSelectedValue();
				  if(selectedAccountGroup!=null) {
					  listModel_2.clear();
				      for(String accountComponentName : selectedAccountGroup.getComponentName()) { 
				          	listModel_2.addElement(accountComponentName);
				        }
				      lblSelectedGroupBalanceValue.setText(Double.toString(selectedAccountGroup.getBalance()));
			}
			}
		});
		
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AccountGroup selectedGroup=(AccountGroup) comboBoxAccountGroups_1.getSelectedItem();
				int days=Integer.parseInt(textFieldAccountGroupDays.getText());
				lblAccountGroupExpectedBalanceValue.setText(Double.toString(selectedGroup.getExpectedBalanceInTRY(days)));
			}
		});
		
		
		 comboBoxStocks.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               Stock selectedItem = (Stock) comboBoxStocks.getSelectedItem();
	               if(selectedItem!=null) {
	               lblSelectedStockPriceValue.setText(Double.toString(selectedItem.getPrice()));
	               lblSelectedStockAmountValue.setText(Integer.toString(selectedItem.getQuantity()));
	               }
	            }
	        });
	               
	     comboBoxBonds.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	              Bond selectedItem = (Bond) comboBoxBonds.getSelectedItem();
	              if(selectedItem!=null) {
	              lblSelectedBondPriceValue.setText(Double.toString(selectedItem.getFaceValue()));
	              lblSelectedBondInterestValue.setText(Double.toString(selectedItem.getCouponRate()));
	              }
	             }
	       });
	     
			btnBuyStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Stock stock=(Stock) comboBoxStocks.getSelectedItem();
					int stockAmount=Integer.parseInt(textFieldStockAmount.getText());
					InvesmentAccount selectedAccount= (InvesmentAccount) comboBoxInvestmentAccounts.getSelectedItem();
					Account selectedAccountToDepositFrom= (Account) comboBoxFundsTryAccounts.getSelectedItem();
					if(selectedAccount!=null && selectedAccountToDepositFrom != null) {
					client.buyStock(stock,stockAmount,selectedAccount, selectedAccountToDepositFrom);
					}
				}
			});
			
			btnBuyBond.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					Bond bond=(Bond) comboBoxBonds.getSelectedItem();
					InvesmentAccount selectedAccount= (InvesmentAccount) comboBoxInvestmentAccounts.getSelectedItem();
					Account selectedAccountToDepositFrom= (Account) comboBoxFundsTryAccounts.getSelectedItem();
					client.buyBond(bond,selectedAccount, selectedAccountToDepositFrom);
				}
			});
			
			btnCreateAccountGroup.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					String newAccountGroupName= textFieldNewAccountGroup.getText();
					AccountGroup newGroup=client.createNewAccountGroup(newAccountGroupName);
					listModel.addElement(newGroup);
					
					comboBoxAccountGroups.removeAllItems();
					comboBoxAccountGroups_1.removeAllItems();
					comboBoxAccountComponents.removeAllItems();
					comboBoxAccountGroups.addItem(client.getAccountGroup());
					comboBoxAccountGroups_1.addItem(client.getAccountGroup());
					for(AccountGroup accountGroup : client.getAccountGroup().getAccountGroupChildren()) {
						comboBoxAccountGroups.addItem(accountGroup);
						comboBoxAccountGroups_1.addItem(accountGroup);
						comboBoxAccountComponents.addItem(accountGroup);
					}
					
					for(Account accountComponent : client.getAccounts()) {
						comboBoxAccountComponents.addItem(accountComponent);
					}
				}
			});
	   		
		
		this.fillComboBoxAccounts();
		this.initialiseSelectAccountsTab();
	}

	private void fillComboBoxAccounts() {
		// TODO Auto-generated method stub
		comboBoxAccounts.removeAllItems();
		comboBoxRegularAccounts.removeAllItems();
		
		for(Account account: client.getAccounts() ) {
			 comboBoxAccounts.addItem(account);
		}	
		
		for(Account account: client.getAccounts() ) {
			if(account.getAccountType().equals(AccountType.RWO)) {
			 comboBoxRegularAccounts.addItem(account);
			}
		}
	}
	
	private void initialiseSelectAccountsTab() {
		Account selectedAccount=(Account) comboBoxAccounts.getSelectedItem();
		this.lblBalanceValue.setText(Double.toString(selectedAccount.getBalance()));
		
	}
	
	private void handleCalculateExpectedBalance() {
		// TODO Auto-generated method stub
		String userInputDays=textFieldDayAmount.getText();
		if(textFieldDayAmount.getText().isEmpty() || Integer.parseInt(userInputDays)>30) {return;}
		//else
		Account selectedAccount=(Account) comboBoxAccounts.getSelectedItem();
		double expectedBalance=selectedAccount.getExpectedBalance(Integer.parseInt(userInputDays));
		lblExpectedBalance.setText("Expected Balance: ");
		lblExpectedBalanceValue.setText(Double.toString(expectedBalance));
		
	}
	
	private void closeAllPanels() {
		 for (Component c : rightPanel.getComponents())
		    {
		        if (c instanceof JPanel) 
		            ((JPanel)c).setVisible(false);
		    }		
	}
	
	private void handleDeposit() {
		double depositAmount=Double.parseDouble(textFieldDeposit.getText());
		
		Account selectedAccount=(Account) comboBoxRegularAccounts.getSelectedItem();
		if(selectedAccount!=null) {
			((RegularAccountWithoutInterest)selectedAccount).deposit(depositAmount);
		}
		
		fillComboBoxAccounts();
		initialiseSelectAccountsTab();
		
	}
	
	private void setFrameInvisible() {
		this.setVisible(false);
	}
}
