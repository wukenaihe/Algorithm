package com.xumh.collection;

import java.util.Arrays;

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

	public ImmutableQueue(E element) {
		elements = new Object[] { element };
		size = 1;
	}

	public ImmutableQueue<E> enqueue(E e) {
		Object[] array = new Object[size + 1];
		System.arraycopy(elements, 0, array, 0, size);
		array[size]=e;
		return new ImmutableQueue<E>(array);
	}
	
	
	
	@Override
	public String toString() {
		return "ImmutableQueue [elements=" + Arrays.toString(elements) + "]";
	}

	public static void main(String[] args) {
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		
		System.out.println(q);
		
		q=q.enqueue(1);
		
		System.out.println(q);
	}

}
