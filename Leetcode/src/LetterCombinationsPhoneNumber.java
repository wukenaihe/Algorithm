import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	private String[][] chars=new String[][]{
		{""},
		{""},
		{"a","b","c"},
		{"d","e","f"},
		{"g","h","i"},
		{"j","k","l"},
		{"m","n","o"},
		{"p","q","r","s"},
		{"t","u","v"},
		{"w","x","y","z"}
	};
	
	public List<String> letterCombinations(String digits) {
		List<String> result=new ArrayList<String>();
		if(digits.length()==0){
			result.add("");
			return result;
		}else if(digits.length()==1){
			result.addAll(Arrays.asList(chars[Integer.valueOf(digits)]));
			return result;
		}
		List<String> list=letterCombinations(digits.substring(1));
		String[] thisDigit=chars[digits.charAt(0)-'0'];
		for (String string : thisDigit) {
			for (String str : list) {
				result.add(string+str);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinationsPhoneNumber l=new LetterCombinationsPhoneNumber();
		System.out.println(l.letterCombinations("23"));
	}
}
