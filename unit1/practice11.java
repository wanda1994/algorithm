import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practice11 {
	static int i = StdIn.readInt();
	static int j = StdIn.readInt();
	public static void main(String[] args) {
		boolean [][]a = new boolean[i][j];
		a = randomInitialize (a);
		print(a);
	}
	private static void print(boolean[][] a) {
		for(int q = 0; q < a[0].length; q++) {
			StdOut.print(" "+q);
		}
		for(int p = 0; p < a.length; p++) {
			//StdOut.print(p+" ");
			StdOut.println();
			StdOut.print(p);
			for(int q = 0; q < j; q++) {
				if(a[p][q])
					StdOut.print("* ");
				else
					StdOut.print("  ");
			}
		}
		
	}
	private static boolean[][] randomInitialize(boolean[][] a) {
		for(int p = 0; p < i; p++) {
			for(int q = 0; q < j; q++) {
				if(StdRandom.bernoulli())
					a[p][q] = true;
				else 
					a[p][1] = false;
			}
		}
		return a;
	}
	

}
