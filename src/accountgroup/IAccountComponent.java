package accountgroup;

import java.util.List;

/**
 * Interface for account components
 */
public interface IAccountComponent {
	public double getBalance();
	public double getBalanceInTRY();
	public List<String> getComponentName();
	public String getName();
	public double getExpectedBalanceInTRY(int days);
}
