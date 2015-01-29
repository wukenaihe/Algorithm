
public class ReverseWordsString {
	public String reverseWords(String s) {
        if(s==null){
            return s;
        }
        s=s.trim();
        int left=0,right=0;
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;--i){
            if(i!=s.length()-1&&s.charAt(i)==' '&&s.charAt(i)==s.charAt(i+1)) continue;
            sb.append(s.charAt(i));
        }
        
        while(right<sb.length()){
            while(right<sb.length()&&sb.charAt(right)!=' ') right++;
            int next=right;
            right-=1;
            while(left<right){
                char c=sb.charAt(left);
                sb.setCharAt(left++,sb.charAt(right));
                sb.setCharAt(right--,c);
            }
            left=next+1;
            right=next+1;
            
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		ReverseWordsString r=new ReverseWordsString();
		
		System.out.println(r.reverseWords(" the  sky is blue "));
	}
}
