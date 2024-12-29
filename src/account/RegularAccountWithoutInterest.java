package account;

import java.util.ArrayList;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;

/**
 * Class for RegularAccountWithoutInterest
 */
public class RegularAccountWithoutInterest extends Account{

	public RegularAccountWithoutInterest(Currency type,int accountNumber) {
		super(type,accountNumber);
		this.accountType=AccountType.RWO;
	}
	
	/**
	 * Deposits money to account
	 * @param amount
	 */
	public void deposit(double amount) {
		if(amount < 0 ) {return;}
		
		this.balance+=amount;
	}
	
	/**
	 * Returns balance in TRY (its own type)
	 */
	@Override
	public double getBalanceInTRY() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	
	/**
	 * Returns expected balance in TRY (its own type)
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}
	
	/**
	 * Returns expected balance in TRY (its own type)
	 */
	@Override
	public double getExpectedBalance(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
