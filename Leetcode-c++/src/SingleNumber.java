public class SingleNumber {
	public int singleNumber(int[] A) {
		int num=0;
		for (int i : A) {
			num^=i;
		}
		return num;
	}
	
	public static void main(String[] args) {
		SingleNumber s=new SingleNumber();
		System.out.println(s.singleNumber(new int[]{0,2,2,3,0}));
	}
}
