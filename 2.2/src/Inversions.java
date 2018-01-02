import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Inversions {
	
	public static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
		int inversions = 0;
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if(aux[j] < aux[i]) {
				a[k] = aux[j++];
				inversions += mid - i + 1;
			}
			else
				a[k] = aux[i++];
		}
		return inversions;
		
		
		
	}
	
	public static long count(int[] a, int[] b, int[] aux, int lo, int hi) {
		long inversions = 0;
		if (lo >= hi) {
			return 0;
		}
		int mid = lo + (hi - lo) / 2;
		inversions += count(a, b, aux, lo, mid);
		inversions += count(a, b, aux, mid+1, hi);
		inversions += merge(b, aux, lo, mid, hi);
		assert inversions  == brute(a, lo, hi);
		return inversions;
	}
	
	public static long count(int[] a) {
		int[] b = a.clone();
		int[] aux = new int[a.length];
		long inversions = count(a, b, aux, 0, a.length-1);
		return inversions;
	}
	
	private static long brute(int[] a, int lo, int hi) {
		long inversion = 0;
		for(int i = lo; i <= hi; i++) {
			for(int j = i+1; j <= hi; j++) {
				if(a[j] < a[i]) 
					inversion++;
			}
		}
		return inversion;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] a = s.split(",");
		int array[] = new int[a.length];
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(a[i]);
			//System.out.print(array[i]);
		}
		
		System.out.println(Inversions.count(array));

	}

}
