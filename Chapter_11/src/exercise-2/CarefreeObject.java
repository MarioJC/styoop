/**
 * CarefreeObject inherits from MoodyObject, redefines the getMood() method, and
 * adds a whistle mehod.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class CarefreeObject extends MoodyObject {

    // redefine class's mood
    protected String getMood() {
	return "carefree";
    }
    
    // specialization
    public void whistle() {
	System.out.println("whistle, whistle, whistle...");
    }
}
