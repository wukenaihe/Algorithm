import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int length = s.length();
		int[] dp = new int[length];
		int max=0;
		for (int i = length - 2; i >= 0; --i) {
			char c = s.charAt(i);
			if (c == '(') {
				int j = i + 1 + dp[i + 1];

				if (j < length && s.charAt(j) == ')') {
					dp[i]=dp[i+1]+2;
					if(j+1<length){
						dp[i]+=dp[j+1];
					}
				}
				max=Math.max(max, dp[i]);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestValidParentheses l = new LongestValidParentheses();
		 System.out.println(l.longestValidParentheses("(()"));
		 System.out.println(l.longestValidParentheses("()(())"));
		 System.out.println(l.longestValidParentheses(")()())"));
		 System.out.println(l.longestValidParentheses("()(()"));
		System.out.println(l.longestValidParentheses("(()(((()"));
	}
}
