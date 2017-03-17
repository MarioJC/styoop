/**
 * MoodyObject is a base class for writing objects that have a mood.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class MoodyObject {
    
    // return the mood
    protected String getMood() {
	return "moody";
    }
    
    // ask the object how it feels
    public void queryMood() {
	System.out.println("I feel " + getMood() + " today!");
    }
    
}
