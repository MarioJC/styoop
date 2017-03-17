import java.util.ArrayList;
import java.util.Iterator;
/**
 * This is the abstract base class for Blackjack players. A player holds a hand,
 * adds cards to the hand, knows how to play, provides state information,
 * and provides listener support.
 * @author  Tony Sintes STYOOP
 */
public abstract class Player {

    private Hand hand;
    private String name;
    private ArrayList listeners = new ArrayList();
    private PlayerState current_state;
    
    public Player( String name, Hand hand ) {
        this.name = name;
        this.hand = hand;
        setCurrentState( getInitialState() );
    }
    
    public void addCard( Card card ) {
        hand.addCard( card );
    }

    public void play( Dealer dealer ) {
        current_state.execute( dealer );
    }
    
    public void reset() {
        hand.reset();
        setCurrentState( getInitialState() );
    }

    public void addListener( PlayerListener l ) {
        listeners.add( l );
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return ( name + ": " + hand.toString() );
    }
    
    public void win() { 
        notifyListeners( new NotifyWon() );
    }
    
    public void lose() {
        notifyListeners( new NotifyLost() );
    }
    
    public void standoff() {
        notifyListeners( new NotifyStandoff() );
    }
    
    public void blackjack() {
        notifyListeners( new NotifyBlackjack() );
    }
    
    protected Hand getHand() {
        return hand;
    }
    
    protected void notifyListeners( NotifyHelper helper ) {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            helper.notifyListener( pl );
        }
    }
    
    protected final void setCurrentState( PlayerState state ) {
        current_state = state;
        hand.setHolder( state );
    }
    
    protected final PlayerState getCurrentState() {
        return current_state;
    }
    
    protected PlayerState getBustedState() {
        return new Busted();
    }
    protected PlayerState getStandingState() {
        return new Standing();
    }
    protected PlayerState getPlayingState() {
        return new Playing();
    }
    protected PlayerState getWaitingState() {
        return new Waiting();
    }
    protected PlayerState getBlackjackState() {
        return new Blackjack();
    }
    protected PlayerState getInitialState() {
        return new Waiting();
    }
    
    protected abstract boolean hit();
    
    private class Waiting implements PlayerState {
        public void handChanged() {
            notifyListeners( new NotifyChanged() );
        }
        public void handPlayable() {
            setCurrentState( getPlayingState() );
            // transition
        }
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyListeners( new NotifyBlackjack() );
            // transition
        }
        public void handBusted() {
            // not possible in waiting state
        }
        public void execute( Dealer dealer ) {
            // do nothing while waiting
        }   
    }
    
    private class Busted implements PlayerState {
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
            dealer.busted( Player.this );
            // terminate
        }
    }
    private class Blackjack implements PlayerState {
        public void handChanged() {
            // not possible in blackjack state
        }
        public void handPlayable() {
            // not possible in blackjack state
        }
        public void handBlackjack() {
            // not possible in blackjack state
        }
        public void handBusted() {
            // not possible in blackjack state
        }
        public void execute( Dealer dealer ) {
            dealer.blackjack( Player.this );
            // terminate
        }
    }
    private class Standing implements PlayerState {
        public void handChanged() {
            // not possible in standing state
        }
        public void handPlayable() {
            // not possible in standing state
        }
        public void handBlackjack() {
            // not possible in standing state
        }
        public void handBusted() {
            // not possible in standing state
        }
        public void execute( Dealer dealer ) {
            dealer.standing( Player.this );
            // terminate
        }
    }
    private class Playing implements PlayerState {
        public void handChanged() {
            notifyListeners( new NotifyChanged() );
        }
        public void handPlayable() {
            // can ignore in playing state
        }
        public void handBlackjack() {
            // not possible in playing state
        }
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyListeners( new NotifyBusted() );
        }
        public void execute( Dealer dealer ) {
            if( hit() ) {
                dealer.hit( Player.this );
            } else {
                setCurrentState( getStandingState() );
                notifyListeners( new NotifyStanding() );
            }
            current_state.execute( dealer );
            // transition
        }
    }
   
    protected interface NotifyHelper {
        public void notifyListener( PlayerListener l );
    }
    protected class NotifyBusted implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerBusted( Player.this ); }
    }
    protected class NotifyBlackjack implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerBlackjack( Player.this ); }
    }
    protected class NotifyWon implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerWon( Player.this ); }
    }
    protected class NotifyLost implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerLost( Player.this ); }
    }
    protected class NotifyChanged implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerChanged( Player.this ); }
    }
    protected class NotifyStanding implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerStanding( Player.this ); }
    }
    protected class NotifyStandoff implements NotifyHelper {
        public void notifyListener( PlayerListener l ) { l.playerStandoff( Player.this ); }
    }
}

