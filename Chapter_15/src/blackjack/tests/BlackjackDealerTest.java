package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Hand;
import BlackjackDealer;
import Player;
import Card;
import Dealer;
import Deckpile;
import Deck;
import Suit;
import Rank;
/**
 * This class tests the BlackjackDealer
 * @author  Tony Sintes STYOOP
 */
public class BlackjackDealerTest extends TestCase {

    private BlackjackDealer dealer;
    private Hand dealer_hand;
    private Hand player_hand;
    private MockPlayer player;
    private MockDealer md;
    
    private final static Card H_10 = new Card( Suit.HEARTS, Rank.TEN );
    private final static Card H_9  = new Card( Suit.HEARTS, Rank.NINE );
    private final static Card H_2  = new Card( Suit.HEARTS, Rank.TWO );
    
    public void test_passTurn() {
        dealer.addPlayer( player );
        dealer.passTurn();
        Assert.assertTrue( player.didPlay() );
    }
    
    public void test_hit() {
        dealer.hit( player );
        Assert.assertTrue( player.numCards() == 1 );
    }
    
    public void test_shouldHit() {
        md.addCard( H_10 );
        Assert.assertTrue( md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( !md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( !md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( !md.hit() );
        Assert.assertTrue( md.isBusted() );
    }
    
    public void test_newGame() {
        dealer.addPlayer( player );
        dealer.newGame();
        Assert.assertTrue( player.didPlay() );
        Assert.assertTrue( player.numCards() == 2 );
    }
    
    public void test_deal() {
        dealer.addPlayer( player );
        dealer.deal();
        Assert.assertTrue( player.numCards() == 2 );
    }
    
    protected void setUp() {
        dealer_hand = new Hand();
        Deckpile pile = new Deckpile();
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        // DO NOT USE md and dealer AT THE SAME TIME!!!
        dealer = new BlackjackDealer( "dealer", dealer_hand, pile );
        md = new MockDealer( "md", dealer_hand, pile );
        
        player_hand = new Hand();
        player = new MockPlayer( "mock", player_hand );
    }
    
    public BlackjackDealerTest( String name ) {
        super( name );
    }

    // if we had placed the test cases in the same package we wouldn't
    // need this mock dealer, hit is protected in the dealer
    // if in the same package you can call protected methods
    // since we're not in the same package, must extend and make public
    private class MockDealer extends BlackjackDealer {
    
        public MockDealer( String name, Hand hand, Deckpile cards ) {
            super( name, hand, cards );
        }
        
        public boolean hit() {
            return super.hit();
        }
    }
    
    private class MockPlayer extends Player {
        
        private boolean did_play = false;
        private int num_cards;
        
        public MockPlayer( String name, Hand hand ) {
            super( name, hand );
        }

        public void addCard( Card card ) {
            num_cards++;
            super.addCard( card );
        }
        
        public int numCards() {
            return num_cards;
        }
        
        public boolean didPlay() {
            return did_play;
        }
        
        public void play( Dealer dealer ) {
            did_play = true;
        }
        
        protected boolean hit() {
            return false;
        }
        
    }
    
}
