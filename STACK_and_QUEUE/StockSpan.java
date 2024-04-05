// Java linear time solution for stock span problem

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StockSpan {
	// A stack based efficient method to calculate
	// stock span values
	static void calculateSpan(int price[], int n, int S[])
	{
		Deque<Integer> st = new ArrayDeque<Integer>();
		st.push(0);
		S[0] = 1;
		for (int i = 1; i < n; i++) {
			while (st.isEmpty()==false && price[st.peek()] <= price[i])
			{
				st.pop();
			}
			S[i] = (st.isEmpty()) ? (i + 1)
								: (i - st.peek());

			st.push(i);
		}
	}
	static void printArray(int arr[])
	{
		System.out.print(Arrays.toString(arr));
	}

	// Driver code
	public static void main(String[] args)
	{
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;
		int S[] = new int[n];

		// Fill the span values in array S[]
		calculateSpan(price, n, S);

		// print the calculated span values
		printArray(S);
	}
}
// This code is contributed by Sumit Ghosh
