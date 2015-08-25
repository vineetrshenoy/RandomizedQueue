import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class StackLL<Item> implements Iterable<Item>{

	private Node<Item> first;
	private int size;
	
	public StackLL(){
		first=null;
		size=0;
		
	}
	
	private class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node<Item> current=first;
		
		public boolean hasNext(){
			return current!=null;
		}

		public Item next() {
			if(!hasNext())
				throw new NoSuchElementException();
			
			Item item=current.item;
			current=current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
			
		}
				
	}
	
	
	
	public void push(Item t){
		Node<Item> node=new Node<Item>();
		node.item=t;
		node.next=first;
		first=node;
		size++;
	}
	
	public Item pop() throws NullPointerException{
		if(first==null)
			throw new NullPointerException();
		Item item=first.item;
		first=first.next;
		size--;
		return item;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return size;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLL<Integer> stack=new StackLL<Integer>();
		Iterator<Integer>iterator=stack.iterator();
		System.out.print(iterator.hasNext());
	}
	

}
