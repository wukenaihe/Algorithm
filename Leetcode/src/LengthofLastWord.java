public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null){
			return 0;
		}
		int count=0;
		int l=s.length()-1;
		while(l>=0&&s.charAt(l)==' '){
			l--;
		}
		
		while(l>=0&&s.charAt(l--)!=' '){
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LengthofLastWord l=new LengthofLastWord();
		
		System.out.println(l.lengthOfLastWord("Hello World"));
		System.out.println(l.lengthOfLastWord("a b  "));

	}
}
