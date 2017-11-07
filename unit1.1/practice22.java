import edu.princeton.cs.algs4.StdOut;

public class practice22 {
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length-1, 1);
	}

	private static int rank(int key, int[] a, int low, int hi, int deep) {
		if(low > hi) {
			return -1;
		}
		int mid = low + (hi - low)/2;
		
		      StdOut.println("low:"+low+" hi:"+hi + " deep" + deep);
	
		if(key > a[mid]) {
			return rank(key, a, mid+1, hi, deep+1);
		}
		else if(key < a[mid]) {
			return rank(key, a, 0, mid-1, deep+1);
		}
		else
			return mid;
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 2, 5, 7, 67, 78};
		rank(7, a);
		

	}

}
