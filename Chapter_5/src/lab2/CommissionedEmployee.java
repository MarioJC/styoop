/**
 * CommissionedEmployee demonstrates inheritance by inheriting from Employee.
 * CommissionedEmployee also demonstrates programming by difference.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class CommissionedEmployee extends Employee {

      private double commission; // the $ per unit
      private int    units;      // keep track of the # of units sold

      public CommissionedEmployee( String first_name, String last_name, double wage, double commission ) {
            super( first_name, last_name, wage ); // call the original constructor in order to properly initialize
            this.commission   = commission;
      }

      public double calculatePay() {
            return getWage() + ( commission * units );
      }

      public void addSales( int units ) {
            this.units = this.units + units;
      }

      public void resetSales() {
            units = 0;
      }

}
