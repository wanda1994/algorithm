import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class SortTransaction {
	public static Transaction[] readTransaction() {
		Queue<Transaction> queue = new Queue<>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			Transaction transaction = new Transaction(line);
			queue.enqueue(transaction);
		}
		int n = queue.size();
		Transaction[] transactions = new Transaction[n];
		for(int i = 0; i < n; i++) {
			transactions[i] = queue.dequeue();
		}
		return transactions;
		
	}

	public static void main(String[] args) {
		Transaction[] transactions = readTransaction();
		Arrays.sort(transactions);
		for(int i = 0; i < transactions.length; i++) {
			StdOut.println(transactions[i]);
		}
		

	}

}
