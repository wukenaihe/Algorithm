public class Atoi {
	public int atoi(String str) {
		str=str.trim();
		int start=0;
		boolean negative=false;
		long l = 0;
		if(str.length()==0){
			return 0;
		}
		
		
		char first=str.charAt(0);
		if(first=='-'){
			negative=true;
			start=1;
		}else if(first=='+'){
			start=1;
		}
		
		int end=start;
		while(end<=str.length()-1){
			char c=str.charAt(end);
			if(c<='9'&&c>='0'){
				end++;
			}else{
				end--;
				break;
			}
		}
		end=end<str.length()?end:end-1;
		
		long position=1;
		while(end>=start){
			char numChar=str.charAt(end);
			int num=numChar-'0';
			l+=num*position;
			if(l>=Integer.MAX_VALUE&&!negative){
				return Integer.MAX_VALUE;
			}else if(negative&&l>Integer.MAX_VALUE){
				return Integer.MIN_VALUE;
			}
			position*=10;
			end--;
		}
		if(negative){
			return (int)-l;
		}else{
			return (int)l;
		}
	
	}
	
	public static void main(String[] args) {
		Atoi a=new Atoi();
		System.out.println(a.atoi("    10522545459"));
	}
}
