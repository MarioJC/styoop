import java.awt.*;
import javax.swing.*;
import java.util.Iterator;
/**
 * The VHand provides a display for the hand.
 * @author  Tony Sintes
 */
public class VHand extends Hand implements Displayable {

    private HandView view = new HandView();
    
    public JComponent view() {
        return view;
    }
    
    // you need to override addCard and reset so that when the hand changes, the 
    // change propigates to the view
    public void addCard( Card c ) {
        super.addCard( c );
        view.changed();
    }
    
    public void reset() {
        super.reset();
        view.changed();
    }
    
    private class HandView extends JPanel {
        public HandView() {
            super( new FlowLayout( FlowLayout.LEFT ) );
            setBackground( new Color( 35, 142, 35 ) );
        }
        public void changed() {
            removeAll();
            Iterator i = getCards();
            while( i.hasNext() ) {
                VCard c = (VCard) i.next();
                add( c.view() );
            }
            revalidate(); 
        }
    }
    
}
