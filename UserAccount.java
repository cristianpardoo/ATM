//(Kenny)

/* accounts: BankAccount()
 * Account Number string 
 * account pin string
 * username string
 * 
 * methods 
 * setpin 
 * getpin
 * verify pin
 * getaccount
 * 
 * 
 */ //cleaned it up a bit and also added comments for the javadocs

/**
 * 
 * @author Kenny Ta 
 * 
 */
public class UserAccount {
	
	private BankAccount checking;
	private BankAccount savings ;
	BankAccount accounts[]=new BankAccount[2]; //This should be of type BankAccount -Jose
	private String accountNumber;
	private String accountPin;
	private String userName;
	
	/**
	 * Constructor for User account class
	 * @param userName 
	 * @param pin 
	 * @param ammountInChecking
	 * @param amountInSavings
	 */
	public UserAccount(String userName, String pin, double ammountInChecking, double amountInSavings){
		this.setUserName(userName);
		accountPin = pin;
		checking = new CheckingAccount(accountNumber + "0", ammountInChecking);
		//Things to do:
		//1. needs to generate the account number
		
		//2. having checking and savings and accounts is redundant. Change it so that we only have either checking/savings attributes
		// or do something like accounts[0] = new SavingsAccount(...
	}
	/**
	 * Setter for pin number
	 * @param pin
	 */
	public void setPin(String pin) {
		accountPin = pin;
	}
	  /**
	   * getter for pin number
	   * @return pin number as a string
	   */
	public String getPin() {
		return accountPin;
	}
	/**
	 * Verifies that the pin number and card number are correct
	 * @param pin
	 * @param cardNumber
	 * @return true if the pin number and account number match, otherwise it returns false
	 */
	public boolean verifyPin(String pin, String cardNumber) {
		if(pin.equals(accountPin) && accountNumber.equals(cardNumber)) {
	      return true;
	    }
	    else {
	      return false;
	    }
	}
	/**
	 * Getter for a bank account.
	 * @param account should be either 0 or 1
	 * @return will return the savings account if the parameter is 1 or checking account if the parameter is 0
	 */
	public BankAccount getAccount(int account){
		if(accounts[account].equals(0)) { // if array equals 0, its account c; otherwise its account s 
	      return checking;
	    }
	    else {
	      return savings;
	    }
	}
	/**
	 * getter for userName
	 * @return user name
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Setter for userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}



















/*public class UserAccount()
{
  public UserAccount() 
  {
  public void setPin(String pin)
  {
    accountPin = pin;
  }
  
  public String getPin()
  {
    return accountPin;
  }

  public boolean verifyPin(String pin, String cardNumber)
  {
    if(pin.equals(accountPin) && accountNumber.equals(cardNumber))
    {
      return true;
    }
    else
      return false;
  }
  
  public BankAccount getAccount(int account)
  {
    if(accounts[account].equals(0)) // if array equals 0, its account c; otherwise its account s 
    {
      return BankAccount c;
    }
    else
    {
      return BankAccount s;
    }
  }
    
  }
  public UserAccount(userName, pin, ammountinChecking, amountinSavings){
    //generateaacountnumber
    
    this.userName = userName;
    accountPin = pin;
    c = new CheckingAccount(accountNumber + "0", ammountInChecking);
     
  }
  
  private BankAccount c;
  private BankAccount s;
  BankAccount accounts[] = new BankAccount[2]; //This should be of type BankAccount -Jose
  accounts[0] = c;
  accounts[1] = s;
  private String accountNumber;
  private String accountPin;
  private String userName;
  
}


public class CheckingAccount()
{
  
}

public class SavingsAccount()
{
  
  private int withdrawNumber;
}*/