/**
 * RewardsAccountDriver instantiates and exercises the RewardsAccount.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class RewardsAccountDriver {

    public static void main( String [] args ) {
        
        RewardsAccount ra = new RewardsAccount( 5000.00, .05, 500.00 );
        System.out.println( "RewardsAccount getBalance() (should be 5000.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount getInterestRate() (should be 0.05): " + ra.getInterestRate() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4900.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4800.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4700.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4600.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4500.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4400.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4300.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4200.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4100.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 4000.0): " + ra.getBalance() );
        System.out.println( "RewardsAccount withdrawFunds() (should be 100.0): " + ra.withdrawFunds( 100.00 ) );
        System.out.println( "RewardsAccount getBalance() (should be 3900.0): " + ra.getBalance() );
        ra.addInterest();
        System.out.println( "RewardsAccount getBalance() after applying interest (should be 4095.0): " + ra.getBalance() );
        ra.withdrawFunds( 10000.00 );
        System.out.println( "RewardsAccount getBalance() (should be 0.0): " + ra.getBalance() );
        ra.depositFunds( 499.00 );
        ra.depositFunds( 499.00 );
        ra.depositFunds( 499.00 );
        ra.depositFunds( 499.00 );
        ra.depositFunds( 499.00 );
        ra.depositFunds( 499.00 );
        System.out.println( "Rewards earned (should be 0): " + ra.getRewardsEarned() );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        System.out.println( "Rewards earned (should be 5): " + ra.getRewardsEarned() );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        ra.depositFunds( 500.00 );
        System.out.println( "Rewards earned (should be 9): " + ra.getRewardsEarned() );
        ra.depositFunds( 500.00 );
        System.out.println( "Rewards earned (should be 10): " + ra.getRewardsEarned() );
        ra.resetRewards();
        System.out.println( "Rewards earned (should be 0): " + ra.getRewardsEarned() );
    }
    
}
