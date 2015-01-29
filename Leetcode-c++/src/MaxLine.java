import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxLine {
	Point ps[][] = new Point[100000][3];
	int num[] = new int[100000];
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
	
	private static class Line{
		double k;
		double b;
		
		public Line(double k,double b){
			this.k=k;
			this.b=b;
		}

		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(b);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(k);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
				return false;
			if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
				return false;
			return true;
		}
		
		
	}
	
	private Line getLine(Point p1,Point p2){
		int x=p1.x-p2.x;
		int y=p1.y-p2.y;
		double a,b;
		if(x==0){
			a=0;
		}else{
			a=y/x/1.0;
		}
		b=p1.y-a*p1.x;
		return new Line(a,b);
	}
	
	private boolean isInLine(Line l,Point p){
		if(Math.abs(p.y-l.k*p.x+l.b)<Double.MIN_VALUE){
			return true;
		}
		return false;
	}

	public int maxPoints(Point[] points) {
		if (points.length < 2) {
			return points.length;
		}
		int max = 1;
		Map<Line, Integer> lines=new HashMap<Line,Integer>();
		lines.put(getLine(points[0], points[1]), 1);
		for(int i=2;i<points.length;++i){
			for(int j=i-1;j>=0;--j){
				Line l=getLine(points[i], points[j]);
				Integer num=lines.get(l);
				if(num!=null){
					lines.put(l, num+1);
					if(max<num+1){
						max=num+1;
					}
				}else{
					lines.put(l, 1);
				}
			}
		}
		return getMax(max);
	}
	
	private int getMax(int num){
		int max=2;
		num=num*2;
		while(max*(max-1)!=num){
			max++;
		}
		return max;
	}


	public static void main(String[] args) {
		long cur = System.currentTimeMillis();
//		Point[] ps = new Point[] { new Point(0, 0), new Point(1, 1),
//				new Point(-1, -1),new Point(-1, -4),new Point(-1, -7) };
		Point[] ps = new Point[] { new Point(0, 0), new Point(1, 1),
				new Point(0, 0) };

		MaxLine mx = new MaxLine();
		int num = mx.maxPoints(ps);
		System.out.println(num);
		System.out.println(System.currentTimeMillis() - cur);

	}
}
