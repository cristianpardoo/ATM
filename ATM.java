/* Jose (ATM)
takeMoney(): allows user to choose how much money to insert into the machine
GiveMoney(): returns the money in the specified bills
welcomeScreen(): displays a welcome screen until user input is detected
transferFunds(): allows user to transfer funds from their bank account to another bank account
withdrawFunds(): allows user to take out money from their account
depositFunds(): allows user to input money or checks into the atm machine. It converts it to a monetary value and adds it to their account balance
viewBalance(): allows user to view the balance of their one of their bank accounts
accessAccount(): allows user to access their bank account if their pin number and account number match
*/

package atm_machine;

import java.util.Scanner;
/**
 *
 * @author Jose Gomez
 *
 */
public class ATM {
	private Bank myBank = new Bank();
	private Scanner cin = new Scanner(System.in);

	public ATM() {}
	/**
	 * This is the ATM welcome Screen<br>
	 * This screen is displayed until there is user input.
	 */
	public void welcomeScreen() {
		// Test
		Screen.displayWelcome();
		//System.out.println("Welcome to bank. press any key to contine...");
		String choice = cin.nextLine();
		if(choice.equalsIgnoreCase("Q")) {}
		else {
			insertCard();
		}
	}
	/**
	 * This method prompts user to input pin card number (simulating inserting card and entering pin number).<br>
	 * If the user get it wrong 3 time, the ATM machine will return to the welcome screen.
	 */
	public void insertCard() {
		int tries = 0;
		String pin, cardNumber;
		boolean accountOpen = false;
		boolean cancel = false;

		while(tries < 3 && !accountOpen && !cancel) {
			if(tries > 0) {
				System.out.print("Try Again? [y/n]: ");
				String choice = cin.nextLine();
				if(choice.equalsIgnoreCase("n")) {
					cancel = true;
				}
			}
			if(!cancel) {
				System.out.println("Insert card and pin number:");
				System.out.print("Card #: ");
				pin = cin.nextLine();
				System.out.print("Pin #: ");
				cardNumber = cin.nextLine();
				accountOpen = myBank.accessAccount(pin, cardNumber);
				System.out.println("Account not found");
				tries++;
			}
		}
		if(accountOpen) {
			mainMenu();
		}else {
			welcomeScreen();
		}
	}
	/**
	 * This is the main menu in the ATM Machine. It allow user to select from withdraw funds, deposit funds, transferFunds
	 * and view balance. The ATM will come back here after each action until the user decides to end their usage of the atm
	 * machine. When the user finishes it goes back to welcome screen.<br><br>
	 * There is also a quit option. Should it be hidden? ATM machines wouldn't normally turn off or end the program.
	 */
	public void mainMenu() {
		boolean quit = false;
		boolean cancel = false;

		while(!quit) {
			//Screen.displayMainMenu();
			String choice = cin.nextLine();
			switch(choice) {
			case "1": //depositFunds(); break;
			case "2": //withdrawBalance(); break;
			case "3": //transferFunds(); break;
			case "4": //viewBalance(); break;
			case "5": //cancel = true; welcomeScreen(); break;
			case "6": //quit = true; break:
			default: System.out.println("Invalid Input");
			}
		}
	}
}
