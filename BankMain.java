import java.util.Scanner;

//Driver Class
public class BankMain {

    // Entry point of program
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Create array of Accounts
        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {

            choice = menu(scnr);
            System.out.println();

            if(choice == 1) {
                accounts[numAccounts++] = createAccount(scnr);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, scnr);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, scnr);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts, scnr);
            } else {
                System.out.println("GoodBye!");
            }

            System.out.println();

        } while(choice != 5);

    }

    /**
     * Account choice
     * 
     * @param scnr
     * @return choice
     */

    public static int accountMenu(Scanner scnr) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = scnr.nextInt();
        } while (choice < 1 || choice > 2);

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
    }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(Account account[], int count, Scanner scnr) {

        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = scnr.nextInt();

        // serach for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // Amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = scnr.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }

    }

    public static void doWithdraw(Account accounts[], int count, Scanner scnr) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = scnr.nextInt();

        // serach for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // Amount
            System.out.print("Please enter Withdraw Amount: ");
            double amount = scnr.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts[] , int count, Scanner scnr) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = scnr.nextInt();

        // serach for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // must be instance of savings account
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }


    /**
     * Function to create a new Account
     */

    public static Account createAccount(Scanner scnr) {

        Account account;
        int choice = accountMenu(scnr);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = scnr.nextInt();

        if (choice == 1) { // Checking Account
            System.out.print("Enter Transaction Fee: ");
            double fee = scnr.nextDouble();
            account = new CheckingAccount(accountNumber, fee);

        } else { // Savings account

            System.out.print("Please enter Interest Rate: ");
            double ir = scnr.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;

    }

    /**
     * Menu to display options and get the user selection
     * 
     * 
     */
    public static int menu(Scanner scnr) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funs");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = scnr.nextInt();
        } while (choice < 1 || choice > 5);

        return choice;
    }
}