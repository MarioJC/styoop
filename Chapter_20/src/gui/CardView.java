import javax.swing.*;
import java.awt.*;
/**
 * The CardView visualizes VCards. This is purely a visual view.
 * It does not allow interaction, thus their is no controller.
 * @author  Tony Sintes STYOOP
 */
public class CardView extends JLabel {

    private ImageIcon icon;
    
    public CardView( VCard card ) {
        getImage( card.getImage() );
        setIcon( icon );
        setBackground( Color.white );
        setOpaque( true );
    }
    
    private void getImage( String name ) {
        java.net.URL url = this.getClass().getResource( name );
        icon = new ImageIcon( url );
    }
    
}
