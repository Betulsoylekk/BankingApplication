package account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Class for RegularAccountWithInterest
 */
public class RegularAccountWithInterest extends AccountWithInterest{

	public RegularAccountWithInterest(Currency type,int accountNumber) {
		super(type,accountNumber);
		this.accountType=AccountType.RW;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns expected balance in given days in 
	 * type TRY (its own type)
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		CompoundInterestCalculationService compoundInterestCalculationService = new CompoundInterestCalculationService();
		double interestRate= this.owner.getBank().getCurrencyInterestRate(this.type);
		double expectedAmount=compoundInterestCalculationService.calculateCompoundInterest(this.balance, interestRate, days);
		
		return expectedAmount;
	}
	
	/**
	 * Returns current balance
	 */
	@Override
	public double getBalanceInTRY() {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
