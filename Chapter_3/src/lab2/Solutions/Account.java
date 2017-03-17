public class Account {
    
    // private data
    private double balance;
    
    // constructor
    public Account( double init_deposit ) {   
	balance = init_deposit;
    }
    
    public Account() {
        // no need to do anything, _balance will default to 0
    }
    
    // deposit monies into account
    public void depositFunds( double amount ) {
	balance = balance + amount ;	
    }
    
    // query the balance
    public double getBalance() {
	return balance;
    }
    
    // withdraw funds from the account
    public double withdrawFunds( double amount ) {
    
        if( amount > balance ) {  // adjust the amount
            amount = balance;
        }
        
	balance = balance - amount;	
	
	return amount;
    }
    
}