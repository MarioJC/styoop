/**
 * The deck builds a deck of cards and supplies methods to shuffle the deck, 
 * retrieve, and return cards.
 * @author  Tony Sintes
 * @version 1.0
 */
public class Deck {

    private java.util.LinkedList deck;
    
    public Deck() {
        buildCards();
    }
    
    public Iterator iterator() {
        return new ForwardIterator();
    }
    
    public Card get( int index ) {
        if( index < deck.size() ) {
            return (Card) deck.get( index );
        }
        return null;
    }
    
    public void replace( int index, Card card ) {
        deck.set( index, card ); 
    }
    
    public int size() {
        return deck.size();
    }
    
    public Card removeFromFront() {
        if( deck.size() > 0 ) {
            Card card = (Card) deck.removeFirst();
            return card;
        } 
        return null;
    }
    
    public void returnToBack( Card card ) {
        deck.add( card );
    }
    
    private void buildCards() {

        deck = new java.util.LinkedList();
        
        for( int i = 0; i < Suit.SUIT.length; i ++ ) {
            for( int j = 0; j < Rank.RANK.length; j ++ ) {
                deck.add( new Card( Suit.SUIT[i], Rank.RANK[j] ) );
            }
        }
    }

    private class ForwardIterator implements Iterator {
        
        int index;
        
        public boolean isDone() {
            if( index >= deck.size() ) {
                return true;
            }
            return false;
        }
    
        public Object currentItem() {
            if( !isDone() ) {
                return deck.get( index );
            }
            return null;
        }
    
        public void next() {
            index++;
        }
    
        public void first() {
            index = 0;
        }
    }

}
