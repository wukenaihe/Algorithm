package com.xumh.collections;

import java.util.concurrent.CountDownLatch;

public class ArrayCopy {
	public static int V=10000;
	public static <T>  T[] copy(T[] s,T[] t){
		int n=s.length;
		if(n<V){
			System.arraycopy(s, 0, t, 0, n);
		}else{
			int num=n/V;
			int i=0;
			CountDownLatch countDownLatch=new CountDownLatch(num+1);
			while(i<num){
				Copy<T> c=new Copy<T>(s,t,i*V,V,countDownLatch);
				new Thread(c).start();
				i++;
			}
			Copy<T> c=new Copy<T>(s,t,num*V,n-num*V,countDownLatch);
			new Thread(c).start();
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	public static class Copy<T> implements Runnable{
		T[] src;
		T[] target;
		int start;
		int length;
		private CountDownLatch countDownLatch;
		public Copy(T[] src,T[] target,int start,int length,CountDownLatch c){
			this.src=src;
			this.target=target;
			this.start=start;
			this.length=length;
			this.countDownLatch=c;
		}
		public void run() {
			System.arraycopy(src, start, target, start, length);
			countDownLatch.countDown();
		}
		
		
	}
}
