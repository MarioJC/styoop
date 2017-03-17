/**
 * The MutableAdapter wraps a Pet instance and presents the instance as
 * a MoodyObject. The mutable adapter allows you to use the wrapper on more
 * than one instance.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class MutableAdapter extends MoodyObject {

    private Pet pet;
    
    public MutableAdapter( Pet pet ) {
        setPet( pet );
    }

    protected String getMood() {
        // only implementing because required to by
        // MoodyObject, since also override queryMood
        // we don't really need it
        return pet.speak();
    }
    
    public void queryMood() {
        System.out.println( getMood() );
    }
    
    public void setPet( Pet pet ) {
        this.pet = pet;
    }
}