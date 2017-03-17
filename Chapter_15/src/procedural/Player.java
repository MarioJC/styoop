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
        // play until player no longer wants a hit or busts
        while( true ) {
            if( !isBusted() && hit() ) { 
                dealer.hit( this );
            } else {
                break;
            }
        }
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
     *  Each subclass must implement this method. The logic whether
     *  to hit or to stay will go into this method.
     */
    protected abstract boolean hit();
    
}

