
public class QuickUnionUF {
	private int[] id;
	private int[] size;
	public int count;
	public QuickUnionUF(int N) {
		id = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
		for(int i = 0; i < N; i++) {
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	
	private int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	private boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i == j) {
			return;
		}
		else if(size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
			count--;
		}
		else {
			id[j] = i;
			size[i] += j;	
			count--;
		}
	}

}
