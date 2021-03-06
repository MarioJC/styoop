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
    
    public void addCard(Card c) {
        hand.addCard( c );
    }

    public void play( final Dealer d ) {
        current_state.execute( d );
    }
    
    public void reset() {
        hand.reset();
        setCurrentState( getInitialState() );
        notifyChanged();
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
        notifyWin();
    }
    
    public void lose() {
        notifyLose();
    }
    
    public void standoff() {
        notifyStandoff();
    }
    
    public void blackjack() {
        notifyBlackjack();
    }
    
    protected Hand getHand() {
        return hand;
    }
    
    protected void notifyChanged() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerChanged( this );
        }
    }
    
    protected void notifyBusted() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerBusted( this );
        }
    }
    
    protected void notifyBlackjack() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerBlackjack( this );
        }
    }
    
    protected void notifyStanding() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerStanding( this );
        }
    }
    
    protected void notifyStandoff() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerStandoff( this );
        }
    }
    
    protected void notifyWin() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerWon( this );
        }
    }
    
    protected void notifyLose() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.playerLost( this );
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
    
    protected abstract PlayerState getInitialState();
    
    protected abstract boolean hit();
    
    private class Waiting implements PlayerState {
        public void handChanged() {
            notifyChanged();
        }
        public void handPlayable() {
            setCurrentState( getPlayingState() );
            // transition
        }
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyBlackjack();
            // transition
        }
        public void handBusted() {
            // not possible in waiting state
        }
        public void execute( Dealer d ) {
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
        public void execute( Dealer d ) {
            d.busted( Player.this );
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
        public void execute( Dealer d ) {
            d.blackjack( Player.this );
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
        public void execute( Dealer d ) {
            d.standing( Player.this );
            // terminate
        }
    }
    private class Playing implements PlayerState {
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
        public void execute( Dealer d ) {
            if( hit() ) {
                d.hit( Player.this );
            } else {
                setCurrentState( getStandingState() );
                notifyStanding();
            }
            current_state.execute( d );
            // transition
        }
    }
   
}

