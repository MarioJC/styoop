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
public class DeckpileTest extends TestCase {

    private final static Deck deck = new Deck();
    private Deckpile pile;
    
    public void test_shuffle() {
        // not a great test, but ensures something gets shuffled around
        Card c = pile.dealUp();
        pile.reset();
        pile.shuffle();
        Assert.assertTrue( "after shuffle the first card should be random", c != pile.dealUp() );
    }
    
    public void test_reset() {
        Card c = pile.dealUp();
        pile.reset();
        Assert.assertTrue( "a reset with no shuffle should return deck to original status", c == pile.dealUp() );
    }
    
    public void test_addToStack() {
        deck.addToStack( pile );
        // should now contain 104 cards
        for( int i = 0; i < 104; i ++ ) {
            Assert.assertTrue( "card should not be null", pile.dealDown() != null );
        }
    }
    
    public void test_dealUp() {
        Card c = pile.dealUp();
        Assert.assertTrue( "cards dealt up should be face up", c.isFaceUp() );
        c = pile.dealUp();
        Assert.assertTrue( "cards dealt up should be face up", c.isFaceUp() );
        c = pile.dealUp();
        Assert.assertTrue( "cards dealt up should be face up", c.isFaceUp() );
    }
    
    public void test_dealDown() {
        Card c = pile.dealDown();
        Assert.assertTrue( "cards dealt down should be face down", !c.isFaceUp() );
        c = pile.dealDown();
        Assert.assertTrue( "cards dealt down should be face down", !c.isFaceUp() );
        c = pile.dealDown();
        Assert.assertTrue( "cards dealt down should be face down", !c.isFaceUp() );
    }
    
    protected void setUp() {
        pile = new Deckpile();
        deck.addToStack( pile );
    }
    
    public DeckpileTest( String name ) {
        super( name );
    }

    private class MockPile extends Deckpile { 
        public void addCards( Card [] cards ) {
            Assert.assertTrue( "should have 52 cards", cards.length == 52 );
            for( int i = 0; i < 52; i ++ ) {
                Assert.assertTrue( "cards should not be null", cards[i] != null );
            }
        }
    }
    
}
