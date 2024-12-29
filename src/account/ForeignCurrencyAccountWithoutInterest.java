package account;

import java.util.ArrayList;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Class for ForeignCurrencyAccountWithoutInterest
 */
public class ForeignCurrencyAccountWithoutInterest extends Account{
	

	public ForeignCurrencyAccountWithoutInterest(Currency type,int accountNumber) {
		super(type,accountNumber);
		this.accountType=AccountType.FCWO;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns current balance in type TRY
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		double currentBalanceInTRY=this.balance * this.owner.getBank().getCurrencyTryExchangeRate(this.type);
		
		return currentBalanceInTRY;
	}
	
	/**
	 * Returns current balance in own type
	 */
	@Override
	public double getExpectedBalance(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
