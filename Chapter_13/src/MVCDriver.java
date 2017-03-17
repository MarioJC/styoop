import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
/**
 * The MVCDriver hooks the model and view together and then sticks the view
 * into a frame for display.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class MVCDriver {

    public static void main( String [] args ) {
        
        BankAccountModel model = new BankAccountModel( 10000.00 );
        BankAccountView view   = new BankAccountView( model );
        BankAccountCLV clv = new BankAccountCLV( model );
        
        JFrame frame = new JFrame();
        
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                System.exit( 0 );
            }
        };
        
        frame.addWindowListener( wa );
        
        frame.getContentPane().add( view );
        frame.pack();
        frame.show();
    }
    
}