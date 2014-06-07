import java.util.Stack;

public class AddBinary {
	public String addBinary(String a, String b) {
		int l1=a.length();
		int l2=b.length();
		if(l1<l2){
			String t=a;
			a=b;
			b=t;
		}
		l1=a.length();
		l2=b.length();
		char[] as=a.toCharArray();
		char[] bs=b.toCharArray();
		
		
		int[] ais=new int[l1];
		int[] bis=new int[l2];
		int j=0;
		for(int i=l1-1;i>=0;--i){
			ais[j++]=as[i]-'0';
		}
		
		j=0;
		for(int i=l2-1;i>=0;--i){
			bis[j++]=bs[i]-'0';
		}
		
		for(int i=0;i<l2;++i){
			ais[i]+=bis[i];
		}
		Stack<Integer> q=new Stack<Integer>();
		for(int i=0;i<l1-1;++i){
			int n=ais[i];
			ais[i+1]+=n/2;
			q.push(n%2);
		}
		int n=ais[l1-1];
		while(n>1){
			q.add(n%2);
			n=n/2;
		}
		q.add(n);
		
		StringBuilder sb=new StringBuilder();
		while(!q.isEmpty()){
			sb.append(q.pop());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		AddBinary a=new AddBinary();
		System.out.println(a.addBinary("1", "111"));
	}
}
