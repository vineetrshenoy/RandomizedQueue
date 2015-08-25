import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class StackArray<T> implements Iterable<T> {

	private Object [] array;
	private int n;
	
	public StackArray(){
		array=(T[])new Object[1];
		n=0;
	}
	
	private void resize(int capacity){
		T[] temp= (T[]) new Object[capacity];
		for(int i=0;i<array.length;i++)
			temp[i]=(T)array[i];
		array=temp;
	}
	
	public boolean isEmpty(){
		return n<0;
	}
	
	public void push(T item){
		if(n==array.length)
			this.resize(array.length*2);
		array[n]=item;
		n++;
	}
	
	public T pop(){
		if(!isEmpty())
			throw new NoSuchElementException();
		T item=(T) array[n];
		n--;
		return item;
		
	}
	
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	

	

}
