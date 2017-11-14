import java.util.ArrayList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Interval1D {
	private double lo;
	private double hi;
	
	public Interval1D (double tlo, double thi) {
		if(tlo > thi) {
			double temp = tlo;
			tlo = thi;
			thi = temp;
		}
		this.lo = tlo;
		this.hi = thi;
	}
	
	public boolean intersect (Interval1D that) {
		if(that.hi < this.lo) {
			return false;
		}
		else if((that.hi > this.lo) && (that.lo < this.hi)) {
			return true;
		}
		else
			return false;
		
	}
	public String toString() {
		return "(" + this.lo + ", " + this.hi + ")";
	}

	public static void main(String[] args) {
		StdOut.println("please enter N");
		int N = StdIn.readInt();
		ArrayList<Interval1D> intervalSets = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			Interval1D interval1Di = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
			intervalSets.add(interval1Di);
		}
		for(int i = 0; i < intervalSets.size(); i++) {
			for(int j = i+1; j < intervalSets.size(); j++) {
				Interval1D temp1 = intervalSets.get(i);
				Interval1D temp2 = intervalSets.get(j);
				if(temp1.intersect(temp2)) {
					StdOut.println("intersect: " + temp1 + " " + temp2);
				}
			}
		}
		
		
		StdOut.println();
		// TODO Auto-generated method stub

	}

}
