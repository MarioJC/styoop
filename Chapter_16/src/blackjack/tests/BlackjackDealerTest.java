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
    
    public void test_hit() {
        dealer.hit( player );
        Assert.assertTrue( "player should have one card", player.numCards() == 1 );
    }
    
    public void test_shouldHit() {
        // need to add a player, get the dealer into the proper state, 
        // and then check should hit
        md.addPlayer( player );
        md.reset();
        md.addCard( H_10 );
        md.addCard( H_2 );
        md.standing( player );
        Assert.assertTrue( "less than 17, should hit", md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( "less than 17, should hit", md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( "less than 17, should hit", md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( "greater than 17, should not hit", !md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( "greater than 17, should not hit", !md.hit() );
        md.addCard( H_2 );
        Assert.assertTrue( "greater than 17, should not hit", !md.hit() );
    }
    
    public void test_newGame() {
        md.addPlayer( player );
        md.newGame();
        Assert.assertTrue( "player should have gotten a turn", player.didPlay() );
        Assert.assertTrue( "player should have 2 cards", player.numCards() == 2 );
    }
    
    public void test_deal() {
        md.addPlayer( player );
        md.reset();
        md.deal();
        Assert.assertTrue( "player should have 2 cards", player.numCards() == 2 );
        Assert.assertTrue( "dealer should have 2 cards", md.numCards() == 2 );
    }
    
    protected void setUp() {
        dealer_hand = new Hand();
        Deckpile pile = new Deckpile();
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        ( new Deck() ).addToStack( pile );
        dealer = new BlackjackDealer( "dealer", dealer_hand, pile );
        md = new MockDealer( "md", dealer_hand, pile );
        player_hand = new Hand();
        player = new MockPlayer( "mock", player_hand );
    }
    
    public BlackjackDealerTest( String name ) {
        super( name );
    }

    private class MockDealer extends BlackjackDealer {
        
        private int num_cards;
        
        public MockDealer( String name, Hand hand, Deckpile pile ) {
            super( name, hand, pile );
        }
        
        public void addCard( Card card ) {
            num_cards++;
            super.addCard( card );
        }
        
        public int numCards() {
            return num_cards;
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
            super.play( dealer );
        }
       
        public boolean hit() {
            return false;
        }
        
    }
    
}
