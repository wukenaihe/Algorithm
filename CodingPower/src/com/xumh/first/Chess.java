package com.xumh.first;

public class Chess {
	public static void chessPostion(int n){
		for(int i=1;i<=n*n;++i){
			for(int j=1;j<=n*n;++j){
				int result=Math.abs(i-j)%n;
				if(result!=0){
					System.out.println("A="+i+"  B="+j);
				}
			}
		}
		
	}
	
	public static void chessChar(){
		char a=81;
		while(a-->0){
			if(a/9%3!=a%9%3){
				System.out.println("A="+(a/9+1)+"  B="+(a%9+1));
			}
		}
	}
	
	public static void chessByte(){
		int a;
		for(a=1;(a&15)<=9;a++){
			for(a= ((a&15)|16);((a&240)>>4)<=9;a=a+16){
				if((a&15)%3!=((a&240)>>4)%3){
					System.out.println("A="+(a&15)+" B="+((a&240)>>4));
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		chessPostion(3);
//		System.out.println();
//		chessChar();
		chessByte();
	}
}
