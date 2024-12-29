package accountgroup;

import account.Account;
import java.util.List;
import java.util.ArrayList;

/**
 * Class for AccountGroup
 */
public class AccountGroup implements IAccountComponent{
	
	List<IAccountComponent> accountComponents=new ArrayList<IAccountComponent>();
	String groupName;
	
	public AccountGroup(String groupName) {
		this.groupName=groupName;
	}
	
	/**
	 * Calculates and returns total balance
	 * of all of the components (account or account group) it contains
	 */
	@Override
	public double getBalance() {
		int i=0;
		double totalBalance=0;
		while(i<accountComponents.size()) {
			totalBalance+=accountComponents.get(i).getBalanceInTRY();
			i++;
		}
		return totalBalance;
	}
	
	public void add(IAccountComponent account ) {
		this.accountComponents.add(account);
	}
	
	public void remove(IAccountComponent account) {
		this.accountComponents.remove(account);
		}
	
	/**
	 * Returns all account components it contains
	 */
	public List<IAccountComponent> getChildren() {
		List<IAccountComponent> accountComponents= new ArrayList<IAccountComponent>();
		for(IAccountComponent accountComponent : this.accountComponents ) {
				accountComponents.add( accountComponent);
		}
		
		return accountComponents;
	}

	/**
	 * Returns all accountGroup components it contains
	 */
	public List<AccountGroup> getAccountGroupChildren() {
		List<AccountGroup> accountGroups= new ArrayList<AccountGroup>();
		for(IAccountComponent accountComponent : this.accountComponents) {
			
			if(accountComponent instanceof AccountGroup) {
				accountGroups.add((AccountGroup) accountComponent);
			}
		}
		
		return accountGroups;
	}
	
	/**
	 * Returns a list containing all
	 * of the account components it contains
	 */
	@Override
	public List<String> getComponentName() {
		// TODO Auto-generated method stub
		List<String> accountNames=new ArrayList<String>();
		
		//accountNames.add(this.groupName);
		for(IAccountComponent accountComponent: this.accountComponents) {
			accountNames.add(accountComponent.getName());
		}
		
		return accountNames;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.groupName;
	}
	
	/**
	 * Calculates and returns total balance of all 
	 * of the components (account or account group) it contains
	 * in type TRY
	 */
	@Override
	public double getBalanceInTRY() {
		// TODO Auto-generated method stub
		int i=0;
		double totalBalance=0;
		while(i<accountComponents.size()) {
			totalBalance+=accountComponents.get(i).getBalanceInTRY();
			i++;
		}
		return totalBalance;
	}
	
	
	/**
	 * Calculates and returns total expected balance of all 
	 * of the components (account or account group) it contains
	 * in type TRY
	 */
	@Override
	public double getExpectedBalanceInTRY(int days) {
		// TODO Auto-generated method stub
		double expectedBalance=0;
		for(IAccountComponent accountComponent: this.accountComponents) {
			expectedBalance+=accountComponent.getExpectedBalanceInTRY(days);
		}
		
		return expectedBalance;
	}
	
	
	public String toString() {
		return this.groupName;
	}
	
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
