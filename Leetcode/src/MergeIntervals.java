import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result=new ArrayList<Interval>();
		int l=intervals.size();
		if(l==0){
			return result;
		}
		
		Collections.sort(intervals, new Compare());
		Interval last=intervals.get(0);
		result.add(last);
		for(int i=1;i<l;++i){
			Interval a=intervals.get(i);
			
			if(a.start>last.end){
				result.add(a);
				last=a;
			}else if(a.start<=last.end&&a.end>last.end){
				last.end=a.end;
			}
		}
		
		return result;
	}
	
	public static class Compare implements Comparator<Interval>{

		public int compare(Interval o1, Interval o2) {
			return o1.start-o2.start;
		}
		
	}
	
	public static void main(String[] args) {
		MergeIntervals m=new MergeIntervals();
		
		Interval i1=new Interval(1, 3);
		Interval i2=new Interval(2, 6);
		Interval i3=new Interval(8, 10);
		Interval i4=new Interval(15, 18);
		
		List<Interval> list=new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		
		System.out.println(m.merge(list));
	}
	
}
