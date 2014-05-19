import java.util.ArrayList;
import java.util.List;


public class PathSum2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	
	public void sum(TreeNode node,ArrayList<Integer> list,int sum,int num){
		if(node==null){
			return;
		}
		int v=node.val+num;
		if(node.left==null&&node.right==null){
			
			if(v==sum){
				list.add(node.val);
				result.add(list);
				return;
			}
		}else{
			ArrayList<Integer> l1=new ArrayList<Integer>();
			l1.addAll(list);
			l1.add(node.val);
			
			ArrayList<Integer> l2=new ArrayList<Integer>();
			l2.addAll(list);
			l2.add(node.val);
			
			sum(node.left,l1,sum,v);
			sum(node.right,l2,sum,v);
		}
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null){
			return result;
		}
		
		ArrayList<Integer> l1=new ArrayList<Integer>();		
		
		sum(root,l1,sum,0);
		return result;
	}
	
	public static void main(String[] args) {
		PathSum2 p=new PathSum2();
		
		
		TreeNode n=new TreeNode(5);
		TreeNode n1=new TreeNode(6);
		TreeNode n2=new TreeNode(7);
		n.left=n1;
		n.right=n2;
		
		TreeNode n3=new TreeNode(1);
		n1.left=n3;
		
		System.out.println(p.pathSum(n, 12));
	}
}
