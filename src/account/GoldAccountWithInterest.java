package account;

import java.util.ArrayList;
import java.util.List;

import accounttype.AccountType;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Class for GoldAccountWithInterest
 */
public class GoldAccountWithInterest extends AccountWithInterest {
	
	private Currency type;
	
	public GoldAccountWithInterest(int accountNumber){
		super(Currency.XAU,accountNumber);
		this.accountType=AccountType.GW;
	}

	
	

}
