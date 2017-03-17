/**
 * The RewardsAccount applies interest like a SavingsAccount but also keeps track of the number 
 * of deposits over a certain amount. When a deposit is large enough the depositor will earn a reward point. The account keeps track of the number of rewards earned.
 * @author  Tony Sintes
 * @version 
 */
public class RewardsAccount extends SavingsAccount {
    private double min_reward_balance;
    private int qualifying_deposits;
    
    public RewardsAccount( double initDeposit, double interest, double min ) {
        super( initDeposit, interest );
        min_reward_balance = min;
    }

    public void depositFunds( double amount ) {
        super.depositFunds( amount );
        if( amount >= min_reward_balance ) {
            qualifying_deposits++;
        }
    }
    
    public int getRewardsEarned() {
        return qualifying_deposits;
    }
    
    public void resetRewards() {
        qualifying_deposits = 0;
    }
    
    public double getMinimumRewardBalance() {
        return min_reward_balance;
    }
    
    public void setMinimumRewardBalance( double min ) {
        min_reward_balance = min;
    }
}
