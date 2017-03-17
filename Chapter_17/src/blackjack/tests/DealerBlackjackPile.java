package tests;

import Deckpile;
import Suit;
import Rank;
import Card;
/**
 * This ensures that within a game containing a dealer and one player, the dealer
 * will always be dealt a blackjack hand.
 * @author  Tony Sintes STYOOP
 */
public class DealerBlackjackPile extends Deckpile {

    private Card [] cards;
    private int index = -1;
    
    public DealerBlackjackPile() {
        cards = new Card[4];
        cards[0] = new Card( Suit.HEARTS, Rank.TWO );
        cards[1] = new Card( Suit.HEARTS, Rank.ACE );
        cards[2] = new Card( Suit.HEARTS, Rank.THREE );
        cards[3] = new Card( Suit.HEARTS, Rank.KING );
    }
    
    public void shuffle() {
        // do nothing
    }
    
    public Card dealUp() {
        index++;
        cards[index].setFaceUp( true );
        return cards[index];
    }
    
    public Card dealDown() {
        index++;
        return cards[index];
    }
    
    public void reset() {
        // do nothing
    }
    
}