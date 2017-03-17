/**
 * BankAccount is the base account class. It provides common code for holding and
 * manipulating a balance.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccount {
    
    // private data
    private double balance;
    
    // constructor
    public BankAccount( double initDeposit ) {   
	setBalance( initDeposit );
    }
    // deposit monies into account
    public void depositFunds( double amount ) {
	// the base class applies no policy
	// does not validate input
	setBalance( getBalance() + amount );	
    }
    // query the balance
    public double getBalance() {
	return balance;
    }
    // set the balance
    protected void setBalance( double newBalance ) {
	balance = newBalance;
    }
    // withdraw funds from the account
    public double withdrawFunds( double amount ) {
        if( amount >= balance ) {
            amount = balance;
        }
	setBalance( getBalance() - amount );	
	
	return amount;
    }
    
}