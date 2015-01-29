public class Candy {
	public int candy(int[] ratings) {
        int[] nums=new int[ratings.length];
        nums[0]=1;
        for(int i=1;i<ratings.length;++i){
            if(ratings[i-1]<ratings[i]){
                nums[i]=nums[i-1]+1;
            }else{
                nums[i]=1;
            }
        }
        
        int res=nums[ratings.length-1];
        for(int i=ratings.length-2;i>=0;--i){
            int cur=0;
            if(ratings[i]>ratings[i+1]&&nums[i]<=nums[i+1]){
                nums[i]=nums[i+1]+1;
            }
            res+=nums[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		Candy c=new Candy();
		System.out.println(c.candy(new int[]{1,3}));
		System.out.println(c.candy(new int[]{1,0,2}));
		System.out.println(c.candy(new int[]{1,3,4,7,0,5,10}));

	}
}
