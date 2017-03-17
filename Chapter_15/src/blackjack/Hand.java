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
    
    public void addCard( Card card ) {
        cards.add( card );
    }
    
    public boolean bust() {
        if( total() > BLACKJACK ) {
            return true;
        }
        return false;
    }
 
    public void reset() {
        cards.clear();
    }
    
    public void turnOver() {
        Iterator i = cards.iterator();
        while( i.hasNext() ) {
            Card card = (Card)i.next();
            card.setFaceUp( true );
        }        
    }
    
    public String toString() {
        Iterator i = cards.iterator();
        String string = "";
        while( i.hasNext() ) {
            Card card = (Card)i.next();
            string = string + " " + card.toString();
        }
        return string;
    }
    
    public int total() {
        int total = 0;
        Iterator i = cards.iterator();
        while( i.hasNext() ) {
            Card card = (Card) i.next();
            total += card.getRank().getRank();
        }
        return total;  
    }
    
}
