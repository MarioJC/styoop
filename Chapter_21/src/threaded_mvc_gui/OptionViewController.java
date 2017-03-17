import java.awt.event.*;
/**
 * The OptionViewController controls the OptionView.
 * @author  Tony Sintes STYOOP
 */
public class OptionViewController implements ActionListener, PlayerListener {

    private GUIPlayer model;
    private OptionView view;
    private BlackjackDealer dealer;
    
    public OptionViewController( GUIPlayer model, BlackjackDealer dealer, OptionView view ) {
        this.model = model;
        model.addListener( this );
        this.dealer = dealer;
        this.view = view;
        view.enablePlayerControls( false );
    }
    
    public void actionPerformed( ActionEvent e ) {
        if( e.getActionCommand().equals( OptionView.QUIT ) ) {
            System.exit( 0 );
        } else if( e.getActionCommand().equals( OptionView.HIT ) ) {
            view.enableDoubleDown( false );
            model.takeCard();
        } else if( e.getActionCommand().equals( OptionView.STAND ) ) {
            view.enableDoubleDown( false );
            model.stand();
        } else if ( e.getActionCommand().equals( OptionView.NEW_GAME ) ) {
            view.enableDoubleDown( false );
            view.enableGameControls( false );
            view.enablePlayerControls( false );
            view.enableBettingControls( true );
            dealer.newGame();
        } else if( e.getActionCommand().equals( OptionView.BET_10 ) ) {
            view.enableBettingControls( false );
            view.enablePlayerControls( true );
            view.enableDoubleDown( true );
            model.place10Bet();
        } else if( e.getActionCommand().equals( OptionView.BET_50 ) ) {
            view.enableBettingControls( false );
            view.enablePlayerControls( true );
            view.enableDoubleDown( true );
            model.place50Bet();
        } else if( e.getActionCommand().equals( OptionView.BET_100 ) ) {
            view.enableBettingControls( false );
            view.enablePlayerControls( true );
            view.enableDoubleDown( true );
            model.place100Bet();
        } else if( e.getActionCommand().equals( OptionView.DOUBLE_DOWN ) ) {
            view.enableBettingControls( false );
            view.enablePlayerControls( false );
            view.enableDoubleDown( false );
            view.enableGameControls( true );
            model.doubleDown();
        }
    }
    
    public void playerChanged( Player p ) {
    }
    
    public void playerBusted( Player p ) {
        view.enablePlayerControls( false );
        view.enableDoubleDown( false );
        view.enableGameControls( true );
    }
    
    public void playerBlackjack( Player p ) {
        view.enablePlayerControls( false );
        view.enableDoubleDown( false );
        view.enableGameControls( true );
    }
    
    public void playerStanding( Player p ) {
        view.enablePlayerControls( false );
        view.enableGameControls( true );
    }
 
    public void playerWon( Player p ) {
        view.enablePlayerControls( false );
        view.enableGameControls( true );
    }
    
    public void playerLost( Player p ) {
        view.enablePlayerControls( false );
        view.enableDoubleDown( false );
        view.enableGameControls( true );
    }
    
    public void playerStandoff( Player p ) {
        view.enablePlayerControls( false );
        view.enableGameControls( true );
    }
    
}