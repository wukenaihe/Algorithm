public class Candy {
	public int candy(int[] ratings) {
		int sum=0,num=0,l=ratings.length;
		if(l==0){
			return 0;
		}
		if(l==1){
			return 1;
		}
		
		int[] tags=new int[l];
		
		if(ratings[0]<=ratings[1]){
			tags[0]=1;
			sum++;
		}
		for(int i=1;i<l-1;++i){
			if(ratings[i]<=ratings[i-1]&&ratings[i]<=ratings[i+1]){
				tags[i]=1;
				sum+=1;
			}else if(ratings[i]>=ratings[i-1]&&ratings[i]<=ratings[i+1]){
				tags[i]=tags[i-1]+1;
				sum+=tags[i];
			}
		}
		if(ratings[l-1]<=ratings[l-2]){
			tags[l-1]=1;
			sum++;
		}else{
			tags[l-1]=tags[l-2]+1;
			sum+=tags[l-1];
		}
		
		for(int i=l-2;i>0;--i){
			if(tags[i]>0) continue;
			if(ratings[i]>=ratings[i+1]&&ratings[i]<=ratings[i-1]){
				tags[i]=tags[i+1]+1;
				sum+=tags[i];
			}else{
				tags[i]=Math.max(tags[i-1], tags[i+1])+1;
				sum+=tags[i];
			}
		}
		
		if(ratings[0]>ratings[1]){
			tags[0]=tags[1]+1;
			sum+=tags[0];
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		Candy c=new Candy();
		System.out.println(c.candy(new int[]{1,3}));
		System.out.println(c.candy(new int[]{1,0,2}));
		System.out.println(c.candy(new int[]{1,3,4,7,0,5,10}));

	}
}
