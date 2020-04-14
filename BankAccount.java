/**
 * 
 * @author Cristian Pardo
 *
 */
public abstract class BankAccount {
	protected double balance;
	protected static String AccountNumber;
	
	/**
	 * Bank Account Constructor
	 * @param number bank account number
	 * @param initialDeposit the amount in the account, when the account is started.
	 */
	public BankAccount(String number, Double initialDeposit) {//changed number to string so it matches use account -Jose
		balance = initialDeposit;
		AccountNumber = number;
	}
	/**
	 * Withdraw money from account
	 * @param amount amount being withdrawn from account
	 * @return will return true if amount is withdrawn
	 */
	public abstract boolean withdraw(double amount);
	/**
	 * Getter for account number
	 * @return account number
	 */
	public static String getAccountNumber() {
		return AccountNumber;
	}
	/**
	 * getter for balance
	 * @return balance of account
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Deposit money into account
	 * @param amount amount being deposited into account
	 */
	public void deposit(double amount) {
		balance+=amount;
	}
}



/**
 * 
 * @author Christian Pardo
 *
 */
public class SavingsAccount extends BankAccount{
	private int monthlyWithdrawls;
	private long DateReset;
	
	/**
	 * Savings Account Constructor
	 * @param number account number
	 * @param initialDeposit the starting amount when the account is started
	 */
	public SavingsAccount(String number, Double initialDeposit) { //changed number to string so it matches use account -Jose
		super(number, initialDeposit);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Withdraw money from account.
	 * If it attempts to withdraw more than three times within a certian time period
	 * it will not allow it.
	 * @param amount amount being withdrawn from bank account
	 */
	@Override
	public boolean withdraw(double amount) {
		long CurrentMonth = System.currentTimeMillis()/(1000L * 60 * 60 * 24 * 30);
		if(CurrentMonth>DateReset) {
			DateReset = CurrentMonth;
			monthlyWithdrawls = 0;
		}
		
		if(monthlyWithdrawls<3) {
			monthlyWithdrawls+=1;
			balance-=amount;
			return true;
		}
		else {
			return false;
		}
	}
}
/**
 * 
 * @author Christian Pardo
 *
 */
public class CheckingAccount extends BankAccount{
	/**
	 * Constructor for Checking account
	 * @param number account number for checking account
	 * @param initialDeposit the amount in the account, when the account was started
	 */
	public CheckingAccount(String number, Double initialDeposit) { //changed number to string so it matches use account -Jose
		super(number, initialDeposit);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	@Override
	public boolean withdraw(double amount) {
		balance -= amount;
		return true;
	}
}




/**abstract class BankAccount{
	double Balance;
	
	
	public BankAccount(Double amount) {
	Balance = amount;
	}
	
	public BankAccount() {
		Balance = 0;
	}
	public void setBalance(Double amount) {
		Balance = amount;
	}
	
	public double getBalance() {
		return Balance;
	}
	
	void withdrawMoney(double amount) {
		// TODO Auto-generated method stub
		Balance-=amount;
	}
	

	public void depositMoney(double amount) {
		Balance+=amount;
	}
	

}

class Checking extends BankAccount{

}
//////////////////////////// Version 1
class Savings extends BankAccount{


	int monthlyWithdrawls;
	long DateReset;
	@Override

	
	void withdrawMoney(double amount) {
		// TODO Auto-generated method stub
		long CurrentMonth = System.currentTimeMillis()/(1000L * 60 * 60 * 24 * 30);
		if(CurrentMonth>DateReset) {
			DateReset = CurrentMonth;
			monthlyWithdrawls = 0;
		}
		
		
		if(monthlyWithdrawls<3) {
			monthlyWithdrawls+=1;
			Balance-=amount;
		}
		else {
			System.out.println("Maximum withdrawls met cannot withdraw today");
		}
	}
	
}
///////////////////////////////// Version 2
class Savings extends BankAccount{


	int monthlyWithdrawls;
	long DateReset;
	boolean withdrawCheck() {
		boolean x = false;
		long CurrentMonth = System.currentTimeMillis()/(1000L * 60 * 60 * 24 * 30);
		if(CurrentMonth>DateReset) {
			DateReset = CurrentMonth;
			monthlyWithdrawls = 0;
			x = true;
		}
		if(monthlyWithdrawls <3) {
			x = true;
		}
		return x;
	}
	
	
	@Override
	void withdrawMoney(double amount) {

		if(withdrawCheck()) {
			monthlyWithdrawls+=1;
			Balance-=amount;
		}
		else {
			System.out.println("Maximum withdrawls met cannot withdraw today");
		}
	}	
}

// abstract class BankAccount{  //implements Serializable{ //maybe we wanna save this?
// 	double balance;
// 	static String AccountNumber;
	
	
// 	public BankAccount(String number, Double initialDeposit) {//changed number to string so it matches use account -Jose
// 		balance = initialDeposit;
// 		AccountNumber = number;
// 	}
	
// 	void withdraw(double amount) {
// 		// TODO Auto-generated method stub
// 		balance-=amount;
// 	}
	
// 	public static String getAccountNumber() {
// 		return AccountNumber;
// 	}
	
// 	public double getBalance() {
// 		return balance;
// 	}
	
// 	public void deposit(double amount) {
// 		balance+=amount;
// 	}
// }

// class CheckingAccount extends BankAccount{

// 	public CheckingAccount(String number, Double initialDeposit) { //changed number to string so it matches use account -Jose
// 		super(number, initialDeposit);
// 		// TODO Auto-generated constructor stub
// 	}


	

// }

// class SavingsAccount extends BankAccount{

// 	public SavingsAccount(String number, Double initialDeposit) { //changed number to string so it matches use account -Jose
// 		super(number, initialDeposit);
// 		// TODO Auto-generated constructor stub
// 	}
// 	int monthlyWithdrawls;
	
// 	@Override
// 	void withdraw(double amount) {
// 		// TODO Auto-generated method stub
// 		if(monthlyWithdrawls<3) {
// 			monthlyWithdrawls+=1;
// 			balance-=amount;
// 		}
// 		else {
// 			System.out.println("Maximum withdrawls met cannot withdraw today");
// 		}
// 	}
// }