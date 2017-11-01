import edu.princeton.cs.algs4.*;

public class practice5 {
	public static void main (String[] args) {
		double a, b;
		StdOut.println("please enter 2 numbers");
		a = StdIn.readDouble();
		b = StdIn.readDouble();
		if(a > 0 && a < 1 && b>0 && b < 1) {
			StdOut.println("true");
		}
		else
			StdOut.println("false");
	}

}
