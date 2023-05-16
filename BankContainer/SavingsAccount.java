package BankContainer;
//Savings Account (Child Class)
//has an interest rate
//a method to apply interest - profit

public class SavingsAccount extends Account {
    
    // Interest rate
    private double interestRate;

    //default Constructor
    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize Savings Account
     * with a custom Account Number and interest rate
     */

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;

    }

    //Getter function
    public double getInterestRate() {
        return this.interestRate;
    }

    public void getInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(interest);
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
            if((amount) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);
            }

        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }


}

