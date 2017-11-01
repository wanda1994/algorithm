import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*二维数组的转置*/
public class practice13 {
	private static int m;
	private static int n;
	public static void print(int a[][]) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				StdOut.print("\t"+a[i][j]);
			}
			StdOut.println();
		}
	}
	public static void main(String[] args) {
		StdOut.println("please enter 2 numbers");
		m = StdIn.readInt();
		n = StdIn.readInt();
		int[][] a = new int[m][n];
		int[][] b = new int[n][m];
 		a = initialize(a);
 		print(a);
		b = reverse(a, b);
		StdOut.println("reverse");
		print(b);

	}
	private static int[][] initialize(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = StdRandom.uniform(100);
				//StdOut.print(a[i][j]+" ");
			}
			//StdOut.println();
		}
		return a;
		
	}
	private static int[][] reverse(int[][] a, int[][] b) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}

	
}
