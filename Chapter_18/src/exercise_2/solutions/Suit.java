import java.util.Collections;
import java.util.List;
import java.util.Arrays;
/**
 * The Suit class defines the valid card suits.
 * @author  Tony Sintes STYOOP
 */
public final class Suit {

    // statically define all valid values of Suit
    public static final Suit DIAMONDS = new Suit( (char)4 );
    public static final Suit HEARTS   = new Suit( (char)3 );
    public static final Suit SPADES   = new Suit( (char)6 );
    public static final Suit CLUBS    = new Suit( (char)5 );
    
    private static final Suit [] VALUES = { DIAMONDS, HEARTS, SPADES, CLUBS };
    
    // provide an unmodifiable list to loop over
    public static final List SUITS =
        Collections.unmodifiableList( Arrays.asList( VALUES ) );

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
