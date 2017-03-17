import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Iterator;
/**
 * The PlayerView knows how to represent a Player. This is purely a visual view.
 * It does not allow interaction, thus their is no controller.
 * @author  Tony Sintes STYOOP
 */
public class PlayerView extends JPanel implements PlayerListener {

    private JPanel cards = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
    private TitledBorder border;
    
    public PlayerView( Player player ) {
        super( new BorderLayout() );
        buildUI( player );
        player.addListener( this );
    }
    
    public void playerChanged( Player p ) {   
        border.setTitle( p.getName() );
        cards.removeAll();
        Hand h = p.getHand();
        Iterator i = h.getCards();
        while( i.hasNext() ) {
            VCard c = (VCard) i.next();
            JLabel card = new CardView( c );
            cards.add( card );
        }
        revalidate();  
        repaint();
    }
    
    public void playerBusted( Player p ) {
        border.setTitle( p.getName() + " BUSTED!" );
        cards.repaint();
    }
    
    public void playerBlackjack( Player p ) {
        border.setTitle( p.getName() + " BLACKJACK!" );
        cards.repaint();
    }
    
    public void playerStanding( Player p ) {
        border.setTitle( p.getName() + " STANDING" );
        cards.repaint();
    }
    
    public void playerWon( Player p ) {
        border.setTitle( p.getName() + " WINNER!" );
        cards.repaint();
    }
    
    public void playerLost( Player p ) {
        border.setTitle( p.getName() + " LOSER!" );
        cards.repaint();
    }
    
    public void playerStandoff( Player p ) {
        border.setTitle( p.getName() + " STANDOFF!" );
        cards.repaint();
    }
     
    private void buildUI( Player player ) {
        add( cards, BorderLayout.NORTH );
        border = new TitledBorder( player.getName() );
        cards.setBorder( border );
        cards.setBackground( new Color( 35, 142, 35 ) );
        border.setTitleColor( Color.black );
    }
   
}