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
    
    private final static Card H_ACE = new Card( Suit.HEARTS, Rank.ACE );
    private final static Card H_10  = new Card( Suit.HEARTS, Rank.TEN );
    private final static Card H_5   = new Card( Suit.HEARTS, Rank.FIVE );
    private final static Card H_2   = new Card( Suit.HEARTS, Rank.TWO );
    
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
        // need to transition to playing, otherwise will not hit (white box)
        player.addCard( H_2 );
        player.addCard( H_2 );
        player.setHit( true );
        player.play( dealer );
        Assert.assertTrue( "while playing the player should have hit", dealer.wasHit() );
    }
    
    public void test_playNoHit() {
        player.setHit( false );
        player.play( dealer );
        Assert.assertTrue( "while playing the player should not have hit", !dealer.wasHit() );
    }
    
    public void test_tellsDealerStanding() {
        player.addCard( H_10 );
        player.addCard( H_5 );
        player.setHit( false );
        player.play( dealer );
        Assert.assertTrue( "player should have stood", dealer.wasStanding() );
    }
    
    public void test_tellsDealerBusted() {
        player.addListener( listener1 );
        player.addCard( H_10 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() );
        player.addCard( H_5 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() );
        player.addCard( H_2 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() );
        player.setHit( true );
        player.play( dealer );
        // will hit and get a 10 and bust
        // player.addCard( H_10 );
        player.play( dealer );
        Assert.assertTrue( "player should be busted", listener1.hasBusted() );
        Assert.assertTrue( "player should have busted to dealer", dealer.wasBusted() );
    }
    
    public void test_isBusted() {
        player.addListener( listener1 );
        player.addCard( H_10 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() );
        player.addCard( H_5 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() );
        player.addCard( H_2 );
        Assert.assertTrue( "player should not be busted", !listener1.hasBusted() ); 
        player.addCard( H_10 );
        Assert.assertTrue( "player should be busted", listener1.hasBusted() );
        player.addListener( listener2 );
        player.addCard( H_10 );
        // while busted, the player should have transitioned to busted at this point
        // while busted the player will ignore busted events, so NOT being busted
        // is the proper behavior!!!
        Assert.assertTrue( "player should not be busted", !listener2.hasBusted() );
    }
    
    public void test_reset() {
        player.addCard( H_10 );
        player.addCard( H_10 );
        player.addCard( H_10 );
        player.reset();
        player.addListener( listener1 );
        player.addCard( H_10 );
        Assert.assertTrue( "after reset player should not be busted", !listener1.hasBusted() );
    }
    
    public void test_notifyChanged() {
        player.addListener( listener1 ); 
        player.addListener( listener2 ); 
        Assert.assertTrue( "listener was called in error", !listener1.hasChanged() );
        Assert.assertTrue( "listener was called in error", !listener2.hasChanged() );
        player.notifyChanged();
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
    
    public void test_notifyBusted() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.addCard( H_10 );
        Assert.assertTrue( "player has not busted", !listener1.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener2.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener3.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener4.hasBusted() );
        player.addCard( H_10 );
        Assert.assertTrue( "player has not busted", !listener1.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener2.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener3.hasBusted() );
        Assert.assertTrue( "player has not busted", !listener4.hasBusted() );
        player.addCard( H_10 );
        Assert.assertTrue( "player has busted", listener1.hasBusted() );
        Assert.assertTrue( "player has busted", listener2.hasBusted() );
        Assert.assertTrue( "player has busted", listener3.hasBusted() );
        Assert.assertTrue( "player has busted", listener4.hasBusted() );
    }
    
    public void test_notifyBlackjack() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.addCard( H_10 );
        Assert.assertTrue( "player does not have blackjack", !listener1.hasBlackjack() );
        Assert.assertTrue( "player does not have blackjack", !listener2.hasBlackjack() );
        Assert.assertTrue( "player does not have blackjack", !listener3.hasBlackjack() );
        Assert.assertTrue( "player does not have blackjack", !listener4.hasBlackjack() );
        player.addCard( H_ACE );
        Assert.assertTrue( "player has blackjack", listener1.hasBlackjack() );
        Assert.assertTrue( "player has blackjack", listener2.hasBlackjack() );
        Assert.assertTrue( "player has blackjack", listener3.hasBlackjack() );
        Assert.assertTrue( "player has blackjack", listener4.hasBlackjack() );
    }
    
    public void test_notifyStanding() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.setHit( false );
        // force the player from waiting to playing
        player.addCard( H_2 );
        player.addCard( H_2 );
        player.play( dealer );
        Assert.assertTrue( "player should stand", listener1.isStanding() );
        Assert.assertTrue( "player should stand", listener2.isStanding() );
        Assert.assertTrue( "player should stand", listener3.isStanding() );
        Assert.assertTrue( "player should stand", listener4.isStanding() );
    }
    
    public void test_notifyStandoff() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.standoff();
        Assert.assertTrue( "player has standoff", listener1.hasStandoff() );
        Assert.assertTrue( "player has standoff", listener2.hasStandoff() );
        Assert.assertTrue( "player has standoff", listener3.hasStandoff() );
        Assert.assertTrue( "player has standoff", listener4.hasStandoff() );
    }
    
    public void test_notifyWin() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.win();
        Assert.assertTrue( "player winner", listener1.hasWon() );
        Assert.assertTrue( "player winner", listener2.hasWon() );
        Assert.assertTrue( "player winner", listener3.hasWon() );
        Assert.assertTrue( "player winner", listener4.hasWon() );
    }
    
    public void test_notifyLose() {
        player.addListener( listener1 );
        player.addListener( listener2 );
        player.addListener( listener3 );
        player.addListener( listener4 );
        player.lose();
        Assert.assertTrue( "player lost", listener1.hasLost() );
        Assert.assertTrue( "player lost", listener2.hasLost() );
        Assert.assertTrue( "player lost", listener3.hasLost() );
        Assert.assertTrue( "player lost", listener4.hasLost() );
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
        private boolean busted;
        private boolean blackjack;
        private boolean won;
        private boolean lost;
        private boolean standoff;
        private boolean standing;
        
        public void playerChanged( Player player ) {
            changed = true;
        }
        
        public void playerBusted( Player player ) {
            busted = true;
        }
    
        public void playerBlackjack( Player player ) {
            blackjack = true;
        }
    
        public void playerStanding( Player player ) {
            standing = true;
        }
 
        public void playerWon( Player player ) {
            won = true;
        }
    
        public void playerLost( Player player ) {
            lost = true;
        }
    
        public void playerStandoff( Player player ) {
            standoff = true;
        }
        
        public boolean hasChanged() {
            return changed;
        }
        public boolean hasBusted() {
            return busted;
        }
        public boolean hasBlackjack() {
            return blackjack;
        }
        public boolean hasWon() {
            return won;
        }
        public boolean hasLost() {
            return lost;
        }
        public boolean hasStandoff() {
            return standoff;
        }
        public boolean isStanding() {
            return standing;
        }
    }
    
    private class MockDealer implements Dealer {
        
        private boolean was_blackjack = false;
        private boolean was_standing = false;
        private boolean was_busted = false;
        private boolean was_hit = false;
        private boolean pass_turn = false;
        
        public boolean wasHit() {
            return was_hit;
        }
        
        public boolean wasBlackjack() {
            return was_blackjack;
        }
        
        public boolean wasBusted() {
            return was_busted;
        }
        
        public boolean wasStanding() {
            return was_standing;
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
        
        public void blackjack( Player player ) {
            was_blackjack = true;
        }
        
        public void busted( Player player ) {
            was_busted = true;
        }
        
        public void standing( Player player ) {
            was_standing = true;
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
        
        protected void notifyChanged() {
            super.notifyChanged();
        }
    
        protected void notifyBusted() {
            super.notifyBusted();
        }
    
        protected void notifyBlackjack() {
            super.notifyBlackjack();
        }
    
        protected void notifyStanding() {
            super.notifyStanding();
        }
    
        protected void notifyStandoff() {
            super.notifyStandoff();
        }
    
        protected void notifyWin() {
            super.notifyWin();
        }
    
        protected void notifyLose() {
            super.notifyLose();
        }
    
        public Hand getHand() {
            return super.getHand();
        }
        
        public boolean hit() {
            return this.hit;
        }
        
    }
    
}
