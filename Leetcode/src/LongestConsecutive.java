import java.util.Arrays;

public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
		Arrays.sort(num);
		int length=num.length,max=1,sum=1;
		for(int i=0;i<length-1;++i){
			if(num[i]==num[i+1]-1){
				sum++;
			}else if(num[i]==num[i+1]){
				continue;
			}else{
				if(sum>max){
					max=sum;
				}
				sum=1;
			}
		}
		if(sum>max){
			max=sum;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestConsecutive l=new LongestConsecutive();
		System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(l.longestConsecutive(new int[]{100}));
		System.out.println(l.longestConsecutive(new int[]{0,-1}));
		System.out.println(l.longestConsecutive(new int[]{1,2,0,1}));


	}
}
