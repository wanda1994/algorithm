import java.util.Scanner;

public class evaluatePostfix {
	
	static InfixToPostfix formula = new InfixToPostfix();
	private static Scanner sc;
	static Stack<Double> value = new Stack<>();
	public static void main(String[] args) {
		System.out.println("please enter formula");
		sc = new Scanner(System.in);
		String input = sc.nextLine();
	    StringBuilder s = formula.transfer(input);
	    double result = calculate(s);
	    System.out.println(result);
	}

	private static double calculate(StringBuilder s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String character = String.valueOf(c);
			if(isOperator(character)) {
				operating(character);
			}
			else {
				value.push(Double.parseDouble(character));
			}
		}
		double result = value.pop();
		// TODO Auto-generated method stub
		return result;
	}

	private static void operating(String s) {
		Double val1 = value.pop();
		Double val2 = value.pop();
		switch(s) {
		case "+" :
			s = val1 + val2 + "";
			break;
			//value.push(Double.parseDouble(s));
		case "-" :
			s = val1 - val2 + "";
			break;
		case "*" :
			s = val1 * val2 + "";
			break;
		case "/" :
			s = val1 / val2 + "";
			break;
		
		}
		value.push(Double.parseDouble(s));
		
	}

	private static boolean isOperator(String s) {
		switch(s) {
		case "+" :
		case "-" :
		case "*" :
		case "/" :
			return true;
		default:
			return false;
		}
	}
	


	

}
