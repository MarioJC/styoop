import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * The BankAccountView view is responsible for constructing the GUI and creating
 * the associated controller. This version generates its own custom events.
 * @author  Tony Sintes STYOOP
 * @version 2.0
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
    
    // wires the given controller to the view, allows outside object to set controller
    public void attachController( BankAccountController controller ) {
        this.controller = controller;
    }
    
    protected BankAccountController makeController() {
        return new BankAccountController( this, model );
    }
   
    // provides access to the amount entered into the field
    private double getAmount() {
        // assume that the user entered a valid number
        return Double.parseDouble( amountField.getText() );
    }
    
    private void fireDepositEvent() {
        BankActivityEvent e = new BankActivityEvent( getAmount() );
        controller.depositPerformed( e );
    }
    
    private void fireWithdrawEvent() {
        BankActivityEvent e = new BankActivityEvent( getAmount() );
        controller.withdrawPerformed( e ); 
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
        
        depositButton.addActionListener( 
            new ActionListener() {
                public void actionPerformed( ActionEvent e ) {
                    fireDepositEvent();
                }
            } 
        );
        
        withdrawButton.addActionListener( 
            new ActionListener() {
                public void actionPerformed( ActionEvent e ) {
                    fireWithdrawEvent();
                }
            } 
        );
    }
}
