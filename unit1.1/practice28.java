import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class practice28 {
	public static void main(String[] args) {
		int[] a = {1,2,2,2,4,4,6,6,8,9,12};
		StdOut.println("the original array is: "+ Arrays.toString(a));
		int[] resultArray = deleteDupicate(a);
		StdOut.println("the result array is: " + Arrays.toString(resultArray));
	}

	private static int[] deleteDupicate(int[] a) {
		int n = a.length;
		int len = n;
		int[] copy = new int [n];
		for(int i = 0; i < n; i++) {
			copy[i] = a[i];
		}
		
		for(int i = 0; i < len; i++) {
			int repeatCount = 0;
			for(int j = i+1; j < len; j++) {
				if(copy[j] == copy[i]) {
					repeatCount++;
				}
				else 
					break;
			}
			if(repeatCount > 0) {
				for(int k = i+repeatCount+1; k < n; k++) {
					copy[k-repeatCount] = copy[k];
				}
				
			}
			len = len-repeatCount;
		}
		
		StdOut.println("len:"+len);
		int[] result = new int[len];
		for(int i = 0; i < len; i++) {
			result[i] = copy[i];
		}
		
		return result;


		
	}

}
