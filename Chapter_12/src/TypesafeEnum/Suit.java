/**
 * The Suit class defines the valid card suits.
 * @author  Tony Sintes
 * @version 1.0
 */
public final class Suit {

    // statically define all valid values of Suit
    public static final Suit DIAMONDS = new Suit( (char)4 );
    public static final Suit HEARTS   = new Suit( (char)3 );
    public static final Suit SPADES   = new Suit( (char)6 );
    public static final Suit CLUBS    = new Suit( (char)5 );
    
    // helps to iterate over enum values
    public static final Suit [] SUIT = { DIAMONDS, HEARTS, SPADES, CLUBS };
    
    // instance variable for holding onto display value
    private final char display;
    
    // do not allow instantiation by outside objects
    private Suit( char display ) {
        this.display = display;
    }

    // return the Suit's value
    public String toString() {
        return String.valueOf( display );
    }
}
