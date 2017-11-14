import java.util.ArrayList;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Point2D {
	private double x;
	private double y;
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distTo(Point2D that) {
		double x = this.x - that.x;
		double y = this.y - that.y;
		double distance = Math.sqrt(x*x + y*y);
		return distance;
		
	}

	public static void main(String[] args) {
		StdOut.println("please enter N");
		int N = StdIn.readInt();
		ArrayList<Point2D> pointSets = new ArrayList<Point2D>();
		for(int i = 0; i < N; i++) {
			Point2D point2D = new Point2D(Math.random(), Math.random());
			pointSets.add(point2D);
		}
		double result = pointSets.get(0).distTo(pointSets.get(1));
		for(int i = 0; i < N; i++) {
			Point2D srcPoint = pointSets.get(i);
			for(int j = i+1; j < N; j++) {
				Point2D dstPoint = pointSets.get(j);
				double distance = srcPoint.distTo(dstPoint);
				if(distance > result) {
					result = distance;
				}
			}
		}
		StdOut.println(result);

	}

}
