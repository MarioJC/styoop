import java.util.ArrayList;
import java.util.Iterator;

/**
 * A Hand holds onto, provides access to, and provides information about a
 * Blackjack hand of cards.
 * @author  Tony Sintes STYOOP
 */
public class Hand {

    private ArrayList cards = new ArrayList();
    private static final int BLACKJACK = 21;
    private HandListener holder;
    private int number_aces;
    
    public Hand() {
        // set the holder to a blank listener so it will not be null if not
        // externally set
        setHolder(
            new HandListener() {
     			public void handPlayable() {}
    			public void handBlackjack() {}
    			public void handBusted() {}
    			public void handChanged() {}
            }
        );
    }

    public void setHolder( HandListener holder ) {
        this.holder = holder;
    }
    
    public Iterator getCards() {
        return cards.iterator();
    }
    
    public void addCard( Card c ) {
        cards.add( c );
        
        holder.handChanged();
        
        if( c.getRank() == Rank.ACE ) {
            number_aces++;
        }
        
        if( bust() ) {
            holder.handBusted();
            return;
        }
        if( blackjack() ) {
            holder.handBlackjack();
            return;
        } 
        if ( cards.size() >= 2 ){
            holder.handPlayable();
            return;
        }
    }
    
    public boolean canDoubleDown() {
        return ( cards.size() == 2 );
    }
  
    public boolean isEqual( Hand h ) {
        if( h.total() == this.total() ) {
            return true;
        }
        return false;
    }
    
    public boolean isGreaterThan( Hand h ) {
        return this.total() > h.total(); 
    }
    
    public boolean blackjack() {
        if( cards.size() == 2 && total() == BLACKJACK ) {
            return true;
        }
        return false;
    }
    
    public void reset() {
        cards.clear();
        number_aces = 0;
    }
    
    public void turnOver() {
        Iterator i = cards.iterator();
        while( i.hasNext() ) {
            Card c = (Card)i.next();
            c.setFaceUp( true );
        }        
    }
    
    public String toString() {
        Iterator i = cards.iterator();
        String s = "";
        while( i.hasNext() ) {
            Card c = (Card)i.next();
            s = s + " " + c.toString();
        }
        return s;
    }
    
    public int total() {
        int total = 0;
        Iterator i = cards.iterator();
        while( i.hasNext() ) {
            Card c = (Card) i.next();
            total += c.getRank().getRank();
        }
        int temp_aces = number_aces;
        while( total > BLACKJACK && temp_aces > 0 ) {
            total = total - 10;
            temp_aces--;
        }
        return total;  
    }
    
    private boolean bust() {
        if( total() > BLACKJACK ) {
            return true;
        }
        return false;
    }
 
}
