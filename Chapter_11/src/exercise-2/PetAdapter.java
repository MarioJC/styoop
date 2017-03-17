/**
 * The PetAdapter wraps a Pet instance and presents the instance as
 * a MoodyObject.
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class PetAdapter extends MoodyObject {

    private Pet pet;
    
    public PetAdapter( Pet pet ) {
        this.pet = pet;
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
}