/**
 * An ItemDisplayFormatter formats an item for display.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public interface ItemDisplayFormatter {
    public void quantity( int quantity );
    public void id( int id );
    public void unitPrice( float unitPrice );
    public void discount( float discount );
    public void description( String description );
    public void adjustedPrice( float total );
    public String format();
}