/**
 * The HumanPlayer determines whether or not to hit based on input from the
 * command line. The details of when to hit and when not to hit is encapsulated
 * within the entity entering data on the command line.
 * @author  Tony Sintes STYOOP
 */
public class HumanPlayer extends Player {

    private final static String HIT   = "H";
    private final static String STAND = "S";
    private final static String MSG   = "[H]it or [S]tay";
    private final static String DEFAULT = "invalid";
    
    public HumanPlayer( String name, Hand hand ) {
        super( name, hand );
    }
    
    protected boolean hit() {
        while( true ) {
            Console.INSTANCE.printMessage( MSG );
            String response = Console.INSTANCE.readInput( DEFAULT );
            if( response.equalsIgnoreCase( HIT ) ) {
                return true;
            } else if( response.equalsIgnoreCase( STAND ) ) {
                return false;
            }
            // if we get here loop until we get meaningful input
        }
    }
    
}