import java.util.ArrayList;
import java.util.Iterator;
/**
 * An EmployeeModel class.
 * @author  Tony Sintes STYOOP
 * @version 2.0 
 */
public abstract class Employee {

    private String first_name;
    private String last_name;
    private double wage;
    private ArrayList listeners = new ArrayList();
    
    public Employee(String first_name,String last_name,double wage) {
        this.first_name = first_name;
        this.last_name  = last_name;
        this.wage = wage;
    }

    public double getWage() {
          return wage;
    }

    public void setWage( double wage ) {
        this.wage = wage;
        updateObservers();
    }
    
    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public abstract double calculatePay();
      
    public abstract double calculateBonus();
    
    public void printPaycheck() {
        String full_name = last_name + ", " + first_name;
        System.out.println( "Pay: " + full_name + " $" + calculatePay() );
    }
    
    public void register( Observer o ) {
        listeners.add( o );  
        o.update();
    }
    
    public void deregister( Observer o ) {
        listeners.remove( o );
    }
    
    private void updateObservers() {
        Iterator i = listeners.iterator();
        while( i.hasNext() ) {
            Observer o = (Observer) i.next();
            o.update();
        }
    }
    
}
