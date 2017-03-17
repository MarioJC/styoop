/**
 * The HumanPlayer determines whether or not to hit based on input from the
 * command line. The details of when to hit and when not to hit is encapsulated
 * within the entity entering data on the command line.
 * @author  Tony Sintes STYOOP
 */
public class HumanPlayer extends BettingPlayer {

    private final static String HIT   = "H";
    private final static String STAND = "S";
    private final static String PLAY_MSG = "[H]it or [S]tay";
    private final static String BET_MSG = "Place Bet: [10] [50] or [100]";
    private final static String DD_MSG  = "Double Down? [Y]es [N]o";
    private final static String BET_10  = "10";
    private final static String BET_50  = "50";
    private final static String BET_100 = "100";
    private final static String NO  = "N";
    private final static String YES = "Y";
    private final static String DEFAULT = "invalid";
    
    public HumanPlayer( String name, Hand hand, Bank bank ) {
        super( name, hand, bank );
    }
    
    protected boolean hit() {
        while( true ) {
            Console.INSTANCE.printMessage( PLAY_MSG );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if( response.equalsIgnoreCase( HIT ) ) {
                return true;
            } else if( response.equalsIgnoreCase( STAND ) ) {
                return false;
            }
            // if we get here loop until we get meaningful input
        }
    }
    
    protected boolean doubleDown() {
        while( true ) {
            Console.INSTANCE.printMessage( DD_MSG );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if( response.equalsIgnoreCase( NO ) ) {
                return false;
            } else if( response.equalsIgnoreCase( YES ) ) {
                return true;
            }
            // if we get here loop until we get meaningful input
        }
    }
    
    protected void bet() {
        while( true ) {
            Console.INSTANCE.printMessage( BET_MSG );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if( response.equals( BET_10 ) ) {
                 getBank().place10Bet();
                 return;
            } 
            if( response.equals( BET_50 ) ) {
                 getBank().place50Bet();
                 return;
                
            } 
            if( response.equals( BET_100 ) ) {
                 getBank().place100Bet();
                 return;
            }
            // if we get here loop until we get meaningful input
        }
    }
    
}