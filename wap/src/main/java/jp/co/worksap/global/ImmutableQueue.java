package jp.co.worksap.global;

import java.util.Arrays;
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

	private final Object[] elements;
	private final int size;

	public ImmutableQueue() {
		elements = new Object[] {};
		size = 0;
	}

	private ImmutableQueue(final Object[] elements) {
		this.elements = elements;
		size = elements.length;
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
		Object[] array = new Object[size + 1];
		System.arraycopy(elements, 0, array, 0, size);
		array[size] = e;
		return new ImmutableQueue<E>(array);
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
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Object[] array = Arrays.copyOfRange(elements, 1, size);
		return new ImmutableQueue<E>(array);
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
	@SuppressWarnings("unchecked")
	public E peek() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return (E) elements[0];
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
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
		if (size == 0)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size - 1; i++) {
			@SuppressWarnings("unchecked")
			E e = (E) elements[i];
			sb.append(e);
			sb.append(',').append(' ');
		}
		@SuppressWarnings("unchecked")
		E last = (E) elements[size - 1];
		sb.append(last);
		return sb.append(']').toString();
	}

}
