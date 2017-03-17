/**
 * SadObject inherits from MoodyObject, redefines the getMood() method, and
 * adds a cry method.
 * @author Tony Sintes STYOOP
 * @version 1.0
 */
public class SadObject extends MoodyObject {
    
    // redefine class's mood
    protected String getMood() {
	return "sad";
    }      
    
    // specialization
    public void cry() {
	System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }
}
