/**
 * The SimpleItemIterator iterates over all of the items.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ReverseIterator implements Iterator {

    private Object [] items;
    private int index;
    
    public ReverseIterator( java.util.LinkedList items ) {
        this.items = items.toArray();
        first();
    }

    public boolean isDone() {
        if( items.length == 0 || index <= -1 ) {
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
        index--;
    }
    
    public void first() {
        index = items.length - 1;
    }
    
}
