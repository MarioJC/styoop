/**
 * BankAccountController control the BankAccountView. This class impements
 * BankActivityListener so that it can receive BankActivityEvents.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountController implements BankActivityListener {

    private BankAccountView  view;
    private BankAccountModel model;
    
    public BankAccountController( BankAccountView view, BankAccountModel model ) {
        this.view  = view;
        this.model = model;
    }

    public void withdrawPerformed( BankActivityEvent e ) {
        double amount = e.getAmount();
        model.withdrawFunds( amount );
    }
    
    public void depositPerformed( BankActivityEvent e ) {
        double amount = e.getAmount();
        model.depositFunds( amount );
    }
    
}
