package Assignments;

public class Fibonacci {

	int first;
	int second;
	public Fibonacci() {
		first=0;
		second=1;
	}
	public void display(int n) {
		 System.out.print("Fibonacci Series up to " + n + "th terms are: ");
		for(int i=1;i<=n;i++)
		{
		     System.out.print(first + " "); // Print the current term
			int next = first + second;
            first = second;
            second = next;
		}
	}
}
