public class Teller {
 
    public static void main( String [] args ) {
    
        // open some accounts
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account( 5000.00 );
        
        account1.depositFunds( 500.00 );    // balance 500.00
        account2.depositFunds( 1000.00 );   // balance 1000.00
        account3.depositFunds( 5000.00 );   // balance 10000.00
        
        account1.withdrawFunds( 250.00 );   // balance 250.00
        account2.withdrawFunds( 1.00 );     // balance 999.00
        account3.withdrawFunds( 1150.00 );  // balance 8850.50
        
        System.out.println( "I have created three accounts." );
        
        double balance1 = account1.getBalance();
        double balance2 = account2.getBalance();
        double balance3 = account3.getBalance();
        
        if( balance1 != 250.00 ) {
            System.out.println( "Account 1 does not have the proper balance of 250.00. The account balance is " + balance1 );
        } else {
            System.out.println( "Account 1 has the proper balance of 250.00."  );    
        }
        if( balance2 != 999.00 ) {
            System.out.println( "Account 2 does not have the proper balance of 999.00. The account balance is " + balance2 );
        } else {
            System.out.println( "Account 2 has the proper balance of 999.00."  );    
        }
        if( balance3 != 8850.00 ) {
            System.out.println( "Account 3 does not have the proper balance of 8850.00. The account balance is " + balance3 );
        } else {
            System.out.println( "Account 3 has the proper balance of 8850.00."  );    
        } 
    }
    
}