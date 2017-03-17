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
        frame.setSize( 580, 480 );
        frame.show();
    }
    
    private VPlayerFactory factory = new VPlayerFactory();
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
    private void setUp() {
        VBlackjackDealer dealer = factory.getDealer();
        
        GUIPlayer human = factory.getHuman();
        
        dealer.addPlayer( human );
        
        players.add( dealer.view() );
        players.add( human.view() );
        getContentPane().add( players, BorderLayout.CENTER );
    }
    
}
