package sort;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	public static void sort(Comparable[] a) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			for(int j = i; j > 0; j--) {
				if(less(a[j], a[j-1])) 
					exch(a, j, j-1);
			}
		}
	}

	private static void exch(Comparable[] a, int v, int w) {
		Comparable t = a[v];
		a[v] = a[w];
		a[w] = t;
		
	}

	private static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
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
