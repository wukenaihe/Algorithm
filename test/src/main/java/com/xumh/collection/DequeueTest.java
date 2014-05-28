package com.xumh.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class DequeueTest {
	public static void main(String[] args) {
		Deque<Integer> q=new ArrayDeque<Integer>();
		
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q);
		
		System.out.println(q.peek());
		
		System.out.println(q);
		
		String s="hello";
		
		String s1=s.replace('h', 'w');
		
		System.out.println(s);
		System.out.println(s1);
		
	}
}
