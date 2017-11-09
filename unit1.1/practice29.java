import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class practice29 {
	public static void main(String[] args) {
		int[] a = {1, 2, 2, 3, 5, 5, 5, 6, 7, 9, 12, 12, 12, 19};
		StdOut.println(Arrays.toString(a));
		StdOut.println("please enter a key");
		int key = StdIn.readInt();
		StdOut.println("the value of rank is " + rank(key, a));
		StdOut.println("the value of count is " + count(key, a));
	}

	private static int count(int key, int[] a) {
		int searchResult = binarySearch(key, a);
		int countNum = 0;
		if(searchResult != -1) {
			for(int i = 0; i < a.length; i++) {
				if(a[i] == a[searchResult]) {
					countNum++;
				}
			}
			
		}
		
		return countNum;
	}

	private static int binarySearch(int key, int[] a) {
		int lo = 0, hi = a.length-1;
		while(lo < hi) {
			int mid = lo + (hi - lo)/2;
			if(key == a[mid]) {
				return mid;
			}
			else if(key > a[mid]) {
				lo = mid + 1;
			}
			else if(key < a[mid]) {
				hi = mid - 1; 
			}
			
		}
		return -1;
		
	}

	private static int rank(int key, int[] a) {
		int searchResult = binarySearch(key, a);
		int rankNum = 0;
		if(searchResult != -1) {
			StdOut.println("SearchResult is " + searchResult);
			for(int i = 0; i < searchResult; i++) {
				if(a[i] < a[searchResult]) {
					rankNum++;
				}
			}
			
		}
		else 
			StdOut.println("cannot find the key");
		
		// TODO Auto-generated method stub
		return rankNum;
	}

}
