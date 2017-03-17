/**
 * BankAccount is the base account class. It provides common code for holding and
 * manipulating a balance. However, there is no such thing as a plain bank account.
 * Thus this class is abstract and cannot be instantiated.
 * @author Tony Sintes STYOOP
 * @version 2.0
 */
public abstract class BankAccount {
    
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