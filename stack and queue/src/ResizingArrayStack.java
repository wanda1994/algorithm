import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	private Item[]a = (Item[]) new Object[1];
	private int N;
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		if(N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			copy[i] = a[i];
		}
		a = copy;	
	}
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		
		int i = N;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
		
	}

}
