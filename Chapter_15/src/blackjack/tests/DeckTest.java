package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Card;
import Deck;
import Deckpile;
/**
 * This class tests the Deck.
 * @author  Tony Sintes STYOOP
 */
public class DeckTest extends TestCase {

    private Deck deck;
    private final static Deckpile pile = new Deckpile();
    
    public void test_deck() {
        deck.addToStack( pile );
    }
    
    protected void setUp() {
        deck = new Deck();
    }
    
    public DeckTest( String name ) {
        super( name );
    }

    private class MockPile extends Deckpile { 
        public void addCards( Card [] cards ) {
            Assert.assertTrue( "the pile should have been passed 52 cards", cards.length == 52 );
            for( int i = 0; i < 52; i ++ ) {
                Assert.assertTrue( "card should not be null" ,cards[i] != null );
            }
        }
    }
    
}
