import java.util.Scanner;

public class test {
	public static void main() {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String s = scanner.next();
			System.out.println(Double.parseDouble(s));
		}
	}

}
