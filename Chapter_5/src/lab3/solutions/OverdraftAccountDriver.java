/**
 * OverdraftAccountDriver instantiates and exercises the OverdraftAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class OverdraftAccountDriver {

    public static void main( String [] args ) {
        OverdraftAccount oa = new OverdraftAccount( 5000.00, .10 );
        System.out.println( "OverdraftAccount getBalance() (should be 5000.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount getCreditRate() (should be .1): " + oa.getCreditRate() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4900.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4800.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4700.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4600.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4500.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount getBalance() (should be 4500.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4400.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4300.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4200.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4100.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 4000.0): " + oa.getBalance() );
        System.out.println( "OverdraftAccount withdrawFunds() (should be 100.0): " + oa.withdrawFunds( 100.00 ) );
        System.out.println( "OverdraftAccount getBalance() (should be 3900.0): " + oa.getBalance() );
        oa.withdrawFunds( 8900 );
        System.out.println( "OverdraftAccount getBalance() (should be -5000.0): " + oa.getBalance() );
        oa.chargeInterest();
        System.out.println( "OverdraftAccount getBalance() after charging interest (should be -5500): " + oa.getBalance() );
        oa.depositFunds( 5600.00 );
        oa.chargeInterest();
        System.out.println( "OverdraftAccount getBalance() after depositing 5600 and charging interest (should be 100.0): " + oa.getBalance() );
    }
    
}