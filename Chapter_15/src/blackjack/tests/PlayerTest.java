package tests;

import junit.framework.TestCase;
import junit.framework.Assert;

import Card;
import Dealer;
import Hand;
import Player;
import PlayerListener;
import Rank;
import Suit;
/**
 * This class tests the player.
 * @author  Tony Sintes STYOOP
 */
public class PlayerTest extends TestCase {

    private MockPlayer player;
    private Hand hand;
    private MockPlayerListener listener1;
    private MockPlayerListener listener2;
    private MockPlayerListener listener3;
    private MockPlayerListener listener4;
    private MockDealer dealer;
    
    private final static Card H_10 = new Card( Suit.HEARTS, Rank.TEN );
    private final static Card H_5  = new Card( Suit.HEARTS, Rank.FIVE );
    private final static Card H_2  = new Card( Suit.HEARTS, Rank.TWO );
    
    public void test_addCard() {
        player.addCard( H_10 );
        Assert.assertTrue( "card not added properly", player.getHand().total() == 10 );
        player.addCard( H_5 );
        Assert.assertTrue( "card not added properly", player.getHand().total() == 15 );
        player.addCard( H_2 );
        Assert.assertTrue( "card not added properly", player.getHand().total() == 17 );
        player.addCard( H_10 );
        Assert.assertTrue( "card not added properly", player.getHand().total() == 27 );
    }
    
    public void test_playHit() {
        player.setHit( true );
        player.play( dealer );
        Assert.assertTrue( "while playing the player should have hit", dealer.wasHit() );
    }
    
    public void test_playNoHit() {
        player.setHit( false );
        player.play( dealer );
        Assert.assertTrue( "while playing the player should not have hit", !dealer.wasHit() );
    }
    
    public void test_isBusted() {
        player.addCard( H_10 );
        Assert.assertTrue( "player should not be busted", !player.isBusted() );
        player.addCard( H_5 );
        Assert.assertTrue( "player should not be busted", !player.isBusted() );
        player.addCard( H_2 );
        Assert.assertTrue( "player should not be busted", !player.isBusted() );
        player.addCard( H_10 );
        Assert.assertTrue( "player should be busted", player.isBusted() );
        player.addCard( H_10 );
        Assert.assertTrue( "player should be busted", player.isBusted() );
    }
    
    public void test_reset() {
        player.addCard( H_10 );
        player.addCard( H_10 );
        player.addCard( H_10 );
        player.reset();
        Assert.assertTrue( "after reset player should not be busted", !player.isBusted() );
    }
    
    public void test_stopPlay() {
        player.stopPlay( dealer );
        Assert.assertTrue( "stopPlay should call dealer.passTurn", dealer.passedTurn() );
    }
    
    public void test_notifyListeners() {
        player.addListener( listener1 ); 
        player.addListener( listener2 ); 
        Assert.assertTrue( "listener was called in error", !listener1.hasChanged() );
        Assert.assertTrue( "listener was called in error", !listener2.hasChanged() );
        player.notifyListeners();
        Assert.assertTrue( "listener was not called", listener1.hasChanged() );
        Assert.assertTrue( "listener was not called", listener2.hasChanged() );
        player.addListener( listener3 ); 
        player.addListener( listener4 ); 
        Assert.assertTrue( "listener was called in error", !listener3.hasChanged() );
        Assert.assertTrue( "listener was called in error", !listener4.hasChanged() );
        player.addCard( H_10 );
        Assert.assertTrue( "listener was not called", listener3.hasChanged() );
        Assert.assertTrue( "listener was not called", listener4.hasChanged() );
    }
    
    protected void setUp() {
        hand = new Hand();
        player = new MockPlayer( "mp", hand );
        listener1 = new MockPlayerListener();
        listener2 = new MockPlayerListener();
        listener3 = new MockPlayerListener();
        listener4 = new MockPlayerListener();
        dealer = new MockDealer();
    }
    
    public PlayerTest( String name ) {
        super( name );
    }

    private class MockPlayerListener implements PlayerListener {
        private boolean changed;
        public void handChanged( Player player ) {
            changed = true;
        }
        public boolean hasChanged() {
            return changed;
        }
    }
    
    private class MockDealer implements Dealer {
        
        private boolean was_hit = false;
        private boolean pass_turn = false;
        
        public boolean wasHit() {
            return was_hit;
        }
        
        public void hit( Player player ) {
            was_hit = true;
            player.addCard( H_10 );
        }
        
        public boolean passedTurn() {
            return pass_turn;
        }
        
        public void passTurn() {
            pass_turn = true;
        }
        
    }
    
    private class MockPlayer extends Player {
    
        private boolean hit;
        
        public MockPlayer( String name, Hand hand ) {    
            super( name, hand );
        }
        
        public void setHit( boolean hit ) {
            this.hit = hit;
        }
        
        public void stopPlay( Dealer dealer ) {
            super.stopPlay( dealer );
        }
        
        public void notifyListeners() {
            super.notifyListeners();
        }
        
        public Hand getHand() {
            return super.getHand();
        }
        
        public boolean hit() {
            return this.hit;
        }
        
    }
    
}
