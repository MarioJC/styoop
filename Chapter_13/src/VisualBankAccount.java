import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * A bank account that merges the model, view, and controller into one class.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class VisualBankAccount extends JPanel implements ActionListener {
    
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                System.exit( 0 );
            }
        };
        
        frame.addWindowListener( wa );
        
        frame.getContentPane().add( new VisualBankAccount( 10000.00 ) );
        frame.pack();
        frame.show();
    }
    
    // private data
    private double balance;
    
    // UI elements
    private JLabel     balanceLabel   = new JLabel();
    private JTextField amountField    = new JTextField( 10 );
    private JButton    depositButton  = new JButton( "Deposit" );
    private JButton    withdrawButton = new JButton( "Withdraw" );
    
    public VisualBankAccount( double initDeposit ) {   
	setBalance( initDeposit );
        buildUI();
    }
    
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == depositButton ) {
            double amount = Double.parseDouble( amountField.getText() );
            depositFunds( amount );
        } else if( e.getSource() == withdrawButton ) {
            double amount = Double.parseDouble( amountField.getText() );
            if( amount > getBalance() ) {
                amount = getBalance();
            }
            withdrawFunds( amount );
        }
    }
    
    private void buildUI() {
        
        setLayout( new BorderLayout() );
        
        // build the display
        JPanel buttons = new JPanel( new BorderLayout() );
        JPanel balance = new JPanel( new BorderLayout() );
        buttons.add( depositButton, BorderLayout.WEST );
        buttons.add( withdrawButton, BorderLayout.EAST );
        balance.add( balanceLabel, BorderLayout.NORTH );
        balance.add( amountField, BorderLayout.SOUTH );
        add( balance, BorderLayout.NORTH );
        add( buttons, BorderLayout.SOUTH );
        
        // set up the callbacks so that the buttons do something
        // the deposit button should call depositFunds()
        depositButton.addActionListener( this );
        // the withdraw button should call withdrawFunds
        withdrawButton.addActionListener( this );
    }
    
    public void depositFunds( double amount ) {
	setBalance( getBalance() + amount );
    }
    
    public double getBalance() {
	return balance;
    }
   
    protected void setBalance( double newBalance ) {
	balance = newBalance;
        balanceLabel.setText( "Balance: " + balance);
    }
    
    public double withdrawFunds( double amount ) {
	setBalance( getBalance() - amount );	
	return amount;
    }
    
}