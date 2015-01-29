import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
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

		public String toString() {
			return "[" + start + ", " + end + "]";
		}

	}

	int length;
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		int[] temps = new int[intervals.size() * 2 + 2];
		int p1, p2;
		int i = 0;
		for (Interval interval : intervals) {
			temps[i++] = interval.start;
			temps[i++] = interval.end;
		}
		length=intervals.size() * 2;
		p1 = insert(temps, newInterval.start);
		p2 = insert(temps, newInterval.end);

		ArrayList<Interval> result = new ArrayList<Interval>();


		Interval n = new Interval();
		if (p1 % 2 != 0) {
			p1=p1-1;
		}
		n.start=temps[p1];
		
		for(int k=0;k<p1;){
			result.add(new Interval(temps[k],temps[k+1]));
			k+=2;
		}
		int a = length - p2 - 1;
		if (a % 2 != 0) {
			p2=p2+1;
		}
		n.end=temps[p2];
		result.add(n);
		
		for(int k=p2+1;k<length;){
			result.add(new Interval(temps[k],temps[k+1]));
			k+=2;
		}


		return result;
	}

	public int insert(int[] A, int num) {
		int i;
		if (length == 0) {
			A[0] = num;
			length++;
			return 0;
		}
		for (i = 0; i < length; ++i) {
			if (A[i] == num) {
				return i;
			} else if (A[i] > num) {
				for (int j = length; j > i; --j) {
					A[j] = A[j - 1];
				}
				A[i] = num;
				length++;
				return i;
			}
		}
		A[i] = num;
		length++;
		return i;
	}

	public static void main(String[] args) {
		InsertInterval in = new InsertInterval();

		ArrayList<Interval> list1 = new ArrayList<Interval>();
		list1.add(new Interval(1, 3));
		list1.add(new Interval(6, 9));

		ArrayList<Interval> list2 = new ArrayList<Interval>();
		list2.add(new Interval(1, 2));
		list2.add(new Interval(3, 5));
		list2.add(new Interval(6, 7));
		list2.add(new Interval(8, 10));
		list2.add(new Interval(12, 16));

		ArrayList<Interval> list3 = new ArrayList<Interval>();
		list3.add(new Interval(1, 5));

		 System.out.println(in.insert(list2, new Interval(4, 9)));
		 System.out.println(in.insert(list1, new Interval(2, 5)));
		 System.out.println(in.insert(list3, new Interval(6, 8)));

		ArrayList<Interval> list4 = new ArrayList<Interval>();
		System.out.println(in.insert(list4, new Interval(6, 8)));
		
		ArrayList<Interval> list5 = new ArrayList<Interval>();
		list5.add(new Interval(1, 5));
		System.out.println(in.insert(list5, new Interval(0, 1)));

	}
}
