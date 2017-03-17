/**
 * This is the dealer class. The dealer knows how to shuffle and deal cards.
 * @author  Tony Sintes STYOOP
 */
public class Dealer {
    
    private Deck deck;
    
    public Dealer( Deck d ) {
        deck = d;
    }

    public void shuffle() {
        // randomize the card array
        int num_cards = deck.size(); 
        for( int i = 0; i < num_cards; i ++ ) {
            int index = (int) ( Math.random() * num_cards );
            Card card_i = ( Card ) deck.get( i );
            Card card_index = ( Card ) deck.get( index );
            deck.replace( i, card_index );
            deck.replace( index, card_i );
        }
    }
    
    public Card dealCard() {
        if( deck.size() > 0 ) {
            return deck.removeFromFront();
        }
        return null;
    }
    
}
