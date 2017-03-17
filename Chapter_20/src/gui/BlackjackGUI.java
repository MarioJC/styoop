import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the BlackjackGUI window. The user can play a game of blackjack
 * through this window. The BlackjackGUI creates the players and starts the game.
 * @author  Tony Sintes
 */
public class BlackjackGUI extends JFrame {

    public static void main( String [] args ) {
        JFrame frame = new BlackjackGUI();
        frame.getContentPane().setBackground( FOREST_GREEN );        
        frame.setSize( 580, 500 );
        frame.show();
    }
    
    private BlackjackDealer dealer;
    private GUIPlayer       human;
    private JPanel players = new JPanel( new GridLayout( 0, 1 ) );
    
    private static final Color FOREST_GREEN = new Color( 35, 142, 35 );
    
    public BlackjackGUI() {  
        setUp();
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                System.exit( 0 );
            }
        };
        addWindowListener( wa );
    }
    
    // needs to be protected if subclassed
    private PlayerView getPlayerView( Player player ) {
        PlayerView view = new PlayerView( player );
        view.setBackground( FOREST_GREEN );
        return view;
    }
    
    // needs to be protected if subclassed
    private void setUp() {
        BlackjackDealer dealer = getDealer();
        PlayerView v1 = getPlayerView( dealer );
        
        GUIPlayer human = getHuman();
        PlayerView v2 = getPlayerView( human );
        
        Player safe = getSafePlayer();
        PlayerView v3 = getPlayerView( safe );
        
        PlayerView [] views = { v1, v2, v3 };
        addPlayers( views );
        
        dealer.addPlayer( human );
        dealer.addPlayer( safe );
        
        addOptionView( human, dealer );
    }
    
    // needs to be protected if subclassed
    private void addPlayers( PlayerView [] pview ) {        
        players.setBackground( FOREST_GREEN );
        for( int i = 0; i < pview.length; i ++ ) {
            players.add( pview[i] );
        }  
        getContentPane().add( players, BorderLayout.CENTER );        
    }
    
    private void addOptionView( GUIPlayer human, BlackjackDealer dealer ) {
        OptionView ov = new OptionView( human, dealer );
        ov.setBackground( FOREST_GREEN );
        getContentPane().add( ov, BorderLayout.SOUTH );
    }
    
    private BlackjackDealer getDealer() {
        if( dealer == null ) {
            Hand dealer_hand = new Hand();
            Deckpile cards = getCards();
            dealer = new BlackjackDealer( "Dealer", dealer_hand, cards );
        }
        return dealer;
    }
    
    private Player getSafePlayer() {
        // return as many as called for
        Hand safe_hand = new Hand();
        Bank safe_bank = new Bank( 1000 );
        return new SafePlayer( "Safe", safe_hand, safe_bank );
    }
    
    private GUIPlayer getHuman() {
        if( human == null ) {
            Hand human_hand = new Hand();
            Bank bank = new Bank( 1000 );
            human = new GUIPlayer( "Human", human_hand, bank );
        }
        return human;
    }

    private Deckpile getCards() {
        Deckpile cards = new Deckpile();
        for( int i = 0; i < 4; i ++ ) {
            cards.shuffle();
            Deck deck = new VDeck();
            deck.addToStack( cards );
            cards.shuffle();
        }
        return cards;
    }
    
}
