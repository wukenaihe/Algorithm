import java.util.Arrays;

public class Distinct {
	public int numDistinct(String S, String T) {
		if(S.length()<T.length()){
			return 0;
		}
		int[] f1=new int[S.length()];
		int[] f2=new int[S.length()];
		Arrays.fill(f1, 1);
		for(int i=0;i<T.length();++i){
			for(int j=i;j<S.length();++j){
				if(T.charAt(i)==S.charAt(j)){
					if(j-1<0){
						f2[j]=1;
					}else{
						f2[j]=f1[j-1]+f2[j-1];
					}
				}else{
					if(j-1<0){
						f2[j]=0;
					}else{
						f2[j]=f2[j-1];
					}
				}
			}
			f1=Arrays.copyOf(f2, f1.length);
			Arrays.fill(f2, 0);
		}
		
		return f1[S.length()-1];
	}
	
	public static void main(String[] args) {
		Distinct d=new Distinct();
		System.out.println(d.numDistinct("ABCDE", "ACE"));
		System.out.println(d.numDistinct("rabbbit", "rabbit"));
		System.out.println(d.numDistinct("ABCDE", "AEC"));
		System.out.println(d.numDistinct("b", "a"));
		System.out.println(d.numDistinct("ccc", "c"));
	}
}
