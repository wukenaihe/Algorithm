

public class Palindrome {
	public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        int start=0;
        int end=s.length()-1;
        int dif='a'-'A';
        while(start<end){
            while(start<end&&!isAlp(s.charAt(start))){
                start++;
            }
            while(start<end&&!isAlp(s.charAt(end))){
                end--;
            }
            if(start>=end){
                return true; 
            }
            int diff=s.charAt(start)-s.charAt(end);
            //判断不是回文的唯一条件就是他们不相等。
            if(diff!=0&&diff!=dif&&diff!=-dif){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean isAlp(char c){
        if((c<='z'&&c>='a')||(c>='A'&&c<='Z')||(c<='9'&&c>='0')){
            return true;
        }else{
            return false;
        }
    }
	
	public static void main(String[] args) {
		Palindrome p=new Palindrome();
		
//		System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(p.isPalindrome("race a car"));
		System.out.println(p.isPalindrome("1a2"));
		System.out.println(p.isPalindrome("a."));
	}
}
