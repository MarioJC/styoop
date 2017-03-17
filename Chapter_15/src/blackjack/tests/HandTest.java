package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Card;
import Hand;
import Rank;
import Suit;
/**
 * This test class tests the Hand.
 * @author  Tony Sintes STYOOP
 */
public class HandTest extends TestCase {

    private Hand hand;
    
    private final static Card H_2 = new Card( Suit.HEARTS, Rank.TWO );
    private final static Card H_3 = new Card( Suit.HEARTS, Rank.THREE );
    private final static Card H_4 = new Card( Suit.HEARTS, Rank.FOUR );
    private final static Card H_5 = new Card( Suit.HEARTS, Rank.FIVE );
    private final static Card H_6 = new Card( Suit.HEARTS, Rank.SIX );
    private final static Card H_7 = new Card( Suit.HEARTS, Rank.SEVEN );
    private final static Card H_8 = new Card( Suit.HEARTS, Rank.EIGHT );
    private final static Card H_9 = new Card( Suit.HEARTS, Rank.NINE );
    private final static Card H_10    = new Card( Suit.HEARTS, Rank.TEN );
    private final static Card H_JACK  = new Card( Suit.HEARTS, Rank.JACK );
    private final static Card H_QUEEN = new Card( Suit.HEARTS, Rank.QUEEN );
    private final static Card H_KING  = new Card( Suit.HEARTS, Rank.KING );
    private final static Card H_ACE   = new Card( Suit.HEARTS, Rank.ACE );
    
    public void test_total() {
        int total = H_2.getRank().getRank();
        
        hand.addCard( H_2 );
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.addCard( H_9 );
        total += H_9.getRank().getRank();
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.addCard( H_ACE );
        total += H_ACE.getRank().getRank();
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.reset();
        total = 0;
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.addCard( H_2 );
        total = H_2.getRank().getRank();
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.addCard( H_9 );
        total += H_9.getRank().getRank();
        Assert.assertTrue( "incorrect total", hand.total() == total );
        
        hand.addCard( H_ACE );
        total += H_ACE.getRank().getRank();
        Assert.assertTrue( "incorrect total", hand.total() == total );
    }
    
    public void test_bust() {
        hand.addCard( H_2 );
        Assert.assertTrue( "hand should not be busted", !hand.bust() );
        hand.addCard( H_3 );
        Assert.assertTrue( "hand should not be busted", !hand.bust() );
        hand.addCard( H_4 );
        Assert.assertTrue( "hand should not be busted", !hand.bust() );
        hand.addCard( H_5 );
        Assert.assertTrue( "hand should not be busted", !hand.bust() );
        hand.addCard( H_6 );
        Assert.assertTrue( "hand should not be busted", !hand.bust() );
        hand.addCard( H_7 );
        Assert.assertTrue( "hand should be busted", hand.bust() );
        hand.reset();
        Assert.assertTrue( "hand should not be busted after reset", !hand.bust() );
    }
    
    protected void setUp() {
        hand = new Hand();
    }

    public HandTest(String name) {
        super( name );
    }

}
