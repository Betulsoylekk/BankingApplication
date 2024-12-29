package factory;

import accounttype.AccountType;

/**
 * Class for AccountFactoryCreator
 */
public class AccountFactoryCreator {
	
	/**
	 * Creates and returns the account factory for given account type
	 * @param accountType given account type 
	 * @return
	 */
	public AccountFactory createAccountFactory(AccountType accountType) {
		if(accountType.equals(AccountType.RW) || accountType.equals(AccountType.RWO)) {
			return new RegularAccountFactory();
		}
		
		else if(accountType.equals(AccountType.FCW) || accountType.equals(AccountType.FCWO)) {
			return new ForeignCurrencyAccountFactory();
		}
		
		else if(accountType.equals(AccountType.GW) || accountType.equals(AccountType.GWO)) {
			return new GoldAccountFactory();}
		
		else if(accountType.equals(AccountType.I) ) {
			return new InvestmentAccountFactory();
		}
		
		//default
		return new RegularAccountFactory();
	}

}
