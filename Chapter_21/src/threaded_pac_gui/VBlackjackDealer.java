import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/**
 * VBlackjackDealer provides a view for the BlackjackDealer.
 * @author  Tony Sintes STYOOP
 */
public class VBlackjackDealer extends BlackjackDealer implements Displayable {

    private DealerView view;
    
    public VBlackjackDealer( String name, VHand hand, Deckpile cards ) {
        super( name, hand, cards );
    }
    
    public JComponent view() {
        if( view == null ) {
            view = new DealerView( (VHand) getHand() );
            addListener( view );
        }
        return view;
    }
    
    // Note that all this class does is retrieve the Hand's view, add that view
    // to itself, and update the border as needed. Note what this class does not do:
    // update the cards as they change. From the point of view of this view the card
    // update happens automatically because the VHand update's its displayable behind 
    // the scenes
    private class DealerView extends JPanel implements PlayerListener {
        
        private TitledBorder border;
        
        public DealerView( VHand hand ) {
            super( new FlowLayout( FlowLayout.LEFT ) );
            String name = VBlackjackDealer.this.getName();
            border = new TitledBorder( name );
            setBorder( border );
            setBackground( new Color( 35, 142, 35 ) );
            border.setTitleColor( Color.black );
            add( hand.view() );
            repaint();
        }
        
        public void playerChanged( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name );
            repaint();
        }
        
        public void playerBusted( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " BUSTED!" );
            repaint();
        }
    
        public void playerBlackjack( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " BLACKJACK!" );
            repaint();
        }
    
        public void playerStanding( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " STANDING" );
            repaint();
        }
    
        public void playerWon( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " WINNER!" );
            repaint();
        }
    
        public void playerLost( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " LOSER!" );
            repaint();
        }
    
        public void playerStandoff( Player p ) {
            String name = VBlackjackDealer.this.getName();
            border.setTitle( name + " STANDOFF!" );
            repaint();
        }

    }
    
}
