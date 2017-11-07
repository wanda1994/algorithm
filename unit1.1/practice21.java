import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class practice21 {
	public void main(String[] args) {
        In in  = new In("se");
		String[] list = in.readAllStrings();
		for(int i = 0; i < list.length; i = i+3) {
			StdOut.print(list[i] + list[i+1] + list[i+2]);
			double m = Double.parseDouble(list[i+1]);
			double n = Double.parseDouble(list[i+2]);
			StdOut.printf("%0.3", m/n);
			StdOut.println();
		}
		
	}

}
