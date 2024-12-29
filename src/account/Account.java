package account;

import java.util.ArrayList;
import java.util.List;
import accountgroup.IAccountComponent;
import accounttype.AccountType;
import currency.Currency;
import user.Client;

/**
 * Abstract class for Account
 * @author buket
 *
 */
public abstract class Account implements IAccountComponent{
	
	protected Currency type;
	protected double balance;
	protected Client owner;
	protected int accountNumber;
	protected String accountName;
	protected AccountType accountType;
	
	public abstract double getExpectedBalance(int days);
	
	public Account(Currency type, int accountNumber) {
		this.type=type;
		this.accountNumber=accountNumber;
		this.balance=0.0;
		this.accountName= this.type.getFullName() + "-" + Integer.toString(accountNumber); 
	}
	
	public boolean isInteresetAccount() {
		return false;
	}
	
	/**
	 * Returns account's balance in TRY. Calculates 
	 * using owner's bank's exchange rates
	 */
	public double getBalanceInTRY() {
		// TODO Auto-generated method stub
		return this.balance* owner.getBank().getCurrencyTRYExchangeRates().get(type);
	}
	
	/**
	 * Returns list with account's name
	 */
	public List<String> getComponentName() {
		// TODO Auto-generated method stub
		List<String> componentName=new ArrayList<String>();
		componentName.add(accountName);
		return componentName;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.accountName;
	}

	
	/** getters and setters */
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Currency getType() {
		return type;
	}
	public void setType(Currency type) {
		this.type = type;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String toString() {
		return this.accountName;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	

}
