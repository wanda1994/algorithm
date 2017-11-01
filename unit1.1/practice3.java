import edu.princeton.cs.algs4.*;
public class practice3 {
	public static void main(String[] args ) {
		int a, b, c;
		StdOut.println("please enter 3 numbers");
		a = StdIn.readInt();
		b = StdIn.readInt();
		c = StdIn.readInt();
		if(a == b && b == c) {
			StdOut.println("equal");
		}
		else
		    StdOut.println("not equal");
	}
	

}
