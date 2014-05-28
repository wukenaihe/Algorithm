import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;

import com.xumh.collections.ImmutableQueue;



public class ImmutableQueueTest {
	
	private Random r=new Random();

	@Test
	public void add1(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<1000;++i){
			q=q.enqueue(1);
		}
	}
	
	@Test
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
	public void add3(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		for(int i=0;i<100000;++i){
			q=q.enqueue(1);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illExcpetion(){
		ImmutableQueue<Integer> q=new ImmutableQueue<Integer>();
		q.enqueue(null);
	}
	
	@Test(expected=NoSuchElementException.class)
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
