/**
 * This is a java Queue interface. An interface defines exactly what you may 
 * do to an implementation.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public interface Queue {
    public void enqueue( Object obj );
    public Object dequeue();
    public boolean isEmpty();
    public Object peek();
}

