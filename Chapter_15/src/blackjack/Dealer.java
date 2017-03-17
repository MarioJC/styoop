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
 
    public void hit( Player player );
    
    public void passTurn();
}

