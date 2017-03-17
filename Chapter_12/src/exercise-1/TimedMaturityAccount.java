/**
 * TimedMaturityAccount inherits SavingsAccount and acts in accordance with the 
 * TimedMaturityAccount description given in lab 3 chapter 5.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class TimedMaturityAccount extends SavingsAccount {
    
    // private data
    private boolean mature;
    private double  feeRate;
    
    // Creates new TimedMaturityAccount 
    public TimedMaturityAccount(double initBalance, double interestRate, double feeRate ) {
        super( initBalance, interestRate );
        setFeeRate( feeRate );
    }
    // override BankAccount's withdrawFunds
    public double withdrawFunds( double amount ) {
        super.withdrawFunds( amount );
        if( !isMature() ) {
            double charge = amount * getFeeRate();
            amount = amount - charge;
        }
	return amount;
    }
    // check maturity
    public boolean isMature() {
        return mature;
    }
    // make mature
    public void mature() {
        mature = true;
    }
    // % fee for early withdraw
    public double getFeeRate() {
        return feeRate;
    }
    // set % fee for early withdraw
    public void setFeeRate( double rate ) {
        feeRate = rate;
    }
    
}