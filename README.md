# RandomizedQueue

Implementing a double-ended queue (deque) and a randomized queue using arrays, linked lists, generics, and iterators, with a special focus on amortized runtime. This assignment was created for Coursera's "Algorithms I" hosted by Princeton University. The official assignment specification can be found here: http://coursera.cs.princeton.edu/algs4/assignments/queues.html

The deque supports added and removing at both ends. The API is as follows:

      public class Deque<Item> implements Iterable<Item> {
      public Deque()                           // construct an empty deque
      public boolean isEmpty()                 // is the deque empty?
      public int size()                        // return the number of items on the deque
      public void addFirst(Item item)          // add the item to the front
      public void addLast(Item item)           // add the item to the end
      public Item removeFirst()                // remove and return the item from the front
      public Item removeLast()                 // remove and return the item from the end
      public Iterator<Item> iterator()         // return an iterator over items in order from front to end
      public static void main(String[] args)   // unit testing
      }


The Randomized queue functions like a normal queue, except that dequeue() selects an element at random to remove. The API is as follows:

  

    public class RandomizedQueue<Item> implements Iterable<Item> {
       public RandomizedQueue()                 // construct an empty randomized queue
       public boolean isEmpty()                 // is the queue empty?
       public int size()                        // return the number of items on the queue
       public void enqueue(Item item)           // add the item
       public Item dequeue()                    // remove and return a random item
       public Item sample()                     // return (but do not remove) a random item
       public Iterator<Item> iterator()         // return an independent iterator over items in random order
       public static void main(String[] args)   // unit testing
    }

This assignment was completed on July 2, 2015

  
