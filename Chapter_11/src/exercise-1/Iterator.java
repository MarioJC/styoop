/**
 * While Java provides an Iterator interface, this Iterator more closely follows
 * the one defined in "Design Patterns Elements of Reusable Object-Oriented Software"
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public interface Iterator {
    public void first();
    public void next();
    public boolean isDone();
    public Object currentItem();
}

