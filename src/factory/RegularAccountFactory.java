package factory;

import account.Account;
import account.RegularAccountWithInterest;
import account.RegularAccountWithoutInterest;
import currency.Currency;

/**
 * Class for RegularAccountFactory
 */
public class RegularAccountFactory implements AccountFactory{
	@Override
	public Account createAccountWithInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new RegularAccountWithInterest(currency,accountNumber);
	}

	@Override
	public Account createAccountWithoutInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new RegularAccountWithoutInterest(currency,accountNumber);
	}
	
	
	
}
