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
    
    protected PlayerState getPlayingState() {
        return new BetterPlaying();
    }
    
    //**************************************************************************
    // newly added for BettingPlayer
    protected final Bank getBank() {
        return bank;
    }
     
    protected PlayerState getBettingState() {
        return new Betting();
    }
    
    protected PlayerState getDoublingDownState() {
        return new DoublingDown();
    }
    
    protected abstract void bet();
    protected abstract boolean doubleDown();
    
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
    private class DoublingDown implements PlayerState {
        public void handChanged() {
            notifyChanged();
        }
        public void handPlayable() {
            setCurrentState( getStandingState() );
            notifyStanding();
        }
        public void handBlackjack() {
            // not possible in doubling down state
        }
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyBusted();
        }
        public void execute( Dealer dealer ) {
            bank.doubleDown();
            dealer.hit( BettingPlayer.this );
            getCurrentState().execute( dealer );
        }
    }
    private class BetterPlaying implements PlayerState {
        public void handChanged() {
            notifyChanged();
        }
        public void handPlayable() {
            // can ignore in playing state
        }
        public void handBlackjack() {
            // not possible in playing state
        }
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyBusted(); 
        }
        public void execute( Dealer dealer ) {
            if( getHand().canDoubleDown() && doubleDown() ) {
                setCurrentState( getDoublingDownState() );
                getCurrentState().execute( dealer );
                return;
            }
            if( hit() ) {
                dealer.hit( BettingPlayer.this );
            } else {
                setCurrentState( getStandingState() );
                notifyStanding();
            }
            getCurrentState().execute( dealer );
            // transition
        }
    }
   
}
