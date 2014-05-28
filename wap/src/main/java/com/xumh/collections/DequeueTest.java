package com.xumh.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DequeueTest {
	public static void main(String[] args) {
		Deque<Integer> q = new ArrayDeque<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);

		System.out.println(q);

		System.out.println(q.peek());
		q.pop();

		System.out.println(q);

		String s = "hello";

		String s1 = s.replace('h', 'w');

		System.out.println(s);
		System.out.println(s1);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("a", "b");
		
		Collections.unmodifiableMap(map);
	}
}
