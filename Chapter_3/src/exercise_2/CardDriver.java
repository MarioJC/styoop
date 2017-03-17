/**
 * This class has a main that creates a deck, prints it out, shuffles it, and
 * then prints it out again
 * @author  Tony Sintes
 * @version 1.0 
 */
public class CardDriver {

    public static void main( String [] args ) {
        Deck deck = new Deck();
        Dealer dealer = new Dealer( deck );
        
        printDeck( deck );
        
        // print out the deck shuffled
        dealer.shuffle();
        
        System.out.println("");

        printDeck( deck );
    }
    
    public static void printDeck( Deck deck ) {
        for( int i = 0; i < 4; i++ ) {
            for( int j = 0; j < 13; j ++ ) {
                Card card = deck.removeFromFront();
                deck.returnToBack( card );
                System.out.print( card.display() + " " );
            }
            System.out.println( " " );
        }
    }
    
}
