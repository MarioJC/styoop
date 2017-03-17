public class HelloWorld {

	public void sayHello() {
          System.out.println( "Hello World!" );
      }

	public static void main( String [] args ) {
		final HelloWorld hw = new HelloWorld();

		Runnable runnable = new Runnable() {
			public void run() {
				hw.sayHello();
                  }
 		};
		
		Thread thread = new Thread( runnable );
		thread.start();

		System.out.println( "All Done!" );

	}	
	
}