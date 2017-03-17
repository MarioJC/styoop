/**
 * A bank activity event.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankActivityEvent {

    private double amount;
    
    public BankActivityEvent( double amount ) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
}