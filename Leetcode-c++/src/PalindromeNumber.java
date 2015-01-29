public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		int num1=x;
		int num2=0;
		while(num1!=0){
			num2=num2*10+num1%10;
			num1/=10;
		}
		return num2==x;
	}
	
	public static void main(String[] args) {
		PalindromeNumber p=new PalindromeNumber();
		System.out.println(p.isPalindrome(111));
		System.out.println(p.isPalindrome(123));
		System.out.println(p.isPalindrome(123321));
	}
}
