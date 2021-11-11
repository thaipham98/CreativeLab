/*
* Demonstration code for showing a common mistake 
* made with String class objects 
* 5/20/2021
* Dr. G
*/

public class StringMistakeDemo
{
	public static void main(String[] args) {
	    String a = "Roux";
	    String b = "Roux";
	    String c = new String("Roux");

        /*
        * Number 1
        * Consider the output from the this block of code. 
        * Which line causes the "false"?
        * Why are the last two lines different?
        */
        
        System.out.println();
		System.out.println("Roux" == "Roux"); //comparing two strings // true. The same objects
		System.out.println(a == b); //comparing two string variables // true. The same objects
		System.out.println(a == c); //comparing two other string variables // false. Different objects (and different memory location too)
		System.out.println(a.equals(c));//using the string class method "equals" // true. Because String is a class, == compares the memory location of the objects, instead of comparing the 2 values itself (but for primitive data type == compares 2 values)
		
		
		/*
		* Number 2
		* "identityHashCode" provides a numeric signature that includes the 
		* memory location for the variable. 
		* What does the following output tell you about how Java stores strings?
		*/
		
		System.out.println();
		System.out.println(Integer.toHexString(System.identityHashCode(a))); // a = Roux and b = Roux => Java assigns the same memory address
		System.out.println(Integer.toHexString(System.identityHashCode(b)));
		System.out.println(Integer.toHexString(System.identityHashCode(c))); // c is a new instance of String object with Roux value, hence it is assigned a new memory address
		
		/*
		* Number 3
		* What happens in memory when you modify the string?
		*/
		
		System.out.println();
		a = a + b; // string concatenation
		System.out.println(a); // new memory address for a, since now a refers to a new instance of String object with value = RouxRoux
		System.out.println(Integer.toHexString(System.identityHashCode(a)));
		System.out.println(Integer.toHexString(System.identityHashCode(b))); // memory address for b remains the same
		System.out.println(Integer.toHexString(System.identityHashCode(c))); // memory address for b remains the same
		
		/*
		* Number 4
		* When would you use the equality operator "==" and .equals?
		*/
		// Equality operator == generally should be used for primitive type. When it is used for instance of object, it compares memory address
		// .equals should be used to compare values of object instances
	}
}