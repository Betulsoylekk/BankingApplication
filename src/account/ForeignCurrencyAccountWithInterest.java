package account;

import java.util.List;
import java.util.ArrayList;
import accounttype.AccountType;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Class for ForeignCurrencyAccountWithInterest
 */
public class ForeignCurrencyAccountWithInterest extends AccountWithInterest {
		
	public ForeignCurrencyAccountWithInterest(Currency type,int accountNumber) {
		super(type,accountNumber);
		this.accountType=AccountType.FCW;
		// TODO Auto-generated constructor stub
	}	

}
