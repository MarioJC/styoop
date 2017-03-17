/**
 *
 * @author  Tony Sintes STYOOP
 * @version 2.0
 */
public class BankDriver {

    public static void main( String [] args ) {
        CheckingAccount  ca = new CheckingAccount( 5000.00, 5, 2.50 );
        OverdraftAccount oa = new OverdraftAccount( 10000.00, 0.18 );
        SavingsAccount   sa = new SavingsAccount( 500.00, 0.02 );
        TimedMaturityAccount tma = new TimedMaturityAccount( 10000.00, 0.06, 0.05 );
        
        Bank bank = Bank.getInstance();
        bank.addAccount( "CHECKING", ca );
        bank.addAccount( "OVERDRAFT", oa );
        bank.addAccount( "SAVINGS", sa );
        bank.addAccount( "TMA", tma );
        
        System.out.println( "Total holdings(should be $25500.0): $" + bank.totalHoldings() );
        System.out.println( "Total accounts(should be 4): " + bank.totalAccounts() );
        
        RewardsAccount ra = new RewardsAccount( 5000.00, .05, 500.00 );
        bank.addAccount( "REWARDS", ra );
       
        System.out.println( "Total holdings(should be $30500.0): $" + bank.totalHoldings() );
        System.out.println( "Total accounts(should be 5): " + bank.totalAccounts() );
        
        bank.deposit( "CHECKING", 250.00 );
        double new_balance = bank.balance( "CHECKING" );
        System.out.println( "CHECKING new balance (should be 5250.0): $" + new_balance );
    }

}
