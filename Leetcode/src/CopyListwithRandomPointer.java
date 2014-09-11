public class CopyListwithRandomPointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode p=head;
        while(p!=null){
            RandomListNode r=new RandomListNode(p.label);
            r.next=p.next;
            p.next=r;
            p=r.next;
        }
        p=head;
        while(p!=null){
            if(p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        RandomListNode h1=head,h2=head.next,p1=h1,p2=h2;
        while(p1!=null&&p2!=null){
            p1.next=p2.next;
            if(p2.next!=null){
            	p2.next=p2.next.next;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return h2;
        
    }
	
	public static void main(String[] args) {
		CopyListwithRandomPointer c=new CopyListwithRandomPointer();
		RandomListNode r=new RandomListNode(-1);
		RandomListNode resListNode=c.copyRandomList(r);
		System.out.println(r);
	}
}
