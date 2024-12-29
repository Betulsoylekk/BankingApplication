package view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import invesment.Bond;
import invesment.Stock;
import user.Bank;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import currency.Currency;

public class BankView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStockName;
	private JTextField textFieldStockPrice;
	private JTextField textFieldStockQuantity;
	private JTextField textFieldBondName;
	private JTextField textFieldBondPrice;
	private JTextField textFieldBondInterest;
	Bank bank;
	private JTextField textFieldModifyStockName;
	private JTextField textFieldModifyStockPrice;
	private JTextField textFieldModifyStockQuantity;
	private JTextField textFieldModifyBondName;
	private JTextField textFieldModifyBondPrice;
	private JTextField textFieldModifyBondInterest;
	JPanel rightPanel;
	private JTextField textFieldCurrencyRate;
	private JTextField textFieldInterestRate;
	private JTextField textFieldGivenDay;

	/**
	 * Launch the application.
	 */
	
	private void setFrameInvisible() {
		this.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public BankView(Bank bank) {
		this.bank=bank;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 692, 506);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		mainPanel.setLayout(null);
		
		rightPanel = new JPanel();
		mainPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel);
		leftPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 69, 207, 38);
		leftPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Stocks And Bonds");
		lblNewLabel.setBounds(10, 15, 159, 13);
		panel.add(lblNewLabel);
		
		JPanel panelModifyStockAndBonds = new JPanel();
		panelModifyStockAndBonds.setLayout(null);
		panelModifyStockAndBonds.setBackground(Color.LIGHT_GRAY);
		panelModifyStockAndBonds.setBounds(0, 117, 207, 38);
		leftPanel.add(panelModifyStockAndBonds);
		
		JLabel lblModifyStocksAnd = new JLabel("Modify Stocks And Bonds");
		lblModifyStocksAnd.setBounds(10, 15, 170, 13);
		panelModifyStockAndBonds.add(lblModifyStocksAnd);
		
		JPanel panelCurrencyAndInterest = new JPanel();
		panelCurrencyAndInterest.setLayout(null);
		panelCurrencyAndInterest.setBackground(Color.LIGHT_GRAY);
		panelCurrencyAndInterest.setBounds(0, 165, 207, 38);
		leftPanel.add(panelCurrencyAndInterest);
		
		JLabel lblCurrencyAndInterest = new JLabel("Currency And Interest Rates");
		lblCurrencyAndInterest.setBounds(10, 15, 186, 13);
		panelCurrencyAndInterest.add(lblCurrencyAndInterest);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(0, 213, 207, 38);
		leftPanel.add(panel_2_1);
		
		JLabel lblDayOperations = new JLabel("Day Operations");
		lblDayOperations.setBounds(10, 15, 176, 13);
		panel_2_1.add(lblDayOperations);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setFrameInvisible();
				LoginView loginView=new LoginView(bank);
				loginView.setVisible(true);
			}
		});
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1_1.setBounds(0, 261, 207, 38);
		leftPanel.add(panel_2_1_1);
		
		JLabel lblLogoutBack = new JLabel("Logout - Back to Login");
		lblLogoutBack.setBounds(10, 15, 159, 13);
		panel_2_1_1.add(lblLogoutBack);
		rightPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelRightStocksAndBonds = new JPanel();
		rightPanel.add(panelRightStocksAndBonds, "name_51275165813700");
		panelRightStocksAndBonds.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("/Stocks And Bonds");
		lblNewLabel_1.setBounds(20, 10, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Create New Stock");
		lblNewLabel_1_1.setBounds(20, 33, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1);
		
		textFieldStockName = new JTextField();
		textFieldStockName.setBounds(209, 53, 182, 19);
		panelRightStocksAndBonds.add(textFieldStockName);
		textFieldStockName.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Stock Name:");
		lblNewLabel_1_1_1.setBounds(20, 56, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Stock Price:");
		lblNewLabel_1_1_1_1.setBounds(20, 84, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1_1);
		
		textFieldStockPrice = new JTextField();
		textFieldStockPrice.setColumns(10);
		textFieldStockPrice.setBounds(209, 82, 182, 19);
		panelRightStocksAndBonds.add(textFieldStockPrice);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Stock Quantity:");
		lblNewLabel_1_1_1_1_1.setBounds(20, 107, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1_1_1);
		
		textFieldStockQuantity = new JTextField();
		textFieldStockQuantity.setColumns(10);
		textFieldStockQuantity.setBounds(209, 111, 182, 19);
		panelRightStocksAndBonds.add(textFieldStockQuantity);
		
		JButton btnNewButton = new JButton("Create Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stockName=textFieldStockName.getText();
				double stockPrice=Double.parseDouble(textFieldStockPrice.getText());
				int stockQuantity=Integer.parseInt(textFieldStockQuantity.getText());
				
				bank.createNewStock(stockName,stockPrice,stockQuantity);
				
			}
		});
		btnNewButton.setBounds(252, 140, 139, 21);
		panelRightStocksAndBonds.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Create New Bond");
		lblNewLabel_1_1_2.setBounds(20, 176, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Bond Name:");
		lblNewLabel_1_1_1_2.setBounds(20, 199, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Bond Price:");
		lblNewLabel_1_1_1_1_2.setBounds(20, 222, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Bond Interest:");
		lblNewLabel_1_1_1_1_2_1.setBounds(20, 245, 150, 13);
		panelRightStocksAndBonds.add(lblNewLabel_1_1_1_1_2_1);
		
		textFieldBondName = new JTextField();
		textFieldBondName.setColumns(10);
		textFieldBondName.setBounds(209, 196, 182, 19);
		panelRightStocksAndBonds.add(textFieldBondName);
		
		textFieldBondPrice = new JTextField();
		textFieldBondPrice.setColumns(10);
		textFieldBondPrice.setBounds(209, 219, 182, 19);
		panelRightStocksAndBonds.add(textFieldBondPrice);
		
		textFieldBondInterest = new JTextField();
		textFieldBondInterest.setColumns(10);
		textFieldBondInterest.setBounds(209, 242, 182, 19);
		panelRightStocksAndBonds.add(textFieldBondInterest);
		
		JButton btnCreateBond = new JButton("Create Bond");
		btnCreateBond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bondName=textFieldBondName.getText();
				double bondPrice=Double.parseDouble(textFieldBondPrice.getText());
				double bondInterest=Double.parseDouble(textFieldBondInterest.getText());
				
				bank.createNewBond(bondName,bondPrice,bondInterest);
			}
		});
		btnCreateBond.setBounds(252, 271, 139, 21);
		panelRightStocksAndBonds.add(btnCreateBond);
		
		JPanel panelRightModifyStocksAndBonds = new JPanel();
		panelRightModifyStocksAndBonds.setLayout(null);
		rightPanel.add(panelRightModifyStocksAndBonds, "name_107706088481400");
		
		JLabel lblNewLabel_1_2 = new JLabel("/Modify Stocks And Bonds");
		lblNewLabel_1_2.setBounds(20, 10, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_2);
		
		textFieldModifyStockName = new JTextField();
		textFieldModifyStockName.setColumns(10);
		textFieldModifyStockName.setBounds(209, 105, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyStockName);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Stock Name:");
		lblNewLabel_1_1_1_3.setBounds(20, 108, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Stock Price:");
		lblNewLabel_1_1_1_1_3.setBounds(20, 137, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_1_3);
		
		textFieldModifyStockPrice = new JTextField();
		textFieldModifyStockPrice.setColumns(10);
		textFieldModifyStockPrice.setBounds(209, 134, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyStockPrice);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Stock Quantity:");
		lblNewLabel_1_1_1_1_1_1.setBounds(20, 165, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_1_1_1);
		
		textFieldModifyStockQuantity = new JTextField();
		textFieldModifyStockQuantity.setColumns(10);
		textFieldModifyStockQuantity.setBounds(209, 162, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyStockQuantity);
		
		JButton btnModifyStock = new JButton("Modify Stock");
		btnModifyStock.setBounds(252, 191, 139, 21);
		panelRightModifyStocksAndBonds.add(btnModifyStock);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Select Bond To Modify");
		lblNewLabel_1_1_2_1.setBounds(20, 222, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Bond Name:");
		lblNewLabel_1_1_1_2_1.setBounds(20, 289, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_2_2 = new JLabel("Bond Price:");
		lblNewLabel_1_1_1_1_2_2.setBounds(20, 323, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Bond Interest:");
		lblNewLabel_1_1_1_1_2_1_1.setBounds(20, 346, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_1_1_2_1_1);
		
		textFieldModifyBondName = new JTextField();
		textFieldModifyBondName.setColumns(10);
		textFieldModifyBondName.setBounds(209, 286, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyBondName);
		
		textFieldModifyBondPrice = new JTextField();
		textFieldModifyBondPrice.setColumns(10);
		textFieldModifyBondPrice.setBounds(209, 314, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyBondPrice);
		
		textFieldModifyBondInterest = new JTextField();
		textFieldModifyBondInterest.setColumns(10);
		textFieldModifyBondInterest.setBounds(209, 343, 182, 19);
		panelRightModifyStocksAndBonds.add(textFieldModifyBondInterest);
		
		JButton btnModifyBond = new JButton("Modify Bond");
		btnModifyBond.setBounds(252, 372, 139, 21);
		panelRightModifyStocksAndBonds.add(btnModifyBond);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Select Stock To Modify");
		lblNewLabel_1_1_3_1.setBounds(20, 33, 150, 13);
		panelRightModifyStocksAndBonds.add(lblNewLabel_1_1_3_1);
		
		JComboBox<Stock> comboBoxModifyStocks = new JComboBox<Stock>();
		comboBoxModifyStocks.setBounds(20, 56, 210, 21);
		panelRightModifyStocksAndBonds.add(comboBoxModifyStocks);
		
		JComboBox<Bond> comboBoxModifyBonds = new JComboBox<Bond>();
		comboBoxModifyBonds.setBounds(20, 242, 210, 21);
		panelRightModifyStocksAndBonds.add(comboBoxModifyBonds);
		
		JPanel panelRightCurrencyAndInterest = new JPanel();
		rightPanel.add(panelRightCurrencyAndInterest, "name_110100066257300");
		panelRightCurrencyAndInterest.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("/Set Currency And Interest Rates");
		lblNewLabel_2.setBounds(10, 10, 199, 13);
		panelRightCurrencyAndInterest.add(lblNewLabel_2);
		
		JComboBox<Currency> comboBoxCurrencies = new JComboBox<Currency>();
		comboBoxCurrencies.setBounds(10, 59, 220, 21);
		panelRightCurrencyAndInterest.add(comboBoxCurrencies);
		
		JLabel lblNewLabel_3 = new JLabel("Select The Currency To Set And Modify");
		lblNewLabel_3.setBounds(10, 33, 307, 13);
		panelRightCurrencyAndInterest.add(lblNewLabel_3);
		
		textFieldCurrencyRate = new JTextField();
		textFieldCurrencyRate.setBounds(198, 113, 168, 19);
		panelRightCurrencyAndInterest.add(textFieldCurrencyRate);
		textFieldCurrencyRate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Currency Exchange Rate:");
		lblNewLabel_4.setBounds(10, 116, 133, 13);
		panelRightCurrencyAndInterest.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Interest Rate:");
		lblNewLabel_4_1.setBounds(10, 158, 106, 13);
		panelRightCurrencyAndInterest.add(lblNewLabel_4_1);
		
		textFieldInterestRate = new JTextField();
		textFieldInterestRate.setColumns(10);
		textFieldInterestRate.setBounds(198, 155, 168, 19);
		panelRightCurrencyAndInterest.add(textFieldInterestRate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(268, 202, 98, 33);
		panelRightCurrencyAndInterest.add(btnSave);
		
		JPanel panelRightDays = new JPanel();
		rightPanel.add(panelRightDays, "name_118971972106800");
		panelRightDays.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("/Day Operations");
		lblNewLabel_5.setBounds(10, 21, 219, 13);
		panelRightDays.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Current Day:");
		lblNewLabel_6.setBounds(10, 57, 159, 13);
		panelRightDays.add(lblNewLabel_6);
		
		JLabel lblCurrentDayValue = new JLabel("");
		lblCurrentDayValue.setBounds(272, 57, 159, 13);
		panelRightDays.add(lblCurrentDayValue);
		
		JLabel lblNewLabel_6_1 = new JLabel("Click on The Button To Move To The Next Day:");
		lblNewLabel_6_1.setBounds(10, 86, 367, 13);
		panelRightDays.add(lblNewLabel_6_1);
		
		JButton btnMoveToNextDay = new JButton("Move To Next Day");
		btnMoveToNextDay.setBounds(10, 119, 182, 21);
		panelRightDays.add(btnMoveToNextDay);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Write The Day You'd Like To Move To (e.g. 20 if you want to go to day 20):");
		lblNewLabel_6_1_1.setBounds(10, 162, 431, 13);
		panelRightDays.add(lblNewLabel_6_1_1);
		
		textFieldGivenDay = new JTextField();
		textFieldGivenDay.setBounds(10, 185, 347, 19);
		panelRightDays.add(textFieldGivenDay);
		textFieldGivenDay.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Move To Day");
		btnNewButton_2.setBounds(231, 224, 131, 21);
		panelRightDays.add(btnNewButton_2);
		
		splitPane.setBounds(0, 0, 696, 648);
		splitPane.setResizeWeight(0.30); 
		mainPanel.add(splitPane);
		
		panelModifyStockAndBonds.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				
				comboBoxModifyStocks.removeAllItems();
				comboBoxModifyBonds.removeAllItems();
				
				for(Stock stock: bank.getStocks()) {
					comboBoxModifyStocks.addItem(stock);
				}
				
				for(Bond bond: bank.getBonds()) {
					comboBoxModifyBonds.addItem(bond);
				}
				
				panelRightModifyStocksAndBonds.setVisible(true);
			}
		});
		
		comboBoxModifyStocks.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               Stock selectedStock=(Stock) comboBoxModifyStocks.getSelectedItem();
               if(selectedStock!=null) {
               textFieldModifyStockName.setText(selectedStock.getName());
               textFieldModifyStockPrice.setText(Double.toString(selectedStock.getPrice()));
               textFieldModifyStockQuantity.setText(Integer.toString(selectedStock.getQuantity()));
            }
            }
        });
		
		
		comboBoxModifyBonds.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               Bond selectedBond=(Bond) comboBoxModifyBonds.getSelectedItem();
               if(selectedBond !=null) {
               textFieldModifyBondName.setText(selectedBond.getName());
               textFieldModifyBondPrice.setText(Double.toString(selectedBond.getFaceValue()));
               textFieldModifyBondInterest.setText(Double.toString(selectedBond.getCouponRate()));
            }
            }
        });
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				panelRightStocksAndBonds.setVisible(true);
			}
		});
		
		btnModifyStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 Stock selectedStock=(Stock) comboBoxModifyStocks.getSelectedItem();
				if(selectedStock !=null) {
					String modifiedName= textFieldModifyStockName.getText();
					Double modifiedPrice=Double.parseDouble(textFieldModifyStockPrice.getText());
		            int modifiedAmount=Integer.parseInt(textFieldModifyStockQuantity.getText());
		            
		            bank.modifyStock(selectedStock,modifiedName,modifiedPrice,modifiedAmount);
				}
				
			}
		});
		
		
		btnModifyBond.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bond selectedBond=(Bond) comboBoxModifyBonds.getSelectedItem();
				if(selectedBond !=null) {
					String modifiedName= textFieldModifyBondName.getText();
					Double modifiedPrice=Double.parseDouble(textFieldModifyBondPrice.getText());
		            double modifiedInterest=Double.parseDouble(textFieldModifyBondInterest.getText());
		            
		            bank.modifyBond(selectedBond,modifiedName,modifiedPrice,modifiedInterest);
				}
				
			}
		});
		
		panelCurrencyAndInterest.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				comboBoxCurrencies.removeAllItems();
				for(Currency currency : bank.getCurrencyInterestRates().keySet()) {
					comboBoxCurrencies.addItem(currency);
				}
				
				panelRightCurrencyAndInterest.setVisible(true);
				
			}
		});
		
		comboBoxCurrencies.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               Currency selectedCurrency=(Currency) comboBoxCurrencies.getSelectedItem();
               if(selectedCurrency !=null) {
            	   if(!selectedCurrency.equals(Currency.TRY)) {
            		   textFieldCurrencyRate.setEnabled(true);
            		   textFieldCurrencyRate.setText(Double.toString(bank.getCurrencyTryExchangeRate(selectedCurrency)));
            	   }
            	   
            	   else {
            		   textFieldCurrencyRate.setText("No exchange rate for TRY");
            		   textFieldCurrencyRate.setEnabled(false);
            	   }
            	   textFieldInterestRate.setText(Double.toString(bank.getCurrencyInterestRate(selectedCurrency)));
            }
            }
        });
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				  Currency selectedCurrency=(Currency) comboBoxCurrencies.getSelectedItem();
				  if(selectedCurrency !=null) {
	            	 double currencyExchangeRate=Double.parseDouble(textFieldCurrencyRate.getText());
	            	 double currencyInterestRate=Double.parseDouble( textFieldInterestRate.getText());
	            	 bank.modifyCurrencyExchangeRate(selectedCurrency, currencyExchangeRate);
	            	 bank.modifyCurrencyInterestRate(selectedCurrency, currencyInterestRate);
	            }
			}
		});
		
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeAllPanels();
				lblCurrentDayValue.setText(Integer.toString(bank.getDay()));
				panelRightDays.setVisible(true);
			}
		});
		
		btnMoveToNextDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bank.incrementDay();
				lblCurrentDayValue.setText(Integer.toString(bank.getDay()));
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int givenDay=Integer.parseInt(textFieldGivenDay.getText());
				bank.moveToGivenDay(givenDay);
				lblCurrentDayValue.setText(Integer.toString(bank.getDay()));
			}
		});
	}
	
	private void closeAllPanels() {
		 for (Component c : rightPanel.getComponents())
		    {
		        if (c instanceof JPanel) 
		            ((JPanel)c).setVisible(false);
		    }		
	}
}
