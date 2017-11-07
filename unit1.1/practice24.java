import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice24 {
	public static void main(String[] args) {
		StdOut.println("please enter 2 numbers");
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		if(a > b) {
			exchange(a, b);
		}
		int p = Euclid(a, b);
		StdOut.println("The greatest common divisor is" + p);
	}

	private static void exchange(int a, int b) {
		int temp = a;
		a = b;
		b = a;	
	}

	private static int Euclid(int a, int b) {
		int r = a % b;
		if(r == 0) {
			return b;
		}
		else {
			a = b;
			b = r;
			StdOut.println("a:" + a + "b:" + b);
			return Euclid(a, b);
		}
		
		
	}

}
