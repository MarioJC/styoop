/**
 * HappyObject inherits from MoodyObject, redefines the getMood() method, and
 * adds a laugh method.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class HappyObject extends MoodyObject {

    // redefine class's mood
    protected String getMood() {
	return "happy";
    }
    
    // specialization
    public void laugh() {
	System.out.println("hehehe... hahaha... HAHAHAHAHAHA!!!!!");
    }
}
