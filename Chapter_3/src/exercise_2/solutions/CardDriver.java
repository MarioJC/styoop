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

        System.out.println( deck.display() );
    }
        
}
