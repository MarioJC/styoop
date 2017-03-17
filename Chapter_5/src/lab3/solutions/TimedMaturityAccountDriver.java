/**
 * TimedMaturityAccountDriver instantiates and exercises the TimedMaturityAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class TimedMaturityAccountDriver extends Object {

    public static void main( String [] args ) {
        
        TimedMaturityAccount tma = new TimedMaturityAccount( 5000.00, .05, .05 );
        System.out.println( "TimedMaturityAccount getBalance() (should be 5000.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount getFeeRate() (should be 0.05): " + tma.getInterestRate() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4900.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4800.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4700.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4600.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4500.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4400.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4300.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 95.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4200.0): " + tma.getBalance() );
        tma.mature();
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 100.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4100.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 100.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 4000.0): " + tma.getBalance() );
        System.out.println( "TimedMaturityAccount withdrawFunds() (should be 100.0): " + tma.withdrawFunds( 100.00 ) );
        System.out.println( "TimedMaturityAccount getBalance() (should be 3900.0): " + tma.getBalance() );
        tma.addInterest();
        System.out.println( "TimedMaturityAccount getBalance() after applying interest (should be 4095.0): " + tma.getBalance() );
        tma.withdrawFunds( 10000.00 );
        System.out.println( "TimedMaturityAccount getBalance() (should be 0.0): " + tma.getBalance() );
        
    }
    
}
