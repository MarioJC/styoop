import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * The BankAccountView view is responsible for constructing the GUI and creating
 * the associated controller.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class BankAccountView extends JPanel implements Observer {

    public final static String DEPOSIT  = "Deposit";
    public final static String WITHDRAW = "Withdraw";
    
    private BankAccountModel model;
    private BankAccountController controller;
   
    // GUI Elements, pre-allocate all to avoid null values
    private JButton depositButton  = new JButton( DEPOSIT );
    private JButton withdrawButton = new JButton( WITHDRAW );
    private JTextField amountField = new JTextField();
    private JLabel balanceLabel    = new JLabel();
    
    public BankAccountView( BankAccountModel model ) {
        this.model = model;
        this.model.register( this );
        attachController( makeController() );
        buildUI();
    }

    // called by model when the model changes
    public void update() {
        balanceLabel.setText( "Balance: " + model.getBalance() );
    }
   
    // provides access to the amount entered into the field
    public double getAmount() {
        // assume that the user entered a valid number
        return Double.parseDouble( amountField.getText() );
    }
    
    // wires the given controller to the view, allows outside object to set controller
    public void attachController( BankAccountController controller ) {
        // each view can only have one controller, so remove the old one first
        if( this.controller != null ) { // remove the old controller
            depositButton.removeActionListener( controller );
            withdrawButton.removeActionListener( controller );
        }
        
        this.controller = controller;
        depositButton.addActionListener( controller );
        withdrawButton.addActionListener( controller );
    }
    
    protected BankAccountController makeController() {
        return new BankAccountController( this, model );
    }
    
    private void buildUI() {
        
        setLayout( new BorderLayout() );
        
        // associate each button with a commend string
        depositButton.setActionCommand( DEPOSIT );
        withdrawButton.setActionCommand( WITHDRAW );
        
        // build the display
        JPanel buttons = new JPanel( new BorderLayout() );
        JPanel balance = new JPanel( new BorderLayout() );
        buttons.add( depositButton, BorderLayout.WEST );
        buttons.add( withdrawButton, BorderLayout.EAST );
        balance.add( balanceLabel, BorderLayout.NORTH );
        balance.add( amountField, BorderLayout.SOUTH );
        add( balance, BorderLayout.NORTH );
        add( buttons, BorderLayout.SOUTH );
    }
}