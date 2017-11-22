import java.util.Scanner;

public class InfixToPostfix {
	private static Scanner sc;
	static StringBuilder result = new StringBuilder();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please enter expression");
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		transfer(input);
		System.out.println(result);

	}


	public static StringBuilder transfer(String input) {
		// TODO Auto-generated method stub
		Stack<String> operation = new Stack<>(); // 运算符栈
		Stack<String> number = new Stack<>(); //数据栈
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
		//	System.out.println(c);
			String expression = String.valueOf(c);
			if(expression.equals("(")) { //"("不比较直接入运算符栈
				operation.push(expression);
			}
			else if(isOperator(expression)) {
				while(!operation.isEmpty() && priority(expression) < priority(operation.peek()) ) {
					 // 当前的操作符小于等于栈顶操作符的优先级时，将栈顶操作符写入到后缀表达式，重复此过程
					number.push(operation.peek());
					operation.pop();	
				}
				 // 当前操作符栈为空或者当前操作符优先级大于栈顶操作符的优先级，将该操作符入栈
				operation.push(expression);
			}
			
			else if(expression.equals(")")) {
				// 遇到右括号将其对应左括号后的操作符（操作符栈中的）全部写入后缀表达式
				while(!operation.peek().equals("(")) {
					number.push(operation.peek());
					operation.pop();
				}
				operation.pop();
			}
			else {
				//数字入数字栈
				number.push(expression);
			}
			
		}
		
		while(!operation.isEmpty()) {
			number.push(operation.peek());
			operation.pop();
		}
		
		while(!number.isEmpty()) {
			operation.push(number.peek());
			number.pop();
		}
		while(!operation.isEmpty()) {
			result.append(operation.pop());
		}
		return result;
		
		
	}
	
	private static int priority(String expression) {
		switch(expression) {
		case "(" :
			return 0;
		case "+" :
		case "-" :
			return 1;
		case "*" :
		case "/" :
			return 2;
		default:
			return -1;
		
		}
	}


	public static boolean isOperator(String expression) {
		switch(expression) {
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
