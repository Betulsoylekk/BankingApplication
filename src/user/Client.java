package user;

import accountgroup.AccountGroup;
import accountgroup.IAccountComponent;
import accounttype.AccountType;
import currency.Currency;
import factory.AccountFactory;
import factory.ForeignCurrencyAccountFactory;
import factory.GoldAccountFactory;
import factory.RegularAccountFactory;
import invesment.Bond;
import invesment.Stock;

import java.util.List;
import java.util.ArrayList;
import account.Account;
import account.InvesmentAccount;

/**
 * Class for Client
 */
public class Client {
    private String firstName;
    private String lastName;
    private Bank bank;
	private String accountNumber;
    private AccountGroup accountGroup;
    private List<Account> accounts=new ArrayList<Account>();
    
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountGroup= new AccountGroup("mainGroup");
    }

	public Client(String firstName, String lastName, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountGroup= new AccountGroup("mainGroup");
    }
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	/**
	 * Creates new account for client of given type
	 */
	public void createNewAccount(AccountType accountType, Currency currency) {
		Account newAccount=bank.createNewAccount(accountType,currency,this);
		newAccount.setOwner(this);
		this.accounts.add(newAccount);
		//this.accountGroup.add(newAccount);
		// ADD TO ACCOUNT GROUP
		
	}
	
	/**
	 * Creates new account group for client of given type. 
	 * This account group is automatically added to the main group which
	 * is the root account group for all accounts and account groups the client has
	 */
	public AccountGroup createNewAccountGroup(String accountGroupName) {
		AccountGroup newAccountGroup=new AccountGroup(accountGroupName);
		this.accountGroup.add(newAccountGroup);
		return newAccountGroup;
	}
	
	/**
	 * Methods for buying stocks and bonds from client's bank
	 */
	
	public void buyStock(Stock stock, int stockAmount, InvesmentAccount investmentAccount,Account selectedAccountToDepositFrom) {
		// TODO Auto-generated method stub
		this.bank.buyStock(stock,stockAmount,this,investmentAccount,selectedAccountToDepositFrom);
		
	}
	
	public void buyBond(Bond bond, InvesmentAccount investmentAccount,Account selectedAccountToDepositFrom) {
		// TODO Auto-generated method stub
		this.bank.buyBond(bond,this,investmentAccount,selectedAccountToDepositFrom);
		
	}
	
    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
    public AccountGroup getAccountGroup() {
		return (AccountGroup) accountGroup;
	}

	public void setAccountGroup(AccountGroup accountGroup) {
		this.accountGroup = accountGroup;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String toString() {
		return this.firstName + this.lastName;
	}



}

