import java.util.ArrayList;
import java.util.Iterator;
/**
 * The BankAccountModel manages the account's state and behavior. It also tracks
 * any object interested in receiving state change notifications.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountModel {
    
    // private data
    private double    balance;
    private ArrayList listeners = new ArrayList(); 
    
    public BankAccountModel( double initDeposit ) {   
	setBalance( initDeposit );
    }
    
    public void depositFunds( double amount ) {
	setBalance( getBalance() + amount );
    }
    
    public double getBalance() {
	return balance;
    }
   
    protected void setBalance( double newBalance ) {
	balance = newBalance;
        updateObservers();
    }
    
    public double withdrawFunds( double amount ) {
        if( amount > getBalance() ) {
            amount = getBalance();
        }
	setBalance( getBalance() - amount );	
	return amount;
    }
    
    public void register( Observer o ) {
        listeners.add( o );  
        o.update();
    }
    
    public void deregister( Observer o ) {
        listeners.remove( o );
    }
    
    private void updateObservers() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            Observer o = (Observer) i.next();
            o.update();
        }
    }
    
}