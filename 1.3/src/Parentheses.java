import java.util.Scanner;
import java.util.Stack;

public class Parentheses {

	public static void main(String[] args) {
		boolean isPaired = true;
		Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			Stack<String> parentheses = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				char item = s.charAt(i);
				String stream = String.valueOf(item);
			
			if(stream.equals("(")) {
				parentheses.push(stream);
			}
			else if(stream.equals("{")) {
				parentheses.push(stream);
			}
			else if(stream.equals("[")) {
				parentheses.push(stream);
			}
			else if(stream.equals(")")) {
				String popedParentheses = parentheses.pop();
				System.out.println(popedParentheses);
				if(!popedParentheses.equals("(")) {
					isPaired = false;
					break;
				}

			}
			else if(stream.equals("]")) {
				String popedParentheses = parentheses.pop();
				if(!popedParentheses.equals("[")) {
					isPaired = false;
					break;
				}

			}
			else if(stream.equals("}")) {
				String popedParentheses = parentheses.pop();
				if(!popedParentheses.equals("{")) {
					isPaired = false;
					break;
				}

			}
			
		}
		
		System.out.println(isPaired);



	}
	
}
