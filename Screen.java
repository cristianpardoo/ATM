/**
 * Provides a Screen class. Displays different menus based on operation.
 */
public class Screen {
    /**
     * Displays menu template.
     */
    public static void printMenuTemplate(String title, String menu) {
        System.out.printf("%s%n%s%n%s%n%n%s%n", "=".repeat(title.length()), title, "=".repeat(title.length()), menu);
    }

    /**
     * Displays main menu.
     */
    public static void displayMainMenu() {
        String mainMenu = String.format(
                "What would you like to do today?%n%n1. %s%n2. %s%n3. %s%n4. %s%n5. %s%n6. %s%n%nENTER NUMBER: ",
                "Deposit", "Withdraw", "Transfer", "View Balance", "Return Home", "Exit");
        printMenuTemplate("MAIN MENU", mainMenu);
    }

    /**
     * Displays welcome.
     */
    public static void displayWelcome() {
        printMenuTemplate("WELCOME", "Enter your card number and PIN to begin.");
    }

    /**
     * Displays withdraw menu.
     */
    public static void displayWithdrawMenu() {
        printMenuTemplate("WITHDRAW", "Enter the amount you want to withdraw (enter 0 to cancel): $");
    }

    /**
     * Displays deposit menu.
     */
    public static void depositMenu() {
        printMenuTemplate("DEPOSIT", "Enter the amount you want to deposit (enter 0 to cancel): $");
    }

    /**
     * Displays account menu.
     */
    public static void chooseAccountMenu() {
        printMenuTemplate("CHOOSE ACCOUNT",
                "Which account do you want to perform the operation on? (enter 0 to cancel)");
    }

    /**
     * Displays transfer menu.
     */
    public static void transferMoneyMenu() {
        printMenuTemplate("TRANSFER", "Enter the amount you want to transfer (enter 0 to cancel): $");
    }

    /**
     * Displays view balance menu.
     */
    public static void checkBalanceMoney() {
        printMenuTemplate("VIEW BALANCE", "This account has $");
    }
}
