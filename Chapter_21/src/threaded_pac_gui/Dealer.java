/**
 * This defines the interfacce that a Class must implement if its instances
 * are to be used as Dealers. It makes sense to make this an interface since
 * a Player may also act as a Dealer. (and Java lacks multiple inheritance) <p>
 * The Dealer interface is an example of a Mixin. Mixin's add additional
 * capabilities to an object. Dealer would add more capabilities to a Player that
 * implements it.
 * @author  Tony Sintes STYOOP
 */
public interface Dealer {
    // used by the player to interact with the dealer
    public void hit( Player player );
    
    // used by the player to communicate state to dealer
    public void blackjack( Player p );
    public void busted( Player p );
    public void standing( Player p );
    public void doneBetting( Player p );
}

