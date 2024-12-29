package factory;

import account.Account;
import account.ForeignCurrencyAccountWithInterest;
import account.ForeignCurrencyAccountWithoutInterest;
import currency.Currency;

/**
 * Class for ForeignCurrencyAccountFactory
 */
public class ForeignCurrencyAccountFactory implements AccountFactory {
	
	@Override
	public Account createAccountWithInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new ForeignCurrencyAccountWithInterest(currency,accountNumber);
	}

	@Override
	public Account createAccountWithoutInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return  new ForeignCurrencyAccountWithoutInterest(currency,accountNumber);
	}

}
