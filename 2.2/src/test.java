
public class test {

	public static void main(String[] args) {
		String a = "1,2,3,4,5,6";  
		String str[] = a.split(",");  
		int array[] = new int[str.length];  
		for(int i=0;i<str.length;i++){  
	     array[i]=Integer.parseInt(str[i]); 
	     System.out.print(array[i]);

	}}

}
