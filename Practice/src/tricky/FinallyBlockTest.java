package tricky;

public class FinallyBlockTest {

	public static void main(String[] args) throws Exception {

		testReturnInCatch();
		
		testThrowFromCAtch();
		
		testFinally();

	}

	private static void testThrowFromCAtch() throws Exception {

		System.out.println("In main method");
		
		try{
			System.out.println("In try block");
			
			System.out.println("... Throwing exception");
			throw new Exception();
		}
		catch (Exception e ){
			System.out.println("In catch block");
			System.out.println("...throwing exception from catch.");
			throw new ClassCastException();
		}
		finally {
			System.out.println("In finally block");
			throw new NullPointerException();
		}
	
		
	}

	private static void testReturnInCatch() {

		System.out.println("In main method");
		
		try{
			System.out.println("In try block");
			
			System.out.println("... Throwing exception");
			throw new Exception();
		}
		catch (Exception e ){
			System.out.println("In catch block");
			System.out.println("...returninng from catch.");
			return;
		}
		finally {
			System.out.println("In finally block");
		}
		
	}

	private static void testFinally() {
		System.out.println("In main method");
		
		try{
			System.out.println("In try block");
			
			System.out.println("... calling System.exit(0)");
			System.exit(0);
		}
		catch (Exception e ){
			System.out.println("In catch block");
		}
		finally {
			System.out.println("In finally block");
		}
	}

}
