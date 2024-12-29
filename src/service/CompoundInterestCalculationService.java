package service;

/**
 * Class for  CompoundInterestCalculationService 
 * @author buket
 *
 */
public class CompoundInterestCalculationService {
	
	public CompoundInterestCalculationService() {
		
	}
	
	/**
	 * Calculates an accounts expected balance using compound interest formula
	 * N (the number of times interest is compounded per year) is taken as one
	 * @param principal
	 * @param interestRate
	 * @param days
	 * @return
	 */
	public double calculateCompoundInterest(double principal, double interestRate, int days) {
        double ratePlusOne = interestRate + 1;
        double exponent =((double)days/365);
        // Calculate the compound interest formula: principal * (1 + interestRate/365)^day             
        double expectedBalance = principal*Math.pow(ratePlusOne, exponent);
        return expectedBalance;
    }

}
