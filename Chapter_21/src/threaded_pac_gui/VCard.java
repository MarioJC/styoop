import javax.swing.*;
import java.awt.*;
/**
 * The VCard holds onto an extra String attribute and returns a displayable.
 * @author  Tony Sintes STYOOP
 */
public class VCard extends Card implements Displayable {

    private String image;
    private CardView view; 
    
    public VCard( Suit suit, Rank rank, String image ) {
        super( suit, rank );
        this.image = image;
        view = new CardView( getImage() );
    }

    public void setFaceUp( boolean up ) {
        super.setFaceUp( up );
        view.changed();
    }
    
    public JComponent view() {
        return view;
    }
    
    private String getImage() {
        if( isFaceUp() ) {
            return image;
        } else {
            return "/bitmaps/empty_pile.xbm";
        }
    }
    
    private class CardView extends JLabel {

        public CardView( String image ) {
            setImage( image );
            setBackground( Color.white );
            setOpaque( true );
        }
    
        public void changed() {
            setImage( getImage() );
        }
        
        private void setImage( String image ) {
            java.net.URL url = this.getClass().getResource( image );
            ImageIcon icon = new ImageIcon( url );
            setIcon( icon );
        }
        
    }

}
