/**
 * The ForwardIterator iterates over all of the items.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class CartIterator implements Iterator {

    private Object [] items;
    private int index;
    
    public CartIterator( java.util.LinkedList items ) {
        this.items = items.toArray();
    }

    public boolean isDone() {
        if( index >= items.length ) {
            return true;
        }
        return false;
    }
    
    public Object currentItem() {
        if( !isDone() ) {
            return items[index];
        }
        return null;
    }
    
    public void next() {
        index++;
    }
    
    public void first() {
        index = 0;
    }
    
}
