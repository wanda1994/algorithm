import java.util.Scanner;

import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
	private static int N;

	public static void main(String[] args) {
		System.out.println("please enter N");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println("please enter trails");
		int trials = sc.nextInt();
		int[] edges = new int[trials];
		for(int i = 0; i < trials; i++) {
			edges[i] = count(i);
		}

	}

	private static int count(int i) {
		int edges = 0;
		QuickUnionUF uf = new QuickUnionUF(i);
		while(uf.count >= 1) {
			int k = StdRandom.uniform(N);
			int j = StdRandom.uniform(N);
			uf.union(k, j);
			edges++;
			}
		return edges;
		}

}
