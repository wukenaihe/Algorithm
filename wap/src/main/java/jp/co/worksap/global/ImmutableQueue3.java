package jp.co.worksap.global;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ImmutableQueue3<E> {

	private final Object[] elements;
	
	public ImmutableQueue3() {
		elements = null;
	}
	
	private ImmutableQueue3(final E[] es) {
		this.elements = es;
	}
	
	public ImmutableQueue3<E> enqueue(E e) {
		int len = size();
		Object[] es;
		if (len == 0) {
			es = new Object[1];
		} else {
			es = Arrays.copyOf(elements, len + 1);			
		}
		es[len] = e;
		return new ImmutableQueue3<E>((E[]) es);
	} 
	
	public ImmutableQueue3<E> dequeue() {
		int len = size();
		if (len == 0) {
			throw new NoSuchElementException();
		} else {
			Object[] es = Arrays.copyOfRange(elements, 1, len);
			return new ImmutableQueue3<E>((E[]) es);
		}
	}
	
	public E peek() {
		int len = size();
		if (len == 0) {
			throw new NoSuchElementException();
		} else {
			return (E) elements[0];
		}
	}
	
	public int size() {
		if (elements == null) {
			return 0;
		} else {
			return elements.length;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder("[");
		for (int i = 0; i != elements.length; i++) {
			if (i != 0) {
				out.append(",");
			}
			out.append(elements[i]);
		}
		out.append("]");
		return out.toString();
	}
	
}
