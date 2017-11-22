import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
	
	private Item[] q;
	private int N;
	private int first;
	private int last;
	
	public ResizingArrayQueue() {
		q = (Item[]) new Object[2];
		N = 0;
		first = 0;
		last = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void resize(int capacity) {
		assert capacity >= N;
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = q[(i + first) % q.length];
		}
		q = copy;
		first = 0;
		last = N;
	}
	
	public void enqueue(Item item) {
		if(N == q.length) {
			resize(2 * q.length);
		}
		q[last++] = item;
		if(last == q.length) {
			last = 0;
		}
		N++;
		
	}
	
	public Item dequeue() {
		Item item = q[first];
		q[first] = null;
		first ++;
		N--;
		if(first == q.length) {
			first = 0;
		}
		if(N > 0 && N < q.length/4) {
			resize(q.length / 2);
		}
		return item;
	}
	
	public Item peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("stack overflow");
		}
		Item item = q[first];
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	private class ArrayIterator<Item> implements Iterator<Item> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			Item item = (Item) q[(i+first) % q.length];
			i++;

			return item;
		}
		
	}

}
