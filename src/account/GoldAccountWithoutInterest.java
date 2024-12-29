package account;

import java.util.ArrayList;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Class for GoldAccountWithoutInterest
 */
public class GoldAccountWithoutInterest extends Account {
	
	private Currency type;
	
	public GoldAccountWithoutInterest(int accountNumber){
		super(Currency.XAU,accountNumber);
		this.type=Currency.XAU;
		this.accountType=AccountType.GWO;
	}
	
	/**
	 * Returns expected balance in type TRY
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		double currentBalanceInTRY=this.balance * this.owner.getBank().getCurrencyTryExchangeRate(this.type);
		
		return currentBalanceInTRY;
	}
	
	/**
	 * Returns expected balance in own type
	 */
	@Override
	public double getExpectedBalance(int days) {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
