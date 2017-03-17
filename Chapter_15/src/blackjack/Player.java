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
    
    public Player( String name, Hand hand ) {
        this.name = name;
        this.hand = hand;
    }
    
    public void addCard( Card card ) {
        hand.addCard( card );
        notifyListeners();
    }
    
    public void play( Dealer dealer ) {
        // as before, play until the player either busts or stays
        while( !isBusted() && hit() ) {
            dealer.hit( this );
        }
        // but now, tell the dealer that the player is done, otherwise nothing
        // will happen when the player returns
        stopPlay( dealer );
    }
    
    public void reset() {
        hand.reset();
    }
    
    public boolean isBusted() {
        return hand.bust();
    }
    
    public void addListener( PlayerListener l ) {
        listeners.add( l );
    }
    
    public String toString() {
        return ( name + ": " + hand.toString() );
    }
    
    protected Hand getHand() {
        return hand;
    }
    
    protected void notifyListeners() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            PlayerListener pl = (PlayerListener) i.next();
            pl.handChanged( this );
        }
    }

    /**
     * The call to passTurn MUST be inside of a protected method. The Dealer
     * needs to override this behavior! Otherwise it will loop forever. 
     */
    protected void stopPlay( Dealer dealer ) {
        dealer.passTurn();
    }
   
    protected abstract boolean hit();
    
}

