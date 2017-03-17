/**
 * The ShoppingCart holds onto items.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ShoppingCart {
    
    java.util.LinkedList items = new java.util.LinkedList();

    /**
     * adds an item to the cart
     * @param item the item to add
     */
    public void addItem( Item item ) {
        items.add( item );
    }
    
    /**
     * removes the given item from the cart
     * @param item the item to remove
     */
    public void removeItem( Item item ) {
        items.remove( item );
    }
    
    /**
     * @return int the number of items in the cart
     */
    public int getNumberItems() {
        return items.size();
    }
    
    /**
     * retrieves the indexed item
     * @param index the item's index
     * @retun Item the item at index
     */
    public Item getItem( int index ) {
        return (Item) items.get( index );
    }
}
