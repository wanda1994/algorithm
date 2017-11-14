import edu.princeton.cs.algs4.StdOut;

public class Matrix {

	public static double dot(double[] x, double[] y) {
		double result = 0;
		if(x.length == y.length) {
			for(int i = 0; i < x.length; i++) {
				result = result + x[i] * y[i];
			}
			return result;
		}
		else {
			StdOut.println("error");
			return result;
			
		}
		
	}
	
	public static double[][] mult(double[][] a, double[][] b) {
		int m = a.length;
		int n = b[0].length;
		double[][] result = new double [m][n];
		if(m == n) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					for(int k = 0; k < n; k++) {
						result[i][j] = result[i][j] + a[i][k] * b[k][j];
					}
				}
			}
			return result;
		}
		else {
			StdOut.println("error");
			return null;
		}
	}
	
	public static double[][] transpose(double[][] a) {
		int m = a.length;
		int n = a[0].length;
		double[][] result = new double[n][m];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = a[j][i];
			}
		}
		return result;
	}
	
	public static double[] mult(double[][] a, double[] x) {
		int m = x.length;
		int n = a[0].length;
		double[] result =  new double[m];
		if(m == n) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					result[i] = result[i] + x[j]*a[i][j];
				}

			}
			return result;
		}
		else {
			StdOut.println("error");
			return null;
		}
	}

}
