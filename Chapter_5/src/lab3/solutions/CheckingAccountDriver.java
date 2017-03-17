/**
 * CheckingAccountDriver instantiates and exercises the CheckingAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class CheckingAccountDriver {

    public static void main( String [] args ) {
        
        CheckingAccount ca = new CheckingAccount( 5000.00, 5, 1 );
        System.out.println( "CheckingAccount getBalance() (should be 5000.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount getFee() (should be 1): " + ca.getFee() );
        System.out.println( "CheckingAccount getMonthlyQuota() (should be 5): " + ca.getMonthlyQuota() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4900.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4800.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4700.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4600.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4500.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount getBalance() (should be 4500.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount getTransactionCount() (should be 5): " + ca.getTransactionCount() );
        ca.accessFees();
        System.out.println( "CheckingAccount getBalance() after accessing any fees (should be 4500.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4400.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4300.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4200.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4100.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 4000.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount withdrawFunds() (should be 100.0): " + ca.withdrawFunds( 100.00 ) );
        System.out.println( "CheckingAccount getBalance() (should be 3900.0): " + ca.getBalance() );
        System.out.println( "CheckingAccount getTransactionCount() (should be 6): " + ca.getTransactionCount() );
        ca.accessFees();
        System.out.println( "CheckingAccount getBalance() after accessing any fees (should be 3899.0): " + ca.getBalance() );
        ca.withdrawFunds( 10000.00 );
        System.out.println( "CheckingAccount getBalance() (should be 0.0): " + ca.getBalance() );
        
    }
    
}
