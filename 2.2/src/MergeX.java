import java.util.Comparator;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class MergeX {

	private static final int CUTOFF = 7;
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length-1);
		assert isSorted(a);
	}
	

	private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
		if (hi <= lo + CUTOFF) {
			insertionSort(dst, lo, hi);
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		sort(dst, src, lo, mid);
		sort(dst, src, mid+1, hi);
		if(!less(src[mid+1], src[mid])) {
			System.arraycopy(src, lo, dst, lo, hi - lo + 1);
			return;
		} 
		
		merge(src, dst, lo, mid, hi);
	}

	private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
		assert isSorted(src, lo, mid);
		assert isSorted(src, mid+1, hi);
		
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++) {
			if(i > mid)
				dst[k] = src[j++];
			else if (j > hi)
				dst[k] = src[i++];
			else if (less(src[j], src[i]))
				dst[k] = src[j++];
			else 
				dst[k] = src[i++];
		}
		
		assert isSorted(dst, lo, hi);
		
	}
	
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length-1);
	}


	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for(int i = lo + 1; i <= hi; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}


	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for(int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
		
	}
	
    private static void exch(Object[] a, int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}


	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	 private static void show(Object[] a) {
	        for (int i = 0; i < a.length; i++) {
	            StdOut.println(a[i]);
	        }
	    }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();	
		String[] a = s.split(",");
		MergeX.sort(a);
		assert isSorted(a);
		show(a);

	}

}
