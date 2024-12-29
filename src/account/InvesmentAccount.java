package account;

import invesment.Stock;
import invesment.Bond;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;

import java.util.ArrayList;

/**
 * Class for InvesmentAccount
 */
public class InvesmentAccount extends Account{
	public InvesmentAccount(Currency type, int accountNumber) {
		super(type, accountNumber);
		this.accountType=AccountType.I;
		super.setAccountName("Investment Account-" + super.getAccountNumber());
		this.accountName="Investment Account-" + super.getAccountNumber();
		// TODO Auto-generated constructor stub
	}
	List<Stock> stocks= new ArrayList<Stock>();
	List<Bond> funds= new ArrayList<Bond>();
	
	/**
	 * Returns expected balance in type TRY
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}
	
	/**
	 * Returns balance in type TRY
	 */
	@Override
	public double getBalanceInTRY() {
		// TODO Auto-generated method stu
		return this.balance;
	}
	
	public void addStock(Stock stock) {
		this.stocks.add(stock);
	}
	
	public void addBond(Bond bond) {
		this.funds.add(bond);
	}
	
	/**
	 * Returns expected balance in type TRY
	 */
	@Override
	public double getExpectedBalance(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}
	
	public String toString() {
		return this.accountName;
	}
}
