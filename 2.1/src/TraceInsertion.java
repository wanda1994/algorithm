import java.awt.Font;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

public class TraceInsertion {
	private static void sort(Comparable[] a) {
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
	
	private static void draw(Comparable[] a, int row, int ith, int min) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(-2.50, row, ith+" ");
		StdDraw.text(-1.25, row, min+" ");
		for(int i = 0; i < a.length; i++) {
			if(i == min) 
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else if (i < ith) 
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else 
				StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(i, row, a[i]+" ");
		}
		
	}
	
	private static void header(Comparable[] a) {
		int n = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n/2.0, -3, "a[ ]");       
        for (int i = 0; i < n; i++)
            StdDraw.text(i, -2, i + "");       
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "min");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, -1, (String) a[i]);
	}
	
	 private static void footer(Comparable[] a) {
	        int n = a.length;
	        StdDraw.setPenColor(StdDraw.BLACK);
	        for (int i = 0; i < n; i++)
	            StdDraw.text(i, n, (String) a[i]);
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] a = s.split(",");
		int n = a.length;
		StdDraw.setCanvasSize(30*(n+3), 30*(n+3));
        StdDraw.setXscale(-3, n+1);
        StdDraw.setYscale(n+1, -3);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));
        header(a);
        sort(a);
        footer(a);

	}

}
