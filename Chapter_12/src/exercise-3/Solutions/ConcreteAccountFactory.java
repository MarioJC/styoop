/**
 * A concrete implementation of the bank account factory.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ConcreteAccountFactory implements AbstractAccountFactory {

    public CheckingAccount createCheckingAccount( double initDeposit, int trans, double fee ) {
        return new CheckingAccount( initDeposit, trans, fee );
    }
    
    public OverdraftAccount createOverdraftAccount( double initDeposit, double rate ) {
        return new OverdraftAccount( initDeposit, rate );
    }
    
    public RewardsAccount createRewardsAccount( double initDeposit, double interest, double min ) {
        return new RewardsAccount( initDeposit, interest, min );
    }
    
    public SavingsAccount createSavingsAccount( double initBalance, double interestRate ) {
        return new SavingsAccount( initBalance, interestRate );
    }
    
    public TimedMaturityAccount createTimedMaturityAccount( double initBalance, double interestRate, double feeRate ) {
        return new TimedMaturityAccount( initBalance, interestRate, feeRate );
    }
    
}