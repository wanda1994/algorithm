import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice30 {
	public static void main(String[] args) {
		StdOut.println("please enter a number");
		int n = StdIn.readInt();
		boolean[][] a = new boolean[n][n];
		a = initialize(a);
		print(a);
	}

	private static void print(boolean[][] a) {
		for(int col = 0; col < a[0].length; col++) {
			StdOut.print(" "+col);
		}
		for(int row = 0; row < a.length; row++) {
			StdOut.println();
			StdOut.print(row);
			for(int col = 0; col < a[0].length; col ++) {
				if(a[row][col]) {
					StdOut.print("* ");
				}
				else {
					StdOut.print("  ");
				}
			}
		}
	}

	private static boolean[][] initialize(boolean[][] a) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 || j == 0) {
					a[i][j] = true;
				}
				else {
					if(isCorprime(i, j)) {
						a[i][j] = true;
					}
					else {
						a[i][j] = false;
					}
				}
				
			}
		}
		// TODO Auto-generated method stub
		return a;
	}

	private static boolean isCorprime(int i, int j) {
		int p = Eculid(i, j);
		if(p == 1) {
			return true;
		}
		else
			return false;
	}

	private static int Eculid(int i, int j) {
		exch(i, j);
		int r = i % j;
		if(r == 0) {
			return j;
		}
		else {
			i = j;
			j = r;
			return Eculid(i, j);
		}
	}

	private static void exch(int i, int j) {
		if(i < j) {
			int temp = i;
			i = j;
			j = temp;
		}
		
	}

}
