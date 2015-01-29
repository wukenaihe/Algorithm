
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int i=0,j=height.length-1;
		if(j<=0) return 0;
		int max=0;
		while(i<j){
			if(height[i]<=height[j]){
				max=Math.max(max, height[i]*(j-i));
				i++;
			}else{
				max=Math.max(max, height[j]*(j-i));
				j--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater c=new ContainerWithMostWater();
		System.out.println(c.maxArea(new int[]{1,2,1,3}));
	}
}
