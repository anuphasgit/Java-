/**
 * Demonstrates the use of primitive data types,arithmetic
 * expressions, and promotion
 *
 * @author Java Foundations, CS121 Instructors, Anup
 */
public class mytemperatureconverter
{
	/**
	 * Computes the Celsius equivalent of a Fahrenheit
	 * value using the formula F =(9/5)C + 32.
	 */
	public static void main(String[] args)
	{
		// Declare and instantiate constants
		final int BASE = 32;//@keyterms primitive data type
		final double CONVERSION_FACTOR = 5.0/9.0; //keyterms decleration and initialization

		//Declare variables (celsiusTemp is also instantiated)
		double celsiusTemp;
		int fahrenheitTemp = 98;  // value to convert

		
         // Notice the types of each variable: BASE is an int. CONVERSION_FACTOR
		// is a double. celsiusTemp is an int. fahrenheitTemp is a double. BASE is promoted 
		// to a double during the evaluation of the expression.

        celsiusTemp = (fahrenheitTemp- BASE )* CONVERSION_FACTOR;

        System.out.println("Celsius Temperature: " + celsiusTemp);
		System.out.println("Fahrenheit Equivalent: " + fahrenheitTemp);
	}
}
