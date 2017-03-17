/**
 * The BankAccountCLV provides a command line view. This view simple prints
 * the balance to the command line.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountCLV implements Observer {

    private BankAccountModel model;
    
    public BankAccountCLV( BankAccountModel model ) {
        this.model = model;
        this.model.register( this );
    }

    public void update() {
        System.out.println( "Current Balance: $" + model.getBalance() );
    }
}