/**
 * EmployeeExample demonstrates that CommissionedEmployee demonstrates that it 
 * does indeed inherit everything in Employee's interface.
 * @author  Tony Sintes STYOOP
 * @version 1.0 
 */
public class EmployeeExample {
      public static void main( String [] args ) {
            CommissionedEmployee c = new CommissionedEmployee("Mr.","Sales",5.50,1.00);
            c.addSales(5);
            System.out.println( "First Name: " + c.getFirstName() );
            System.out.println( "Last Name: "  + c.getLastName()  );
            System.out.println( "Base Pay: $" + c.getWage() );
            System.out.println( "Total Pay: $" + c.calculatePay() );
      }
}
