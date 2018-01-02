import java.util.Scanner;

public class Merge {
	private static void Merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(j > hi) 
				a[k] = aux[i++];
			else if (i > mid)
				a[k] = aux[j++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
		assert isSorted(a, lo, hi);
	}
	
	private static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		Merge(a, aux, lo, mid, hi);
		
	}

	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length-1);
	}
	
	

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for(int i = lo + 1; i <= hi; i++) {
			if (less(a[i], a[i-1]))
				return false;
		}
		return true;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
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
