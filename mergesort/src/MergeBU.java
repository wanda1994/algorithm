import java.util.Scanner;

public class MergeBU {
	private static Comparable[] aux;
	
	public static void sort(Comparable [] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz = sz + sz) {
			for(int lo = 0; lo < N -sz; lo += sz + sz) {
				merge(a, lo, lo + sz -1, Math.min(lo + sz + sz - 1, N-1));
			}
		}
		
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if(less(a[j], a[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
		
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
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
