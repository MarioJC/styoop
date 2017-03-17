/**
 * HourlyEmployee demonstrates inheritance by inheriting from Employee.
 * HourlyEmployee also demonstrates programming by difference.
 * @author  Tony Sintes STYOOP
 * @version 2.0 
 */
public class HourlyEmployee extends Employee {

      private int hours; // keep track of the # of hours worked

      public HourlyEmployee( String first_name, String last_name, double wage ) {
            super( first_name, last_name, wage ); // call the original constructor in order to properly initialize
      }

      public double calculatePay() {
            return getWage() * hours;
      }

      public double calculateBonus() {
        return 100.00;
      }
      
      public void addHours( int hours ) {
            this.hours = this.hours + hours;
      }

      public int getHours() {
          return hours;
      }
      
      public void resetHours() {
            hours = 0;
      }

}
