import java.util.ArrayList;
import java.util.Iterator;
/**
 * The Dealer deals cards and directs the course of play. In the game of
 * Blackjack a dealer is also a player.
 * @author  Tony Sintes STYOOP
 */
public class BlackjackDealer extends Player implements Dealer {
    
    private Deckpile cards;
    private ArrayList players = new ArrayList();
    
    public BlackjackDealer( String name, Hand hand, Deckpile cards ) {
        super( name, hand );
        this.cards = cards;
    }
    
    public void addPlayer( Player player ) {
        players.add( player );
    }
    
    public void hit( Player player ) {
        player.addCard( cards.dealUp() );
    }
    
    public void newGame() {
        
        cards.shuffle();
        
        // reset each player and deal 1 card up to each and self
        Player [] player = new Player[players.size()];
        players.toArray( player );
        for( int i = 0; i < player.length; i ++ ) {
            player[i].reset();
            player[i].addCard( cards.dealUp() );
        }
        this.addCard( cards.dealUp() );
        
        // deal 1 more up card to each player and one down to self
        for( int i = 0; i < player.length; i ++ ) {
            player[i].addCard( cards.dealUp() );
        }
        this.addCard( cards.dealDown() );
        
        // have each player play and then dealer
        for( int i = 0; i < player.length; i ++ ) {
            player[i].play(this);
        }
        exposeCards();
        this.play( this );
        
    }
    
    protected boolean hit() {
        if( getHand().total() <= 16 ) {
            return true;
        }
        return false;
    }
    
    private void exposeCards() {
        getHand().turnOver();
        notifyListeners();
    }
    
}
