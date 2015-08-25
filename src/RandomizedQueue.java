import java.util.Iterator;
import java.util.*;
import java.util.NoSuchElementException;




public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item [] array;
	private int N;
	
	public RandomizedQueue(){
		array = (Item[]) new Object [2];
		N = 0;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int capacity){
		if (capacity <= 0)
			throw new IllegalArgumentException();
		Item [] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++)
			temp[i] = array[i];
		array = temp;
	}
	
	public void enqueue(Item item){
		if (item == null)
			throw new NullPointerException();
		if (N == array.length)
			this.resize(2*array.length);
		array[N++] = item;
	}
	
	public Item dequeue(){
		if (N == 0)
			throw new NoSuchElementException();
		int i = StdRandom.uniform(N);
		N--;
		Item item = array[i];
		array[i] = array[N];
		array[N] = null;
		if (N == array.length/4)
			this.resize(array.length/2);
		return item;
			
	}
	
	public Item sample(){
		if (N == 0)
			throw new NoSuchElementException();
		int i = StdRandom.uniform(N);
		Item item=array[i];
		return item;
				
	}
	
	
	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new rqIterator();
	}
	
	private class rqIterator implements Iterator<Item>{

		Item[] temp;
		int count;
		
		private rqIterator(){
			temp = (Item[]) new Object[N];
			StdRandom.shuffle(array, 0, N-1);
			for (int i = 0; i < N; i++)
				temp[i] = array[i];
			count = 0;
		}
		

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count != temp.length;
		}

		public Item next() {
			// TODO Auto-generated method stub
			if (count == temp.length)
				throw new NoSuchElementException();
			Item item = temp[count++];
			return item;
			
		}

		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		/**
		
		System.out.println(rq.isEmpty());
		System.out.println(rq.size());
		rq.enqueue("hello");
		System.out.println(rq.isEmpty());
		System.out.println(rq.size());
		**/
		
		//rq.enqueue(null);
		
		rq.enqueue("my");
		rq.enqueue("name");
		rq.enqueue("is");
		rq.enqueue("Vineet");
		rq.enqueue("Shenoy");
		
		System.out.println();
		
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		//System.out.println(rq.dequeue());
		
	
		/**
		Iterator<String> iteratorOne = rq.iterator();
		//iteratorOne.remove();
		System.out.println("ITERATOR ONE");
		while (iteratorOne.hasNext())
			System.out.println(iteratorOne.next());
		Iterator<String> iteratorTwo = rq.iterator();
		System.out.println("ITERATOR TWO");
		while (iteratorTwo.hasNext())
			System.out.println(iteratorTwo.next());
		**/
	}

	

	

	
}
