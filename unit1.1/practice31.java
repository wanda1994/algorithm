import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class practice31 {

	public static void main(String[] args) {
		StdOut.println("please enter n(int) and p(double)");
		int n = StdIn.readInt();
		double p = StdIn.readDouble();
		randomLink(n, p);

	}

	private static void randomLink(int N, double p) {
		 StdDraw.setCanvasSize();
	     StdDraw.setScale(-1.5, 1.5);
	     StdDraw.setPenRadius(.015);
	     StdDraw.setPenColor(StdDraw.ORANGE);
	        
	        double[][] d = new double[N][2];
	        for (int i = 0; i < N; i++)
	        {
	            d[i][0] = Math.cos(2 * Math.PI * i / N);
	            d[i][1] = Math.sin(2 * Math.PI * i / N);
	            StdDraw.point(d[i][0], d[i][1]);
	        }
	        
	        StdDraw.setPenRadius();
	        StdDraw.setPenColor(StdDraw.GRAY);
	        
	        for (int i = 0; i < N - 1; i++)
	            for (int j = i + 1; j < N; j++)
	                if (StdRandom.bernoulli(p))
	                      StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
	}

}
