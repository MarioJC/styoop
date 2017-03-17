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
    
    private ArrayList waiting_players;
    private ArrayList standing_players;
    private ArrayList busted_players;
    private ArrayList blackjack_players;
    private ArrayList betting_players;
    
    public BlackjackDealer( String name, Hand hand, Deckpile cards ) {
        super( name, hand );
        this.cards = cards;
    }
    
    //**************************************************************************
    // Methods that players can call
    public void blackjack( Player player ) {
        blackjack_players.add( player );
        play( this );
    }
    
    public void busted( Player player ) {
        busted_players.add( player );
        play( this );
    }
    
    public void standing( Player player ) {
        standing_players.add( player );
        play( this );
    }

    public void doneBetting( Player player ) {
        waiting_players.add( player );
        play( this );
    }
    
    public void hit( Player player ) {
        player.addCard( cards.dealUp() );
    }
    
    //**************************************************************************
    // Game setup methods
    public void addPlayer( Player player ) {
        players.add( player );
    }
    public void reset() {
        super.reset();
        
        // set up the player buckets
        waiting_players = new ArrayList();
        standing_players = new ArrayList();
        busted_players = new ArrayList();
        blackjack_players = new ArrayList();
        betting_players = new ArrayList();
        betting_players.addAll( players );
        
        cards.reset();
        Iterator i = players.iterator();
        while( i.hasNext() ) {
            Player player = (Player) i.next();
            player.reset();
        }
    }
    public void newGame() {
        reset();
        // go!
        play( this );
    }
    
    //**************************************************************************
    
    public void deal() {
        
        cards.shuffle();
        
        // reset each player and deal 1 card up to each and self
        Player [] player = new Player[waiting_players.size()];
        waiting_players.toArray(player);
        for( int i = 0; i < player.length; i ++ ) {
            player[i].addCard( cards.dealUp() );
        }
        this.addCard( cards.dealUp() );
        
        // deal 1 more up card to each player and one down to self
        for( int i = 0; i < player.length; i ++ ) {
            player[i].addCard( cards.dealUp() );
        }
        this.addCard( cards.dealDown() );
    }
    
    protected boolean hit() {
        if( standing_players.size() > 0 && getHand().total() < 17 ) {
            return true;
        }
        return false;
    }
    
    private void exposeHand() {
        getHand().turnOver();
        notifyChanged();
    }
    
    protected PlayerState getBlackjackState() {
        return new DealerBlackjack();
    }
    protected PlayerState getDealingState() {
        return new DealerDealing();
    }
    protected PlayerState getCollectingBetsState() {
        return new DealerCollectingBets();
    }
    protected PlayerState getBustedState() {
        return new DealerBusted();
    }
    protected PlayerState getStandingState() {
        return new DealerStanding();
    }
    protected PlayerState getWaitingState() {
        return new DealerWaiting();
    }
    protected PlayerState getInitialState() {
        return new DealerCollectingBets();
    }

    private class DealerCollectingBets implements PlayerState {
        public void handChanged() {
            // not possible in betting state
        }
        public void handPlayable() {
            // not possible in betting state
        }
        public void handBlackjack() {
            // not possible in betting state
        }
        public void handBusted() {
            // not possible in betting state
        }
        public void execute( Dealer dealer ) {
            if( !betting_players.isEmpty() ) {
                Player player = (Player) betting_players.get( 0 );
                betting_players.remove( player );
                player.play( dealer );
            } else {
                setCurrentState( getDealingState() );
                getCurrentState().execute( dealer );
                // transition and execute
            }
        }
    }
    
    private class DealerBusted implements PlayerState {
        public void handChanged() {
            // not possible in busted state
        }
        public void handPlayable() {
            // not possible in busted state
        }
        public void handBlackjack() {
            // not possible in busted state
        }
        public void handBusted() {
            // not possible in busted state
        }
        public void execute( Dealer dealer ) {
            Iterator i = standing_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.win();
            }
            i = blackjack_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.blackjack();
            }
            i = busted_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.lose();
            }
        }
    }
    private class DealerBlackjack implements PlayerState {
        public void handChanged() {
            notifyChanged();
        }
        public void handPlayable() {
            // not possible in blackjack state
        }
        public void handBlackjack() {
            // not possible in blackjack state
        }
        public void handBusted() {
            // not possible in blackjack state
        }
        public void execute( Dealer dealer ) {
            exposeHand();
            Iterator i = players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                if( player.getHand().blackjack() ) {
                    player.standoff();
                } else {
                    player.lose();
                }
            }
        }
    }
    private class DealerStanding implements PlayerState {
        public void handChanged() {
            // not possible in standing state
        }
        public void handPlayable() {
            // not possible in standing state
        }
        public void handBlackjack() {
            // not possible in standing state
        }
        public void handBusted() {
            // not possible in standing state
        }
        public void execute( Dealer dealer ) {        
            Iterator i = standing_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                if( player.getHand().isEqual( getHand() ) ) {
                    player.standoff();
                } else if( player.getHand().isGreaterThan( getHand() ) ) {
                    player.win();
                } else {
                    player.lose();
                }
            }
            i = blackjack_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.blackjack();
            }
            i = busted_players.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.lose();
            }
        }
    }
    private class DealerWaiting implements PlayerState {
        public void handChanged() {
            // not possible in waiting state
        }
        public void handPlayable() {
            // not possible in waiting state
        }
        public void handBlackjack() {
            // not possible in waiting state
        }
        public void handBusted() {
            // not possible in waiting state
        }
        public void execute( Dealer dealer ) {
            if( !waiting_players.isEmpty() ) {
                Player player = (Player) waiting_players.get( 0 );
                waiting_players.remove( player );
                player.play( dealer );
            } else {
                setCurrentState( getPlayingState() );
                exposeHand();
                getCurrentState().execute( dealer );
                // transition and execute
            }
        }
    }
    private class DealerDealing implements PlayerState {
        public void handChanged() {
            notifyChanged();
        }
        public void handPlayable() {
            setCurrentState( getWaitingState() );
            // transition
        }
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyBlackjack();
            // transition
        }
        public void handBusted() {
            // not possible in dealing state
        }
        public void execute( Dealer dealer ) {
            deal();
            getCurrentState().execute( dealer );
            // transition and execute
        }
    }
}
