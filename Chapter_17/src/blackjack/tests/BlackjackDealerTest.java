package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Hand;
import BlackjackDealer;
import Player;
import BettingPlayer;
import Card;
import Dealer;
import Deckpile;
import Deck;
import Suit;
import Rank;
import Bank;
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
    
    public void test_newGame() {
        dealer.addPlayer( player );
        dealer.newGame();
        Assert.assertTrue( "player should have gotten a turn", player.didPlay() );
        Assert.assertTrue( "player should have 2 cards", player.numCards() == 2 );
    }
    
    public void test_deal() {
        md.addPlayer( player );
        md.reset();
        player.play( md );
        md.deal();
        Assert.assertTrue( "player should have 2 cards", player.numCards() == 2 );
        Assert.assertTrue( "dealer should have 2 cards", md.numCards() == 2 );
    }
    
    public void test_dealerHit() {
        // testing whether the dealer hits or not is more difficult because
        // of the state, here we will use a stacked deck to see if the dealer
        // hits enough times, the dealer should have 5 cards at the end
        Card [] cards = { H_9, H_9, H_10, H_2, H_2, H_2, H_2, H_2 };
        Deckpile pile = new Deckpile();
        pile.addCards( cards );
        MockDealer mockdealer = new MockDealer( "md", dealer_hand, pile );
        mockdealer.addPlayer( player );
        mockdealer.newGame();
        Assert.assertTrue( mockdealer.numHits() == 3 );
        Assert.assertTrue( player.numCards() == 2 );
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
        player = new MockPlayer( "mock", player_hand, new Bank( 1000 ) );
    }
    
    public BlackjackDealerTest( String name ) {
        super( name );
    }

    private class MockDealer extends BlackjackDealer {
        
        private int num_cards;
        private int num_hits;
        
        public MockDealer( String name, Hand hand, Deckpile pile ) {
            super( name, hand, pile );
        }
        
        public void hit( Player p ) {
            num_hits++;
            super.hit( p );
        }
        
        public int numHits() {
            return num_hits;
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
    
    private class MockPlayer extends BettingPlayer {
        
        private boolean did_play = false;
        private int num_cards;
        
        public MockPlayer( String name, Hand hand, Bank bank ) {
            super( name, hand, bank );
        }

        public void bet() {
            
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
