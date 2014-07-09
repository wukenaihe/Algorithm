package com.xumh.first;

public class Gcd {
	public static long gcd(long a,long b){
		return doGcd2(Math.max(a, b), Math.min(a, b));
	}
	private static long doGcd1(long a,long b){
		while(a%b!=0){
			long temp=b;
			b=a%b;
			a=temp;
		}
		return b;
	}
	
	private static long doGcd2(long a,long b){
		if(a<b){
			return doGcd2(b, a);
		}
		if(b==0){
			return a;
		}else{
			return doGcd1(a-b, b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(42,30));
	}
}
