/**
 * This is the abstract BettingPlayer class. All players that bet should inherit
 * from this player type. This player types adds support for betting.
 * @author  Tony Sintes STYOOP
 */
public abstract class BettingPlayer extends Player {

    private Bank bank;
    
    public BettingPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand );
        this.bank = bank;
    }

    //**************************************************************************
    // overridden behavior
    public String toString() {
        return ( getName() + ": " + getHand().toString() + "\n" + bank.toString() );
    }
     
    public void win() {
        bank.win();
        super.win();
    }
    
    public void lose() {
        bank.lose();
        super.lose();
    }
    
    public void standoff() {
        bank.standoff();
        super.standoff();
    }
    
    public void blackjack() {
        bank.blackjack();
        super.blackjack();
    }
   
    protected PlayerState getInitialState() {
        return getBettingState();
    }
    
    //**************************************************************************
    // newly added for BettingPlayer
    protected final Bank getBank() {
        return bank;
    }
     
    protected PlayerState getBettingState() {
        return new Betting();
    }
    
    protected abstract void bet();
    
    private class Betting implements PlayerState {   
        public void handChanged() {
            // not possible in busted state
        }
        public void handPlayable() {
            // not possible in busted state
        }
        public void handBlackjack() {
            // not possible in busted state
        }
        public void handBusted() {
            // not possible in busted state
        }
        public void execute( Dealer dealer ) {
            bet();
            setCurrentState( getWaitingState() );
            dealer.doneBetting( BettingPlayer.this );
            // terminate
        }
    }
}
