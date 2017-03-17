/**
 * StackDriver instantiates and exercises Stack instances.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class StackDriver {

    public static void main( String [] args ) {
        Stack s = new Stack();
        
        Integer i1 = new Integer( 1 );
        Integer i2 = new Integer( 2 );
        Integer i3 = new Integer( 3 );
        Integer i4 = new Integer( 4 );
        Integer i5 = new Integer( 5 );
        Integer i6 = new Integer( 6 );
        
        System.out.println( "The stack is empty (should be true): " + s.empty() );
        
        s.push( i1 );
        
        System.out.println( "Peek (should be 1): " + s.peek() );
        
        s.push( i2 );
        
        System.out.println( "Peek (should be 2): " + s.peek() );
        
        s.push( i3 );

        System.out.println( "Peek (should be 3): " + s.peek() );
        
        s.push( i4 );

        System.out.println( "Peek (should be 4): " + s.peek() );
        
        s.push( i5 );

        System.out.println( "Peek (should be 5): " + s.peek() );
        
        s.push( i6 );
        
        System.out.println( "Peek (should be 6): " + s.peek() );
        
        System.out.println( "The stack is empty (should be false): " + s.empty() );
        
        System.out.println( "Pop (should be 6): " + s.pop() );
        System.out.println( "Pop (should be 5): " + s.pop() );
        System.out.println( "Pop (should be 4): " + s.pop() );
        System.out.println( "Pop (should be 3): " + s.pop() );
        System.out.println( "Pop (should be 2): " + s.pop() );
        System.out.println( "Pop (should be 1): " + s.pop() );
        System.out.println( "Pop (should be null): " + s.pop() );
        
        System.out.println( "The stack is empty (should be true): " + s.empty() );
        
        s.push( i1 );
        s.push( i2 );
        s.push( i3 );
        s.push( i4 );
        s.pop();
        s.pop();
        s.push( i5 );
        s.push( i6 );
        
        System.out.println( "Search (should be 4): " + s.search( i1 ) );
        System.out.println( "Search (should be 3): " + s.search( i2 ) );
        System.out.println( "Search (should be 2): " + s.search( i5 ) );
        System.out.println( "Search (should be 1): " + s.search( i6 ) );
        System.out.println( "Search (should be -1): " + s.search( new Object() ) );
        
        System.out.println( "Pop (should be 6): " + s.pop() );
        System.out.println( "Pop (should be 5): " + s.pop() );
        System.out.println( "Pop (should be 2): " + s.pop() );
        System.out.println( "Pop (should be 1): " + s.pop() );
        System.out.println( "Pop (should be null): " + s.pop() );
        
    }
    
}
