import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.*;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size;
	
	public Deque(){
		size = 0;
	}
	
	private class Node{
		Item item;
		Node next;
		Node previous;
	}
	
	/*
	 * returns true if there are no elements in the deque
	 * false, otherwise
	 */

	public boolean isEmpty(){
		return size == 0;
	}
	
	
	/*
	 * returns the number of elements in the deque
	 */
	
	public int size(){
		return size;
	}
	
	/*
	 * Adds to the front of a deque
	 * 
	 * throws a NullPointerException if a null item is added
	 */
	
	public void addFirst(Item item){
		if (item == null)
			throw new NullPointerException();
		Node node = new Node();
		node.item = item;
		node.previous = null;
		if (size == 0){
			first = node;
			last = node;
		}
		else {
			node.next = first;
			first.previous = node;
			first = node;
		}
		
		size++;
	}
	
	/*
	 * Adds an item to the end of the deque
	 * 
	 * Throws a NullPointerException if a null item is added
	 */
	
	public void addLast(Item item){
		if (item == null)
			throw new NullPointerException();
		Node node = new Node();
		node.item = item;
		
		if (size == 0){
			first = node;
			last = node;
		}
		else {
			last.next = node;
			node.previous = last;
			last = node;
		}
		
		size++;
	}
	
	/*
	 * Removes and returns the first item from the deque
	 * 
	 * throws a NoSuchElementException if the deque is empty
	 */
	public Item removeFirst(){
		if (size == 0)
			throw new NoSuchElementException();
		Item item = first.item;
		if (size == 1){
			first = null;
			last = null;
		}
		else {
			first = first.next;
			first.previous = null;
		}			
		size--;
		return item;			
	}
	
	/*
	 * Removes and returns the last item from the deque
	 * 
	 * throws a NoSuchElementExceptino if the deque is empty
	 */
	public Item removeLast(){
		if (size == 0)
			throw new NoSuchElementException();
		Item item = last.item;
		if (size == 1){
			first = null;
			last = null;
		}
		else {
			last = last.previous;
			last.next = null;
		}
		size--;
		return item;
	}
	
	private class DequeIterator implements Iterator<Item>{

		private Node node = first;

		public boolean hasNext() {
			return node != null;
		}

		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	public Iterator<Item> iterator(){
		return new DequeIterator();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Checking isEmpty(), size()
		/** 
		
		Deque<String> deque = new Deque<String>();
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		deque.addFirst("hello");
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		
		**/
		
		/**
		// Checking addFirst(), removeFirst()
		Deque<String> deque = new Deque<String>();
		//deque.addFirst(null);
		deque.addFirst("hello");
		deque.addFirst("world");
		
		deque.removeFirst();
		deque.removeFirst();
		deque.removeFirst();
		**/
		
		/**
		// Checking addLast(), removeLast()
		Deque<String> deque = new Deque<String>();
		//deque.addLast(null);
		deque.addLast("hello");
		deque.addLast("world");
		
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		**/
		
		/**
		//Testing the iterator
		Deque<String> deque = new Deque<String>();
		deque.addLast("my");
		deque.addLast("name");
		deque.addLast("is");
		deque.addLast("Vineet");
		
		Iterator<String> iterator = deque.iterator();
		//iterator.remove();
		
		while (iterator.hasNext()){
			System.out.print(iterator.next()+ " ");
		}
		iterator = deque.iterator();
		for (int i = 0; i < 2; i++){
			iterator.next();
		}
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		**/
	}


}
