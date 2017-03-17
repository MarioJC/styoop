import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * VBettingPlayer provides a view for BettingPlayers. Visual BettingPlayers
 * should inherit from this class.
 * @author  Tony Sintes STYOOP
 */
public abstract class VBettingPlayer extends BettingPlayer implements Displayable {

    private BettingView view;
    
    public VBettingPlayer( String name, VHand hand, Bank bank ) {
        super( name, hand, bank );
    }

    public JComponent view() {
        if( view == null ) {
            view = new BettingView( (VHand) getHand() );
            addListener( view );
        }
        return view;
    }

    // Note that all this class does is retrieve the Hand's view, add that view
    // to itself, and update the border as needed. Note what this class does not do:
    // update the cards as they change. From the point of view of this view the card
    // update happens automatically because the VHand update's its displayable behind 
    // the scenes
    private class BettingView extends JPanel implements PlayerListener {
        
        private TitledBorder border;
        
        public BettingView( VHand hand ) {
            super( new FlowLayout( FlowLayout.LEFT ) );
            buildGUI( hand.view() );
        }
        
        public void playerChanged( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name );
            repaint();
        }
        
        public void playerBusted( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " BUSTED!" );
            repaint();
        }
    
        public void playerBlackjack( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " BLACKJACK!" );
            repaint();
        }
    
        public void playerStanding( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " STANDING" );
            repaint();
        }
    
        public void playerWon( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " WINNER!" );
            repaint();
        }
    
        public void playerLost( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " LOSER!" );
            repaint();
        }
    
        public void playerStandoff( Player player ) {
            String name = VBettingPlayer.this.getName();
            border.setTitle( name + " STANDOFF!" );
            repaint();
        }

        private void buildGUI( JComponent hand ) {
            border = new TitledBorder( VBettingPlayer.this.getName() );
            setBorder( border );
            setBackground( new Color( 35, 142, 35 ) );
            border.setTitleColor( Color.black );
            add( hand );
        }
        
    }
    
}
