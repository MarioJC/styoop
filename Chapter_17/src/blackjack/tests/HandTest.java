package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Card;
import Hand;
import HandListener;
import Rank;
import Suit;
/**
 * This test class tests the Hand.
 * @author  Tony Sintes STYOOP
 */
public class HandTest extends TestCase {

    private Hand hand;
    private MockHandListener listener;
    
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
    
    public void test_isEqual() {
        Hand hand2 = new Hand();
        hand2.setHolder( listener );
        hand.addCard( H_2 );
        hand2.addCard( H_2 );
        hand.addCard( H_3 );
        hand2.addCard( H_3 );
        Assert.assertTrue( "hand should be equal", hand.isEqual( hand2 ) );
        hand2.addCard( H_2 );
        Assert.assertTrue( "hand should not be equal", !hand.isEqual( hand2 ) );
    }
    
    public void test_events() {
        hand.addCard( H_2 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should not yet be playable", !listener.isPlayable() );
        listener.reset();
        hand.addCard( H_3 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_3 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_3 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_3 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_ACE );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_5 );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_ACE );
        Assert.assertTrue( "should not be busted", !listener.isBusted() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should be playable", listener.isPlayable() );
        listener.reset();
        hand.addCard( H_10 );
        Assert.assertTrue( "hand should not be playable after bust", !listener.isPlayable() );
        Assert.assertTrue( "hand should have changed", listener.isChanged() );
        Assert.assertTrue( "hand should bust", listener.isBusted() );
    }
    
    public void test_isGreaterThan() {
        Hand hand1 = new Hand();
        hand1.addCard( H_10 );
        hand1.addCard( H_ACE );
        hand.addCard( H_2 );
        hand.addCard( H_3 );
        Assert.assertTrue( "hand1 is greater than hand", hand1.isGreaterThan( hand ) );
        hand.addCard( H_10 );
        hand.addCard( H_ACE );
        Assert.assertTrue( "hand1 is greater than hand", hand1.isGreaterThan( hand ) );
        hand.addCard( H_10 );
        // this is the proper behavior since you can have a higher total and be busted
        // this means that when comparing, you should only compare non-busted hands
        Assert.assertTrue( "hand1 is not greater than hand", !hand1.isGreaterThan( hand ) );
    }
    
    public void test_blackjack() {
        hand.addCard( H_10 );
        Assert.assertTrue( "should not have gotten blackjack event", !listener.isBlackjack() );
        Assert.assertTrue( "should not be blackjack", !hand.blackjack() );
        listener.reset();
        hand.addCard( H_ACE );
        Assert.assertTrue( "should have gotten blackjack event", listener.isBlackjack() );
        Assert.assertTrue( "should be blackjack", hand.blackjack() );
        listener.reset();
        hand.addCard( H_10 );
        Assert.assertTrue( "should not have gotten blackjack event", !listener.isBlackjack() );
        Assert.assertTrue( "should not be blackjack", !hand.blackjack() );
        listener.reset();
        hand.addCard( H_2 );
        Assert.assertTrue( "should not have gotten blackjack event", !listener.isBlackjack() );
        Assert.assertTrue( "should not be blackjack", !hand.blackjack() );
    }
    
    public void test_total() {
        int total = H_2.getRank().getRank();
        
        hand.addCard( H_2 );
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
        total += H_ACE.getRank().getRank() - 10;
        Assert.assertTrue( "incorrect total", hand.total() == total );
    }
    
    public void test_toString() {
        H_2.setFaceUp( true );
        H_ACE.setFaceUp( true );
        hand.addCard( H_2 );
        hand.addCard( H_ACE );
        String correct_output = " " + H_2.toString() + " " + H_ACE.toString();
        Assert.assertTrue( "should be: " + correct_output, correct_output.equals( hand.toString() ) );
    }
    
    public void test_bust() {
        hand.addCard( H_2 );
        Assert.assertTrue( "hand should not be busted", !listener.isBusted() );
        hand.addCard( H_3 );
        Assert.assertTrue( "hand should not be busted", !listener.isBusted() );
        hand.addCard( H_4 );
        Assert.assertTrue( "hand should not be busted", !listener.isBusted() );
        hand.addCard( H_5 );
        Assert.assertTrue( "hand should not be busted", !listener.isBusted() );
        hand.addCard( H_6 );
        Assert.assertTrue( "hand should not be busted", !listener.isBusted() );
        hand.addCard( H_7 );
        Assert.assertTrue( "hand should be busted", listener.isBusted() );
        hand.reset();
        Assert.assertTrue( "hand should not be busted after reset", hand.total() == 0 );
    }
    
    protected void setUp() {
        hand = new Hand();
        listener = new MockHandListener();
        hand.setHolder( listener );
    }

    public HandTest(String name) {
        super( name );
    }

    private class MockHandListener implements HandListener {
        
        private boolean playable;
        private boolean blackjack;
        private boolean busted;
        private boolean changed;
        
        public void handPlayable() {
            playable = true;
        }
    
        public void reset() {
            playable = blackjack = busted = changed = false;
        }
        
        public void handBlackjack() {
            blackjack = true;
        }
    
        public void handBusted() {
            busted = true;
        }
    
        public void handChanged() {
            changed = true;
        }
        
        public boolean isPlayable() {
            return playable;
        }
        
        public boolean isBlackjack() {
            return blackjack;
        }
        
        public boolean isBusted() {
            return busted;
        }
        
        public boolean isChanged() {
            return changed;
        }
    }
    
}
