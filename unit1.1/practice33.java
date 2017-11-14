import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice33 {
	public static void main(String[] args) {
		StdOut.println("please the length of array x");
		int m = StdIn.readInt();
		double[] x = new double[m];
		StdOut.println("please enter array x");
		for(int i = 0; i < m; i++) {
			x[i] = StdIn.readDouble();
		}
		StdOut.println("please enter the length of array y");
		int n = StdIn.readInt();
		double[] y = new double[n];
		StdOut.println("enter array y");
		for(int i = 0; i < n; i++) {
			y[i] = StdIn.readDouble();
		}
		StdOut.println("please enter the height and width of matrix a");
		int ha = StdIn.readInt();
		int wa = StdIn.readInt();
		StdOut.println("please enter matrix a");
		double[][] a = new double[ha][wa];
		for(int i = 0; i < ha; i++) {
			for(int j = 0; j < wa; j++) {
				a[i][j] = StdIn.readDouble();
			}
		}
		StdOut.println("please enter the height and width of matrix b");
		int hb = StdIn.readInt();
		int wb = StdIn.readInt();
		StdOut.println("please enter matrix b");
		double[][] b = new double[hb][wb];
		for(int i = 0; i < hb; i++) {
			for(int j = 0; j < wb; j++) {
				b[i][j] = StdIn.readDouble();
			}
		}
		
		StdOut.println("dot(x,y): " +Matrix.dot(x, y));
		double[][] matrix = Matrix.mult(a, b);
		for (int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				StdOut.print(matrix[i][j] + " ");
			}
			StdOut.println();
		}
		
		StdOut.println("mult(a,b): "+Matrix.mult(a, b));
	} 

}
