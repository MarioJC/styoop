/**
 * This Stack implementation internally "Has-A" ArrayList.
 * @author  Tony Sintes
 * @version 1.0
 */
public class Stack {

    private java.util.ArrayList list;
    
    public Stack() {
        list = new java.util.ArrayList();
    }
    
    public boolean empty() {
        return list.isEmpty();
    }
    
    public Object peek() {
        if( !empty() ) {
            return list.get( 0 );
        }
        return null;
    }
    
    public Object pop() {
        if( !empty() ) { 
            return list.remove( 0 );
        }
        return null;
    }
    
    public Object push( Object item ) {
        list.add( 0, item );
        return item;
    }
    
    public int search( Object o ) {
	  int index = list.indexOf( o );
	  if( index != -1 ) {
	      return index + 1;
	  }        
        return -1;
    }
    
}
