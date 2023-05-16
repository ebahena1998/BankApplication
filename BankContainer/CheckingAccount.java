package BankContainer;
//Checking Account (Child Class)
public class CheckingAccount extends Account {

    //
    private static double FEE = 2.5;

    //default Constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize Checking Account
     * with a custom Account Number and a Custom Transaction
     * Fee.
     */

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;

    }

    //Abstract
    /**
     * Function to deposit funds into the account as long as
     * the amount paramter is > 0
     * 
     * Apply Transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {

        //First Check amount
        if( amount > 0 ) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            //Apply Transaction Fee
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f %n", amount);

        } else {
            System.out.printf("Amount %.2f deposited%n", amount);
        }

    }

    /**
     * Function to withdraw funds from the account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     *
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount) {

        // Same check
        if(amount > 0) {
            //Check sufficent balance
            if((amount + FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }

        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }


}
