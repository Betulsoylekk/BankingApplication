package account;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import currency.Currency;
import service.CompoundInterestCalculationService;

/**
 * Abstract class for AccountWithInterest
 *
 */
public abstract class AccountWithInterest extends Account{
	
	protected double interestRate;
	// holds the day when money is deposited to this 
	// account from an account without interest
	protected int prohibitedDay;
	
	public AccountWithInterest(Currency type, int accountNumber) {
		super(type,accountNumber);
		this.prohibitedDay=-1;
		this.accountName +="/Interest";
	}
	
	@Override
	public boolean isInteresetAccount() {
		return true;
	}
	
	/**
	 * Calculates account's balance at given day using
	 * compound interest calculation
	 * @param principal current balance
	 * @param interestRate interest rate for account's currency 
	 * @param days the given day
	 * @return
	 */
	private double calculateCompoundInterest(double principal, double interestRate, int days) {
        CompoundInterestCalculationService compoundInterestCalculationService=new CompoundInterestCalculationService();
        return compoundInterestCalculationService.calculateCompoundInterest(principal, interestRate, days);
    }
	
	/**
	 * Returns expected balance at given day
	 */
	@Override
	public double getExpectedBalance(int days) {
		double interestRate=owner.getBank().getCurrencyInterestRate(this.type);
		return calculateCompoundInterest(this.balance,interestRate,days);
	}
	
	/**
	 * Calculates account's balance in type of TRY at given day using
	 * compound interest calculation
	 */
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		CompoundInterestCalculationService compoundInterestCalculationService = new CompoundInterestCalculationService();
		double currentBalanceInTRY=this.balance * this.owner.getBank().getCurrencyTryExchangeRate(this.type);
		double interestRate= this.owner.getBank().getCurrencyInterestRate(this.type);
		double expectedAmount=compoundInterestCalculationService.calculateCompoundInterest(currentBalanceInTRY, interestRate, days);
		
		return expectedAmount;
	}
	
	/** getters and setters */
	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public int getProhibitedDay() {
		return prohibitedDay;
	}
	
	public void setProhibitedDay(int prohibitedDay) {
		this.prohibitedDay = prohibitedDay;
	}
}
