public class CountAndSay {
	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append('1');

		for (int i = 1; i < n; ++i) {
			int length = sb.length();
			StringBuilder temp = new StringBuilder();
			int j = 0;
			while (j < length) {
				char str = sb.charAt(j);
				int num=1;
				j++;
				while(j<length){
					char t=sb.charAt(j);
					if(t==str){
						num++;
						j++;
					}else{
						break;
					}
				}
				temp.append(toS(num, str));
			}
			sb = temp;
		}

		return sb.toString();
	}
	
	private String toS(int num,char str){
		return num+""+str;
	}

	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		for (int i = 1; i < 10; i++) {
			System.out.println(c.countAndSay(i));
		}
	}
}
