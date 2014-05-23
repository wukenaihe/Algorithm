import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<String>();
		Collections.checkedList(list, String.class);
		Collections.synchronizedList(list);
		list.contains("a");
	}
}
