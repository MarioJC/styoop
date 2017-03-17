/**
 * This is teh Class repsresentation of the card. There is no sense in having a 
 * different class for each suit of card. Cards only differ in their value of
 * the value and suit.
 * @author  Tony Sintes
 * @version 1.0
 */
public class Card {

    private int rank;
    private int suit;
    private boolean face_up;
    
    // constants used to instantiate
    // suits
    public static final int DIAMONDS = 4;
    public static final int HEARTS   = 3;
    public static final int SPADES   = 6;
    public static final int CLUBS    = 5;
    // values
    public static final int TWO   = 2;
    public static final int THREE = 3;
    public static final int FOUR  = 4;
    public static final int FIVE  = 5;
    public static final int SIX   = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE  = 9;
    public static final int TEN   = 10;
    public static final int JACK  = 74;
    public static final int QUEEN = 81;
    public static final int KING  = 75;
    public static final int ACE   = 65;

    // creates a new card - only use the constants to initialize 
    public Card( int suit, int rank ) {
        // In a real program you would need to do validation on the arguments.
        
        this.suit = suit;
        this.rank  = rank;
    }

    public int getSuit() {
        return suit;
    }
    
    public int getRank() {
        return rank;
    }
    
    public void faceUp() {
        face_up = true;
    }
    
    public void faceDown() {
        face_up = false;
    }
    
    public boolean isFaceUp() {
        return face_up;
    }
    
    public String display() {
        String display;
        
        if( rank > 10 ) {
            display = String.valueOf( (char) rank );
        } else {
            display = String.valueOf( rank );
        }
        
        switch ( suit ) {
            case DIAMONDS:
                return display + String.valueOf( (char) DIAMONDS );
            case HEARTS:
                return display + String.valueOf( (char) HEARTS );
            case SPADES:
                return display + String.valueOf( (char) SPADES );
            default:
                return display + String.valueOf( (char) CLUBS );
        }
    }
}
