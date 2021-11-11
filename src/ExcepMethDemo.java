/*
Demonstration for setting methods to throw exceptions
9/28/2021
-Dr. G

Before beginning do a quick search to see what default exception arguments exist. 

*/

/*
-What's the difference in a checked an unchecked exception?
-What's actually happening as far as control flow is concerned?
-Why not just let the Java JVM or OS handle exceptions?
*/


import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class ExcepMethDemo
{
	public static void main(String[] args) 
	{
		//In Java we get user input through a Scanner class object
		Scanner sc = new Scanner(System.in);
		Book b1 = new Book();
		System.out.println("Please enter page number : ");
		//Take a look at the available scanner methods
		//This methods halts control flow, allows the user to enter something into system.in, and then it retrieves that
		b1.setPage(sc.nextInt());
		
		/*
		try {
		    b1.setPage(sc.nextInt());
		    } 
		catch(IllegalArgumentException E) {
		    System.out.println(E);
		} */
		
	}
}


/**
	Class object representing a book with a current page and maxPage
*/
class Book
{
    private int page;
    private int maxPage;
    
	//Basic no argument constructor
	//Start at page 0 with a maximum page size of 99
    public Book() 
    {
       page = 0;
       maxPage=99;
    }
    
	/**
		Set the current page to a new page, but throw an exception if the user tries to go past max page
	*/
    public void setPage(int page)throws IllegalArgumentException // required for the throw new exception below
    {
         if (page > maxPage) 
        {
            System.out.println("requested page size exceeds max page limit");
            throw new IllegalArgumentException(); // toss exception
        }
        else
            this.page=page;
        
    }
    
}
