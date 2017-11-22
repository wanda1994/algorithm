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
		Stack<String> operation = new Stack<>(); // �����ջ
		Stack<String> number = new Stack<>(); //����ջ
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
		//	System.out.println(c);
			String expression = String.valueOf(c);
			if(expression.equals("(")) { //"("���Ƚ�ֱ���������ջ
				operation.push(expression);
			}
			else if(isOperator(expression)) {
				while(!operation.isEmpty() && priority(expression) < priority(operation.peek()) ) {
					 // ��ǰ�Ĳ�����С�ڵ���ջ�������������ȼ�ʱ����ջ��������д�뵽��׺���ʽ���ظ��˹���
					number.push(operation.peek());
					operation.pop();	
				}
				 // ��ǰ������ջΪ�ջ��ߵ�ǰ���������ȼ�����ջ�������������ȼ������ò�������ջ
				operation.push(expression);
			}
			
			else if(expression.equals(")")) {
				// ���������Ž����Ӧ�����ź�Ĳ�������������ջ�еģ�ȫ��д���׺���ʽ
				while(!operation.peek().equals("(")) {
					number.push(operation.peek());
					operation.pop();
				}
				operation.pop();
			}
			else {
				//����������ջ
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
