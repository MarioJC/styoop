/**
 * The Bank object holds onto accounts and provides methods for manipulating those accounts.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class Bank {

    private java.util.Hashtable accounts = new java.util.Hashtable();
    
    public void addAccount( String name, BankAccount account ) {
        accounts.put( name, account );
    }
    
    public double totalHoldings() {
        double total = 0.0;
        
        java.util.Enumeration enum = accounts.elements();
        while( enum.hasMoreElements() ) {
            BankAccount account = (BankAccount) enum.nextElement();
            total += account.getBalance();
        }
        return total;
    }
    
    public int totalAccounts() {
        return accounts.size();
    }
    
    public void deposit( String name, double ammount ) {
        BankAccount account = retrieveAccount( name );
        if( account != null ) {
            account.depositFunds( ammount );
        }
    }
    
    public double balance( String name ) {
        BankAccount account = retrieveAccount( name );
        if( account != null ) {
            return account.getBalance();
        }
        return 0.0;
    }
    
    private BankAccount retrieveAccount( String name ) {
        return (BankAccount) accounts.get( name );
    }
}
