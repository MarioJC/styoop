/**
 * CheckingAccount inherits BankAccount and acts in accordance with the CheckingAccount
 * description given in lab 3 chapter 5.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class CheckingAccount extends BankAccount {
    
    // private data
    private int    monthlyQuota;
    private int    transactionCount;
    private double fee;
    
    // Creates new CheckingAccount
    public CheckingAccount( double initDeposit, int trans, double fee ) {
        super( initDeposit );
        setMonthlyQuota( trans );
        setFee( fee );
    }
    // override BankAccount's withdrawFunds
    public double withdrawFunds( double amount ) {
        transactionCount++;
	return super.withdrawFunds( amount );
    }
    // access fees if went over transaction limit
    public void accessFees() {
        int extra = getTransactionCount() - getMonthlyQuota();
        if( extra > 0 ) {
            double total_fee = extra * getFee();
            double balance = getBalance() - total_fee;
            setBalance( balance );
        }
        transactionCount = 0;
    }
    // some getters and setters
    public double getFee() {
        return fee;
    }
    public void setFee( double fee ) {
        this.fee = fee;
    }
    public int getMonthlyQuota() {
        return monthlyQuota;
    }
    public void setMonthlyQuota( int quota ) {
        monthlyQuota = quota;
    }
    public int getTransactionCount() {
        return transactionCount;
    }
    
}