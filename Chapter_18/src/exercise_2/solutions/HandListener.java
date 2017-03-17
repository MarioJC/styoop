/**
 * An object can implement this interface if it is interested in receiving
 * update events from a Hand.
 * @author  Tony Sintes STYOOP
 */
public interface HandListener {

    public void handPlayable();
    
    public void handBlackjack();
    
    public void handBusted();
    
    public void handChanged();
    
}

