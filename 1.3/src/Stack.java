import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
	
	private Node first;
	private int N;
	
	
	private class Node<Item> {
		Item item;
		Node next;
	}
	public Stack() {
		first = null;
		N = 0;
		
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		if(isEmpty()) 
			throw new NoSuchElementException("Stack underflow");
		Item item = (Item) first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek() {
		if(isEmpty()) 
			throw new NoSuchElementException("Stack underflow");
		Item item = (Item) first.item;
		return item;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Item item : this) {
			s.append(item);
			s.append(" ");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator<Item> implements Iterator<Item> {
		Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			Item item = (Item) current.item;
			current = current.next;
			return item;
		}
		
	}

}
