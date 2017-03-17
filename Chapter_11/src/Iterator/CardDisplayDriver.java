/**
 * The CardDisplayDriver includes various looping code.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class CardDisplayDriver {
    
    public String deckToString( Deck deck ) {
        String cards = "";
        for( int i = 0; i < deck.size(); i ++ ) {
            Card card = deck.get( i );
            cards = cards + card.display();
        }
        return cards;
    }

    public String deckToString( Iterator i ) {
        String cards = "";
        for ( i.first(); !i.isDone(); i.next() ) {
            Card card = (Card) i.currentItem();
            cards = cards + card.display();
        }
        return cards;
    }
    
    public String deckToString( Card [] deck ) {
        String cards = "";
        for( int i = 0; i < deck.length; i ++ ) {
            cards = cards + deck[i].display();
        }
        return cards;
    }
    
    public String reverseDeckToString( Deck deck ) {
        String cards = "";
        for( int i = deck.size() - 1; i > -1; i -- ) {
            Card card = deck.get( i );
            cards = cards + card.display();
        }
        return cards;
    }
    
    public static void main( String [] args ) {
        Deck deck = new Deck();
        
        Card [] cards = new Card[3];
        cards[0] = deck.get( 0 );
        cards[1] = deck.get( 1 );
        cards[2] = deck.get( 2 );
        
        CardDisplayDriver display = new CardDisplayDriver();
        System.out.println( display.deckToString( deck ) );
        System.out.println( display.reverseDeckToString( deck ) );
        System.out.println( display.deckToString( cards ) );
        
        Iterator i = deck.iterator();
        System.out.println( display.deckToString( i ) );
        
    }
    
}