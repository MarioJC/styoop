/**
 * OverdraftAccount inherits CheckingAccount and acts in accordance with the 
 * OverdraftAccount description given in lab 3 chapter 5.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class OverdraftAccount extends BankAccount {
    
    // private data
    private double creditRate;
    
    // Creates new OverdraftAccount
    public OverdraftAccount( double initDeposit, double rate ) {
        super( initDeposit );
        setCreditRate( rate );
    }
    // charge he interest on any lent monies
    public void chargeInterest() {
        double balance = getBalance();
        if( balance < 0 ) {
            double charge = balance * getCreditRate();
            setBalance( balance + charge );
        }
    }
    // query the credit rate
    public double getCreditRate() {
        return creditRate;
    }
    // set the credit rate
    public void setCreditRate( double rate ) {
        creditRate = rate;
    }
    
    // withdraw funds from the account
    public double withdrawFunds( double amount ) {
	setBalance( getBalance() - amount );	
	
	return amount;
    }
}