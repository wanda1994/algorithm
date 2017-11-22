import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		System.out.println("please enter N and M:");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> deadSeq = new Queue<>();
		for(int i = 0; i < N; i++) {
			deadSeq.enqueue(i);
		}
		while(!deadSeq.isEmpty()) {
			for(int i = 0; i < M-1; i++) {
				deadSeq.enqueue(deadSeq.dequeue());
			}
			
			System.out.println(deadSeq.dequeue());
		}

	}

}
