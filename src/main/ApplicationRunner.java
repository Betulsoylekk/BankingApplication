package main;

import java.util.HashMap;
import java.util.Map;

import currency.Currency;
import user.Bank;
import view.LoginView;

/**
 * Class for ApplicationRunner
 */
public class ApplicationRunner {
	
	/**
	 * Initialises the bank and the exchange and interest rates of 
	 * currencies in the bank (which can be modified within the app) 
	 * before application starts. Launches the application
	 */
	public void run() {
		
		Bank bank= new Bank("Bank");
		
		Map<Currency,Double> exchangeRatetoTry= new HashMap<Currency,Double>();
		exchangeRatetoTry.put(Currency.EUR, 25.0);
		exchangeRatetoTry.put(Currency.USD, 23.0);
		exchangeRatetoTry.put(Currency.XAU, 46.20);
		
		Map<Currency,Double> interestRates= new HashMap<Currency,Double>();
		interestRates.put(Currency.EUR, 0.03);
		interestRates.put(Currency.TRY, 0.01);
		interestRates.put(Currency.USD, 0.6);
		interestRates.put(Currency.XAU, 0.02);
		
		bank.setCurrencyTRYExchangeRates(exchangeRatetoTry);
		bank.setCurrencyInterestRates(interestRates);
	
		
		LoginView loginView=new LoginView(bank);
		loginView.setVisible(true);
		
	}
	
}
