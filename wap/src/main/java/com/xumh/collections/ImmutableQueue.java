package com.xumh.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of objects
 * 
 * @author xumh
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

	public ImmutableQueue(Object[] elements) {
		this.elements = elements;
		size = elements.length;
	}

	public ImmutableQueue<E> enqueue(E e) {
		if(e==null){
			throw new IllegalArgumentException("");
		}
		Object[] array = new Object[size + 1];
		System.arraycopy(elements, 0, array, 0, size);
		array[size]=e;
		return new ImmutableQueue<E>(array);
	}
	
	public ImmutableQueue<E> dequeue(){
		if(size==0){
			throw new NoSuchElementException();
		}
		Object[] array=Arrays.copyOfRange(elements, 1, size);
		return new ImmutableQueue<E>(array);
	}
	
	public E peek(){
		if(size==0){
			throw new NoSuchElementException();
		}
		return (E) elements[0];
	}
	
	public int size(){
		return this.size;
	}
	
	@Override
	public String toString() {
		return "ImmutableQueue [elements=" + Arrays.toString(elements) + "]";
	}

	public static void main(String[] args) throws IllegalAccessException {
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		
		System.out.println(q);
		
		q=q.enqueue(1);
		q=q.enqueue(2);
		q=q.enqueue(3);
		
		System.out.println(q+"  "+q.size());
		q=q.dequeue();
		q=q.dequeue();
		System.out.println(q+"  "+q.size());
		System.out.println(q.peek());
	}

}
