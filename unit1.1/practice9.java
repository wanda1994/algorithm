import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice9 {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		String s = "";
		for(int n = N; n > 0; n = n/2) {
			s =  (n%2) + s;
		}
		StdOut.print(s);

	}

}
