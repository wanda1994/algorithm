import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class InsertionX {
	private InsertionX() {
		
	}
	public static void sort(Comparable[] a) {
		int n = a.length;
		int exchanges = 0;
		for(int i = n-1; i > 0; i--) {
			if(less(a[i], a[i-1])) {
				exch(a, i, i-1);
				exchanges++;
			}
		}
		if(exchanges == 0)
			return;
		for(int i = 2; i < n; i++) {
			Comparable v = a[i];
			int j = i;
			while(less(v, a[j-1])) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = v;	
		}
		assert isSorted(a);
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;	
	}
	
	
	private static boolean less(Comparable i, Comparable j) {
		// TODO Auto-generated method stub
		return i.compareTo(j) < 0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			StdOut.print(a[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();	
		String[] a = s.split(",");
		InsertionX.sort(a);
		show(a);
	}

}
