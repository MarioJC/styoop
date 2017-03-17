/**
 * MoodyObject is a base class for writing objects that have a mood.
 * @author Tony Sintes STYOOP
 * @version 2.0
 */
public abstract class MoodyObject {
    
    // return the mood
    protected abstract String getMood();
    
    // ask the object how it feels
    public void queryMood() {
	System.out.println("I feel " + getMood() + " today!");
    }
    
}
