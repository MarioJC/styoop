/**
 * The abstract factory for creating bank accounts. This factory is implemented
 * as an interface. You could have also implemented it as an abstract class.
 * However, Java is constrained to single inheritance so an interface is a better
 * Java based solution.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public interface AbstractAccountFactory {

    public CheckingAccount createCheckingAccount( double initDeposit, int trans, double fee );
    
    public OverdraftAccount createOverdraftAccount( double initDeposit, double rate );
    
    public RewardsAccount createRewardsAccount( double initDeposit, double interest, double min );
    
    public SavingsAccount createSavingsAccount( double initBalance, double interestRate );
    
    public TimedMaturityAccount createTimedMaturityAccount( double initBalance, double interestRate, double feeRate );    

}