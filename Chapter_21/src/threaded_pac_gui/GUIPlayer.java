import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * The GUIPlayer represents the human player in the game. The GUIPlayer needs
 * to provide custom Betting and Playing states because the GUIPlayer needs to
 * wait for the user to press a button.
 * @author  Tony Sintes STYOOP
 */
public class GUIPlayer extends VBettingPlayer implements Displayable {

    private BlackjackDealer dealer;
    private JPanel view;
    
    public GUIPlayer( String name, VHand h, Bank bank, VBlackjackDealer d ) {
        super( name, h, bank );
        dealer = d;
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
    
    // doubling down is a bit different since the player needs to 
    // respond to Hand events as a card gets added to the hand
    // so set the state to DoublingDown and then execute it
    protected boolean doubleDown() {
        setCurrentState( getDoublingDownState() );
        getCurrentState().execute( dealer );
        return true;
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
    
    public JComponent view() {
        if( view == null ) {
            view = new JPanel( new BorderLayout() );
            JComponent pv = super.view();
            GUIView cv = new GUIView();
            addListener( cv );
            view.add( pv, BorderLayout.CENTER );
            view.add( cv, BorderLayout.SOUTH );
        }
        return view;
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
        
        public void execute( Dealer d ) {
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
        public void execute( Dealer d ) {
            // do nothing here, actions will come from the GUI which is 
            // external to the state, since no events come in as part of
            // betting the state will need to be changed externally to this state
        }
    }
    
    private class GUIView extends JPanel implements PlayerListener, ActionListener {
        
        private JButton bet_10  = new JButton( "$10" );
        private JButton bet_50  = new JButton( "$50" );
        private JButton bet_100 = new JButton( "$100" );
        private JButton deal  = new JButton( "New Game" );
        private JButton quit  = new JButton( "Quit" );
        private JButton hit   = new JButton( "Hit" );
        private JButton stand = new JButton( "Stand" );
        private JButton ddown = new JButton( "Double Down" );
        
        private final String NEW_GAME = "new";
        private final String QUIT     = "quit";
        private final String HIT      = "hit";
        private final String STAND    = "stand";
        private final String BET_10   = "BET10";
        private final String BET_50   = "BET50";
        private final String BET_100  = "BET100";
        private final String D_DOWN   = "DDown";
    
        private final Color FOREST_GREEN = new Color( 35, 142, 35 );
    
        public GUIView() {
            super( new BorderLayout() );
            GUIPlayer.this.addListener( this );
            buildGUI();
        }
        private void buildGUI() {
            JPanel betting_controls = new JPanel();
            JPanel game_controls    = new JPanel();
            
            add( betting_controls, BorderLayout.NORTH );
            add( game_controls, BorderLayout.SOUTH );
            
            betting_controls.setBackground( FOREST_GREEN );
            game_controls.setBackground( FOREST_GREEN );
            deal.setActionCommand( NEW_GAME );
            deal.addActionListener( this );
            quit.setActionCommand( QUIT );
            quit.addActionListener( this );
            hit.setActionCommand( HIT );
            hit.addActionListener( this );
            stand.setActionCommand( STAND );
            stand.addActionListener( this );
            bet_10.setActionCommand( BET_10 );
            bet_10.addActionListener( this );
            bet_50.setActionCommand( BET_50 );
            bet_50.addActionListener( this );
            bet_100.setActionCommand( BET_100 );
            bet_100.addActionListener( this );
            ddown.setActionCommand( D_DOWN );
            ddown.addActionListener( this );
            betting_controls.add( bet_10 );
            betting_controls.add( bet_50 );
            betting_controls.add( bet_100 );
            game_controls.add( ddown );
            game_controls.add( hit );
            game_controls.add( stand );
            game_controls.add( deal );
            game_controls.add( quit );
            enableBettingControls( false );
            enablePlayerControls( false );
            enableDoubleDown( false );
        }
        
        private void enableBettingControls( boolean enable ) {
            bet_10.setEnabled( enable );
            bet_50.setEnabled( enable );
            bet_100.setEnabled( enable );
        }
    
        private void enablePlayerControls( boolean enable ) {
            hit.setEnabled( enable );
            stand.setEnabled( enable );
        }   
    
        private void enableGameControls( boolean enable ) {
            deal.setEnabled( enable );
            quit.setEnabled( enable );
        }
    
        private void enableDoubleDown( boolean enable ) {
            ddown.setEnabled( enable );
        }
    
        public void actionPerformed( ActionEvent e ) {
            if( e.getActionCommand().equals( QUIT ) ) {
                System.exit( 0 );
            } else if( e.getActionCommand().equals( HIT ) ) {
                enableDoubleDown( false );
                takeCard();
            } else if( e.getActionCommand().equals( STAND ) ) {
                enableDoubleDown( false );
                stand();
            } else if ( e.getActionCommand().equals( NEW_GAME ) ) {
                enableDoubleDown( false );
                enableGameControls( false );
                enablePlayerControls( false );
                enableBettingControls( true );
                dealer.newGame();
            } else if( e.getActionCommand().equals( BET_10 ) ) {
                enableDoubleDown( true );
                enableBettingControls( false );
                enablePlayerControls( true );
                place10Bet();
            } else if( e.getActionCommand().equals( BET_50 ) ) {
                enableDoubleDown( true );
                enableBettingControls( false );
                enablePlayerControls( true );
                place50Bet();
            } else if( e.getActionCommand().equals( BET_100 ) ) {
                enableDoubleDown( true );
                enableBettingControls( false );
                enablePlayerControls( true );
                place100Bet();
            } else if( e.getActionCommand().equals( D_DOWN ) ) {
                enablePlayerControls( false );
                enableDoubleDown( false );
                doubleDown();
            }
        }
    
        public void playerChanged( Player p ) {
        }
    
        public void playerBusted( Player p ) {
            enablePlayerControls( false );
            enableGameControls( true );
        }
    
        public void playerBlackjack( Player p ) {
            enableDoubleDown( false );
            enablePlayerControls( false );
            enableGameControls( true );
        }
    
        public void playerStanding( Player p ) {
            enablePlayerControls( false );
            enableGameControls( true );
        }
 
        public void playerWon( Player p ) {
            enablePlayerControls( false );
            enableGameControls( true );
        }
    
        public void playerLost( Player p ) {
            enableDoubleDown( false );
            enablePlayerControls( false );
            enableGameControls( true );
        }
    
        public void playerStandoff( Player p ) {
            enablePlayerControls( false );
            enableGameControls( true );
        }
    
    }
}
