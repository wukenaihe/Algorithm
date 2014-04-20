import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyOfMaxLine {
	private static class Point {

		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	
	public int maxPoints(Point[] points) {
		if (points.length <= 2) {
			return points.length;
		}
		int max=2;
		for(int i=0;i<points.length-1;++i){
			Map<Double, Integer> lines=new HashMap<>();
			Point p=points[i];
			int same=0;
			int maxLine=1;
			for(int j=i+1;j<points.length;++j){
				Point p1=points[j];
				Double d;
				if(p.x==p1.x&&p.y==p1.y){
					same++;
					continue;
				}else if(p.x==p1.x){
					d=Math.PI;
				}else{
					d=new Double((double)(points[i].y-points[j].y) / (double)(points[i].x-points[j].x));
					if(d==-0.0){
						d=0.0;
					}
				}
				
				Integer num=lines.get(d);
				if(num==null){
					lines.put(d, 2);
					if(maxLine<2){
						maxLine=2;
					}
				}else{
					lines.put(d, num+1);
					if(maxLine<num+1){
						maxLine=num+1;
					}
				}
			}
			max=max>maxLine+same?max:maxLine+same;
		}
		return max;
	}


	public static void main(String[] args) {
		long cur = System.currentTimeMillis();
//		Point[] ps = new Point[] { new Point(0, 0), new Point(1, 1),
//				new Point(-1, -1),new Point(-1, -4),new Point(-1, -7) };
		Point[] ps = new Point[] { new Point(1, 1), new Point(1, 1),
				new Point(1, 1) };

		CopyOfMaxLine mx = new CopyOfMaxLine();
		int num = mx.maxPoints(ps);
		System.out.println(num);
		System.out.println(System.currentTimeMillis() - cur);

	}
}
