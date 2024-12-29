package user;

import java.util.ArrayList;
import currency.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import factory.AccountFactory;
import factory.ForeignCurrencyAccountFactory;
import factory.GoldAccountFactory;
import factory.InvestmentAccountFactory;
import factory.RegularAccountFactory;
import account.Account;
import account.InvesmentAccount;
import accountgroup.AccountGroup;
import accounttype.AccountType;
import invesment.Stock;
import time.Timer;
import invesment.Bond;
import account.AccountWithInterest;
import factory.AccountFactoryCreator;

/**
 * Class for Bank
 */
public class Bank {
    private String bankName;
    // stores exchange rate of each currency to try
    private Map<Currency, Double> currencyTRYExchangeRates;
    // stores interest rate of each currency 
    private Map<Currency, Double> currencyInterestRates;
    private List<Client> clients;
    private List<Account> accounts=new ArrayList<Account>();
    private List<Stock> stocks=new ArrayList<Stock>();
    private List<Bond> bonds=new ArrayList<Bond>();
    Timer timer;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.currencyInterestRates = new HashMap<>();
        this.clients = new ArrayList<>();
        timer= new Timer();
    }
    
    /**
     * Returns exchange rate for given currency type
     */
    public double getCurrencyTryExchangeRate(currency.Currency type) {
    	return this.currencyTRYExchangeRates.get(type);
    }
    
    public int getNextAccountNumber() {
    	return this.accounts.size();
    }
    
    public void registerNewAccount(Account account) {
    	this.accounts.add(account);
    	
    }

    /**
     * Creates and registers new account to the bank for given client
     * @return created account
     */
    public Account createNewAccount(AccountType accountType, Currency currency, Client client) {
    	AccountFactory accountFactory;
		Account newAccount=null;
		
		AccountFactoryCreator accountFactoryCreator=new AccountFactoryCreator();
		accountFactory=accountFactoryCreator.createAccountFactory(accountType);
		
		if(isInterestAccountType(accountType)) {
			newAccount=accountFactory.createAccountWithInterest(currency, getNextAccountNumber());
		}
		
		else {
			newAccount=accountFactory.createAccountWithoutInterest(currency, getNextAccountNumber());
		}
				
		this.accounts.add(newAccount);
		return newAccount;
		
    }
    
    /**
     * Checks if given account type is an interest account
     */
    public boolean isInterestAccountType(AccountType accountType) {
    	return accountType.equals(AccountType.FCW) || accountType.equals(AccountType.RW) || accountType.equals(AccountType.GW);     	
    }
    
    /**
     * Transfers money from a TRY account (regular account with or w/o interest)
     * to a currency (gold,euro or usd) account if conditions are accurate. 
     * @param fromAccount account to deposit money from
     * @param toAccount account to deposit money to
     * @param amount given amount
     */
    public void transferMoneyFromTryAccountToCurrencyAccount(Account fromAccount,Account toAccount,double amount) {
    	if(fromAccount.getBalance() <amount) {return;}
    	
    	if(areSameAccounts(fromAccount,toAccount)) {return;}
    	
    	//if it is an interest account check if it is prohibited to deposit money from the account
		//for the current day and if the account we are trying to send money to is an account without interest
    	if(fromAccount.isInteresetAccount()&& ((AccountWithInterest) fromAccount).getProhibitedDay()== timer.getDay()
    		&& !toAccount.isInteresetAccount()) 
    	{return;}
    	
    	double amountInExchangedCurrency=amount/ this.currencyTRYExchangeRates.get(toAccount.getType());
    	fromAccount.setBalance(fromAccount.getBalance() - amount);
    	toAccount.setBalance(toAccount.getBalance() + amountInExchangedCurrency);
    	
    	// if the account the money is deposited to is an interest account,
    	// set as prohibited (prohibited to deposit money from) for day 
    	if(toAccount.isInteresetAccount()) {
    		((AccountWithInterest) toAccount).setProhibitedDay(timer.getDay());
    	}
    	
    }
    
    /**
     * Transfers money from a currency (gold,euro or usd) account
     * to a TRY account (regular account with or w/o interest) account if conditions are accurate. 
     * @param fromAccount account to deposit money from
     * @param toAccount account to deposit money to
     * @param amount given amount
     */
    public void transferMoneyFromCurrencyAccountToTryAccount(Account fromAccount, Account toAccount, double amount) {
    	if(fromAccount.getBalance() <amount) {
    		return;}
    	
    	if(areSameAccounts(fromAccount,toAccount)) {return;}
    	
		//if it is an interest account check if it is prohibited to deposit money from the account
		//for the current day and if the account we are trying to send money to is an account without interest
    	if(fromAccount.isInteresetAccount()&& ((AccountWithInterest) fromAccount).getProhibitedDay()== timer.getDay()
    		&& !toAccount.isInteresetAccount()) 
    	{return;}
    	
    	double amountInExchangedCurrency=amount* this.currencyTRYExchangeRates.get(fromAccount.getType());
    	fromAccount.setBalance(fromAccount.getBalance() - amount);
    	toAccount.setBalance(toAccount.getBalance() + amountInExchangedCurrency);
    	
    	// if the account the money is deposited to is an interest account,
    	// set as prohibited (prohibited to deposit money from) for day 
    	if(toAccount.isInteresetAccount()) {
    		((AccountWithInterest) toAccount).setProhibitedDay(timer.getDay());
    	}

    }
    
    /**
     * Transfers money from accounts with same currency 
     * @param fromAccount account to deposit money from
     * @param toAccount account to deposit money to
     * @param amount given amount
     */
    public void transferMoneyFromAccountToAccount(Account fromAccount, Account toAccount, double amount) {
    	if(fromAccount.getBalance() <amount) {
    		return;}
    	
    	if(areSameAccounts(fromAccount,toAccount)) {return;}
    	
    	// if currency types of the accounts are different, return
    	if(!fromAccount.getType().equals(toAccount.getType())){ return;}
    	
    	//if it is an interest account check if it is prohibited to deposit money from the account
		//for the current day and if the account we are trying to send money to is an account without interest
    	if(fromAccount.isInteresetAccount()&& ((AccountWithInterest) fromAccount).getProhibitedDay()== timer.getDay()
    		&& !toAccount.isInteresetAccount()) 
    	{return;}
    	
    	fromAccount.setBalance(fromAccount.getBalance() - amount);
    	toAccount.setBalance(toAccount.getBalance() + amount);
    	
    	// if the account the money is deposited to is an interest account,
    	// set as prohibited (prohibited to deposit money from) for day 
    	if(toAccount.isInteresetAccount()) {
    		((AccountWithInterest) toAccount).setProhibitedDay(timer.getDay());
    	}

    }
    
    public boolean areSameAccounts(Account fromAccount,Account toAccount) {
    	return fromAccount.equals(toAccount);
    }
    
    public void createNewStock(String stockName,double stockPrice,int stockQuantity) {
    	Stock newStock=new Stock(stockName,stockPrice,stockQuantity);
    	stocks.add(newStock);
    }
    public void  createNewBond(String bondName,double bondPrice,double bondInterest){
    	Bond newBond=new Bond(bondName,bondPrice,bondInterest);
    	bonds.add(newBond);
    }
    
    /**
     * Stock is added to client's stocks and are updated 
     * accordingly in bank's stocks. The price of the stock is added
     * to client's given investment account. The price of the stock is retreived
     * from given client's account 
     */
	public void buyStock(Stock stock, int stockAmount,Client client,InvesmentAccount investmentAccount,Account selectedAccountToDepositFrom) {
		// TODO Auto-generated method stub
		if(stockAmount> stock.getQuantity()) {return;}
		
		double stockTotalPrice=stock.getPrice() * stockAmount;
		
		if(selectedAccountToDepositFrom.getBalance() < stockTotalPrice) {return;}
		
		selectedAccountToDepositFrom.setBalance(selectedAccountToDepositFrom.getBalance()- stockTotalPrice);
		
		//update the stock in bank's stocks
		stock.setQuantity(stock.getQuantity() - stockAmount);
		
		Stock boughtStock=new Stock(stock.getName(),stock.getPrice(),stockAmount);
		investmentAccount.addStock(boughtStock);
		// add the stock's value to investment account
		investmentAccount.setBalance(investmentAccount.getBalance() + (stock.getPrice() * stockAmount));
		
	}
	
	  /**
     * Bond is added to client's bonds and are updated 
     * accordingly in bank's bonds. The price of the bond is not added
     * to client's given investment account as the client should receive the money on bond's due date.
     *  The price of the bond is retreived from given client's account 
     */
	public void buyBond(Bond bond,Client client,InvesmentAccount investmentAccount,Account selectedAccountToDepositFrom) {
		// TODO Auto-generated method stub
		if(selectedAccountToDepositFrom.getBalance() < bond.getFaceValue()) {return;}
		
		selectedAccountToDepositFrom.setBalance(selectedAccountToDepositFrom.getBalance()- bond.getFaceValue());

		Bond boughtBond=new Bond(bond.getName(),bond.getFaceValue(),bond.getCouponRate());
		// the bond is just added to bank's bonds.the bond's value is not added
		// to client's account as in theory the client will receive the money it spent on bond's due date 
		investmentAccount.addBond(boughtBond);
		
	}
	
	/**
	 * Methods for modifying bonds and stocks existing in the system with the given new values
	 */
	
	public void modifyStock(Stock stock,String modifiedName, Double modifiedPrice, int modifiedAmount) {
		// TODO Auto-generated method stub
		if(modifiedPrice <0 || modifiedAmount <0 ) {return;}
		
		stock.setName(modifiedName);
		stock.setPrice(modifiedPrice);
		stock.setQuantity(modifiedAmount);
	}
	
	public void modifyBond(Bond bond,String modifiedName, Double modifiedPrice, double modifiedInterest) {
		if(modifiedPrice <0 || modifiedInterest <0 ) {return;}
		
		bond.setName(modifiedName);
		bond.setFaceValue(modifiedPrice);
		bond.setCouponRate(modifiedInterest);
	}
	
	/**
	 * Methods for modifying currency exchange and interest rates
	 */
	
	public void modifyCurrencyExchangeRate(Currency selectedCurrency, double currencyExchangeRate) {
		this.currencyTRYExchangeRates.put(selectedCurrency, currencyExchangeRate);
	}

	public void modifyCurrencyInterestRate(Currency selectedCurrency, double currencyInterestRate) {
		this.currencyInterestRates.put(selectedCurrency, currencyInterestRate);
	}
	
	/**
	 * Methods for bank changing days
	 */
	
	public int getDay() {
		return this.timer.getDay();
	}
	
	public void incrementDay() {
		timer.moveToNextDay();
		updateInterestAccountBalances(1);
	}
	
	public void moveToGivenDay(int day) {
		timer.jumpToGivenDay(day);
		updateInterestAccountBalances(day);
	}
	
	/**
	 * Updates interest account's balance to the 
	 * expected balance for the given day
	 * @param days
	 */
	public void updateInterestAccountBalances(int days) {
		for(Account account : this.accounts) {
			if(isInterestAccountType(account.getAccountType()))  {
				account.setBalance(account.getExpectedBalance(days));
			}
		}
	}
	
	/**
	 * Registers given client to the system
	 */
	public Client registerClient(Client client) {
	    AccountFactory accountFactory = new RegularAccountFactory();
	    
	    Account initialAccount=accountFactory.createAccountWithoutInterest(Currency.TRY,this.getNextAccountNumber());
	    
	    client.setAccountNumber(Integer.toString(getNextAccountNumber()));
	    client.addAccount(initialAccount);
	    client.setBank(this);
        clients.add(client);
        accounts.add(initialAccount);
        return client;
    }

	
	public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    /**
     * Sets given interest rate for given currency
     */
    public void setCurrencyInterestRate(Currency currency, double interestRate) {
        currencyInterestRates.put(currency, interestRate);
    }

    public double getCurrencyInterestRate(Currency currency) {
        return currencyInterestRates.getOrDefault(currency, 0.0);
    }

    // Getters and setters

    public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Bond> getBonds() {
		return bonds;
	}

	public void setBonds(List<Bond> bonds) {
		this.bonds = bonds;
	}

	public Map<Currency, Double> getCurrencyTRYExchangeRates() {
		return currencyTRYExchangeRates;
	}

	public void setCurrencyTRYExchangeRates(Map<Currency, Double> currencyTRYExchangeRates) {
		this.currencyTRYExchangeRates = currencyTRYExchangeRates;
	}

	public Map<Currency, Double> getCurrencyInterestRates() {
		return currencyInterestRates;
	}

	public void setCurrencyInterestRates(Map<Currency, Double> currencyInterestRates) {
		this.currencyInterestRates = currencyInterestRates;
	}
	
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Client> getClients() {
        return clients;
    }



}
