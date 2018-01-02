import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class Transaction implements Comparable<Transaction> {
	private final double amount;
	private final String who;
	private final Date when;
	
	
	public Transaction(double amount, String who, Date when) {
		this.amount = amount;
		this.who = who;
		this.when = when;
	}
	
	public Transaction(String s) {
		String[] a = s.split(",");
		who = a[0];
		when = new Date(a[1]);
		amount = Double.parseDouble(a[2]);
	}
	
	public String who() {
		return who;
	}
	
	public Date when() {
		return when;
	}
	
	public double amount() {
		return amount;
	}
	
	public String toString() {
		return String.format("%-10s, %10s, %8.2f", who, when, amount);
	}

	

	@Override
	public int compareTo(Transaction that) {
		return Double.compare(this.amount, that.amount);
	}
	
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (this.getClass() != other.getClass())
			return false;
		Transaction that = (Transaction) other;
		return (this.amount == that.amount) && (this.when == that.when) && (this.who == that.who);
	}
	
	public int hashCode() {
		int hash = 1;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double) amount).hashCode();
		return hash;
	}
	
	public static class whoOrder implements Comparator<Transaction> {

		@Override
		public int compare(Transaction v, Transaction w) {
			return v.who.compareTo(w.who);
		}
		
	}
	
	public static class whenOrder implements Comparator<Transaction> {

		@Override
		public int compare(Transaction v, Transaction w) {
			return v.when.compareTo(w.when);
		}
		
	}
	
	public static class orderByAmount implements Comparator<Transaction> {

		@Override
		public int compare(Transaction v, Transaction w) {
			return Double.compare(v.amount, w.amount);
		}
		
	}
	
	public static void main(String[] args) {
		Transaction[] a = new Transaction[4];
        a[0] = new Transaction("Turing,6/17/1990,644.08");
        a[1] = new Transaction("Tarjan,3/26/2002,4121.85");
        a[2] = new Transaction("Knuth,6/14/1999,288.34");
        a[3] = new Transaction("Dijkstra,8/22/2007,2678.40");
        
        StdOut.println("Unsorted");
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
        StdOut.println("Sorted by customer");
        Arrays.sort(a, new Transaction.whoOrder());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
        StdOut.println("Sorted by date");
        Arrays.sort(a, new Transaction.whenOrder());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
        StdOut.println("Sorted by customer");
        Arrays.sort(a, new Transaction.orderByAmount());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();


	}

}
