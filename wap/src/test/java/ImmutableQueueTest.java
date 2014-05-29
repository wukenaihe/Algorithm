import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import com.xumh.collections.ImmutableQueue;



public class ImmutableQueueTest {
	
	private Random r=new Random();

	@Test
	@Ignore
	public void add1(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<1000;++i){
			q=q.enqueue(1);
		}
	}
	
	@Test
	@Ignore
	public void add2(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<10000;++i){
			q=q.enqueue(1);
		}
		for(int i=0;i<10000;++i){
			q.dequeue();
		}
	}
	
	@Test
//	@Ignore
	public void add3(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<100000;++i){
			q=q.enqueue(1);
		}
	}
	
	
//	@Test
//	public void add5(){
//		ImmutableQueue3<Integer> q=new ImmutableQueue3<Integer>();
//		for(int i=0;i<100000;++i){
//			q=new ImmutableQueue3<Integer>();
//		}
//	}
	
	@Test(expected=IllegalArgumentException.class)
	@Ignore
	public void illExcpetion(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		q.enqueue(null);
	}
	
	@Test(expected=NoSuchElementException.class)
	@Ignore
	public void testnoSuchElementException(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<10000;++i){
			q=q.enqueue(1);
		}
		for(int i=0;i<10000;++i){
			q=q.dequeue();
		}
		System.out.println(q.size());
		q.dequeue();
	}
}
