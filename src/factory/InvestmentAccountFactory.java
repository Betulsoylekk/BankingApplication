package factory;

import account.Account;
import account.InvesmentAccount;
import currency.Currency;

/**
 * Class for InvestmentAccountFactory
 */
public class InvestmentAccountFactory implements AccountFactory{
	
	@Override
	public Account createAccountWithInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new InvesmentAccount(currency,accountNumber);
	}

	@Override
	public Account createAccountWithoutInterest(Currency currency,int accountNumber) {
		// TODO Auto-generated method stub
		return new InvesmentAccount(currency,accountNumber);
	}

}
