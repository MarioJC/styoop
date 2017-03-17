/**
 * BankAccountDriver instantiates and exercises the BankAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountDriver {

    public static void main( String [] args ) {
        BankAccount ba = new BankAccount( 5000.00 );
        System.out.println( "BankAccount getBalance() (should be 5000.0): " + ba.getBalance() );
        System.out.println( "BankAccount withdrawFunds() (should be 250.55): " + ba.withdrawFunds( 250.55 ) );
        System.out.println( "BankAccount getBalance() (should be 4749.45): " + ba.getBalance() );
        ba.depositFunds( 100.00 );
        System.out.println( "BankAccount getBalance() (should be 4849.45): " + ba.getBalance() );
        ba.withdrawFunds( 10000.00 );
        System.out.println( "BankAccount getBalance() (should be 0.0): " + ba.getBalance() );
    }
    
}
