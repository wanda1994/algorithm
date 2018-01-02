import java.util.Scanner;

public class fourSum {
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter N:");
		N = sc.nextInt();
		System.out.println("please enter array a");
		long[] a = new long[N];
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		count(a);

	}

	private static void count(long[] a) {
		int count = 0;
		for(int i = 0; i < N; i++ ) {
			for (int j = i + 1; j < N; j++) {
				for(int k = j + 1; k < N; k++) {
					for(int l = k + 1; l < N; l++) {
						if(a[i] + a[j] + a[k] + a[l] == 0) {
							count++;
							System.out.println(a[i] + "+" + a[j] + "+" + a[k] + "+" + a[l] + "= 0");
						}
					}
				}
			}
		}
		System.out.println(count);
		
	}

}
