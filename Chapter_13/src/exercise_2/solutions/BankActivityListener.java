/**
 * Defines the methods one has to implement in order to receive withdraw and
 * deposit events.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public interface BankActivityListener {

    public void withdrawPerformed( BankActivityEvent e );
    
    public void depositPerformed( BankActivityEvent e );
    
}
