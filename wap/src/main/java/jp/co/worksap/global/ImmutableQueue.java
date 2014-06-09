package jp.co.worksap.global;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of
 * objects
 * 
 * @author Xu Minhua
 * 
 * @param <E>
 */
public class ImmutableQueue<E> {

	private List<E> elements;
	private int start;
	private int end;

	public ImmutableQueue() {
		elements = new ArrayList<E>();
		start = 0;
		end = 0;
	}

	private ImmutableQueue(List<E> list) {
		this.elements = list;
	}

	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2,1,2,2,6,4)
	 * and this object still represents the queue (2,1,2,2,6)
	 * </pre>
	 * 
	 * if the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 *            the element to add
	 * @return a ImmutableQueue<E> object that represents this object's elements
	 *         enqueue the argument
	 * @throws IllegalArgumentException
	 */
	public ImmutableQueue<E> enqueue(E e) {
		if (e == null) {
			throw new IllegalArgumentException("");
		}
		ImmutableQueue<E> r;

		// Share data, dequeue is hold just by one
		synchronized (elements) {
			if (elements.size() == end) {
				r = new ImmutableQueue<E>(elements);
				elements.add(e);
				r.start = start;
				r.end = end + 1;
				return r;
			}
		}

		List<E> copy = new ArrayList<E>(end - start + 1);
		for (int i = start; i < end; ++i) {
			copy.add(elements.get(i));
		}
		copy.add(e);
		r = new ImmutableQueue<E>(copy);
		r.start = 0;
		r.end = end - start + 1;
		return r;
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue. If this queue is empty, throws
	 * java.util.NoSuchElementException.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7,1,3,3,5,1),
	 * this method returns a new queue (1,3,3,5,1)
	 * and this object still represents the queue (7,1,3,3,5,1).
	 * </pre>
	 * 
	 * @return a ImmutableQueue<E> object that represents this object's elements
	 *         which remove the head of element
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue<E> dequeue() {
		if (end <= start) {
			throw new NoSuchElementException();
		}
		ImmutableQueue<E> r = new ImmutableQueue<E>(elements);
		r.start = start + 1;
		r.end = end;
		return r;
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7,1,3,3,5,1),
	 * this method returns 7 and this object still represents the queue (7,1,3,3,5,1).
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return the head of this queue
	 * @throws java.util.NoSuchElementException
	 */
	public E peek() {
		if (end <= start) {
			throw new NoSuchElementException();
		}
		return elements.get(start);
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return end - start;
	}

	/**
	 * Returns a string representation of this collection. The string
	 * representation consists of a list of the collection's elements in the
	 * order they are enqueued, enclosed in square brackets (<tt>"[]"</tt>).
	 * Adjacent elements are separated by the characters <tt>", "</tt> (comma
	 * and space). Elements are converted to strings as by
	 * {@link String#valueOf(Object)}.
	 * 
	 * @return a string representation of this collection
	 */
	public String toString() {
		if (end - start <= 0)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = start; i < end - 1; i++) {
			E e = elements.get(i);
			sb.append(e);
			sb.append(',').append(' ');
		}
		E last = elements.get(end - 1);
		sb.append(last);
		return sb.append(']').toString();
	}

}
