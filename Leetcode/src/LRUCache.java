import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
	private int capacity;
	private static final long serialVersionUID = 1L;

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true); // 'true' for accessOrder.
		this.capacity = capacity;
	}

	public boolean removeEldestEntry(Map.Entry entry) {
		return (size() > this.capacity);
	}

	public void set(int key, int value) {
		put(key, value);
	}

	public int get(int key) {
		Integer v=super.get(key);
		if(v==null){
			return -1;
		}else{
			return v;
		}
	}
	
	public static void main(String[] args) {
		LRUCache l=new LRUCache(1);
		l.get(0);
	}
}