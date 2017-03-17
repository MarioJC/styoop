/**
 * Employee is a base class. Employee objects could appear in a database payroll 
 * system.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class Employee {

      private String first_name;
      private String last_name;
      private double wage;

      public Employee( String first_name, String last_name, double wage ) {
            this.first_name = first_name;
            this.last_name  = last_name;
            this.wage = wage;
      }

      public double getWage() {
            return wage;
      }

      public String getFirstName() {
            return first_name;
      }

      public String getLastName() {
            return last_name;
      }

}
