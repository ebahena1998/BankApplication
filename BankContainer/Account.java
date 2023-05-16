package BankContainer;

//BASE CLASS (Super class of Accounts)
public abstract class Account {
    
    //account number
    private int accountNumber;

    //Balance
    protected double balance;

    //Default Constructor
    public Account() {

    }

    public Account (int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    //Getter methods
    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
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
    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds from the account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     *
     * @param amount value to be withdrawn
     */
    public abstract void withdraw(double amount);



}
