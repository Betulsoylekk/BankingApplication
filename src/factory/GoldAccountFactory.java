package factory;

import account.Account;
import account.GoldAccountWithInterest;
import account.GoldAccountWithoutInterest;
import currency.Currency;

/**
 * Class for GoldAccountFactory
 */
public class GoldAccountFactory implements AccountFactory{

	@Override
	public Account createAccountWithInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new GoldAccountWithInterest(accountNumber);
	}

	@Override
	public Account createAccountWithoutInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new GoldAccountWithoutInterest(accountNumber);
	}

}
