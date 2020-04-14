import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
public class Money {
	private Map<Integer, Integer> bills = new TreeMap<>(Collections.reverseOrder());
	
	public Money() {
	 bills.put(1, 0);
   bills.put(2, 0);
   bills.put(5, 0);
   bills.put(10, 0);
   bills.put(20, 0);
   bills.put(50, 0);
   bills.put(100, 0);
	}
	public Money(Map<Integer, Integer> bills) {
		this.bills.putAll(bills);
	}
	public void updateMoney(int billValue, int quantity) {
		if (bills.containsKey(billValue)) {
      bills.put(billValue, bills.get(billValue) + quantity);
    } else {
      bills.put(billValue, quantity);
    }
	}
	public void updateMoney(Map<Integer, Integer> bills) {
    for (Map.Entry<Integer, Integer> entry : bills.entrySet()) {
      updateMoney(entry.getKey().intValue(), entry.getValue().intValue());
    }
	}
	public double moneyToValue() {
    double total = 0;
		for (Map.Entry<Integer, Integer> entry : bills.entrySet()) {
      total += entry.getKey().intValue() * entry.getValue().intValue();
    }
    return total;
	}
	public void valueToMoney(double value) {
    int quotient = 0;
    int billValue = 0;
    for (Map.Entry<Integer, Integer> entry : bills.entrySet()) {
      billValue = entry.getKey().intValue();
      quotient = (int) (value / billValue);
      if (quotient > 0) {
       updateMoney(billValue, quotient);
       value %= billValue;
      }
    }
	}
  public String toString() {
    String listing = "";
    for (Map.Entry<Integer, Integer> entry : bills.entrySet()) {
      if (entry.getValue() > 0) {
        listing += entry.getValue().toString() + " $" + entry.getKey().toString() + ", ";
      }
    }
    listing = listing.substring(0, listing.lastIndexOf(','));
    return listing.substring(0, listing.lastIndexOf(", ") + 2) + "and " + listing.substring(listing.lastIndexOf(", ") + 2);
  }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Screen {

  public static void printMenuTemplate(String title, String menu) {
    System.out.printf("%s%n%s%n%s%n%n%s%n", "=".repeat(title.length()), title, "=".repeat(title.length()), menu);
  }
	public static void displayMainMenu() {
    // In the screen class we have a DisplayMainMenu method that displays the main menu of the ATM.
    /*
    case "1": //depositFunds(); break;
    case "2": //withdrawBalance(); break;
    case "3": //transferFunds(); break;
    case "4": //viewBalance(); break;
    case "5": //openAccount = null; quit = true; welcomeScreen(); break;
    case "6": //quit = true; break:
    */
    String mainMenu = String.format("What would you like to do today?%n%n1. %s%n2. %s%n3. %s%n4. %s%n5. %s%n6. %s%n%nENTER NUMBER: ",
    "Deposit",
    "Withdraw",
    "Transfer",
    "View Balance",
    "Return Home",
    "Exit");
    printMenuTemplate("MAIN MENU", mainMenu);
	}
	public static void displayWelcome() {
		// The DisplayWelcome method will output the welcome message of the display screen.
    printMenuTemplate("WELCOME", "Enter your card number and PIN to begin.");
	}
	public static void displayWithdrawMenu() {
		// The DisplayWithdrawMenu method will output the withdrawal screen, and prompts users to choose an option.
    printMenuTemplate("WITHDRAW", "Enter the amount you want to withdraw (enter 0 to cancel): $");
	}
	public static void depositMenu() {
		// The DepositMenu method will display the deposit screen, and prompts users to choose an option.
    printMenuTemplate("DEPOSIT", "Enter the amount you want to deposit (enter 0 to cancel): $");
	}
	public static void chooseAccountMenu() {
		// The ChooseAccountMenu method will prompt the user to choose an account to perform actions upon.
    printMenuTemplate("CHOOSE ACCOUNT", "Which account do you want to perform the operation on? (enter 0 to cancel)");
	}
	public static void transferMoneyMenu() {
		// The TransferMoneyMenu will display options to transfer the money.
    printMenuTemplate("TRANSFER", "Enter the amount you want to transfer (enter 0 to cancel): $");
	}
	public static void checkBalanceMoney() {
		// The last method, CheckBalanceMenu will display options to check balances. 
    printMenuTemplate("VIEW BALANCE", "This account has $");
	}
}
