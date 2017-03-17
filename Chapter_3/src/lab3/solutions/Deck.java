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
        
        deck.add( new Card( Card.CLUBS, Card.TWO   ) );
        deck.add( new Card( Card.CLUBS, Card.THREE ) );
        deck.add( new Card( Card.CLUBS, Card.FOUR  ) );
        deck.add( new Card( Card.CLUBS, Card.FIVE  ) );
        deck.add( new Card( Card.CLUBS, Card.SIX   ) );
        deck.add( new Card( Card.CLUBS, Card.SEVEN ) );
        deck.add( new Card( Card.CLUBS, Card.EIGHT ) );
        deck.add( new Card( Card.CLUBS, Card.NINE  ) );
        deck.add( new Card( Card.CLUBS, Card.TEN   ) );
        deck.add( new Card( Card.CLUBS, Card.JACK  ) );
        deck.add( new Card( Card.CLUBS, Card.QUEEN ) );
        deck.add( new Card( Card.CLUBS, Card.KING  ) );
        deck.add( new Card( Card.CLUBS, Card.ACE   ) );
        
        deck.add( new Card( Card.SPADES, Card.TWO   ) );
        deck.add( new Card( Card.SPADES, Card.THREE ) );
        deck.add( new Card( Card.SPADES, Card.FOUR  ) );
        deck.add( new Card( Card.SPADES, Card.FIVE  ) );
        deck.add( new Card( Card.SPADES, Card.SIX   ) );
        deck.add( new Card( Card.SPADES, Card.SEVEN ) );
        deck.add( new Card( Card.SPADES, Card.EIGHT ) );
        deck.add( new Card( Card.SPADES, Card.NINE  ) );
        deck.add( new Card( Card.SPADES, Card.TEN   ) );
        deck.add( new Card( Card.SPADES, Card.JACK  ) );
        deck.add( new Card( Card.SPADES, Card.QUEEN ) );
        deck.add( new Card( Card.SPADES, Card.KING  ) );
        deck.add( new Card( Card.SPADES, Card.ACE   ) );
        
        deck.add( new Card( Card.HEARTS, Card.TWO   ) );
        deck.add( new Card( Card.HEARTS, Card.THREE ) );
        deck.add( new Card( Card.HEARTS, Card.FOUR  ) );
        deck.add( new Card( Card.HEARTS, Card.FIVE  ) );
        deck.add( new Card( Card.HEARTS, Card.SIX   ) );
        deck.add( new Card( Card.HEARTS, Card.SEVEN ) );
        deck.add( new Card( Card.HEARTS, Card.EIGHT ) );
        deck.add( new Card( Card.HEARTS, Card.NINE  ) );
        deck.add( new Card( Card.HEARTS, Card.TEN   ) );
        deck.add( new Card( Card.HEARTS, Card.JACK  ) );
        deck.add( new Card( Card.HEARTS, Card.QUEEN ) );
        deck.add( new Card( Card.HEARTS, Card.KING  ) );
        deck.add( new Card( Card.HEARTS, Card.ACE   ) );
        
        deck.add( new Card( Card.DIAMONDS, Card.TWO   ) );
        deck.add( new Card( Card.DIAMONDS, Card.THREE ) );
        deck.add( new Card( Card.DIAMONDS, Card.FOUR  ) );
        deck.add( new Card( Card.DIAMONDS, Card.FIVE  ) );
        deck.add( new Card( Card.DIAMONDS, Card.SIX   ) );
        deck.add( new Card( Card.DIAMONDS, Card.SEVEN ) );
        deck.add( new Card( Card.DIAMONDS, Card.EIGHT ) );
        deck.add( new Card( Card.DIAMONDS, Card.NINE  ) );
        deck.add( new Card( Card.DIAMONDS, Card.TEN   ) );
        deck.add( new Card( Card.DIAMONDS, Card.JACK  ) );
        deck.add( new Card( Card.DIAMONDS, Card.QUEEN ) );
        deck.add( new Card( Card.DIAMONDS, Card.KING  ) );
        deck.add( new Card( Card.DIAMONDS, Card.ACE   ) );

    }

}
