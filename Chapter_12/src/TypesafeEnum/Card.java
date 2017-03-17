/**
 * This is teh Class repsresentation of the card. There is no sense in having a 
 * different class for each suit of card. Cards only differ in their value of
 * the value and suit.
 * @author  Tony Sintes
 * @version 1.0
 */
public class Card {

    private Rank rank;
    private Suit suit;
    private boolean face_up;
    
    // creates a new card - only use the constants to initialize 
    public Card( Suit suit, Rank rank ) {
        // In a real program you would need to do validation on the arguments.
        
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
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
        return rank.toString() + suit.toString();
    }
}
