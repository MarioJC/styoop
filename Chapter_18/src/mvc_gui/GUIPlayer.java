/**
 * The GUIPlayer represents the human player in the game. The GUIPlayer needs
 * to provide custom Betting and Playing states because the GUIPlayer needs to
 * wait for the user to press a button.
 * @author  Tony Sintes STYOOP
 */
public class GUIPlayer extends BettingPlayer {

    private Dealer dealer;
    
    public GUIPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }
    
    public boolean hit() {
        return true;
    }

    public void bet() {
        // do nothing, this won't get called
        // instead, the human player presses a GUI button
    }
    
    // these bet methods will get called by the GUI controller
    // for each: place the proper bet, change the state, let the 
    // dealer know that the player is done betting
    public void place10Bet() {
        getBank().place10Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }
    
    public void place50Bet() {
        getBank().place50Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }
    
    public void place100Bet() {
        getBank().place100Bet();
        setCurrentState( getWaitingState() );
        dealer.doneBetting( this );
    }
    
    // takeCard will get called by the GUI controller when the player 
    // decides to hit
    public void takeCard() {
        dealer.hit( this );
    }
    
    // stand will get called by the GUI controller when the player chooses
    // to stand, when standing change state, let the world know, and then
    // tell the dealer
    public void stand() {
        setCurrentState( getStandingState() );
        notifyStanding();
        getCurrentState().execute( dealer ); 
    }
    
    // you need to override play so that it stores the dealer away for
    // later use
    public void play( Dealer dealer ) {
        this.dealer = dealer;
        super.play( dealer );
    }
    
    // the following deal w/ states
    protected PlayerState getPlayingState() {
        return new Playing();
    }

    protected PlayerState getBettingState() {
        return new Betting();
    }
  
    private class Playing implements PlayerState {
    
        public void handPlayable() {
            // do nothing
        }
    
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyBlackjack();
            getCurrentState().execute( dealer );
        }
    
        public void handBusted() {
            setCurrentState( getBustedState() );
            notifyBusted();
            getCurrentState().execute( dealer );
        }
    
        public void handChanged() {
            notifyChanged();
        }
        
        public void execute( Dealer dealer ) {
            // do nothing here, actions will come from the GUI which is 
            // external to the state, but when events do come in be sure to 
            // force state transition right away
        }
    }
    private class Betting implements PlayerState {   
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
            // do nothing here, actions will come from the GUI which is 
            // external to the state, since no events come in as part of
            // betting the state will need to be changed externally to this state
        }
    }
}
