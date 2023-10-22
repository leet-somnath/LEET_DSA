// Java program to print all n-digit numbers whose digits
// are strictly increasing from left to right
import java.io.*;

 public class IncreasingNumbers
{
	// Function to print all n-digit numbers whose digits
	// are strictly increasing from left to right.
	// out --> Stores current output number as string
	// start --> Current starting digit to be considered
	void findStrictlyIncreasingNum(int start, String out, int n)
	{
		// If number becomes N-digit, print it
		if (n == 0)
		{
			System.out.print(out + " ");
			return;
		}

		// start from (prev digit + 1) till 9
		for (int i = start; i <= 9; i++)
		{
			// append current digit to number
			String str = out + Integer.toString(i);

			// recurse for next digit
			findStrictlyIncreasingNum(i + 1, str, n - 1);
		}
	}

	// Driver code for above function
	public static void main(String args[])throws IOException
	{
		IncreasingNumbers obj = new IncreasingNumbers();
		int n = 3;
		obj.findStrictlyIncreasingNum(0, " ", n);
	} 
}
