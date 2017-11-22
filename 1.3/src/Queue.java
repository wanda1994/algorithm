import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>{
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) {
			first = last;
		}
		else {
			oldlast.next = last;
		}
		N++;
	}
	
	public Item dequeue() {
		Item item = (Item) first.item;
		first = first.next;
		if(isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	public static void main(String[] args) {
		
		Queue<String> q = new Queue<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				q.enqueue(item);
			}
			else if(!q.isEmpty()) {
				StdOut.print(q.dequeue() + " ");
			}
		}
		StdOut.println("(" + q.size() + "left on queue)");
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		
		Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = (Item) current.item;
			current = current.next;
			return item;
		}
		
	}

}
