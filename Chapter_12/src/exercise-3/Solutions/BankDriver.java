/**
 *
 * @author  Tony Sintes STYOOP
 * @version 2.0
 */
public class BankDriver {

    public static void main( String [] args ) {
        AbstractAccountFactory f = new ConcreteAccountFactory();
        CheckingAccount  ca = f.createCheckingAccount( 5000.00, 5, 2.50 );
        OverdraftAccount oa = f.createOverdraftAccount( 10000.00, 0.18 );
        SavingsAccount   sa = f.createSavingsAccount( 500.00, 0.02 );
        TimedMaturityAccount tma = f.createTimedMaturityAccount( 10000.00, 0.06, 0.05 );
        
        Bank bank = new Bank();
        bank.addAccount( "CHECKING", ca );
        bank.addAccount( "OVERDRAFT", oa );
        bank.addAccount( "SAVINGS", sa );
        bank.addAccount( "TMA", tma );
        
        System.out.println( "Total holdings(should be $25500.0): $" + bank.totalHoldings() );
        System.out.println( "Total accounts(should be 4): " + bank.totalAccounts() );
        
        RewardsAccount ra = f.createRewardsAccount( 5000.00, .05, 500.00 );
        bank.addAccount( "REWARDS", ra );
       
        System.out.println( "Total holdings(should be $30500.0): $" + bank.totalHoldings() );
        System.out.println( "Total accounts(should be 5): " + bank.totalAccounts() );
        
        bank.deposit( "CHECKING", 250.00 );
        double new_balance = bank.balance( "CHECKING" );
        System.out.println( "CHECKING new balance (should be 5250.0): $" + new_balance );
    }

}
