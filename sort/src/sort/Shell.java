package sort;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Shell {
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		while(h < n/3) {
			h = 3*h + 1;
		}
		while (h >= 1) {
			for(int i = 0; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			h = h / 3;
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();	
		String[] a = s.split(",");
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
