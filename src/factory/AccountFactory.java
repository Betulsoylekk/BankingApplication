package factory;

import account.Account;
import currency.Currency;

/**
 * Class for AccountFactory
 */
public interface AccountFactory {	
	public Account createAccountWithInterest(Currency currency,int accountNumber);
	public Account createAccountWithoutInterest(Currency currency,int accountNumber);
}
