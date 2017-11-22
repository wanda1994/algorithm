import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*Dijkstra˫ջ�㷨           */
public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		String in = scanner.next();
		char[] arr = in.toCharArray(); 
		for(char c : arr) {
			String s = String.valueOf(c);
			if (s.equals("("));
			else if(s.equals("+"))
				ops.push(s);
			else if(s.equals("-"))
				ops.push(s);
			else if(s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")) {
					v = vals.pop()+v;
				}
				else if(op.equals("-")) {
					v = vals.pop() - v;
				}
				vals.push(v);
			}
			else
				vals.push(Double.parseDouble(s));
		}
		
		StdOut.print(vals.pop());
		// TODO Auto-generated method stub

	}

}
