/**
 * SavingsAccount inherits BankAccount and acts in accordance with the SavingsAccount
 * description given in lab 3 chapter 5.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class SavingsAccount extends BankAccount {
    
    // private data
    private double interestRate;
    
    // Creates new SavingsAccount
    public SavingsAccount( double initBalance, double interestRate ) {
        super( initBalance );
        setInterestRate( interestRate );
    }
    // calculate and add interest to the account
    public void addInterest() {
        double balance  = getBalance();
        double rate     = getInterestRate();
        double interest = balance * rate;
        
        double new_balance = balance + interest;
        
        setBalance( new_balance );
    }
    // set the interest rate
    public void setInterestRate( double interestRate ) {
        this.interestRate = interestRate;
    }
    // query the interest rate
    public double getInterestRate() {
        return interestRate;
    }
    
}