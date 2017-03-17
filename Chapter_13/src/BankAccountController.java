import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountController implements ActionListener {

    private BankAccountView  view;
    private BankAccountModel model;
    
    public BankAccountController( BankAccountView view, BankAccountModel model ) {
        this.view  = view;
        this.model = model;
    }

    public void actionPerformed( ActionEvent e ) {
        
        String command = e.getActionCommand();
        double amount = view.getAmount();
        
        if( command.equals( view.WITHDRAW ) ) {
            model.withdrawFunds( amount );
        } else if( command.equals( view.DEPOSIT ) ) {
            model.depositFunds( amount );
        }
        
    }
    
}