import java.util.Arrays;

public class MinDistance {
	public int minDistance(String word1, String word2) {
		int[][] num=new int[word1.length()+1][word2.length()+1];
		for(int i=0;i<=word1.length();++i){
			num[i][0]=i;
		}
		for(int i=0;i<=word2.length();++i){
			num[0][i]=i;
		}
		
		for(int i=1;i<=word1.length();++i){
			for(int j=1;j<=word2.length();++j){
				if (word1.charAt(i-1) == word2.charAt(j-1))
	                num[i][j] = num[i-1][j-1];
	            else
	                num[i][j] = min(num[i-1][j-1], num[i][j-1], num[i-1][j])+1;
			}
		}
		
		
		return num[word1.length()][word2.length()];
	}
	
	private int min(int a,int b,int c){
		int min=a;
		if(b<min){
			min=b;
		}
		if(c<min){
			min=c;
		}
		return min;
	}
	
	public static void main(String[] args) {
		MinDistance m=new MinDistance();
		
		System.out.println(m.minDistance("park", "spake"));
	}
}
