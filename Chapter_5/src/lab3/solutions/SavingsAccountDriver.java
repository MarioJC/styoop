/**
 * SavingsAccountDriver instantiates and exercises the SavingsAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class SavingsAccountDriver {

    public static void main( String [] args ) {
        
        SavingsAccount sa = new SavingsAccount( 5000.00, .05 );
        System.out.println( "SavingsAccount getBalance() (should be 5000.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount getInterestRate() (should be 0.05): " + sa.getInterestRate() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4900.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4800.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4700.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4600.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4500.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4400.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4300.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4200.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4100.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 4000.0): " + sa.getBalance() );
        System.out.println( "SavingsAccount withdrawFunds() (should be 100.0): " + sa.withdrawFunds( 100.00 ) );
        System.out.println( "SavingsAccount getBalance() (should be 3900.0): " + sa.getBalance() );
        sa.addInterest();
        System.out.println( "SavingsAccount getBalance() after applying interest (should be 4095.0): " + sa.getBalance() );
        sa.withdrawFunds( 10000.00 );
        System.out.println( "SavingsAccount getBalance() (should be 0.0): " + sa.getBalance() );
        
    }
    
}
