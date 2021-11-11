//Demonstration code for Java Exception Handling
//9-30-18
//Updated: 5/21/2021
//Dr. G

/*
The instructor in the provided module video went over how to set up methods to throw exceptions and catch 
those exceptions within a driver.

I'd like to add this a demonstration about try/catch blocks that demonstrates control flow. 
I would also like to discuss command line IO.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoExcep
{
	public static void main(String [] args)
	{		
		//1. What's the difference in:
			//a runtime error <-- exception handling
			//compiler error
			//logic error
			//convention error
			
		//2. Look up the javadocs for the scanner class
		Scanner input = new Scanner(System.in); // read information from a buffer
		boolean continueLoop = true;
		int n1 = 0;
		int n2 = 0;
		int sum = 0;
		
		//3.
		//What happens when the user enters a 0?
		//Who is handling this error?
		//What would happen in an application if it crashed everytime an error occured?
		
		do {
		// handle divide by 0, and make sure a number is entered (instead of a string/char. etc)
			try {
				//prompt user and get contents of the stdin buffer
				System.out.println ("Enter value 1");
				// read 4 bytes from the buffer, convert into int, and pass to n1
				n1 = input.nextInt(); // leads to input mismatch exception
				System.out.println ("Enter value 2");
				n2 = input.nextInt(); // leads to input mismatch exception
				sum = n1/n2; // leads to Arithmetic exception
				System.out.println(sum);
			}
			catch(ArithmeticException AE) { // thrown by sum = n1/n2;
				System.out.println(AE);
			}
			catch(InputMismatchException IE ) {
				System.out.println(IE);
				System.out.println("Only input ints");
				// clear the buffer
				input.next();
			}
			catch(Exception E) {
				System.out.println(E);
			}
		}
		while(continueLoop); // have to clear the buffer or else loop continues running if exception
		
		System.out.println("woot!");
		//We could avoid this by putting it in a while loop to see what the user entered
		//or we could use try/catch
		
		//4. Add a try/catch block to the above code that catches all exceptions. 
		// Add a statement to let the user know what mistake they made. 
		// handle divide by 0, and make sure a number is entered (instead of a string/char. etc)
		
		//5. Change this to a specific exception. 
		//There's at least one other exception that could occur. What is it?
		
		//6. Add an exception for that error. 
		
		//7. Now force them to execute forever unless they do it right with a do/while loop.
		// What happens with math error? What happens with the "other" error?
		
		//8. Fix the "other" error problem caused by the loop. 
		
		
		
		
		
		//Move the dangerous part to a method and specify what exception that method 
		//can throw. Comment out the above code and move it here with a method call. 
		//Create the method below.
		
		/*
					...code...
		*/
	
	//Do an online search to look for a class/method and its associated exceptions
	//Why bother at all? Why not just let the program crash
	}
	
	
	//Edit this method to throw an ArithmeticException
	/*public static int divide(int x, int y)
	{return x/y;}*/
	
	
}