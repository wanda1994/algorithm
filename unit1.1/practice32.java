import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class practice32 {

	public static void main(String[] args) {
		StdOut.println("please enter a number");
		int n = StdIn.readInt();
		StdOut.println("please enter l and r");
		double l = StdIn.readDouble();
		double r = StdIn.readDouble();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<>();
		while(scanner.hasNextDouble()) {
			list.add(scanner.nextDouble());
		}
		StdOut.println(list);
		histogram(l, r, n, list);

	}

	private static void histogram(double l, double r, int n, ArrayList<Double> list) {
		int[] counts = new int[n];
		 for (int i = 0; i < list.size(); i++)
	        {
			    double element = list.get(i);
	            int k = getInterval(element, n, l, r);
	            if (k >= 0)
	                counts[k]++;
	        }
	        
	        int maxCount = StdStats.max(counts);
	        
	        StdDraw.setCanvasSize(1024, 512);
	        StdDraw.setXscale(l, r);
	        StdDraw.setYscale(0, maxCount);
	        
	        double w = (r - l) / n;
	        
	        for (int i = 0; i < n; i++)
	        {
	            double x = l + (i + 0.5) * w,
	                   y = counts[i] / 2.0,
	                   rw = 0.5 * w,
	                   rh = counts[i] / 2.0;
	            StdDraw.filledRectangle(x, y, rw, rh);
	}
		// TODO Auto-generated method stub
		
	}

	private static int getInterval(double d, int n, double l, double r) {
		 if (d < l || d >= r)
	            return -1;
	        else
	            return (int)(n * (d - l) / (r - l));
	}

}
